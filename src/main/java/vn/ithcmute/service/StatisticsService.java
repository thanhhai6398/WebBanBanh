package vn.ithcmute.service;

import java.util.List;

import vn.ithcmute.model.StatisticsModel;

public interface StatisticsService {
	List<StatisticsModel> getListAllReceipt();

	List<StatisticsModel> getListDeliveredReceipt();

	List<StatisticsModel> getStatisticsCategory();

	List<StatisticsModel> getStatisticsProduct();

	List<StatisticsModel> getStatistics(String sql);
}
