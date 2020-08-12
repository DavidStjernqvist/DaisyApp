package com.company.daisyapp.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {

    public String formatDate(){

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);

        return formatDateTime;
    }
}
