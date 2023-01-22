package com.thierry.fundusv2.exceptions;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime localDateTime, String description, String details) {
}
