package com.example.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.model.User;
import com.example.security.service.SecurityService;
import com.example.security.service.UserService;
import com.example.security.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        
        if (bindingResult.hasErrors()) {
        	
        	return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        
        return "redirect:/user/index";
    }
    
  
    @GetMapping(value="/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        	
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

 
    @RequestMapping(value= {"/","/index"})
	public String index() {
		return "index";
	}

//    @GetMapping("/user/index")
//    public ModelAndView userIndex(Model model,String message){
//    	ModelAndView modelAndView = new ModelAndView();
//    	modelAndView.addObject("temp","SomeThing");
//    	Map<String,Object> temp = model.asMap();
//    	return modelAndView;
//    	
//    }
    
    @RequestMapping("/user/index")
    public ModelAndView userIndex(){
        ModelAndView model = new ModelAndView("/user/index");
        model.addObject("temp","SomeMessage");
        return model;
    }
    
    @RequestMapping("/loginError")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }
    
    @RequestMapping("/admin/admin")
    public ModelAndView userAdmin(){
        ModelAndView model = new ModelAndView("/admin/admin");
        model.addObject("temp","SomeMessage");
        return model;
    }
    
    @GetMapping("/admin/error")
    public ModelAndView adminError(){
        ModelAndView model = new ModelAndView("/admin/admin_denied");
        model.addObject("temp","AccessDenied");
        return model;
    }
}
