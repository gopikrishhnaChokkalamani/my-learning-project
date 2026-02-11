package com.example.ui;

import com.example.ui.catalog.AgentBlock;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgentToA2uiMapper {

    private static final String VERSION = "v0.10";
    private static final String STANDARD_CATALOG_ID =
            "https://a2ui.org/specification/v0_10/standard_catalog.json";

    private final ObjectMapper om;

    private final A2UIComponentBuilder componentBuilder;

    public List<Object> map(String surfaceId, String agentJsonArray) throws Exception {
        List<AgentBlock> blocks = om.readValue(agentJsonArray, new TypeReference<>() {});

        var built = componentBuilder.buildFromAgentBlocks(blocks);

        Object createSurfaceMsg = createSurface(surfaceId);
        Object updateComponentsMsg = updateComponents(surfaceId, built.components());

        return List.of(createSurfaceMsg, updateComponentsMsg);
    }

    // ---------- placeholder message factories (REPLACE with your generated server_to_client classes) ----------
    private Object createSurface(String surfaceId) {
        return java.util.Map.of(
                "version", VERSION,
                "createSurface", java.util.Map.of(
                        "surfaceId", surfaceId,
                        "catalogId", STANDARD_CATALOG_ID,
                        "theme", java.util.Map.of(
                                "primaryColor", "#2F80ED",
                                "agentDisplayName", "Agent"
                        ),
                        "sendDataModel", false
                )
        );
    }

    private Object updateComponents(String surfaceId, List<Object> components) {
        return java.util.Map.of(
                "version", VERSION,
                "updateComponents", java.util.Map.of(
                        "surfaceId", surfaceId,
                        "components", components
                )
        );
    }
}
