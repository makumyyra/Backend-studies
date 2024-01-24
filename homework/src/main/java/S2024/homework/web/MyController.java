package S2024.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

		@RequestMapping("index")
		@ResponseBody
		public String returnMainPage() {
			return "Thi@s is the main page";
		}

		@RequestMapping("contact")
		@ResponseBody
		public String returnContactPage() {
			return "This is the contact page";
		}
					
		@RequestMapping("helloMoon")
		@ResponseBody
		public String returnHello(@RequestParam (name="location") String location, @RequestParam (name="name") String name) {
			return "Welcome to the " + location + " " + name + "!";
		}
		
		
		
		@RequestMapping("hello")
		public String showMessage(@RequestParam String name, @RequestParam int age, Model model) {
			model.addAttribute("name", name);
			model.addAttribute("age", age);
			return "hello";
		}





		
		
		
		




		/*@GetMapping("ageGreeting")
		public String newCarInfo(Model model) {
			//insert list to model Key-Value
			model.addAttribute("car", new Car());
			return "newCar";
		}

		@RequestMapping(value = "/hello", method = RequestMethod.POST)
		public String greetingSubmit(@ModelAttribute Message msg, Model model) {
			model.addAttribute("message", msg);
			return "result";
		}
		*/
}
