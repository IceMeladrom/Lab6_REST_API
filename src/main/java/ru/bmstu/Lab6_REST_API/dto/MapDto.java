package ru.bmstu.Lab6_REST_API.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MapDto {
    private Long id;
    @NotBlank
    private String playerLogin;
}
