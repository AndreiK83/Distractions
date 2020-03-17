package com.vulk.shkola.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vulk.shkola.dao.UserDAO;
import com.vulk.shkola.model.User;

@Controller
public class MainController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/")
	public ModelAndView listUsers(ModelAndView model) {

		List<User> listOfUsers = userDAO.getAllUsers();
//		System.out.println(listOfUsers);
		model.addObject("listOfUsers", listOfUsers);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addNewUser(ModelAndView model) {
		User newUser = new User();
		model.addObject("user", newUser);
		model.setViewName("user_form");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		System.out.println(user);
		if (user.getId() == null) {
			userDAO.save(user);
		} else {
			userDAO.update(user);
		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int UserId = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.getUserByID(UserId);
		ModelAndView model = new ModelAndView("user_form");
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam Integer id) {
		userDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
}
