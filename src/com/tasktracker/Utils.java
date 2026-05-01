package com.tasktracker;

import java.time.LocalDateTime;

/*
Utility clas used for helper methods
 */

public class Utils {
/*
This method returns current date and time
It is used when creating or updating a task
 */


    public static String getCurrentTime(){
        return LocalDateTime.now().toString();
    }
}
