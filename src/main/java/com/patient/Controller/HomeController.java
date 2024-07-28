package com.patient.Controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patient.entity.Contact;
import com.patient.service.ContactService;
import com.patient.service.RoleService;
import com.patient.service.UserService;

@Controller
@RequestMapping("Home")
public class HomeController
{
    private ContactService contactService;
    private UserService userService;
    private RoleService roleService;
    public HomeController(RoleService roleService, ContactService contactService, UserService userService)
    {
        this.contactService = contactService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String getHomePage(Model model)
    {
        return "Home/home";
    }
    @GetMapping("/home-page")
    public String sayHello(Model model)
    {
        model.addAttribute("date",new java.util.Date());
        return "Home/home";
    }
    @GetMapping("/login")
    public String login()
    {
        return "Login/Login";
    }
    @GetMapping("/signUP")
    public String signUP(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("roleList",roleService());
        return "Register/sign-up";
    }

    private Object roleService() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/register-user")
    public String registerNewUser(@ModelAttribute("user") User user)
    {
        userService(user);
        return "redirect:/Home/home-page";
    }
    private void userService(User user) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/contact-US")
    public String getContactPage(Model model)
    {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact-US/contact-US";
    }

    @PostMapping("/save-contact")
    public String reciveContact(@ModelAttribute("contact") Contact contact)
    {
        try
        {
            contactService(contact);
            return "redirect:/Home/home-page";
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:/Home/home-page";
    }

	private void contactService(Contact contact) {
		// TODO Auto-generated method stub
		
	}
}
