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
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    @NotBlank
    private String login;
    @NotBlank
    private String email;
}
