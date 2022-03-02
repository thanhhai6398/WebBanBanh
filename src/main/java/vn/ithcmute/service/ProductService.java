package vn.ithcmute.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;

public interface ProductService {
	void update(ProductModel pModel);

	void insert(ProductModel pModel);

	ProductModel get(int id);

	List<ProductModel> getAll();

	void activeProduct(int pID, int state);

	List<ProductModel> search(String txt);

	List<ProductModel> getProductByCID(int cateID);

	List<ProductModel> getActiveProduct();

	List<ProductModel> getNoActiveProduct();

	List<ProductModel> getOutOfStockProduct();

	int CountProduct();
	
	List<ProductModel> getTop8New();
	List<ProductModel> getTop8BestSeller();
	int countAll();
	int countCid(int cid);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByCID(String cid, int index);
	List<ProductModel> getProductBysID(int sID);
	
	//Admin
	int getTotalSoldProductByShop();
		
	Map<String, Integer> getTop6ShopByProduct();
		
	Map<ShopModel, Integer> getAllShopByProduct();
	
	//Seller
	int countNoneProduct();
		
	int countNoActiveProduct();

	int countActiveProduct();
		
	HashMap<Integer, Integer> getSoldAmount();

	List<ProductModel> getTop4NewProduct();

	List<ProductModel> getTop4BestSeller();
}
