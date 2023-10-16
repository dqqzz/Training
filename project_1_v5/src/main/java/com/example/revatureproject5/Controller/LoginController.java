package com.example.revatureproject5.Controller;
import com.example.revatureproject5.JPA.RegisterRepository;
import com.example.revatureproject5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping("/login")
    public String showForm() {
        return "redirect:/login.html"; // Redirect to the static file.
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String userName, @RequestParam String password) {
        userName = userName.trim();
        password = password.trim();

        // Retrieve the user by username
        User existingUser = registerRepository.findByUserName(userName);

        if (existingUser != null) {
            // Compare the entered password with the stored user's password
            if (password.equals(existingUser.getPassword())) {
                // Passwords match, redirect to the desired page
                return "redirect:/NewTicket.html";
            }
        }

        // Username or password is incorrect, redirect to the error page
        return "redirect:/error.html";
    }
}