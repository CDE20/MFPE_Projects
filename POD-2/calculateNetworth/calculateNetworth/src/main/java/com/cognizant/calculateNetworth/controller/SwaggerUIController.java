package com.cognizant.calculateNetworth.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerUIController {
@RequestMapping(value = "/")
public String index() {
return "redirect:swagger-ui.html";
}
}