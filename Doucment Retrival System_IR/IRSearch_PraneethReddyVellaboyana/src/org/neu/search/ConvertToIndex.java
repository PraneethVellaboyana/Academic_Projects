/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Praneeth Reddy
 */
public class ConvertToIndex {

	//convert the text files in the  inverted index using a sorted map while insertion
	private TreeMap<String,TreeMap<String,Integer>> invertedIndex = new TreeMap<String,TreeMap<String,Integer>>();
	//Number of tokens in each document
    private TreeMap<String,Integer> wordCountInDocument = new TreeMap<String,Integer>();
	private BufferedReader breader;
	private BufferedReader bufferreader;
    
	/**
	 *
	 * Gets the Inverted Index by removing the stopwords. I have used LinkedHashSet to preserve the order of the
	 * stop words and hash the collection for easy retrieval.
	 */
	public void getInvertedIndex() throws IOException, ClassNotFoundException
	{
		//IntegerConstants.cur_dir+
    FileReader freader = new FileReader(IntegerConstants.cur_dir+"stopwords.txt");
    breader = new BufferedReader(freader);
    String l = breader.readLine();
    //loading the stop words to elimate the stop words from the text documents
    LinkedHashSet<String> stopwordslist = new LinkedHashSet<String>();
    
    while(l!=null)
    {
        stopwordslist.add(l);
        l = breader.readLine();
    }
    
    //gets the files from the folder in the cur_dir 
    File myfolder = new File(IntegerConstants.cur_dir+"files");
    File[]  filesList = myfolder.listFiles();
    
    //Iterate over the files to get each file for processing
    for(File file:filesList)
    { 
        int wordcount = 0;
        System.out.println("File name "+file.getName());
        
        FileReader filereader = new FileReader(file);
        bufferreader = new BufferedReader(filereader);
        
        String line = bufferreader.readLine();
        String str = "";
        // takes the words into single line and then convert it into lower case
       while(line!=null)
       {
           str = str+" "+line.toLowerCase();
           line = bufferreader.readLine();
       }
       
       // stemming using the porterstemmer using the open nlp api
       PorterStemmer stemmer = new PorterStemmer();
       // removing the tokens and tokenizing the text
       StringTokenizer stz = new StringTokenizer(str," ,.~!@#øü$-=ä|ß°±%^&\\\"*()?_+{}:[]/';");
       while(stz.hasMoreTokens())
       {
           String token = stz.nextToken();
           if(!stopwordslist.contains(token))
           {
        	   //stemming the words adding it to the word count Map
               String stemmedword = stemmer.stem(token);
              
               wordcount = wordcount+1;
               wordCountInDocument.put(file.getName().substring(0, file.getName().length()-4),wordcount);
               if(!invertedIndex.containsKey(stemmedword))
               {
            	   // adding to the invertedIndex creating new if it doesn't exist
                   TreeMap<String,Integer>  nestedmap = new TreeMap<String,Integer>();
                   nestedmap.put(file.getName().substring(0, file.getName().length()-4),1);
                   invertedIndex.put(stemmedword,nestedmap);
               }
               else
               {
            	   
                   TreeMap<String,Integer> hm = invertedIndex.get(stemmedword);
                  if(hm.containsKey(file.getName().substring(0, file.getName().length()-4)))
                  {
                	// getting the map and adding the count
                   int occurence = hm.get(file.getName().substring(0, file.getName().length()-4));
                   hm.put(file.getName().substring(0, file.getName().length()-4), (occurence+1));
                   invertedIndex.put(stemmedword,hm);
                  }
                  else
                  {
                	  // putting the word and adding the frequency in the inverted index
                   // System.out.println("new in the file "+stemmedword);
                   hm.put(file.getName().substring(0, file.getName().length()-4),1);
                   invertedIndex.put(stemmedword,hm);
                  }
               }
                   
               
           }
       }   
    }
    bufferreader.close();
    for(Map.Entry<String,TreeMap<String,Integer>> entries:invertedIndex.entrySet())
    {
       
       TreeMap<String,Integer> hmp = entries.getValue();
       for(Map.Entry<String,Integer> e:hmp.entrySet())
       {
          // System.out.println("[Term:]  "+entries.getKey()+" [File name:]  "+e.getKey()+" [Occurence]  "+e.getValue());
          
       }
    }
    
    /*for(Map.Entry<String,Integer> mapentries:wordCountInDocument.entrySet())
    {
      System.out.println("File name is "+mapentries.getKey()+" Wordcount "+mapentries.getValue());
      IntegerConstants.cur_dir+
    }*/
    
    FileOutputStream outfile = new FileOutputStream(IntegerConstants.cur_dir+"invertedIndex.out");
    ObjectOutputStream outputfile = new ObjectOutputStream(outfile);
    System.out.println("Writing inverted index");
    //writing the index and the token count to the algorithm
    outputfile.writeObject(invertedIndex);
    outputfile.writeObject(wordCountInDocument);
    outputfile.close();
    outfile.close();
	}
}
