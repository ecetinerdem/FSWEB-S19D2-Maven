package com.workintech.s18d4.exceptions;

import java.time.LocalDateTime;

public record GlobalErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
}
