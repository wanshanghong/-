package cn.liulangzhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liulangzhe.mapper.Rescue_StationMapper;
import cn.liulangzhe.pojo.Rescue_Station;
import cn.liulangzhe.service.Rescue_StationService;

@Service
public class Rescue_StationServiceImpl implements Rescue_StationService{
	@Autowired
	private Rescue_StationMapper rescue_StationMapper;
	
	
	//通过static_id寻找救助站信息
	@Override
	public Rescue_Station FindRescueById(int station_id) {
		// TODO Auto-generated method stub
		return rescue_StationMapper.FindRescueById(station_id);
	}

	//查找所有的救助站
	@Override
	public List<Rescue_Station> FindAllRescue() {
		// TODO Auto-generated method stub
		return rescue_StationMapper.FindAllRescue();
	}

	//添加救助站 
	@Override
	public int AddStation(Rescue_Station station) {
		// TODO Auto-generated method stub
		return rescue_StationMapper.AddStation(station);
	}

	
}
