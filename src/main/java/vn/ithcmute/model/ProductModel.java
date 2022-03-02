package vn.ithcmute.model;

public class ProductModel {
	private int pID;
	private String pName;
	private String pImage;
	private int pPrice;
	private String pUnit;
	private int pAmount;
	private String pOrigin;
	private CategoryModel category;
	private String pDescs;
	private ShopModel Shop;
	private int pActive;
	public ShopModel getShop() {
		return Shop;
	}
	public void setShop(ShopModel shop) {
		Shop = shop;
	}
	public int getpActive() {
		return pActive;
	}
	public void setpActive(int pActive) {
		this.pActive = pActive;
	}
	public ProductModel(int pID, String pName, String pImage, int pPrice, String pUnit, int pAmount, String pOrigin,
			CategoryModel category, String pDescs, ShopModel shop, int pActive) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.pImage = pImage;
		this.pPrice = pPrice;
		this.pUnit = pUnit;
		this.pAmount = pAmount;
		this.pOrigin = pOrigin;
		this.category = category;
		this.pDescs = pDescs;
		Shop = shop;
		this.pActive = pActive;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpUnit() {
		return pUnit;
	}
	public void setpUnit(String pUnit) {
		this.pUnit = pUnit;
	}
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	public String getpOrigin() {
		return pOrigin;
	}
	public void setpOrigin(String pOrigin) {
		this.pOrigin = pOrigin;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public String getpDescs() {
		return pDescs;
	}
	public void setpDescs(String pDescs) {
		this.pDescs = pDescs;
	}

}
