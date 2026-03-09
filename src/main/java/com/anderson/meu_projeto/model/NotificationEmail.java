package com.anderson.meu_projeto.model;

public record NotificationEmail(
    String subject,
    String recipient,
    String body
) {
    
}
