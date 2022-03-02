package vn.ithcmute.model;

public class CategoryModel {
	private int cID;
	private String cName;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int cID, String cName) {
		super();
		this.cID = cID;
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "CategoryModel [cID=" + cID + ", cName=" + cName + "]";
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
}
