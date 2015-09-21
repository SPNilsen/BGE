package org.bge.ccportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class maps the login URL to the login.jsp page.
 *
 * @author Sean Nilsen
 * @version 1.0
 */
@Controller
public class LoginController
{
	/**
	 * Maps the login URL with the login.jsp page
	 * @return
	 */
	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String login()
	{
		return "login";
	}
}