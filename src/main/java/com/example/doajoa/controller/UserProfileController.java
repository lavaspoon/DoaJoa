package com.example.doajoa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;
import com.example.doajoa.model.UserProfile;

@RestController
public class UserProfileController {
    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<String,UserProfile>();
        userMap.put("1", new UserProfile("1","홍길동","111-1111","대전시 서구 둔산동"));
        userMap.put("2", new UserProfile("2","홍길동","111-1111","대전시 서구 둔산동"));
        userMap.put("3", new UserProfile("3","홍길동","111-1111","대전시 서구 둔산동"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return userMap.get(id);
    }
    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }
    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }
}
