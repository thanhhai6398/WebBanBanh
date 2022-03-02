package vn.ithcmute.service.impl;


import java.util.List;

import vn.ithcmute.dao.StatisticsDao;
import vn.ithcmute.dao.impl.StatisticsDaoImpl;
import vn.ithcmute.model.StatisticsModel;
import vn.ithcmute.service.StatisticsService;



public class StatisticsServiceImpl implements StatisticsService{
	StatisticsDao dao  = new StatisticsDaoImpl();
	
	@Override
	public List<StatisticsModel> getListAllReceipt() {
		return dao.getListAllReceipt();
	}

	@Override
	public List<StatisticsModel> getListDeliveredReceipt() {
		return dao.getListDeliveredReceipt();
	}

	@Override
	public List<StatisticsModel> getStatisticsCategory() {
		return dao.getStatisticsCategory();
	}

	@Override
	public List<StatisticsModel> getStatisticsProduct() {
		return dao.getStatisticsProduct();
	}

	@Override
	public List<StatisticsModel> getStatistics(String sql) {
		return dao.getStatistics(sql);
	}

}
