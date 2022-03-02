package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.StatisticsModel;


public interface StatisticsDao {

	List<StatisticsModel> getListAllReceipt();

	List<StatisticsModel> getListDeliveredReceipt();

	List<StatisticsModel> getStatisticsCategory();

	List<StatisticsModel> getStatisticsProduct();

	List<StatisticsModel> getStatistics(String sql);

}
