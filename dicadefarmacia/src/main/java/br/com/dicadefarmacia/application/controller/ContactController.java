package br.com.dicadefarmacia.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.service.ContactService;

@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class ContactController {

	@Autowired
    private ContactService contactService;
 
    @RequestMapping("/")
    public String listContacts(Map<String, Object> map) {
        map.put("contact", new Usuario());
        map.put("contactList", contactService.listContact());
        System.out.println("passou aqui.........");
        return "contact";
    }

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Usuario contact, BindingResult result) {
        contactService.addContact(contact);
        return "redirect:/";
    }
    
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId) {
        contactService.removeContact(contactId);
        return "redirect:/";
    }
    
    @RequestMapping("/client")
    public String redirecionaCliente() {
        
        System.out.println("passou aqui.........");
        return "client";
    }
}
