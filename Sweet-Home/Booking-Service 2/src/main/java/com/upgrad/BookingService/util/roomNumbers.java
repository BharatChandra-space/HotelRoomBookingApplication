package com.upgrad.BookingService.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class roomNumbers {

    @Autowired
    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }
}
