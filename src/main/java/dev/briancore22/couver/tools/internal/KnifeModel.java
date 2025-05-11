package dev.briancore22.couver.tools.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "knife_model")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnifeModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String description;
    @Column(name = "model_number")
    private Integer modelNumber;
    @Builder.Default
    private Boolean discontinued = false;
    private Integer stock;
    @ManyToOne(
            targetEntity = KnifeCategory.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private KnifeCategory category;
}
