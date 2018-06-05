package com.dygstudio.group.microserviceprovideruser.controller;

import com.dygstudio.group.microserviceprovideruser.entity.Users;
import com.dygstudio.group.microserviceprovideruser.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    /** 说明：其中这是 Spring4.3提供的新注解。
     * 这是一个组合注解，等价于 @RequestMapping(method=RequestMenthod.GET)，用于简化开发。
     * 同样的还有 @PostMapping，@PutMapping，@DeleteMapping，@PatchMapping 等。*/
    @GetMapping("/{id}")
    public Users findById(@PathVariable String id){
        Users findOne = this.usersRepository.findOne(id);
        return findOne;
    }
}
