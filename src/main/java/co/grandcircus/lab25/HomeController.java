package co.grandcircus.lab25;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.lab25.ApiService;
import co.grandcircus.lab25.Data;

@Controller
public class HomeController {
	@Autowired
	ApiService apiServ;

	@RequestMapping("/")
	public String home() {
		return "redirect:/select";
	}

	@RequestMapping("/select")
	public String showInputForm() {
		return "select-form";
	}

	@RequestMapping("/set-location")

	public String showLocation(@RequestParam String resType, @RequestParam Double latitude,
			@RequestParam Double longitude, Model model) {

		ForecastResponse response;

		if (resType.equalsIgnoreCase("xml")) {
			response = apiServ.setLocationXML(latitude, longitude);
		} else {
			response = apiServ.setLocation(latitude, longitude);
		}

		if (response != null && response.getData() != null) {
			Data data = response.getData();

			String productionCenter = response.getProductionCenter();

			model.addAttribute("data", data);

			model.addAttribute("productionCenter", productionCenter);

		}
		return "select-location";
	}

	

}
