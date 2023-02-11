package LearnWithUs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccount123")
public class CreateAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LearnWithUs");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Client c = new Client();
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setPassword(req.getParameter("password"));
		
		et.begin();
		em.persist(c);
		et.commit();
		
		PrintWriter pw = resp.getWriter();
		//pw.write("Account Created!");
		RequestDispatcher rd = req.getRequestDispatcher("login Page.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
