package Transfer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopUpServlet
 */
@WebServlet("/TopUpServlet")
public class TopUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopUpServlet() {
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
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        int id =Integer.parseInt(request.getParameter("id"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your ID number is: " + id + "<br/>";      
        htmlResponse += "Your Top Up amount is: " + amount + "</h2>";    
        htmlResponse += "</html>";
        
        // return response
        writer.println(htmlResponse);
        
        //top up users account
        writer.println(Transact.user_top_up(UpdateUsers.account_map, id, amount));
        
        String htmlResponse2 = "<html><br/>";
        htmlResponse2 += "<a href=\"index.html\"><button type = \"button\">Back to Home</button></a>";
        writer.println(htmlResponse2);
        
        
         
    }

}
