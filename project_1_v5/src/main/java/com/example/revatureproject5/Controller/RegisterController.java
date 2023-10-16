package com.example.revatureproject5.Controller;

import com.example.revatureproject5.JPA.RegisterRepository;
import com.example.revatureproject5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

//    @GetMapping("/register")
//    public String showForm() {
//        return "redirect:/index.html"; // Redirect to the static file.
//    }
//
//    @PostMapping("/register")
//    public String handleLogin(@RequestParam String userName, @RequestParam String password) {
//        System.out.println("UserName: " + userName);
//        System.out.println("Password: " + password);
//        return "redirect:/response.html?username=" + userName + "&password=" + password;
//    }
//
//}
@Autowired
private RegisterRepository registerRepository;
@GetMapping("/register")
public String showRegistrationForm(User user) {
    user.addAttribute("user", new User());
    return "register";
}

    @PostMapping("/register")
    public String registerUser(User user, @RequestParam("userName") String userName) {
        // Check if a user with the same username already exists
        userName = userName.trim();
        User existingUser = registerRepository.findByUserName(userName);

        if (existingUser!=null) {
            // A user with the same username already exists, handle this case
            return "redirect:/error.html?message=Username+already+exists";
        } else {
            // Save the new user to the repository
            registerRepository.save(user);
            return "redirect:/response.html?userName=" + user.getUserName() + "&password=" + user.getPassword();
         }
    }
}
