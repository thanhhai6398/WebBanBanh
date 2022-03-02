package vn.ithcmute.model;

public class ShopModel {

	private int sID;
	private String sAddrs;
	private String sPhone;
	private String sName;
	public ShopModel() {
		super();
	}
	public ShopModel(int sID, String sAddrs, String sPhone, String sName) {
		super();
		this.sID = sID;
		this.sAddrs = sAddrs;
		this.sPhone = sPhone;
		this.sName = sName;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getsAddrs() {
		return sAddrs;
	}
	public void setsAddrs(String sAddrs) {
		this.sAddrs = sAddrs;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "ShopModel [sID=" + sID + ", sAddrs=" + sAddrs + ", sPhone=" + sPhone + ", sName=" + sName + "]";
	}
	
}
