package com.company.daisyapp.Controllers;

import com.company.daisyapp.Models.Entry;
import com.company.daisyapp.Repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
@Controller
public class HomeController {

    @Autowired
    EntryRepository entryRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Entry> entriesList = entryRepository.findAll();
        model.addAttribute("entriesList", entriesList);
        return "index";
    }
}
