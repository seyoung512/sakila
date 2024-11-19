package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Staff;

@Mapper
public interface StaffMapper {
	
	Integer updateStaff(Staff staff);
	
	Integer selectStaffCount();
	
	List<Staff> selectStaffList(Map<String, Object> map);
	
	Integer insertStaff(Staff staff);
	
	// /on/staffOne.jsp
	Map<String, Object> selectStaffOne(Integer staffId);
	
	// /off/login.jsp
	Staff login(Staff staff);
}
