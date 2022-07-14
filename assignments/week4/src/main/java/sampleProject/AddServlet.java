package sampleProject;

import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    
     int i = Interger.parseInt(request.getParameter("num1")); 
 	int j = Interger.parseInt(request.getParameter("num2"));
 
 	int k = i + j;
     response.setContentType("text/plain");
             
     PrintWriter out = response.getWriter();
     out.println("The sum is: " + k); 
     
  }
}
