package org.capgemini;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeSkill {
    @Id
    private Long EmployeeId;

    @ElementCollection
    private List<String> skills;
}
