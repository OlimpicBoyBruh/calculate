package ru.sberbank.jd.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessage {
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

}