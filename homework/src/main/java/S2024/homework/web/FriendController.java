package S2024.homework.web;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import S2024.homework.domain.Friend;

@Controller
public class FriendController {

	@GetMapping("hello")
	public String showFriends(Model model) {
	
		List<Friend> kaverit = new LinkedList<>();
		kaverit.add(new Friend("Salla", "Antikainen"));
		kaverit.add(new Friend("Karoliina", "Alakotila"));
		kaverit.add(new Friend("Jutta", "Ruusunen"));
		kaverit.add(new Friend("Jonna", "Beldjuskin"));
		model.addAttribute("friends", kaverit);
		return "hello";
	}
		
	@GetMapping("addFriend")
	public String addFriend(Model model) {
		
		model.addAttribute("friend", new Friend("", ""));
		return "addFriend";
	}

	@PostMapping("saveFriend")
	//public String saveFriend(@ModelAttribute Friend friend, Model model) {
	public String saveFriend(Friend friend) {
		System.out.println("save friend : " + friend);
		//TODO save to database
		return "hello";
	}


	/*
	 * @GetMapping("newcar")
	public String newCarInfo(Model model) {
		//insert list to model Key-Value
		model.addAttribute("car", new Car());
		return "newCar";
	} 
	*/

	
	// @PostMapping("saveFriend")
	// //public String saveFriend(@ModelAttribute Friend friend, Model model) {
	// public String saveFriend(Friend friend) {
	// 	System.out.println("save friend : " + friend);
	// 	//TODO save to database
	// 	return "hello";
	// }
	
	
}
