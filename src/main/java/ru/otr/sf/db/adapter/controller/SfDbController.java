package ru.otr.sf.db.adapter.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.service.UserService;

import java.util.List;
import java.util.Optional;

@Api(tags = {"sf-db-adapter"})
@RestController
@RequestMapping("/api/v20/")
public class SfDbController {

    public SfDbController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @ApiOperation("Модель all")
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getFindAll();
    }

    @ApiOperation("Модель ")
    @GetMapping("/user")
    public Optional<User> getUser(@RequestParam Long id) {
        return  userService.getById(id);
    }

    @ApiOperation("Модель ")
    @PostMapping("/create")
    public User addUsers(@RequestParam String username) {
        return userService.addUsers(username);
    }

}
