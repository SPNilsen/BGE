package org.bge.ccportal.controller;

import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.bge.ccportal.model.User;
import org.bge.ccportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class maps the admin URL to the admin.jsp page.
 *
 * @author Alessandro Giannone
 * @version 1.0
 */
@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    UserService userService;

    /**
     * Maps the admin URL with the admin.jsp page
     *
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "admin";
    }

    @RequestMapping(value = "/admin/AddUser", method = RequestMethod.POST)
    public String addUser(ModelMap model, @ModelAttribute User user) {
        userService.insertData(user);
        model.addAttribute("pageMsg", "User Added!");
        return "admin_msg";
    }

    @RequestMapping(value = "/admin/EditUser", method = RequestMethod.GET)
    public String editUserGet(ModelMap model, @ModelAttribute User user) {
        
        user = userService.getUser(user.getUsername());
        
        model.addAttribute("user",user);
        
        return "admin_edituser";
    }

    @RequestMapping(value = "/admin/EditUser", method = RequestMethod.POST)
    public String editUserPost(ModelMap model, @ModelAttribute User user, HttpServletRequest request) {
        
        String retString = "admin_msg";
        
        if (request.getParameter("userDelete") != null) {
            //Handle Postback of Delete Button from /admin page
            
            userService.deleteData(user.getUsername());
            model.addAttribute("pageMsg", "User : "+user.getUsername()+", has been deleted!");
            
        } else  if (request.getParameter("userEdit") != null) {
            //Handle Postback of Edit Button from /admin page
            
            model.addAttribute("pageMsg", "User would have been edited!");
            user = userService.getUser(user.getUsername());
            model.addAttribute("user",user);
            retString = "admin_edituser";
            
        }else  if (request.getParameter("userUpdate") != null) {
            //Handle Postback of Update Button from /admin/EditUser page
            System.out.println("\r\n***\r\n***\r\n***   Here I am. \r\n***\r\n***\r\n***");
            System.out.println(user.describe());
            
            userService.updateData(user);
            model.addAttribute("pageMsg", "User has been edited!");
            retString = "admin_msg";
        }
        return retString;
    } 
}
