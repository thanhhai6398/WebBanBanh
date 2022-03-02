package vn.ithcmute.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.ProductDao;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.CategoryService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.CategoryServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.util.ShopID;

public class ProductDaoImpl implements ProductDao{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	CategoryService cateService = new CategoryServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	@Override
	public void insert(ProductModel pModel) {
		String sql ="insert into Product (ProductName,ProductImage,Price,Unit,Amount,Origin,CategoryID,Descs,ShopID,Active) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pModel.getpName());
			ps.setString(2, pModel.getpImage());
			ps.setInt(3, pModel.getpPrice());
			ps.setString(4, pModel.getpUnit());
			ps.setInt(5, pModel.getpAmount());
			ps.setString(6, pModel.getpOrigin());
			ps.setInt(7, pModel.getCategory().getcID());
			ps.setString(8, pModel.getpDescs());
			ps.setInt(9, pModel.getShop().getsID());
			ps.setInt(10, pModel.getpActive());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(ProductModel  pModel) {
		String sql ="update Product set ProductName=?,ProductImage=?,Price=?,Unit=?,Amount=?,Origin=?,CategoryID=?,Descs=?\r\n" + 
				"where ProductID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pModel.getpName());
			ps.setString(2, pModel.getpImage());
			ps.setInt(3, pModel.getpPrice());
			ps.setString(4, pModel.getpUnit());
			ps.setInt(5, pModel.getpAmount());
			ps.setString(6, pModel.getpOrigin());
			ps.setInt(7, pModel.getCategory().getcID());
			ps.setString(8, pModel.getpDescs());
			ps.setInt(9, pModel.getpID());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void activeProduct(int pID,int state) {
		String sql="update Product set Active=? where ProductID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, pID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public ProductModel get(int id) {
		ProductModel pModel = new ProductModel();
		String sql="select * from Product where ProductID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				pModel=new ProductModel(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getInt(6),
						rs.getString(7),cateService.get(rs.getInt(8)),
						rs.getString(9),shopService.get(rs.getInt(10)),rs.getInt(11));
				return pModel;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<ProductModel> getAll() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select * from Product";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ProductModel> search(String txt){
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select * from Product where ProductName like ?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+txt+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ProductModel> getProductByCID(int cateID){
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select * from Product where CategoryID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,cateID);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<ProductModel> getListProduct(String sql) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		try{
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ProductModel> getActiveProduct() {
		String sql ="select * from Product where Active=1";
		return this.getListProduct(sql);
	}
	@Override
	public List<ProductModel> getNoActiveProduct() {
		String sql ="select * from Product where Active=0";
		return this.getListProduct(sql);
	}
	@Override
	public List<ProductModel> getOutOfStockProduct() {
		String sql ="select * from Product where Amount=0";
		return this.getListProduct(sql);
	}
	public int getCount(String sql) {
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ShopID.sID);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int CountProduct() {
		String sql="select count(*)  from Product where ShopID=?";
		return this.getCount(sql);
	}
	@Override
	public List<ProductModel> getTop8New() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select top 8 * from Product where Active = 1 and Amount >0 order by ProductID DESC";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ProductModel> getTop8BestSeller() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select top 8 * from Product where Active = 1 and Amount >0 order by Amount Desc";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int countAll() {
		String query = "SELECT count(*) FROM Product";
		try {
			con = new DBConnection().getConnection();// mo ket noi voi sql
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public int countCid(int cid) {
		String query = "SELECT count(*) FROM Product WHERE CategoryID = ?";
		try {
			con = new DBConnection().getConnection();// mo ket noi voi sql
			ps = con.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public List<ProductModel> pagingProduct(int index) {
				List<ProductModel> list = new ArrayList<ProductModel>();

				String sql = "select * from Product where Active = 1 and Amount >0 order by ProductID OFFSET ? ROW fetch next 6 rows only ";
				try {
					con = new DBConnection().getConnection();
					ps = con.prepareStatement(sql);
					ps.setInt(1, (index - 1) * 6);
					rs = ps.executeQuery();

					// lấy ResultSet đổ vào List
					while (rs.next()) {
						ProductModel pModel = new ProductModel();
						pModel.setpID(rs.getInt(1));
						pModel.setpName(rs.getString(2));
						pModel.setpImage(rs.getString(3));
						pModel.setpPrice(rs.getInt(4));
						pModel.setpUnit(rs.getString(5));
						pModel.setpAmount(rs.getInt(6));
						pModel.setpOrigin(rs.getString(7));
						pModel.setCategory(cateService.get(rs.getInt(8)));
						pModel.setpDescs(rs.getString(9));
						pModel.setShop(shopService.get(rs.getInt(10)));
						pModel.setpActive(rs.getInt(11));
						list.add(pModel);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
			
	}
	@Override
	public List<ProductModel> pagingProductByCID(String cid, int index) {

				List<ProductModel> list = new ArrayList<ProductModel>();
				String sql = "select * from product where Active = 1 and Amount >0 and CategoryID = ? order by ProductID OFFSET ? ROW fetch next 6 rows only ";
				try {
					con = new DBConnection().getConnection();
					ps = con.prepareStatement(sql);
					ps.setString(1, cid);
					ps.setInt(2, (index - 1) * 6);
					rs = ps.executeQuery();
					while (rs.next()) {
						ProductModel pModel = new ProductModel();
						pModel.setpID(rs.getInt(1));
						pModel.setpName(rs.getString(2));
						pModel.setpImage(rs.getString(3));
						pModel.setpPrice(rs.getInt(4));
						pModel.setpUnit(rs.getString(5));
						pModel.setpAmount(rs.getInt(6));
						pModel.setpOrigin(rs.getString(7));
						pModel.setCategory(cateService.get(rs.getInt(8)));
						pModel.setpDescs(rs.getString(9));
						pModel.setShop(shopService.get(rs.getInt(10)));
						pModel.setpActive(rs.getInt(11));
						list.add(pModel);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
	}
	@Override
	public List<ProductModel> getProductBySID(int sID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql="select * from Product where Active = 1 and Amount >0 and ShopID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,sID);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel pModel = new ProductModel();
				pModel.setpID(rs.getInt(1));
				pModel.setpName(rs.getString(2));
				pModel.setpImage(rs.getString(3));
				pModel.setpPrice(rs.getInt(4));
				pModel.setpUnit(rs.getString(5));
				pModel.setpAmount(rs.getInt(6));
				pModel.setpOrigin(rs.getString(7));
				pModel.setCategory(cateService.get(rs.getInt(8)));
				pModel.setpDescs(rs.getString(9));
				pModel.setShop(shopService.get(rs.getInt(10)));
				pModel.setpActive(rs.getInt(11));
				list.add(pModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getTotalSoldProductByShop() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT ISNULL(SUM(Amount), 0) AS TongSanPham\r\n" + 
				"FROM Receipt INNER JOIN ReceiptDetail\r\n" + 
				"ON Receipt.ReceiptID = ReceiptDetail.ReceiptID\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())";
		
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("TongSanPham");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public Map<String, Integer> getTop6ShopByProduct() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT TOP 6 Shop.ShopID, ISNULL(TongSanPham, 0) AS TongSanPham\r\n" + 
				"FROM Shop LEFT OUTER JOIN\r\n" + 
				"(SELECT Receipt.ShopID, SUM(Amount) AS TongSanPham\r\n" + 
				"FROM Receipt INNER JOIN ReceiptDetail\r\n" + 
				"ON Receipt.ReceiptID = ReceiptDetail.ReceiptID\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n" + 
				"GROUP BY Receipt.ShopID) AS R\r\n" + 
				"ON Shop.ShopID = R.ShopID\r\n" + 
				"ORDER BY TongSanPham DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopService.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongSanPham");
				map.put(shop.getsName(), count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<ShopModel, Integer> getAllShopByProduct() {
		// TODO Auto-generated method stub
		Map<ShopModel, Integer> map = new HashMap<ShopModel, Integer>();
		String sql = "SELECT Shop.ShopID, ISNULL(TongSanPham, 0) AS TongSanPham\r\n" + 
				"FROM Shop LEFT OUTER JOIN\r\n" + 
				"(SELECT Receipt.ShopID, SUM(Amount) AS TongSanPham\r\n" + 
				"FROM Receipt INNER JOIN ReceiptDetail\r\n" + 
				"ON Receipt.ReceiptID = ReceiptDetail.ReceiptID\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n" + 
				"GROUP BY Receipt.ShopID) AS R\r\n" + 
				"ON Shop.ShopID = R.ShopID\r\n" + 
				"ORDER BY TongSanPham DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopService.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongSanPham");
				map.put(shop, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public int countNoneProduct() {
		// TODO Auto-generated method stub
		String sql = "select count(*)  from Product where Amount=0 and ShopID=?";
		return this.getCount(sql);
	}
	@Override
	public int countNoActiveProduct() {
		// TODO Auto-generated method stub
		String sql = "select count(*)  from Product where Active=0 and ShopID=?";
		return this.getCount(sql);
	}
	@Override
	public int countActiveProduct() {
		String sql = "select count(*)  from Product where Active=1 and ShopID=?";
		return this.getCount(sql);
	}
	@Override
	public HashMap<Integer, Integer> getSoldAmount() {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		String sql="select ProductID, sum(ReceiptDetail.Amount) as 'SL'\r\n" + 
				"from ReceiptDetail,Receipt\r\n" + 
				"where ReceiptDetail.ReceiptID=Receipt.ReceiptID and StateID=3 \r\n" + 
				"group by ProductID";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			//ps.setInt(1,ShopID.sID);
			rs = ps.executeQuery();
			while(rs.next()) {
				int pID = rs.getInt(1);
				int sold = rs.getInt(2);
				map.put(pID, sold);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public List<ProductModel> getTop4NewProduct() {
		String sql = "select top 4 * from Product where ShopID=? order by ProductID desc";
		return this.getListProduct(sql);
	}
	@Override
	public List<ProductModel> getTop4BestSeller() {
		// TODO Auto-generated method stub
		String sql="select *\r\n" + 
				"from Product,(select top 4 ProductID,sum(ReceiptDetail.Amount) as'SL' from Receipt,ReceiptDetail\r\n" + 
				"where Receipt.ReceiptID=ReceiptDetail.ReceiptID and ShopID=?\r\n" + 
				"group by ProductID\r\n" + 
				"order by SL) as a\r\n" + 
				"where Product.ProductID=a.ProductID";
		return getListProduct(sql);
	}
	

}
