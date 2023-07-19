package com.mis.domain;

public class UserVO {

	private String usid;
	private String upw;
	private String uname;
	private int upoint;

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		return "UserVO [usid=" + usid + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}

}
