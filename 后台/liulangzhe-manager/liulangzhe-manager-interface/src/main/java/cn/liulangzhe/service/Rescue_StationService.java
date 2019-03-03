package cn.liulangzhe.service;

import java.util.List;

import cn.liulangzhe.pojo.Rescue_Station;

public interface Rescue_StationService {
	
	//通过ID获取救助站的信息
	Rescue_Station FindRescueById(int station_id);
	
	//查找所有的救助站
	List<Rescue_Station> FindAllRescue();
	
	//添加救助站 
	int AddStation(Rescue_Station station);
}
	