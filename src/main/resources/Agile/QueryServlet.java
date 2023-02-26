package Transfer;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       // read form fields
       int id =Integer.parseInt(request.getParameter("id"));
        
       // get response writer
       PrintWriter writer = response.getWriter();
        
       // build HTML code
       String htmlResponse = "<html>";
       htmlResponse += "<h2>ID number of " + id + " is being queried... <br/>";
       htmlResponse += "</html>";
       
       // return response
       writer.println(htmlResponse);
       
       //add new user into database
       writer.println(UpdateUsers.query_balance(UpdateUsers.account_map, id));
       
       String htmlResponse2 = "<html> <br/>";
       htmlResponse2 += "<a href=\"index.html\"><button type = \"button\">Back to Home</button></a>";
       writer.println(htmlResponse2);
       
       
        
   }

}
