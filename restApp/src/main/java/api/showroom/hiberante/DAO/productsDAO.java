package api.showroom.hiberante.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import api.showroom.hibernate.entities.BrandEntity;
import api.showroom.hibernate.entities.productEntity;

public class productsDAO {

	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(productEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<productEntity> getProducts(int brandId) {
		
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<productEntity> productList = null;
		String sql="from products where brandId='"+ brandId +"'";
		
		//System.out.println(productList);
		productList=session.createQuery(sql).getResultList();
		return productList;
	}

	public List<productEntity> getProductsByCategory(int brandId, String category) {		
		
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<productEntity> productList = null;
		String sql="from products where brandId='"+ brandId +"' and category='"+category+"'";
		
		//System.out.println(productList);
		productList=session.createQuery(sql).getResultList();
		return productList;
	}
					
}
