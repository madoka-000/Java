package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * トピックを購読するサーブレット
 */
public class ReadServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	        throws ServletException, IOException{
		
	   porform(request, response);
	}

	protected void doPost(HttpServletRequest request,
		    HttpServletResponse response)
	throws ServletException, IOException{
		 porform(request, response);
}
	
	protected void porform(HttpServletRequest request,
		    HttpServletResponse response)
	throws ServletException, IOException{
		
		BlogController ctrl = BlogController.getInstance();
		List<Topic>topics = ctrl.getTopics();
		
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("/read.jsp")
		      .forward(request, response);
	}
		

}
