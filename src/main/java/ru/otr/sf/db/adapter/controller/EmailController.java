package ru.otr.sf.db.adapter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.db.adapter.model.Email;
import ru.otr.sf.db.adapter.model.User;
import ru.otr.sf.db.adapter.service.EmailService;
import ru.otr.sf.db.adapter.service.UserService;

import java.util.List;
import java.util.Optional;

@Api(tags = {"sf-db-adapter-email"})
@RestController
@RequestMapping("/api/v20/email")
public class EmailController {
    public EmailController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    private final EmailService emailService;
    private final UserService userService;

    @ApiOperation("Модель all")
    @GetMapping("/all/getAllEmail")
    public List<Email> getAllEmail() {
        return emailService.getFindAll();
    }

    @ApiOperation("EmailAdd ")
    @PostMapping("/addEmail")
    public Email addEmail(@RequestParam String email, @RequestParam Long idUser) {
        return emailService.addEmail(email, idUser);
    }

}
