package org.neu.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchResultPage
 */
public class SearchResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BufferedReader bufferReader;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cur_dir = "files\\";
		String docmentName = request.getParameter("resDoc");
		String suffix = ".txt";
		
		FileReader filereader = new FileReader(IntegerConstants.cur_dir+cur_dir+docmentName+suffix);
        bufferReader = new BufferedReader(filereader);
        
        String line = bufferReader.readLine();
        String str = "";
        
       while(line!=null)
       {
           str = str+" "+line;
           line = bufferReader.readLine();
       }
       PrintWriter out = response.getWriter();
       out.println("<HTML>");
       out.println("<HEAD>");
       out.println("<TITLE>"+docmentName+suffix+"</TITLE>");
       out.println("</HEAD>");
       out.println("<BODY>");
       out.println("<H2>File "+docmentName+" Found</H2>");
       out.println("<BR>");
       out.println("<BR>");
       out.println("<H3>" + str + "</H3>");
       out.println("</BODY>");
       out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
