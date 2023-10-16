package com.example.revatureproject5.Controller;

import com.example.revatureproject5.JPA.TicketRepository;
import com.example.revatureproject5.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllTicketsController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/allTickets")
    public String showTicketForm(Model model, @RequestParam("userId_2") String userId) {
        //ticket.addAttribute("ticket", new Ticket());
//        List<Ticket> allTickets = ticketRepository.findAll();
//        System.out.println(allTickets);
//        model.addAttribute("tickets", allTickets);
//        return allTickets.toString();
        return "hello";
    }

    @PostMapping("/allTickets")
//    public String userTickets(Ticket ticket, @RequestParam("userId") Long userId) {
    public String allTickets(Model model, @RequestParam("userId_2") String userId) {
        //User user = userRepository.findByUserId(userId).orElse(null);
        //System.out.println("passed userid is: " + userId);
        System.out.println(userId);

        List<Ticket> allTickets = ticketRepository.findAll();
            if (allTickets != null && userId.equals("david123")) {
                System.out.println(allTickets);
                model.addAttribute("tickets", allTickets);
//                return "redirect:/resultPage.html";
                String input=allTickets.toString();
                String[] tickets = input.split("}},");

                // Create a StringBuilder to store the formatted result
                StringBuilder formattedResult = new StringBuilder();

                // Iterate through the split tickets and add <br/> before each
                for (String ticket : tickets) {
                    // Ensure that there is content before adding <br/>
                    if (!ticket.trim().isEmpty()) {
                        formattedResult.append("<br/>").append(ticket);
                    }
                }
                return formattedResult.toString();

            } else {
                System.out.println("allTicket is null !");
                // Add the 'userTickets' attribute to the

                // Return the view name
                return "redirect:/error.html";// Change to the appropriate view name
            }
        //return "redirect:/allTickets.html";
    }
}
