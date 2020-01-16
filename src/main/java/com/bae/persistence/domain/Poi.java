   package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String poiName;
	private String link;
	
	public Poi() {

	}

	public Poi(String poiName, String link) {
		super();
		this.poiName = poiName;
		this.link = link;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPoiName() {
		return poiName;
	}


	public void setPoiName(String poiName) {
		this.poiName = poiName;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((poiName == null) ? 0 : poiName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (poiName == null) {
			if (other.poiName != null)
				return false;
		} else if (!poiName.equals(other.poiName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Poi [id=" + id + ", poiName=" + poiName + ", link=" + link + "]";
	}
	
}
