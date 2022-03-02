package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.DeliveryCompanyDao;
import vn.ithcmute.model.DeliveryCompanyModel;

public class DeliveryCompanyDaoImpl implements DeliveryCompanyDao{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public DeliveryCompanyModel get(int id) {
		String sql="select * from DeliveryCompany where CompanyID=?";
		DeliveryCompanyModel companyModel = new DeliveryCompanyModel();
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				companyModel.setComID(rs.getInt(1));
				companyModel.setComName(rs.getString(2));
				companyModel.setComPrice(rs.getInt(3));
				return companyModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DeliveryCompanyModel> getAll() {
		List<DeliveryCompanyModel> list = new ArrayList<DeliveryCompanyModel>();
		String sql="select * from DeliveryCompany";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				DeliveryCompanyModel deliModel = new DeliveryCompanyModel();
				deliModel.setComID(rs.getInt(1));
				deliModel.setComName(rs.getString(2));
				deliModel.setComPrice(rs.getInt(3));
				list.add(deliModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
