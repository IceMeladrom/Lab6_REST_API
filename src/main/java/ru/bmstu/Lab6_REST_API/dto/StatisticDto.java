package ru.bmstu.Lab6_REST_API.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StatisticDto {
    private Long id;
    @NotBlank
    private String playerLogin;
    @NotBlank
    private String gameName;
    private Boolean isGameWon = true;
}
