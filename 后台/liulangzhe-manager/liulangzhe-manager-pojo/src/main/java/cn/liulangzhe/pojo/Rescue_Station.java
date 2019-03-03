package cn.liulangzhe.pojo;

public class Rescue_Station {
	private int station_id;
	private String station_name;
	private double longitude;
	private double latitude;
	
	
	public Rescue_Station() {
		super();
	}
	public Rescue_Station(String station_name, double longitude, double latitude) {
		super();
		this.station_name = station_name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
}
