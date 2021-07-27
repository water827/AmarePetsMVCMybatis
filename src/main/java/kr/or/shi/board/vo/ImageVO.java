package kr.or.shi.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ImageVO {

	private int imageFileNo;
	private String imageFileName;
	private Date regDate;
	private int pro_boardNum;
	public int getImageFileNo() {
		return imageFileNo;
	}
	public void setImageFileNo(int imageFileNo) {
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLEncoder.encode(imageFileName, "utf-8");		//파일이름에 특수문자가 있을 경우 인코딩합니다.
			}
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		}
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getPro_boardNum() {
		return pro_boardNum;
	}
	public void setPro_boardNum(int pro_boardNum) {
		this.pro_boardNum = pro_boardNum;
	}

	
	
}
