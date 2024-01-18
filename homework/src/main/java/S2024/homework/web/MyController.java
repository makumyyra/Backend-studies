package S2024.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

		@RequestMapping("index")
		@ResponseBody
		public String returnMainPage() {
			return "This is the main page";
		}

		@RequestMapping("contact")
		@ResponseBody
		public String returnContactPage() {
			return "This is the contact page";
		}
				
		
		@RequestMapping("hello")
		@ResponseBody
		public String returnHello(@RequestParam (name="location") String location, @RequestParam (name="name") String name) {
			return "Welcome to the " + location + " " + name + "!";
		}

}
