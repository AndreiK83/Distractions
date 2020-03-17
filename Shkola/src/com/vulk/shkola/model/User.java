package com.vulk.shkola.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String gender;
}
