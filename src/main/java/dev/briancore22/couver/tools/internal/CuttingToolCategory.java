package dev.briancore22.couver.tools.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cutting_tool_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuttingToolCategory {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Max(255)
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Max(255)
    @NotBlank(message = "Code cannot be blank")
    private String code;
    private String description;
    private Boolean availability;
}
