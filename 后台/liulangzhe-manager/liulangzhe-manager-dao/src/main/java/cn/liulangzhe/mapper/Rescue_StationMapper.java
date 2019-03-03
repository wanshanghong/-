package cn.liulangzhe.mapper;

import java.util.List;

import cn.liulangzhe.pojo.Rescue_Station;

public interface Rescue_StationMapper {
	//查找救助站(通过Id)
	Rescue_Station FindRescueById(int station_id);
	
	//查找所有的救助站
	List<Rescue_Station> FindAllRescue();
	
	//添加救助站 
	int AddStation(Rescue_Station station);
	
}
