package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId=req.getParameter("id");
		int id=Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		out.println("</head>");
		ServletContext co=this.getServletContext();
		String color=co.getInitParameter("color");
		out.println("<body bgcolor='"+color+"'>");
		
		
		ServletContext app=this.getServletContext();
		String appTitle=app.getInitParameter("app.title");
		out.println("<h1> " + appTitle+" </h1>");
		
		out.println("<h2>Edit Candidate</h2>");
		try(CandidateDao cdao=new CandidateDaoImpl()){
			Candidate c=cdao.findById(id);
			if(c!=null) {
				out.println("<form method='post' action='editcand'>");
				out.printf("<input type='hidden' name='id'  value='%d'><br/>\n",c.getId());
				out.printf("Name: <input type='text' name='name'  value='%s' ><br/>\n",c.getName());
				out.printf("Party: <input type='text' name='party'  value='%s' ><br/>\n",c.getParty());
				out.printf("Votes: <input type='text' name='votes'  value='%d' readonly><br/>\n",c.getVotes());
				out.printf("<input type='submit' value='Update Candidate'>");
				out.println("</form>");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
			
		}
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		int votes = Integer.parseInt(req.getParameter("votes"));
		
		Candidate c = new Candidate(id, name, party, votes);
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.update(c);
			String message = "Candidates updated: " + count;
			req.setAttribute("msg", message);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		ServletContext ctx=this.getServletContext();
		RequestDispatcher rd=ctx.getRequestDispatcher("/result");
		rd.forward(req, resp);
		
		
	}

	
	
	

}