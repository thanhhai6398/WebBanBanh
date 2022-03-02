package vn.ithcmute.model;

public class DeliveryCompanyModel {
	private int comID;
	private String comName;
	private int comPrice;
	public DeliveryCompanyModel() {
		super();
	}
	public DeliveryCompanyModel(int comID, String comName, int comPrice) {
		super();
		this.comID = comID;
		this.comName = comName;
		this.comPrice = comPrice;
	}
	public int getComID() {
		return comID;
	}
	public void setComID(int comID) {
		this.comID = comID;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getComPrice() {
		return comPrice;
	}
	public void setComPrice(int comPrice) {
		this.comPrice = comPrice;
	}
	@Override
	public String toString() {
		return "DeliveryCompanyModel [comID=" + comID + ", comName=" + comName + ", comPrice=" + comPrice + "]";
	}

}
