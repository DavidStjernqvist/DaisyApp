package com.company.daisyapp.Controllers;

import com.company.daisyapp.Models.Entry;
import com.company.daisyapp.Repositories.EntryRepository;
import com.company.daisyapp.Utils.DateFormater;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.*;
@Controller
public class HomeController {

    @Autowired
    EntryRepository entryRepository;

    DateFormater dateFormater = new DateFormater();

    @GetMapping("/")
    public String index(Model model){
        List<Entry> entriesList = entryRepository.findAll();
        Collections.reverse(entriesList);
        model.addAttribute("entriesList", entriesList);
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String editEntry(@PathVariable Integer id, Model model){
        Entry entry = entryRepository.getOne(id);
        model.addAttribute("entry", entry);

        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Entry entry1, Model model, RedirectAttributes redirectAttributes){
        System.out.println("EDIT");
      
        Entry entry = entryRepository.getOne(entry1.getId());
        entry.setId(entry1.getId());
        entry.setText(entry1.getText());
        entry.setImageUrl(entry1.getImageUrl());
        entry.setTitle(entry1.getTitle());

        entryRepository.save(entry);

        return "redirect:/edit/" + entry.getId();
    }
    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Integer id, Model model){
        Entry entry = entryRepository.getOne(id);
        model.addAttribute(entry);
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Entry entry, Model model, RedirectAttributes redirectAttributes){
        entryRepository.deleteById(entry.id);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String addPage(@ModelAttribute Entry entry, Model model){
        return "add";
    }
    @PostMapping("/add")
    public String add(Entry entry, Model model, RedirectAttributes redirectAttributes){

        String dateString = dateFormater.formatDate();
        entry.setDate(dateString);
        entryRepository.save(entry);
        return "redirect:/";
    }
}
