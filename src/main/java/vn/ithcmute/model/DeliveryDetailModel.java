package vn.ithcmute.model;

public class DeliveryDetailModel {
	private DeliveryCompanyModel company;
	private ReceiptModel receipt;
	private int repPrice;
	public DeliveryDetailModel() {
		super();
	}
	public DeliveryDetailModel(DeliveryCompanyModel company, ReceiptModel receipt, int repPrice) {
		super();
		this.company = company;
		this.receipt = receipt;
		this.repPrice = repPrice;
	}
	public DeliveryCompanyModel getCompany() {
		return company;
	}
	public void setCompany(DeliveryCompanyModel company) {
		this.company = company;
	}
	public ReceiptModel getReceipt() {
		return receipt;
	}
	public void setReceipt(ReceiptModel receipt) {
		this.receipt = receipt;
	}
	public int getRepPrice() {
		return repPrice;
	}
	public void setRepPrice(int repPrice) {
		this.repPrice = repPrice;
	}
	@Override
	public String toString() {
		return "DeliveryDetailModel [company=" + company + ", receipt=" + receipt + ", repPrice=" + repPrice + "]";
	}
}
