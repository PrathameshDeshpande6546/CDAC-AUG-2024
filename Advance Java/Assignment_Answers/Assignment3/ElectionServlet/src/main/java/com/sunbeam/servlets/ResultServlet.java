package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Candidate> list=new ArrayList<>();
	try(CandidateDao cdao=new CandidateDaoImpl()){
		list=cdao.findAll();
	}catch (Exception e) {
	e.printStackTrace();
	throw new ServletException(e);
	}
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Result</title>");
	out.println("</head>");
	ServletContext co=this.getServletContext();
	String color=co.getInitParameter("color");
	out.println("<body bgcolor='"+color+"'>");
	
	
	
	ServletContext app=this.getServletContext();
	String appTitle=app.getInitParameter("app.title");
	out.println("<h1> " + appTitle+" </h1>");
	
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
	out.printf("Hello %s %s ...",role,userName);
	
	ServletContext ctx = this.getServletContext();
	String ann = (String) ctx.getAttribute("announcement");
	if(ann != null)
		out.println("<p style='color:red'> NOTE: " + ann + "</p>");
	
	
	out.println("<h2>Voting Result</h2>");
	out.println("<table border=1>");
	out.println("<thead>");
	
	
	
	out.println("<tr>");
	out.println("<th>Id</th>");
	out.println("<th>Name</th>");
	out.println("<th>Party</th>");
	out.println("<th>Vote</th>");
out.println("<th>Actions</th>");
	out.println("</tr>");
	out.println("</thead>");
	out.println("<tbody>");
	for(Candidate c:list) {
		out.println("<tr>");
		out.printf("<td>%d</td>\n",c.getId());
		out.printf("<td>%s</td>\n",c.getName());
		out.printf("<td>%s</td>\n",c.getParty());
		out.printf("<td>%s</td>\n",c.getVotes());
		
		out.printf("<td>\n");
		out.printf("<a href='editcand?id=%d'><img src='images/edit.png' alt='Edit' width='24' height='24'/></a>\n",c.getId());
		out.printf("<a href='delcand?id=%d'><img src='images/delete.png' alt='Delete' width='24' height='24'/></a>\n",c.getId());
		
		
		out.printf("</td>\n");
		out.println("</tr>");
	}
	out.println("</tbody>");
	out.println("</table>");
	String message=(String) req.getAttribute("msg");
	if(	message!=null) {
		out.println("<p> "+message+ " </p>");
		
	}
	out.println("<p><a href='newcandidate.html'>Add NewCandidate</a></p>");
	out.println("<p><a href='announcement.html' >Announcement</a> | <a href='logout'>Sign Out</a></p>");
	
	out.println("</body>");
	out.println("</html>");
	
	}
}
