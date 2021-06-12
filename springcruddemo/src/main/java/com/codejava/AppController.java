package com.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {		
		List<Product> listProducts = productService.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	
	@RequestMapping("/new")
	public String newProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProductForm(@PathVariable(name="id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = productService.getProductById(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id) {
		productService.deleteById(id);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	

}
