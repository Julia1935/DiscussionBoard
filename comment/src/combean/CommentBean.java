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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment_time() {
		return comment_time;
	}

	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}

	public String getContent_box() {
		return content_box;
	}

	public void setContent_box(String content_box) {
		this.content_box = content_box;
	}
	
}
