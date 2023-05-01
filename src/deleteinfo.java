

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class deleteinfo
 */
@WebServlet("/deleteinfo")
public class deleteinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletRequest request;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteinfo() {
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

	int usn = Integer.parseInt(request.getParameter("usn"));
	
//	 PrintWriter out = response.getWriter();

	 


}
