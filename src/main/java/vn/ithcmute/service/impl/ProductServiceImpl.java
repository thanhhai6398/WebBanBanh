package vn.ithcmute.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.dao.ProductDao;
import vn.ithcmute.dao.impl.ProductDaoImpl;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao dao = new ProductDaoImpl();

	@Override
	public void update(ProductModel pModel) {
		ProductModel oldP = dao.get(pModel.getpID());
		oldP.setpName(pModel.getpName());
		oldP.setpAmount(pModel.getpAmount());
		oldP.setpDescs(pModel.getpDescs());
		oldP.setCategory(pModel.getCategory());
		oldP.setpOrigin(pModel.getpOrigin());
		oldP.setpPrice(pModel.getpPrice());
		oldP.setpUnit(pModel.getpUnit());
		if(pModel.getpImage()!=null) {
			String fileName = pModel.getpImage();
			final String dir = "D:\\BAKERY";
			File file = new File(dir + "/product" + fileName);
			if (file.exists()) {
			file.delete();
			}
			oldP.setpImage(pModel.getpImage());
		}
		dao.update(oldP);
	}

	@Override
	public void insert(ProductModel pModel) {
		dao.insert(pModel);
		
	}

	@Override
	public ProductModel get(int id) {
		return dao.get(id);
	}
	@Override
	public void activeProduct(int pID, int state) {
		dao.activeProduct(pID, state);
	}

	@Override
	public List<ProductModel> getAll() {
		return dao.getAll();
	}
	public static void main(String[] args) {
		ProductServiceImpl serviceImpl = new ProductServiceImpl();
		List<ProductModel> l = new ArrayList<ProductModel>();
		 l  =serviceImpl.search("nhi");
		System.out.print(l);
	}

	@Override
	public List<ProductModel> search(String txt) {
		return dao.search(txt);
	}

	@Override
	public List<ProductModel> getProductByCID(int cateID) {
		return dao.getProductByCID(cateID);
	}

	@Override
	public List<ProductModel> getActiveProduct() {
		return dao.getActiveProduct();
	}

	@Override
	public List<ProductModel> getNoActiveProduct() {
		return dao.getNoActiveProduct();
	}

	@Override
	public List<ProductModel> getOutOfStockProduct() {
		return dao.getOutOfStockProduct();
	}

	@Override
	public int CountProduct() {
		return dao.CountProduct();
	}

	@Override
	public List<ProductModel> getTop8New() {
		return dao.getTop8New();
	}

	@Override
	public List<ProductModel> getTop8BestSeller() {
		return dao.getTop8BestSeller();
	}

	@Override
	public int countAll() {
		return dao.countAll();
	}

	@Override
	public int countCid(int cid) {
		// TODO Auto-generated method stub
		return dao.countCid(cid);
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return dao.pagingProduct(index);
	}

	@Override
	public List<ProductModel> pagingProductByCID(String cid, int index) {
		// TODO Auto-generated method stub
		return dao.pagingProductByCID(cid, index);
	}

	@Override
	public List<ProductModel> getProductBysID(int sID) {
		// TODO Auto-generated method stub
		return dao.getProductBySID(sID);
	}

	@Override
	public int getTotalSoldProductByShop() {
		// TODO Auto-generated method stub
		return dao.getTotalSoldProductByShop();
	}

	@Override
	public Map<String, Integer> getTop6ShopByProduct() {
		// TODO Auto-generated method stub
		return dao.getTop6ShopByProduct();
	}

	@Override
	public Map<ShopModel, Integer> getAllShopByProduct() {
		// TODO Auto-generated method stub
		return dao.getAllShopByProduct();
	}

	@Override
	public int countNoneProduct() {
		// TODO Auto-generated method stub
		return dao.countNoneProduct();
	}

	@Override
	public int countNoActiveProduct() {
		// TODO Auto-generated method stub
		return dao.countNoActiveProduct();
	}

	@Override
	public int countActiveProduct() {
		// TODO Auto-generated method stub
		return dao.countActiveProduct();
	}

	@Override
	public HashMap<Integer, Integer> getSoldAmount() {
		// TODO Auto-generated method stub
		return dao.getSoldAmount();
	}

	@Override
	public List<ProductModel> getTop4NewProduct() {
		// TODO Auto-generated method stub
		return dao.getTop4NewProduct();
	}

	@Override
	public List<ProductModel> getTop4BestSeller() {
		// TODO Auto-generated method stub
		return dao.getTop4BestSeller();
	}

}
