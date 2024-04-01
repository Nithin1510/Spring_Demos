package com.insuranceapp.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.insuranceapp.model.AppUser;

@Mapper
public interface IAppUserRepository {
	
	@Insert("insert into user_details values(#{username}, #{password})")
	void addUser(AppUser user);
	
	@Select("select * from user_details where username=#{username}")
	AppUser findByUsername(String username);
}
