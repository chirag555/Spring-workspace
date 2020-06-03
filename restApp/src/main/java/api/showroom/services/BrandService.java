package api.showroom.services;

import java.util.List;

import api.showroom.hiberante.DAO.BrandsDAO;
import api.showroom.hibernate.entities.BrandEntity;



public class BrandService {
		BrandsDAO dao= new BrandsDAO();
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list=dao.getBrands();
		return list;
	}

	public void addBrands(BrandEntity brand) {
		
		dao.addBrand(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) {
		dao.updateBrand(updatedBrand);
		
	}

	public void deleteBrand(int brandId) {
		dao.deleteBrand(brandId);
	}

	public BrandEntity getBrands(int brandId) {
		return dao.getBrands(brandId);
	}

	

	
}
