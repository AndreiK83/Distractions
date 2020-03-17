package com.vulk.shkola.dao;

import java.util.List;

import com.vulk.shkola.model.User;

public interface UserDAO {
	public int save(User user);
	
	public int delete(Integer id);
	
	public int update(User user);
	
	public User getUserByID(Integer id);
	
	public List<User> getAllUsers();
}
