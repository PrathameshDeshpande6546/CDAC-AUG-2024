package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
@WebServlet("/vote")
public class VoteServlet extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// get selected candidate id from previous page
					String candId = req.getParameter("candidate"); // "candidate" is name of radio button in prev page
					int id = Integer.parseInt(candId);
					// increment votes of that candidate in database
					resp.setContentType("text/html");
					PrintWriter out = resp.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Result</title>");
					out.println("</head>");
					out.println("<body>");
					
					Cookie[] arr=req.getCookies();
					String userName="",role="";
					if(arr!=null) {
						for(Cookie c:arr) {
							if(c.getName().equals("uname")) {
								userName=c.getValue();
							}
							if(c.getName().equals("role")) {
								role=c.getValue();
							}
						}
					}
					out.printf("Thank you %s for your valuable Vote..",userName);
					
					out.println("<h2>Voting Status</h2>");
		try(CandidateDao cdao=new CandidateDaoImpl()){
			int count=cdao.incrVote(id);
			if(count==1) {
				out.println("<h4>Your Vote is Successfully Casted..</h4>");
			}else {
				out.println("<h4>Your Vote is Failed..</h4>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			
		}
		out.println("<p><a href='logout'>Sign Out</a></p>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		}

}