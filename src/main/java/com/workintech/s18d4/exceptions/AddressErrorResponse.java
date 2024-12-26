package com.workintech.s18d4.exceptions;

import java.time.LocalDateTime;

public record AddressErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
}
