package vn.ithcmute.dao;

import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.model.CategoryModel;

public interface CategoryDao {
	void insert(CategoryModel cate);
	void edit(CategoryModel cate);
	void delete(int id);

	CategoryModel get(int id);

	ArrayList<CategoryModel> getAllCategory();
	
	int isCategoryExist(CategoryModel cate);
	
	List<CategoryModel> getListByShop();
}
