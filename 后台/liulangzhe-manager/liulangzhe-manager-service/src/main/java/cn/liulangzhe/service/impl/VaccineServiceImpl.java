package cn.liulangzhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liulangzhe.mapper.VaccineMapper;
import cn.liulangzhe.pojo.Vaccine;
import cn.liulangzhe.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService{
	@Autowired
	private VaccineMapper vaccineMapper;
	
	//查找疫苗(通过Id)
	@Override
	public Vaccine FindVaccinById(int vaccine_id) {
		// TODO Auto-generated method stub
		return vaccineMapper.FindVaccineById(vaccine_id);
	}
	
	//查找所有的疫苗
	@Override
	public List<Vaccine> FindAllVaccin() {
		// TODO Auto-generated method stub
		return vaccineMapper.FindAllVaccine();
	}
	
	//添加疫苗
	@Override
	public int AddVaccine(Vaccine vaccine) {
		// TODO Auto-generated method stub
		return vaccineMapper.AddVaccine(vaccine);
	}
	
}
