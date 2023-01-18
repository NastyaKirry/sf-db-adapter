package ru.otr.sf.db.adapter.controller;


import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/v20/user")
public class SfDbController {

    public SfDbController(UserService userService, EmailService emailService, MapperUser mapperUser) {
        this.userService = userService;
        this.emailService = emailService;
        this.mapperUser = mapperUser;
    }

    private final UserService userService;
    private final EmailService emailService;
    private final MapperUser mapperUser;

    @ApiOperation("Вывести всех пользователей")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getFindAll();
    }

    @ApiOperation("Поиск user ")
    @GetMapping("/getUser/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return  userService.getById(id);
    }

    @ApiOperation("Добавить user ")
    @PostMapping("/addUsers")
    public User addUsers(@RequestBody UserDto userDTO){//(@RequestParam String username) {
        return userService.addUsers(mapperUser.dtoToUser(userDTO));
    }

    @ApiOperation("Удаление")
    @DeleteMapping("/delete/{id}")
    public void delete(@RequestParam Long id){
        userService.deleteUsers(id);
    }
    @ApiOperation("Поиск user")
    @GetMapping("/search/{username}")
    public List<User>  getSearchById(@PathVariable String username) {
        return userService.searchUsers(username);
    }
}
