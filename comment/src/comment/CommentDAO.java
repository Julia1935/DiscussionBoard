package comment;
// DAO: Database Access Object

// 專責與Comment Table之新增,修改,刪除與查詢

import java.sql.*;

import combean.CommentBean;

public class CommentDAO {

	private Connection conn;

	// 建構子
	public CommentDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	  //CommentBean變數名稱
	  public boolean insertComment(CommentBean commentData) {
	    try {
	      String sqlString = "insert into jwstudent values('"		                
			                    +commentData.getName()+"','"
	                            + commentData.getGender()+"','"
	                            + commentData.getAge()+"','"
	                            + commentData.getStatus()+"','" 
	                            + commentData.getComment_time()+"','"
	                            + commentData.getContent_box()+"')";
	                           
	      Statement stmt = conn.createStatement();
	      System.out.println(sqlString);
		    int updatecount = stmt.executeUpdate(sqlString);
	      stmt.close();
	      if (updatecount >= 1) return true;
	      else                  return false;
		  } catch (Exception e) {
		    System.err.println("Error:" + e);
			  return false;
	    }
	  }
	  
	  public boolean update(String account,String pwd) {
			try {
				String sqlString = "UPDATE comment SET name='"+name+"' "+ "WHERE MB_Account ='"+account+"'";
				Statement stmt = conn.createStatement();
				int updatecount = stmt.executeUpdate(sqlString);
				stmt.close();
				if (updatecount >= 1)
					return true;
				else
					return false;
			} catch (Exception e) {
				System.err.println("更新部門資料時發生錯誤:" + e);
				return false;
			}
		}

		public MemberBean select(String data) {
			try {
				Statement stmt = conn.createStatement();
				String sqlString = "SELECT * FROM MEMBERS WHERE MB_Account ='"+data+"'";

				ResultSet rs = stmt.executeQuery(sqlString);
				MemberBean dep = null;
				String Account;
				String Password;
				String Sex;
				Date Birthday;
				String Name;
				String Mail;
				String Tel;
				String Address;
				String type;
				while (rs.next()) {
					Account = rs.getString("MB_Account");
					Password = rs.getString("MB_Password");
					Sex = rs.getString("MB_Sex");
					Birthday = Date.valueOf(rs.getString("MB_Birthday"));
					Name = rs.getString("MB_Name");
					Mail = rs.getString("MB_Mail");
					Tel = rs.getString("MB_Tel");
					Address = rs.getString("MB_Address");
					type = rs.getString("MB_type");
					dep = new MemberBean(Account, Password,Sex,Birthday,Name,Mail,Tel,Address, null, 0, type);
				}
				System.out.println(1);
				return dep;
				
			} catch (Exception e) {
				System.err.println("錯誤" + e);
			}
			return null ;
		}


////  建立新的留言
//	public int createComment(String name, String content_box) {
//    try {
//  	  /*String name1 = null;
//	    String sqlString = "SELECT name FROM comment";
//  	  Statement stmt = conn.createStatement();
//  	  //自取號機取得新部門的部門代號
//	    ResultSet rs = stmt.executeQuery(sqlString);
//
//      if (rs.next()) name1 = rs.getString(1);
//
//      rs.close();
//      */
//
//    //新增留言到Comment Table
//      String sql;
//      name=
//      sql = "INSERT INTO comment(name,gender,age,status,comment_time,content_box) VALUES(+ name + "," + gender + ","+ age +"," + status+ "," + comment_time + "," + content_box)"";
//      stmt.executeUpdate(sqlString);
//  	  stmt.close();
//	    return name;
//	  } catch (Exception e) {
//	    System.err.println("建立留言時發生錯誤:" + e);
//		  return -1;
//	  }
//  }
//
//	// 刪除留言
//	public boolean deleteComment(String name) {
//		try {
//			String sqlString = "DELETE FROM comment " + "WHERE name = " + name;
//			Statement stmt = conn.createStatement();
//			int deletecount = stmt.executeUpdate(sqlString);
//			stmt.close();
//			if (deletecount >= 1)
//				return true;
//			else
//				return false;
//		} catch (Exception e) {
//			System.err.println("刪除留言時發生錯誤: " + e);
//			return false;
//		}
//	}
//
//	// 更新留言資料
//	public boolean updateComment(Comm CommentData) {
//		try {
//			String sqlString = "UPDATE comment " + "SET name = '" + CommentData.getName() + "' " + "WHERE name = "
//					+ CommentData.getName();
//
//			Statement stmt = conn.createStatement();
//			int updatecount = stmt.executeUpdate(sqlString);
//			stmt.close();
//			if (updatecount >= 1)
//				return true;
//			else
//				return false;
//		} catch (Exception e) {
//			System.err.println("更新留言時發生錯誤:" + e);
//			return false;
//		}
//	}
//
//	// 尋找留言資料
//	public Comm findComment(String name) {
//		try {
//			Comm dis = null;
//			String cname;
//
//			Statement stmt = conn.createStatement();
//			String sqlString = "SELECT name " + "FROM comment WHERE product_id = " + product_id;
//
//			ResultSet rs = stmt.executeQuery(sqlString);
//
//			if (rs.next()) {
//				cname = rs.getString("cname");
//				dis = new Comm(product_id, cname);
//			}
//			rs.close();
//			stmt.close();
//			return dis;
//
//		} catch (Exception e) {
//			System.err.println("尋找留言時發生錯誤:" + e);
//			return null;
//		}
//	}
}
