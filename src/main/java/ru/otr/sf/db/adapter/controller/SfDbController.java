package ru.otr.sf.db.adapter.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.db.adapter.dto.UserDto;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.service.EmailService;
import ru.otr.sf.db.adapter.service.UserService;
import ru.otr.sf.db.adapter.utils.MapperUser;

import java.util.List;
import java.util.Optional;

@Api(tags = {"sf-db-adapter"})
@RestController
@RequestMapping("/api/v20/")
public class SfDbController {

    public SfDbController(UserService userService, EmailService emailService, MapperUser mapperUser) {
        this.userService = userService;
        this.emailService = emailService;
        this.mapperUser = mapperUser;
    }

    private final UserService userService;
    private final EmailService emailService;
    private final MapperUser mapperUser;

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
    public User addUsers(@RequestBody UserDto userDTO){//(@RequestParam String username) {
        return userService.addUsers(mapperUser.DtoToUser(userDTO));
    }

    @ApiOperation("Удаление")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUsers(id);
    }
    @ApiOperation("Search Username")
    @GetMapping("/Search/{username}")
    public List<User>  getSearchById(@PathVariable String username) {
        return userService.searchUsers(username);
    }
}
