package dev.briancore22.couver.defect.internal;

import dev.briancore22.couver.tools.internal.CuttingToolCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "defective_tools")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefectTools {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "product_id", nullable = false)
    @NotNull(message = "Product ID cannot be null")
    private Integer product;
    @ManyToOne(
            targetEntity = CuttingToolCategory.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "tool_type", nullable = false, referencedColumnName = "id")
    private CuttingToolCategory toolType;
    @Column(name = "product_sku", nullable = false)
    @NotBlank(message = "Product SKU cannot be blank")
    private String productSku;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "defect_detection_date", nullable = false)
    private LocalDate defectDetectionDate;
    @Column(name = "defect_location")
    private String defectLocation;
    @Column(name = "defect_description")
    private String defectDescription;
    @Column(name = "defect_type")
    @NotBlank(message = "Defect type cannot be blank")
    private String defectType;
    @ManyToOne(
            targetEntity = DefectSeverity.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "defect_severity", nullable = false, referencedColumnName = "id")
    private DefectSeverity defectSeverity;
    @Column(name = "analysis_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @FutureOrPresent
    private LocalDate analysisDate;
    @Column(name = "resolution_status", nullable = false)
    @NotNull(message = "Resolution status cannot be null")
    private Integer resolutionStatus;
    @Column(name = "corrective_action")
    private String correctiveAction;
}
