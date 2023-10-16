package com.example.revatureproject5.Controller;

import com.example.revatureproject5.JPA.TicketRepository;
import com.example.revatureproject5.JPA.UserRepository;
import com.example.revatureproject5.model.Ticket;
import com.example.revatureproject5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tickets")
    public String showTicketForm(Ticket ticket) {
        ticket.addAttribute("ticket", new Ticket());
        return "NewTicket";
    }

    @PostMapping("/tickets")
    public String registerUser(Ticket ticket, @RequestParam("userId") Long userId) {
        // 从数据库中查找对应的用户
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            // 关联用户与Ticket
            System.out.println(user);
            //System.out.println("userid is: " + user.getUserId());
            ticket.setUser(user);
            ticketRepository.save(ticket);
        } else {
            // 处理用户不存在的情况
            // 可以在这里返回错误信息或采取其他操作
            System.out.println("no such user id");
        }

        return "redirect:/allTickets.html?&description=" + ticket.getDescription() + "&resolved=" + ticket.isResolved() + "&userId=" + user.getUserId();
    }


    }
