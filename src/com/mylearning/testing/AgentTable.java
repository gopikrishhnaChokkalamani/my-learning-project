package com.example.ui.catalog;

import java.util.List;

public record AgentTable(
        String type,
        String title,
        List<String> columns,
        List<List<String>> rows
) implements AgentBlock { }
