package com.study.mybatis.board.vo;

import java.sql.Date;

public class Reply {
	private int reply_no;
	private String reply_content;
	private int ref_bno;
	private String reply_writer;
	private Date create_date;
	private String status;
	
	public Reply() {}

	public Reply(int reply_no, String reply_content, int ref_bno, String reply_writer, Date create_date,
			String status) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.ref_bno = ref_bno;
		this.reply_writer = reply_writer;
		this.create_date = create_date;
		this.status = status;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public int getRef_bno() {
		return ref_bno;
	}

	public void setRef_bno(int ref_bno) {
		this.ref_bno = ref_bno;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reply [reply_no=" + reply_no + ", reply_content=" + reply_content + ", ref_bno=" + ref_bno
				+ ", reply_writer=" + reply_writer + ", create_date=" + create_date + ", status=" + status + "]";
	}
}