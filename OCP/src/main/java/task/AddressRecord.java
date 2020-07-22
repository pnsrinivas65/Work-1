package task;

public class AddressRecord extends Record {

	private String country;
	private String province;
	private String city;
	private String street;
	private String building;
	private String apartment;
	private String index;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String format() {
		return "address: " + getCountry() + ", " + getProvince() + ", " + getCity() + ", " + getStreet() + " st., "
				+ getBuilding() + " b., " + getApartment() + " apt., " + getIndex();
	}
}
