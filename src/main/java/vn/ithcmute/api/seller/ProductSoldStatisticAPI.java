package vn.ithcmute.api.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.ithcmute.model.StatisticsModel;
import vn.ithcmute.service.StatisticsService;
import vn.ithcmute.service.impl.StatisticsServiceImpl;
import vn.ithcmute.util.HttpUtil;



@WebServlet(urlPatterns= {"/api-sold-product"})
public class ProductSoldStatisticAPI extends HttpServlet{

	StatisticsService service = new StatisticsServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("application/json");
		 List<StatisticsModel> solidProduct =  HttpUtil.of(req.getReader()).listModel(StatisticsModel.class);
		 solidProduct = service.getStatisticsProduct();
		 mapper.writeValue(resp.getOutputStream(), solidProduct);
	}

}
