package com.krukowska.model;

import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClasRequest {
    private Subject subject;
    private Year year;
    private Set<String> teacherIds =new HashSet<>();
}
