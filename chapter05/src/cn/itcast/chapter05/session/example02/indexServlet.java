package cn.itcast.chapter05.session.example02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("user");
		if (user==null) {
			response.getWriter().print("����û�е�¼,��<a href='/chapter05/login.html'>��¼</a>");
		}
			else {
				response.getWriter().print("���ѵ�¼����ӭ��,"+user.getUsername()+"!");
				response.getWriter().print("<a href='/chapter05/LogoutServlet'>�˳�</a>");
				Cookie cookie=new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(60*30);
				cookie.setPath("/chapter05");
				response.addCookie(cookie);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
