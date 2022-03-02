package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.StateReceiptDao;
import vn.ithcmute.model.StateReceiptModel;

public class StateReceiptDaoImpl extends DBConnection implements StateReceiptDao{

	@Override
	public void insert(StateReceiptModel StateReceipt) {
		String sql = "INSERT INTO StateReceipt(StateID, StateName) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, StateReceipt.getStId());
			ps.setString(2, StateReceipt.getStName());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(StateReceiptModel StateReceipt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StateReceiptModel get(int id) {
		StateReceiptModel state = new StateReceiptModel();
		String sql ="select * from StateReceipt where StateID=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				state.setStId(rs.getInt(1));
				state.setStName(rs.getString(2));
				return state;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StateReceiptModel> getAll() {
		List<StateReceiptModel> StateList = new ArrayList<StateReceiptModel>();
		String sql = "SELECT StateReceipt.StateID, StateReceipt.StateName FROM StateReceipt";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StateReceiptModel state = new StateReceiptModel();
				state.setStId(rs.getInt("StateID"));
				state.setStName(rs.getString("StateName"));
				
				StateList.add(state);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StateList;
	}

	@Override
	public List<StateReceiptModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
