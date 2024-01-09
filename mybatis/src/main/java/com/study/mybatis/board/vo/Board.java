package com.study.mybatis.board.vo;

import java.sql.Date;

public class Board {
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_writer;
	private int count;
	private Date create_date;
	private String status;
	
	public Board() {}

	public Board(int board_no, String board_title, String board_content, String board_writer, int count,
			Date create_date, String status) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_writer = board_writer;
		this.count = count;
		this.create_date = create_date;
		this.status = status;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
		return "Board [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", count=" + count + ", create_date=" + create_date + ", status="
				+ status + "]";
	}
}
