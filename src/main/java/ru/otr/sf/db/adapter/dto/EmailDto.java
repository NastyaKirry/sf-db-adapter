package ru.otr.sf.db.adapter.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class EmailDto {
    public EmailDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    public EmailDto(){};

    private Long id;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
