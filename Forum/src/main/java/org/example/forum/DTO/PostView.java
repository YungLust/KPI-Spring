package org.example.forum.DTO;

public record PostView(
        String text,
        String author,
        String status
) {}
