package com.senac.darley_b.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record GrupoDTORequest (

		@NotEmpty String nome,
		@NotEmpty String cor,

		@Min(1)@Max(2) Integer  tipo
		){}