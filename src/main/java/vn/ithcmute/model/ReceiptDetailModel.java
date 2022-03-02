package vn.ithcmute.model;

public class ReceiptDetailModel {
	private int dId;
	private ReceiptModel rId;
	private ProductModel pId;
	private int amount;	
	public ReceiptDetailModel(int dId, ReceiptModel rId, ProductModel pId, int amount) {
		super();
		this.dId = dId;
		this.rId = rId;
		this.pId = pId;
		this.amount = amount;
	}
	public ReceiptDetailModel() {
		super();
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public ReceiptModel getrId() {
		return rId;
	}
	public void setrId(ReceiptModel rId) {
		this.rId = rId;
	}
	public ProductModel getpId() {
		return pId;
	}
	public void setpId(ProductModel pId) {
		this.pId = pId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ReceiptDetailModel [dId=" + dId + ", rId=" + rId + ", pId=" + pId + ", amount=" + amount + "]";
	}
	
	
}
