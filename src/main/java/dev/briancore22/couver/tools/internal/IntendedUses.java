package dev.briancore22.couver.tools.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "intended_uses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntendedUses {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Column(name = "intended_use", nullable = false)
    @NotBlank(message = "Intended use cannot be blank")
    private String intendedUse;
}
