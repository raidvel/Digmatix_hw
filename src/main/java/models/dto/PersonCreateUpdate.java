package models.dto;

import java.time.LocalDate;

public record PersonCreateUpdate(String name, LocalDate birthDate) {
}
