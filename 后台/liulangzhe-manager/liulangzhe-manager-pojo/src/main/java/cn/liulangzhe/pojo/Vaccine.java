package cn.liulangzhe.pojo;

import java.util.Date;

//疫苗表
public class Vaccine {
	private int vaccine_id;
	private String vaccine_name;
	private Date vaccine_date;
	public int getVaccine_id() {
		return vaccine_id;
	}
	public void setVaccine_id(int vaccine_id) {
		this.vaccine_id = vaccine_id;
	}
	public String getVaccine_name() {
		return vaccine_name;
	}
	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}
	public Date getVaccine_date() {
		return vaccine_date;
	}
	public void setVaccine_date(Date vaccine_date) {
		this.vaccine_date = vaccine_date;
	}
	
	
}
