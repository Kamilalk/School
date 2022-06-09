package com.krukowska.model;

import com.krukowska.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenderNAgeRequest {
    private int age;
    private Gender gender;
}
