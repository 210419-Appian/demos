package com.revature.models;

import java.io.Serializable;

/**
 * Homes for Avengers.
 */
public class Home implements Serializable{
	//Java Bean is a design convention for building entity objects. 

	private static final long serialVersionUID = 1L;


	private String name;
	private String stNum;
	private String stName;
	private String city;
	private String region;
	private String zip;
	private String country;
	private Avenger[] residents; 
	


	public Home(String name, String stNum, String stName, String city, String region, String zip, String country,
			Avenger[] residents) {
		super();
		this.name = name;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.region = region;
		this.zip = zip;
		this.country = country;
		this.residents = residents;
	}

	public Home() {
		super();
	}

	public Home(String name, String stNum, String stName, String city, String region, String zip, String country) {
		super();
		this.name = name;
		this.stNum = stNum;
		this.stName = stName;
		this.city = city;
		this.region = region;
		this.zip = zip;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStNum() {
		return stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Avenger[] getResidents() {
		return residents;
	}

	public void setResidents(Avenger[] residents) {
		this.residents = residents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((stName == null) ? 0 : stName.hashCode());
		result = prime * result + ((stNum == null) ? 0 : stNum.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Home other = (Home) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (stName == null) {
			if (other.stName != null)
				return false;
		} else if (!stName.equals(other.stName))
			return false;
		if (stNum == null) {
			if (other.stNum != null)
				return false;
		} else if (!stNum.equals(other.stNum))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [name=" + name + ", stNum=" + stNum + ", stName=" + stName + ", city=" + city + ", region="
				+ region + ", zip=" + zip + ", country=" + country + "]";
	}


	
	
	
	
	

}
