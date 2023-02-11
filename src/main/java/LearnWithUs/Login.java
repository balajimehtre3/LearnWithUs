package LearnWithUs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login123")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LearnWithUs");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select a from Client a where a.Email = ?1 and a.Password = ?2");
		q.setParameter(1, req.getParameter("email"));
		q.setParameter(2, req.getParameter("password"));
		List<Client> c = q.getResultList();
		
		if(c.size()==1)
		{
			RequestDispatcher rd = req.getRequestDispatcher("LearnWithUs Website/balaji.html");
			rd.forward(req, resp);
		}
		else
		{
			PrintWriter pw = resp.getWriter();
			pw.write("Invalid credentials!"+c.size()+"");
			RequestDispatcher rd = req.getRequestDispatcher("login Page.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
