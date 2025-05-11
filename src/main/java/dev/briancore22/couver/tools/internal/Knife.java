package dev.briancore22.couver.tools.internal;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "knife")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Knife {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(
            targetEntity = KnifeModel.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "model", referencedColumnName = "id")
    private KnifeModel model;
    @NotBlank(message = "sku cannot be blank")
    @Max(100)
    private String sku;
    @ManyToOne(targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer", referencedColumnName = "id")
    private Manufacturer manufacturer;
    @Column(name = "physical_dimensions")
    @Type(JsonType.class)
    private Map<String, String> physicalDimensions = new HashMap<>();
    @Column(name = "blade_properties")
    @Type(JsonType.class)
    private Map<String, String> bladeProperties = new HashMap<>();
    @Column(name = "handle_properties")
    @Type(JsonType.class)
    private Map<String, String> handleProperties = new HashMap<>();
    @Column(name = "features")
    @Type(JsonType.class)
    private Map<String, String> features = new HashMap<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "knife_uses",
            joinColumns = @JoinColumn(name = "knife_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "use_id", referencedColumnName = "id", nullable = false)

    )
    private List<IntendedUses> intendedUse;
    @Column(name = "country_origin", nullable = false)
    @NotBlank(message = "Country of origin cannot be blank")
    private String countryOrigin;
    @Column(name = "date_added", nullable = false)
    @NotNull(message = "Date added cannot be null")
    @Builder.Default
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @FutureOrPresent(message = "Date added must be in the present or future")
    private LocalDate dateAdded = LocalDate.now();
    @Column(name = "price")
    private Double price;
}
