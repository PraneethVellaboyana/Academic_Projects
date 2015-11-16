/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neu.search;

import java.util.*;
import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
/**
 *
 * @author Praneeth Reddy
 */
public class OkapiBM25 {
    

    /**
     * @param args the command line arguments
     */
	//The inverted index treemap from the inverted index file(Stopped and stemmed data with tokenized value)
    public Map<String, TreeMap<String, Integer>> inv_index = new TreeMap<String, TreeMap<String, Integer>>();
    //The inverted index treemap from the token count in each document
    public Map<String, Integer> tokenCount = new TreeMap<String, Integer>();
    // The query words indexed with the matched word and the document and its frequency
    public Map<String, TreeMap<String, Integer>> query_index = new TreeMap<String, TreeMap<String, Integer>>();
    //Document Score for each document and the rank of the document calculated
    public Map<String, Double> documentScore = new TreeMap<String, Double>();
    // list of files in the order to display in the UI
    private List<String> queryResults = new ArrayList<String>();


    public class DescendingOrder implements Comparator<String> {

        Map<String, Double> map = new TreeMap<String, Double>();

        public DescendingOrder(TreeMap map) {
            this.map = map;
        }

        public DescendingOrder() {
            super();
        }

        @Override
        public int compare(String o1, String o2) {
            if (map.get(o1) >= map.get(o2)) {
                return -1;
            } else {
                return 1;
            }
        }

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> getBestMatchingScore(String indexfile, String queryfile, String num) throws IOException, ClassNotFoundException {

//        try {
        int count = Integer.parseInt(num);

        //String cur_dir = "D:\\STS_Workspace\\IRSearch_PraneethReddyVellaboyana"; cur_dir + "\\" +
        //System.out.println("!!!!!!!!!!!!!!!!"+cur_dir);
        FileInputStream fileIn = new FileInputStream(IntegerConstants.cur_dir+indexfile);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        inv_index = (TreeMap) in.readObject();
        System.out.println(inv_index);

        tokenCount = (TreeMap) in.readObject();

        System.out.println(tokenCount);
        //Total number of words in all the documents
        int totalTokenCount = 0;

        //Calculate the total number of tokens in the collection
        for (Iterator i = tokenCount.entrySet().iterator(); i.hasNext();) {
            Map.Entry next = (Map.Entry) i.next();
            totalTokenCount = totalTokenCount + (Integer) next.getValue();
        }
        // average  document length
        Double avdl = totalTokenCount * 1.0 / tokenCount.size();

        //Reading a file cur_dir + "\\" + 
        File qf = new File(IntegerConstants.cur_dir+queryfile);
        BufferedReader bf = new BufferedReader(new FileReader(qf));

        String querytext;

        int queryid = 1;
        while ((querytext = bf.readLine()) != null) {

            String[] querywords = querytext.split(" ");

            //Step1: Retrieve all inverted lists corresponding to terms in a query.
            for (String word1 : querywords) {

                PorterStemmer ps = new PorterStemmer();
                String word = ps.stem(word1);

                word = word.trim();
                if (!word.equals("") && inv_index.containsKey(word)) {
                    query_index.put(word, inv_index.get(word));
                }
            }

            //Step2: Compute BM25 scores for documents in the lists.
            for (Iterator iterator1 = query_index.entrySet().iterator(); iterator1.hasNext();) {
            	//next contains list of files for the query word and their occurrences in each file
                Map.Entry next = (Map.Entry) iterator1.next();
                TreeMap indexes = (TreeMap) next.getValue();
                for (Iterator iterator2 = indexes.entrySet().iterator(); iterator2.hasNext();) {
                    Map.Entry next2 = (Map.Entry) iterator2.next();
                    // number of words of the query in the document
                    int fi = (Integer) next2.getValue();
                    //  total number of documents
                    int N = tokenCount.size();
                    // number of files the query word occurred in
                    int ni = indexes.size();
                    Double qfi = 0.0;
                    
                    //Number of words in the query string
                    for (int i = 0; i < querywords.length; i++) {
                    	//matching the query word with the index of the queries to count the matched and revelent query 
                        if (querytext.contains(querywords[i])) {
                            qfi++;
                        }
                    }

                    //Computing K value
                    Double K = IntegerConstants.k1 * ((1 - IntegerConstants.b) + IntegerConstants.b * (tokenCount.get(next2.getKey()) / avdl));
                    Double first_term = (Math.log(((IntegerConstants.ri + 0.5) / (IntegerConstants.R - IntegerConstants.ri + 0.5))
                            / ((ni - IntegerConstants.ri + 0.5) / (N - ni - IntegerConstants.R + IntegerConstants.ri + 0.5))));
                    Double second_term = ((IntegerConstants.k1 + 1) * fi / (K + fi));
                    Double third_term = ((IntegerConstants.k2 + 1) * qfi / (IntegerConstants.k2 + qfi));
                    Double total = first_term * second_term * third_term;

                    if (documentScore.containsKey((String) next2.getKey())) {
                        Double valueToPut = total + documentScore.get((String) next2.getKey());
                        documentScore.put((String) next2.getKey(), valueToPut);
                    } else {
                        documentScore.put((String) next2.getKey(), total);
                    }
                }
            }
            //putting all the rank in descending order using the rank
            DescendingOrder comp = new DescendingOrder((TreeMap) documentScore);
            //order document score
            TreeMap<String, Double> list_asc = new TreeMap<String, Double>(comp);
            list_asc.putAll(documentScore);

            int rank = 1;
            //iterating with respect to the number of fetch results(third) parameter from the method
            for (Iterator itr = list_asc.entrySet().iterator(); itr.hasNext() && rank <= count;) {
                Map.Entry nx = (Map.Entry) itr.next();
                //Double bmValue = (Double) nx.getValue();
               // System.out.println(queryid + " Q0 " + nx.getKey() + " " + rank + " " + bmValue + " Praneeth");
                // adding the files in the list by preserving the insertion order
                queryResults.add(nx.getKey().toString());
                rank++;
            }
            queryid++;
            documentScore.clear();
            query_index.clear();

        }

        in.close();
        fileIn.close();
        bf.close();
		return queryResults;
    }
    
}
