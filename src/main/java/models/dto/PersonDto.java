package models.dto;

import java.time.LocalDate;

public record PersonDto(String name, LocalDate birthDate) {
}
