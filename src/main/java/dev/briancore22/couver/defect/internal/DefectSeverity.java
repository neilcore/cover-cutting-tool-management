package dev.briancore22.couver.defect.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "defect_severity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefectSeverity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Code cannot be blank")
    private String code;
}
