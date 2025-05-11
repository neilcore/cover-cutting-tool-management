package dev.briancore22.couver.tools.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Table(name = "knife_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KnifeCategory {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String description;
    @Builder.Default
    private Integer stock = 0;
}
