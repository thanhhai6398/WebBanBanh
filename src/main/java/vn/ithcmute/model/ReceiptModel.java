package vn.ithcmute.model;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class ReceiptModel implements Serializable{
	private int rId;
	private UserModel uId;
	private ShopModel sId;
	private StateReceiptModel stId;
	private Date date;
	private String address;
	public ReceiptModel() {
		super();
	}
	public ReceiptModel(int rId, UserModel uId, ShopModel sId, StateReceiptModel stId, Date date, String address) {
		super();
		this.rId = rId;
		this.uId = uId;
		this.sId = sId;
		this.stId = stId;
		this.date = date;
		this.address = address;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public UserModel getuId() {
		return uId;
	}
	public void setuId(UserModel uId) {
		this.uId = uId;
	}
	public ShopModel getsId() {
		return sId;
	}
	public void setsId(ShopModel sId) {
		this.sId = sId;
	}
	public StateReceiptModel getStId() {
		return stId;
	}
	public void setStId(StateReceiptModel stId) {
		this.stId = stId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ReceiptModel [rId=" + rId + ", uId=" + uId + ", sId=" + sId + ", stId=" + stId + ", date=" + date
				+ ", address=" + address + "]";
	}
	
	
}
