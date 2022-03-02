package vn.ithcmute.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.DeliveryDetailDao;
import vn.ithcmute.dao.ReceiptDao;
import vn.ithcmute.model.DeliveryDetailModel;

import vn.ithcmute.service.DeliveryCompanyService;
import vn.ithcmute.service.impl.DeliveryCompanyServiceImpl;

public class DeliveryDetailDaoImpl implements DeliveryDetailDao{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DeliveryCompanyService companyService = new DeliveryCompanyServiceImpl();
	ReceiptDao receiptService = new ReceiptDaoImpl();
	
	//Lay theo Ma hoa don
	@Override
	public DeliveryDetailModel get(int id) {
		DeliveryDetailModel detailModel = new DeliveryDetailModel();
		String sql="select * from Delivery where ReceiptID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				detailModel.setCompany(companyService.get((rs.getInt(1))));
				detailModel.setReceipt(receiptService.get(rs.getInt(2)));
				detailModel.setRepPrice(rs.getInt(3));
				return detailModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DeliveryDetailModel> getAll() {
		List<DeliveryDetailModel> list = new ArrayList<DeliveryDetailModel>();
		String sql="select * from Delivery";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				DeliveryDetailModel detailModel = new DeliveryDetailModel();
				detailModel.setCompany(companyService.get((rs.getInt(1))));
				detailModel.setReceipt(receiptService.get(rs.getInt(2)));
				detailModel.setRepPrice(rs.getInt(3));
				list.add(detailModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(DeliveryDetailModel deliveryDetail) {
		String sql ="insert into Delivery(CompanyID, ReceiptID, ReceiptPrice) values(?,?,?)";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,deliveryDetail.getCompany().getComID());
			ps.setInt(2,deliveryDetail.getReceipt().getrId());
			ps.setInt(3, deliveryDetail.getRepPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDeliveryDetail(DeliveryDetailModel dModel) {
		// TODO Auto-generated method stub
		String sql="update Delivery set CompanyID=?,ReceiptPrice=? \r\n" + 
				"where ReceiptID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dModel.getCompany().getComID());
			ps.setInt(2, dModel.getRepPrice());
			ps.setInt(3, dModel.getReceipt().getrId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
