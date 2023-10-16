package com.example.revatureproject5.Controller;

import com.example.revatureproject5.JPA.TicketRepository;
import com.example.revatureproject5.JPA.UserRepository;
import com.example.revatureproject5.model.Ticket;
import com.example.revatureproject5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTicketsController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/allTicketsByUser")
    public String showTicketForm(Ticket ticket) {
        //ticket.addAttribute("ticket", new Ticket());
        return "allTickets";
    }

    @PostMapping("/allTicketsByUser")
//    public String userTickets(Ticket ticket, @RequestParam("userId") Long userId) {
    public String userTickets(Ticket ticket, @RequestParam("userId_1") Long userId) {
        //User user = userRepository.findByUserId(userId).orElse(null);
        //System.out.println("passed userid is: " + userId);
        long id=userId;
        User user = userRepository.findById(id);
        System.out.println("userid is: " + user.getUserId());
        System.out.println(user);

        if (user != null) {
            ticket.setUser(user);
            List<Ticket> userTickets = ticketRepository.findByUser(user);
            if (userTickets != null) {
                System.out.println(userTickets);
                String input=userTickets.toString();
                String[] tickets = input.split("}},");
                // Create a StringBuilder to store the formatted result
                StringBuilder formattedResult = new StringBuilder();
                // Iterate through the split tickets and add <br/> before each
                for (String ticket1 : tickets) {
                    // Ensure that there is content before adding <br/>
                    if (!ticket1.trim().isEmpty()) {
                        formattedResult.append("<br/>").append(ticket1);
                    }
                }
                return formattedResult.toString();
            } else {
                System.out.println("userTicket is null !");
                // Add the 'userTickets' attribute to the model
                ticket.addAttribute("userTickets", (Ticket) userTickets);

                // Return the view name
                return "redirect:/allTickets"; // Change to the appropriate view name
            }
        } else {
            return "redirect:/error";
        }
    }
}
