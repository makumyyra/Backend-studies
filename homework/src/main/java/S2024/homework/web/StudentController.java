package S2024.homework.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import S2024.homework.domain.Student;


@Controller
public class StudentController {
	
	@GetMapping("helloStudent")
	public String showMessage(@RequestParam String firstName, @RequestParam String lastName, Model model) {
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
	//	return "hello";
	//}
	
	//@GetMapping("/studentList")
	
	//public String showStudents(Model model) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Suvi", "Sammakkosuo"));
		students.add(new Student("Kalle", "Taxell"));
		students.add(new Student("Muneer", "Algburi"));
		students.add(new Student("Olivia", "Martikkala"));
		students.add(new Student("Alma", "Poja"));
		//insert car list to model as a key-value paistudents.add(new Student("Volkkari", "Golf"))r
		model.addAttribute("students", students);
		return "helloStudent";
	}
		
	
	
	

}

/*
 * Create student
objects in the controller and add students to a list. The list will be then added to the model and sent to a view. Finally you
have to create view to show students using th:each
*/
