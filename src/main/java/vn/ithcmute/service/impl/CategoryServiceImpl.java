package vn.ithcmute.service.impl;

import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.dao.CategoryDao;
import vn.ithcmute.dao.impl.CategoryDaoImpl;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao dao = new CategoryDaoImpl();

	@Override
	public CategoryModel get(int id) {
		return dao.get(id);
	}

	@Override
	public ArrayList<CategoryModel> getAllCategory() {
		return dao.getAllCategory();
	}

	@Override
	public void insert(CategoryModel cate) {
		// TODO Auto-generated method stub
		dao.insert(cate);
	}

	@Override
	public void edit(CategoryModel cate) {
		// TODO Auto-generated method stub
		dao.edit(cate);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public int isCategoryExist(CategoryModel cate) {
		// TODO Auto-generated method stub
		return dao.isCategoryExist(cate);
	}

	@Override
	public List<CategoryModel> getListByShop() {
		// TODO Auto-generated method stub
		return dao.getListByShop();
	}

}