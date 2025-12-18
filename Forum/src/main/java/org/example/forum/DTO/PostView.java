package org.example.forum.DTO;

public record PostView(
        int id,
        int authorId,
        String text,
        String author,
        String authorStatus
) {}
