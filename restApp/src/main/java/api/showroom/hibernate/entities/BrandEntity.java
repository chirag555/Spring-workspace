package api.showroom.hibernate.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "brands")
@Table(name = "brands")
public class BrandEntity {
	@Id
	@Column(name = "brandId")
	int brandId;
	@Column(name = "brandName")
	String brandName;
	
	
	@Transient
	private List<Link> links;
		
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public BrandEntity() {
	}

	public BrandEntity(int brandId, String brandName) {

		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getbrandId() {
		return brandId;
	}

	public void setbrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
}
