package com.bvivg.minigame.controllers;

import com.bvivg.minigame.entities.User;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {

  // @Autowired
  // private UserService userService;

  // @GetMapping("/username/{username}")
  // public User getByUsername(@PathVariable String username) {
  //   return userService.findByUsername(username);
  // }


}
