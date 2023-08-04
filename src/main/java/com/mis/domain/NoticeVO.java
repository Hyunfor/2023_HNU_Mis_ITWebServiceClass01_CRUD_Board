package com.mis.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class NoticeVO {
	
	private int noticeNo;
	private String title;
	private String content;
	private String register;
	private Date regDate;
	private String[] files;
	//상세보기 file 여러개 가져오기
	private ArrayList<NoticeFileVO> fileList;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public ArrayList<NoticeFileVO> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<NoticeFileVO> fileList) {
		this.fileList = fileList;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", register=" + register
				+ ", regDate=" + regDate + ", files=" + Arrays.toString(files) + ", fileList=" + fileList + "]";
	}

}
