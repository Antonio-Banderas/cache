package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.Cache;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheController {

    // Create cache
    Cache myCache = new Cache();

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam int id) throws InterruptedException {
        if(myCache.has(id)){
            System.out.println("cache returned");
            return myCache.get(id);
        } else {
            User user = new User(id);
            String userData = user.getDataSlow();
            myCache.set(id,userData);
            System.out.println("new user!");
            return userData;

        }
    }
}
