package cn.liulangzhe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.liulangzhe.pojo.Rescue_Station;
import cn.liulangzhe.service.Rescue_StationService;
import net.sf.json.JSONObject;

@Controller
public class Rescue_StationController{
	@Autowired
	private Rescue_StationService rescue_StationService;
	
	
	//通过ID获取救助站的信息
	@RequestMapping("FindRescueById.action")
	@ResponseBody
	public String FindRescueById(@RequestParam("station_id") int station_id)
	{
		System.out.println("通过ID获取救助站功能开启........请求信息：station_id="+station_id);
		Rescue_Station station=new Rescue_Station();
		station=rescue_StationService.FindRescueById(station_id);
		JSONObject json =JSONObject.fromObject(station);
		System.out.println("通过ID获取救助站功能结束........响应信息：json="+json.toString());
		return json.toString();
	}
	
	
	//查找所有的救助站
	@RequestMapping("FindAllRescue")
	@ResponseBody
	public String FindAllRescue(){
		System.out.println("查找所有的救助站功能开启........请求信息：无");
		List<Rescue_Station> list=new ArrayList<Rescue_Station>();
		list=rescue_StationService.FindAllRescue();
		JSONObject json =JSONObject.fromObject(list);
		System.out.println("查找所有的救助站功能结束........响应信息：json="+json.toString());
		return null;
	}
	
	
	//添加救助站 
	@RequestMapping("AddStation")
	@ResponseBody
	public String AddStation(@RequestParam("station_name")String station_name,
			@RequestParam("longitude")double longitude,
			@RequestParam("latitude")double latitude){
		System.out.println("添加救助站功能开启........请求信息：station_name="+station_name+"    longitude="+longitude+"    latitude="+latitude);
		Rescue_Station station=new Rescue_Station(station_name,longitude,latitude);
		
		int station_id=rescue_StationService.AddStation(station);
		
		JSONObject json=new JSONObject();
		json.put("station_id", station_id);
		System.out.println("添加救助站功能结束........响应信息：json="+json.toString());
		return json.toString();
	}
}
