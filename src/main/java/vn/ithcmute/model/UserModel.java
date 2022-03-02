package vn.ithcmute.model;

public class UserModel {
	private int uid;
	private String uname;
	private String upass;
	private int isSel;
	private int isAd;
	private ShopModel shop;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int uid, String uname, String upass, int isSel, int isAd, ShopModel shop) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.isSel = isSel;
		this.isAd = isAd;
		this.shop = shop;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getIsSel() {
		return isSel;
	}
	public void setIsSel(int isSel) {
		this.isSel = isSel;
	}
	public int getIsAd() {
		return isAd;
	}
	public void setIsAd(int isAd) {
		this.isAd = isAd;
	}
	public ShopModel getShop() {
		return shop;
	}
	public void setShop(ShopModel shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "UserModel [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", isSel=" + isSel + ", isAd=" + isAd
				+ ", shop=" + shop + "]";
	}
}
