package com.workintech.s18d4.exceptions;

import java.time.LocalDateTime;

public record CustomerErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
}
