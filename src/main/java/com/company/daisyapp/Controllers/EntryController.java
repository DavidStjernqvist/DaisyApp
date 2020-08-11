package com.company.daisyapp.Controllers;

import com.company.daisyapp.Models.CommonResponse;
import com.company.daisyapp.Models.Entry;
import com.company.daisyapp.Repositories.EntryRepository;
import com.company.daisyapp.Utils.Command;
import com.company.daisyapp.Utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EntryController {

    @Autowired
    private EntryRepository entryRepo;

    @GetMapping("/")
    public ResponseEntity<CommonResponse> getAllEntries(HttpServletRequest request){
        Command cmd = new Command(request);

        CommonResponse cr = new CommonResponse();
        cr.data = entryRepo.findAll();
        cr.message = "All entries";

        HttpStatus resp = HttpStatus.OK;

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(cr,resp);
    }

    @PostMapping("/entry")
    public ResponseEntity<CommonResponse> addEntry(HttpServletRequest request, HttpServletResponse response, @RequestBody Entry entry){
        Command cmd = new Command(request);

        entry = entryRepo.save(entry);

        CommonResponse cr = new CommonResponse();
        cr.data = entry;
        cr.message = "New entry with id: " + entry.id;

        HttpStatus resp = HttpStatus.CREATED;

        response.addHeader("Location", "/entry/" + entry.id);

        
        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(cr, resp);

    }
}
