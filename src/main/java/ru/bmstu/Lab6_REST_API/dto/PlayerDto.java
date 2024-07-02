package ru.bmstu.Lab6_REST_API.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayerDto {
    private Long id;
    @NotBlank
    private String userLogin;
    @NotBlank
    private String login;


}
