package com.example.carshop.home;

import com.example.carshop.auction.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private AuctionService auctionService;

    public HomeController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cars", auctionService.find5MostExpensive());
        return "home";
    }
}