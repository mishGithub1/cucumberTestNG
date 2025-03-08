package com.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtility {

    // Static method to get the formatted date and time
    public static String getFormattedDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");

        // Format the current date and time and return it as a string
        return currentDateTime.format(formatter);
    }
    
 // Static method to get the formatted date and time including milliseconds
    public static String getFormattedDateTimeWIthMiliseconds() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format pattern with milliseconds
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss_SSS");

        // Format the current date and time and return it as a string
        return currentDateTime.format(formatter);
    }
}

