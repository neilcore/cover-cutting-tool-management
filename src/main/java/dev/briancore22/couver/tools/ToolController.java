package dev.briancore22.couver.tools;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tools")
@AllArgsConstructor
public class ToolController {
    private final ToolManagement toolManagement;
}
