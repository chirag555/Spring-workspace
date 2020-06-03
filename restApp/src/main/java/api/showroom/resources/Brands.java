package api.showroom.resources;

import java.util.ArrayList;
import java.util.List;

import api.showroom.hibernate.entities.BrandEntity;
import api.showroom.hibernate.entities.Link;
import api.showroom.services.BrandService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;

@Path("/showroom/brands")
public class Brands {
	BrandService brandService = new BrandService();

	@GET
	// @Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = brandService.getBrands();
		return list;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandEntity getBrands(@PathParam("brandId") int brandId,@Context UriInfo uri) {
		Link self= new Link(uri.getAbsolutePath().toString(),"self");
		Link product=new Link(uri.getAbsolutePathBuilder().path("products").build().toString(),"product");
		BrandEntity brand=brandService.getBrands(brandId);;
		List<Link> links=new ArrayList<>();
		links.add(self);
		links.add(product);
		brand.setLinks(links);
		return brand;
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response postBrands(BrandEntity brand) {
		brandService.addBrands(brand);
		return Response.status(Status.CREATED).entity("OK").build();

	}

	@PUT
	// @Path("/brands/{brandId}/{brandName}")
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {
		updatedBrand.setbrandId(brandId);
		brandService.updateBrand(updatedBrand);
	}
	
	
	@DELETE
	@Path("/{brandId}")
	// @Consumes(MediaType.TEXT_PLAIN)
	public void deleteBrands(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}
	@Path("/{brandId}/products")
	public products productsDelegation() {
		return new products();
	}
}
