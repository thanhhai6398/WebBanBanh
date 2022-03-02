package vn.ithcmute.model;

public class StateReceiptModel {
	private int stId;
	private String stName;
	public StateReceiptModel() {
		super();
	}
	public StateReceiptModel(int stId, String stName) {
		super();
		this.stId = stId;
		this.stName = stName;
	}
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	@Override
	public String toString() {
		return "StateReceiptModel [stId=" + stId + ", stName=" + stName + "]";
	}
	
}
