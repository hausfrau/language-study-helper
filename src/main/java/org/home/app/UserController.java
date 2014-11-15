package org.home.app;

import java.util.List;

import org.home.models.Users;
import org.home.services.DataLayerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
public class UserController {
	
	@Autowired
	DataLayerServiceImpl dataLayerService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value="/listUser")	 
	 public String listUsers(ModelMap model){
		model.addAttribute("users",dataLayerService.getAllListUsers());
		return "users";
	 }	
	
	@RequestMapping(value="/createUser")	 
	public String createUser(ModelMap model){	
		model.addAttribute("user", new Users());
		return "editUser";
	 }
	
	 @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	  public String saveUser(@ModelAttribute Users user, ModelMap model) {
		 	if(user.getId() != null) {
		 		user.setNew(false);
		 	}
		 	dataLayerService.saveUser(user);
		 	model.addAttribute("users",dataLayerService.getAllListUsers());
		 	return "users";
	   }
	 
	 
	 @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	  public String editUser(@PathVariable int id, ModelMap model) {
		 	Users u = dataLayerService.getUser((long)id);
		 	model.addAttribute("user", u);
		 	return "editUser";
	   }
	 
	 
	 
	 
	 
	 //ajax
	 
	 /**
	  * Передаем параметры
	  * 
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "/deleteUser", params = {"id","uid"}, method = RequestMethod.GET)  
	 public @ResponseBody String deleteUser(@RequestParam(value = "id") int id, @RequestParam(value = "uid") String uid)  { 
		 try {
				dataLayerService.deleteUser((long)id);
				 //Gson gson = new Gson();
			     //return gson.toJson(dataLayerService.getAllListUsers()).toString();
				return "ok";
			} catch (Exception e) {
				logger.info("Ошибка удаления",e);
				return "error";
			}
	    }  
	 
	 /**
	  * Передаем путь
	  * 
	  * @param id
	 * @return 
	  * @return
	  */
	 @RequestMapping(value = "/deleteUserPath/{id}", method = RequestMethod.GET)  
	  public @ResponseBody String deleteUserPath(@PathVariable int id)  { 
			try {
				dataLayerService.deleteUser((long)id);
				// Gson gson = new Gson();
			    // return gson.toJson(dataLayerService.getAllListUsers()).toString();
				return "ok";
			} catch (Exception e) {
				logger.info("Ошибка удаления",e);
				return "error";
			}
		
	    }
	 
	 
	
	
	
}
