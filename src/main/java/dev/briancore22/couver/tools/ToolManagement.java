package dev.briancore22.couver.tools;

import dev.briancore22.couver.tools.internal.KnifeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToolManagement {
    private final KnifeRepository knifeRepository;
}
