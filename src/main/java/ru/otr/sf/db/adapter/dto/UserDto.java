package ru.otr.sf.db.adapter.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDto {

    private Long id;

    private String name;

    private List<EmailDto> emails = new ArrayList<>();

    public UserDto(Long id, String name, List<EmailDto> emails) {
        this.id = id;
        this.name = name;
        this.emails=emails;
    }

    public UserDto() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDto> emails) {
        this.emails = emails;
    }
}
