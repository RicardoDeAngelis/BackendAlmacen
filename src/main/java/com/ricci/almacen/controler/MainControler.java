/**
 * 
 */
package com.ricci.almacen.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ricardo
 * Anotacion
 */
@Controller
public class MainControler {

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "<h1>Bienvenidos<h1>";
		return response;
	}
}
