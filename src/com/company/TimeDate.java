package com.company;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TimeDate {

    public static void main(String[] args) {


        List<String> timeSlot = new ArrayList<>();
         timeSlot.add("2021-09-18_24:00:00");
         timeSlot.add("2021-09-19_24:00:00");
        LocalDateTime startTimeDate = LocalDateTime.parse(timeSlot.get(0),
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss") );
        LocalDateTime endTimeDate = LocalDateTime.parse(timeSlot.get(1),
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss") );
        long startTime =startTimeDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long endTime = endTimeDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        System.out.println(startTime);
        System.out.println(endTime);
    }
}

   