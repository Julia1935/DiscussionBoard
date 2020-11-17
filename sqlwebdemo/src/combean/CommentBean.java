package combean;

import java.util.Date;

public class CommentBean {
	String name;
	String gender;
	int age;
	int status;
	String comment_time;
	String content_box;

	public void combean()
	  {
	  }

	public CommentBean(String pName, String pGender,
	                 int pAge, int pStatus, String pComment_time, String pContent_box)
	  {
	    this.name = pName;
	    this.gender = pGender;
	    this.age = pAge;
	    this.status = pStatus;
	    this.comment_time = pComment_time;
	    this.content_box = pContent_box;
	  }
	
}
