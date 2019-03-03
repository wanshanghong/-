package cn.liulangzhe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.liulangzhe.pojo.Vaccine;
import cn.liulangzhe.service.VaccineService;
import net.sf.json.JSONObject;

@Controller
public class VaccineController{
	@Autowired
	private VaccineService vaccineService;
	
	
	//查找疫苗(通过ID)
	@RequestMapping("FindVaccinById")
	@ResponseBody
	public String FindVaccinById(@RequestParam("vaccine_id") int vaccine_id)
	{
		
		System.out.println("查找疫苗(通过ID)功能触发.....请求消息：vaccine_id="+vaccine_id);
		Vaccine vaccine=new Vaccine();
		vaccine = vaccineService.FindVaccinById(vaccine_id);
		JSONObject json=JSONObject.fromObject(vaccine);
		System.out.println("查找疫苗(通过ID)功能结束.....响应消息：json="+json.toString());
		return json.toString();
	}
	
	//查找所有疫苗
	@RequestMapping("FindAllVaccin")
	@ResponseBody
	public String FindAllVaccin()
	{
		
		System.out.println("查找所有疫苗功能触发.....请求消息:无");
		List<Vaccine> list=new ArrayList<Vaccine>();
		list = vaccineService.FindAllVaccin();
		JSONObject json=JSONObject.fromObject(list);
		System.out.println("查找所有疫苗功能结束.....响应消息：json="+json.toString());
		return json.toString();
	}
	
	//添加疫苗
	@RequestMapping("AddVaccine")
	@ResponseBody
	public String AddVaccine(@RequestParam("vaccine_name")String vaccine_name)
	{
		Date vaccine_date=new Date();
		Vaccine vaccine=new Vaccine();
		vaccine.setVaccine_date(vaccine_date);
		vaccine.setVaccine_name(vaccine_name);
		int vaccine_id=vaccineService.AddVaccine(vaccine);
		JSONObject json=new JSONObject();
		json.put("vaccine_id", vaccine_id);
		return json.toString();
	}
	
}
