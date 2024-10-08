package com.electric_diary.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleRequestDTO {
	@NotNull(message = "Role name cannot be null")
	private String name;
}
