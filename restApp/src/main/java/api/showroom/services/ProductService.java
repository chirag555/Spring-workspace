package api.showroom.services;

import java.util.List;

import api.showroom.hiberante.DAO.productsDAO;
import api.showroom.hibernate.entities.productEntity;

public class ProductService {
	productsDAO dao=new productsDAO();
	List<productEntity> productList;
	public List<productEntity> getProducts(int brandId) {
		
		productList= dao.getProducts(brandId);
		return productList;
	}
	public List<productEntity> getProductsByCategory(int brandId, String category) {
		productList= dao.getProductsByCategory(brandId,category);
		return productList;
	}
	

}
