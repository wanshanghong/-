package cn.liulangzhe.mapper;

import java.util.List;

import cn.liulangzhe.pojo.Vaccine;

public interface VaccineMapper {
	//添加疫苗
	int AddVaccine(Vaccine vaccine);
	
	//查找所有的疫苗
	List<Vaccine> FindAllVaccine();
	
	//通过(vaccine_id)查找疫苗
	Vaccine FindVaccineById(int vaccine_id);
}
