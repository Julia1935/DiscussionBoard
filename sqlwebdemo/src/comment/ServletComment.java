package comment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import combean.CommentBean;



/**
 * Servlet implementation class ServletComment
 */
@WebServlet("/ServletComment")
public class ServletComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 private static final String CHARSET_CODE = "UTF-8";
	 public void init(ServletConfig config) throws ServletException
	 {
	   super.init(config);
	 }   
    /**
     * @see HttpServlet#HttpServlet()
     */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		    request.setCharacterEncoding(CHARSET_CODE);
		    response.setContentType(CONTENT_TYPE);

		    // To prevent caching 
		   response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
		   response.setHeader("Pragma","no-cache"); // HTTP 1.0
		   response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server

		    
		   if (request.getParameter("submit")!=null)
		     gotoSubmitProcess(request, response);
		   else if (request.getParameter("confirm")!=null)
		     gotoConfirmProcess(request, response);
		}
		
		 public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		  {
		    String name;
		    String gender;
		    Integer age;
		    Integer status;
		    String comment_time;
		    String content_box;
		   //trim使用者多打的空白
		    name = request.getParameter("name").trim();
		    gender = request.getParameter("gender").trim();
		    age = Integer.parseInt(request.getParameter("age").trim());
		    status = Integer.parseInt(request.getParameter("status").trim());
		    comment_time = request.getParameter("comment_time").trim();
		    content_box = request.getParameter("content_box").trim();
		    //十分重要
		    //把模型建出來
		    CommentBean dis_board =  new CommentBean(name, gender, age, status, comment_time, content_box);
//		    把CommentBean放在session裡
		    request.getSession(true).setAttribute("dis_board",dis_board);
		    //RegisterServlet派遣工作給DisplayStudent
		    request.getRequestDispatcher("/DisplayBoard.jsp").forward(request,response);
		  }

		  public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		  {

		    DataSource ds = null;
		    InitialContext ctxt = null;
		    Connection conn = null;
		    
		    try {
		     
		      //�إ�Context Object,�s��JNDI Server
		      ctxt = new InitialContext();

		      //�ϥ�JNDI API���DataSource
		      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/comment");
		     //ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
		      //�VDataSource�nConnection
		      conn = ds.getConnection();

		      //�إ�Database Access Object,�t�dTable��Access
		      CommentDAO commentDAO = new CommentDAO(conn);
		      CommentBean studentData = (CommentBean)request.getSession(true).getAttribute("dis_board");
		      if (commentDAO.insertComment(commentData))
		        {
		          System.out.println("Get some SQL commands done!");
		          request.getSession(true).invalidate();
		          request.getRequestDispatcher("/Thanks.jsp").forward(request,response);
		        }
		    } catch (NamingException ne) {
		      System.out.println("Naming Service Lookup Exception");  
		    } catch (SQLException e) {
		      System.out.println("Database Connection Error"); 
		    } finally {
		      try {
		        if (conn != null) conn.close();
		      } catch (Exception e) {
		        System.out.println("Connection Pool Error!");
		      }
		    }
		           
		  }

	}

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.print("!!!");
//		
//		
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request,response);
//		
//	}


