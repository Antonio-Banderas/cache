package com.example.demo.services;

import java.util.HashMap;

public class Cache {

    HashMap<Integer,String> cache = new HashMap<>();


public String get(int key){
    return cache.get(key);
}

public void set (int key, String value){
    cache.put(key,value);
}

public boolean has (int key){
   return cache.containsKey(key);
}

public void delete(int key){
    cache.remove(key);
}

public void setTTL(String key){

}

}
