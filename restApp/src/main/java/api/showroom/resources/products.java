package api.showroom.resources;

import java.util.List;

import api.showroom.hibernate.entities.productEntity;
import api.showroom.services.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

//@Path("/showroom/brands")
public class products {
	ProductService productService = new ProductService();

	@GET
	//@Path("/{brandId}/products")
	// @Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<productEntity> getProducts(@PathParam("brandId") int brandId,
			@QueryParam("category") String category,
			@QueryParam("start") int start,
			@QueryParam ("end") int end) {
		List<productEntity> productList ;
		//if(category.equals("bike") || category.equals("car")) {
		if(category!=null) {
			 productList = productService.getProductsByCategory(brandId,category);
		}
		else {
			 productList = productService.getProducts(brandId);
			
		}
		if(end>0) {			
			productList=productList.subList(start,end);
		}
		return productList;
		
	}

}
