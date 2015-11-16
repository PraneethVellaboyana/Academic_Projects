package org.neu.search;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 * It is used to read the query from the jsp page and processes the <h1> Query String</h1>
 * 
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //making the inverted on the startup of the server
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
			ConvertToIndex index = new ConvertToIndex();
			try {
				index.getInvertedIndex();
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("!!!"+e.getMessage());
			} 
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Query being taken as the request parameter from the JSP and written to a file where BM25 algorithm loads 
	 * the query file to process.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		//String cur_dir = "D:\\STS_Workspace\\IRSearch_PraneethReddyVellaboyana";
		query = query.toLowerCase();
		//wirting out the query file to .txt format
		BufferedWriter out = new BufferedWriter(new FileWriter(IntegerConstants.cur_dir+"query.txt"));

        out.write(query);
        out.close();
        
        try {
        	// call of BM25 algorithm
	        OkapiBM25 searchRank = new OkapiBM25();
	        //computing the rank of the query with respect of the relevant file list and the number 
	        // of search results
			List<String> queryRes = searchRank.getBestMatchingScore("invertedIndex.out", "query.txt", "10");
	        request.setAttribute("queryRes", queryRes);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
        String resultJSP = "/searchResult.jsp"; 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(resultJSP); 
        dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
