package ru.parhomych.restfulwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Status {

    private String status;

    public Status(String status) {
        this.status = status;
    }
}
