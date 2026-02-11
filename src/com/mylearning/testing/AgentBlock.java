package com.example.ui.catalog;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AgentText.class, name = "TEXT"),
        @JsonSubTypes.Type(value = AgentTable.class, name = "TABLE"),
        @JsonSubTypes.Type(value = AgentAction.class, name = "ACTION"),
        @JsonSubTypes.Type(value = AgentLink.class, name = "LINK")
})
public sealed interface AgentBlock permits AgentText, AgentTable, AgentAction, AgentLink { }

