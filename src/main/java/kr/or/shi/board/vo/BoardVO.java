package kr.or.shi.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int pro_boardNum;
	
	public int getPro_boardNum() {
		return pro_boardNum;
	}

	public void setPro_boardNum(int pro_boardNum) {
		this.pro_boardNum = pro_boardNum;
	}

	private String pro_noticeNum;
	private String pro_kind;
	private String pro_gender;
	private String pro_age;
	private String pro_place;
	private String pro_findDate;
	private String pro_character;
	private String pro_neutering;
	private String pro_registNum;
	private String pro_state;
	private String pro_shelter;
	private String pro_img;
	private Date pro_date;
	private String user_id;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(String pro_noticeNum, String pro_kind, String pro_gender, String pro_age, String pro_place,
			String pro_findDate, String pro_character, String pro_neutering, String pro_registNum, String pro_state,
			String pro_shelter, String pro_img, String user_id) {
		super();
		this.pro_noticeNum = pro_noticeNum;
		this.pro_kind = pro_kind;
		this.pro_gender = pro_gender;
		this.pro_age = pro_age;
		this.pro_place = pro_place;
		this.pro_findDate = pro_findDate;
		this.pro_character = pro_character;
		this.pro_neutering = pro_neutering;
		this.pro_registNum = pro_registNum;
		this.pro_state = pro_state;
		this.pro_shelter = pro_shelter;
		this.pro_img = pro_img;
		this.user_id = user_id;
	}


	public String getPro_noticeNum() {
		return pro_noticeNum;
	}

	public void setPro_noticeNum(String pro_noticeNum) {
		this.pro_noticeNum = pro_noticeNum;
	}

	public String getPro_kind() {
		return pro_kind;
	}

	public void setPro_kind(String pro_kind) {
		this.pro_kind = pro_kind;
	}

	public String getPro_gender() {
		return pro_gender;
	}

	public void setPro_gender(String pro_gender) {
		this.pro_gender = pro_gender;
	}

	public String getPro_age() {
		return pro_age;
	}

	public void setPro_age(String pro_age) {
		this.pro_age = pro_age;
	}

	public String getPro_place() {
		return pro_place;
	}

	public void setPro_place(String pro_place) {
		this.pro_place = pro_place;
	}

	public String getPro_findDate() {
		return pro_findDate;
	}

	public void setPro_findDate(String pro_findDate) {
		this.pro_findDate = pro_findDate;
	}

	public String getPro_character() {
		return pro_character;
	}

	public void setPro_character(String pro_character) {
		this.pro_character = pro_character;
	}

	public String getPro_neutering() {
		return pro_neutering;
	}

	public void setPro_neutering(String pro_neutering) {
		this.pro_neutering = pro_neutering;
	}

	public String getPro_registNum() {
		return pro_registNum;
	}

	public void setPro_registNum(String pro_registNum) {
		this.pro_registNum = pro_registNum;
	}

	public String getPro_state() {
		return pro_state;
	}

	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}

	public String getPro_shelter() {
		return pro_shelter;
	}

	public void setPro_shelter(String pro_shelter) {
		this.pro_shelter = pro_shelter;
	}

	public String getPro_img() {
try {
			
			if(pro_img != null && pro_img.length() != 0) {
				pro_img = URLDecoder.decode(pro_img, "utf-8");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return pro_img;
	}

	public void setPro_img(String pro_img) {
		try {
			if(pro_img != null && pro_img.length() != 0) {
				this.pro_img = URLEncoder.encode(pro_img, "utf-8");
			}
		} catch (UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
	}

	public Date getPro_date() {
		return pro_date;
	}

	public void setPro_date(Date pro_date) {
		this.pro_date = pro_date;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
