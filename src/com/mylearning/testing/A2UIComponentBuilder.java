package com.example.ui;

import com.example.ui.catalog.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class A2UIComponentBuilder {

    private final AtomicInteger seq = new AtomicInteger(1);

    private final String rootId = "root";
    private final String rootColumnId = "root-column";

    private final List<Object> components = new ArrayList<>();

    private final List<String> rootChildren = new ArrayList<>();

    public Result buildFromAgentBlocks(List<AgentBlock> blocks) {
        addRoot();

        for (AgentBlock block : blocks) {
            if (block instanceof AgentText t) {
                addDividerIfNeeded();
                rootChildren.add(addText("body", t.content()));
            } else if (block instanceof AgentTable table) {
                addDividerIfNeeded();
                rootChildren.add(addTableCard(table));
            } else if (block instanceof AgentAction action) {
                addDividerIfNeeded();
                rootChildren.add(addButton(action.label(), action.actionId()));
            } else if (block instanceof AgentLink link) {
                addDividerIfNeeded();
                rootChildren.add(addLink(link.label(), link.actionId()));
            }
        }

        setColumnChildren(rootColumnId, rootChildren);

        return new Result(components);
    }

    private void addRoot() {
        String rootCol = rootColumnId;
        components.add(column(rootId, List.of(rootCol), null, null));
        components.add(column(rootCol, List.of(), "start", "stretch"));
    }

    private void addDividerIfNeeded() {
        if (!rootChildren.isEmpty()) {
            rootChildren.add(addDivider("horizontal"));
        }
    }

    private String addText(String variant, String text) {
        String id = nextId("text");
        components.add(text(id, variant, text));
        return id;
    }

    private String addDivider(String axis) {
        String id = nextId("div");
        components.add(divider(id, axis));
        return id;
    }

    private String addTableCard(AgentTable table) {
        String cardId = nextId("card");
        String cardColId = nextId("col");

        components.add(card(cardId, cardColId));

        List<String> children = new ArrayList<>();
        children.add(addText("h3", safe(table.title(), "Table")));
        children.add(addDivider("horizontal"));

        if (table.columns() != null && table.columns().size() >= 2) {
            children.add(addTwoColRow(
                    safe(table.columns().get(0), "Column 1"),
                    safe(table.columns().get(1), "Column 2"),
                    "caption"
            ));
            children.add(addDivider("horizontal"));
        }

        if (table.rows() != null) {
            for (int i = 0; i < table.rows().size(); i++) {
                List<String> row = table.rows().get(i);
                String left = row.size() > 0 ? row.get(0) : "";
                String right = row.size() > 1 ? row.get(1) : "";
                children.add(addTwoColRow(left, right, "body"));
                if (i < table.rows().size() - 1) children.add(addDivider("horizontal"));
            }
        }

        components.add(column(cardColId, children, "start", "stretch"));
        return cardId;
    }

    private String addTwoColRow(String left, String right, String textVariant) {
        String rowId = nextId("row");
        String leftId = nextId("cell");
        String rightId = nextId("cell");

        components.add(text(leftId, textVariant, safe(left, "")));
        components.add(text(rightId, textVariant, safe(right, "")));

        components.add(row(rowId, List.of(leftId, rightId), "spaceBetween", "center"));
        return rowId;
    }

    private String addButton(String label, String actionId) {
        String btnId = nextId("btn");
        String textId = nextId("btnText");

        components.add(text(textId, "body", safe(label, "Action")));
        components.add(button(btnId, "primary", textId, action(actionId)));

        return btnId;
    }

    private String addLink(String label, String actionId) {
        String btnId = nextId("btn");
        String textId = nextId("btnText");

        components.add(text(textId, "body", safe(label, "Action")));
        components.add(button(btnId, "borderless", textId, action(actionId)));

        return btnId;
    }

    private void setColumnChildren(String columnId, List<String> children) {
        for (int i = 0; i < components.size(); i++) {
            Object c = components.get(i);
            if (isColumnWithId(c, columnId)) {
                components.set(i, column(columnId, children, "start", "stretch"));
                return;
            }
        }
        throw new IllegalStateException("Root column not found: " + columnId);
    }

    private boolean isColumnWithId(Object c, String id) {
        if (!(c instanceof Map<?, ?> m)) return false;
        Object comp = m.get("component");
        Object cid  = m.get("id");
        return "Column".equals(comp) && id.equals(cid);
    }

    private String nextId(String prefix) {
        return prefix + "_" + seq.getAndIncrement();
    }

    private static String safe(String s, String def) {
        return (s == null || s.isBlank()) ? def : s;
    }

    private Object text(String id, String variant, String text) {
        return Map.of("id", id, "component", "Text", "variant", variant, "text", text);
    }

    private Object divider(String id, String axis) {
        return Map.of("id", id, "component", "Divider", "axis", axis);
    }

    private Object row(String id, List<String> children, String justify, String align) {
        return Map.of("id", id, "component", "Row", "children", children, "justify", justify, "align", align);
    }

    private Object column(String id, List<String> children, String justify, String align) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", id);
        m.put("component", "Column");
        m.put("children", children);
        if (justify != null) m.put("justify", justify);
        if (align != null) m.put("align", align);
        return m;
    }

    private Object card(String id, String childId) {
        return Map.of("id", id, "component", "Card", "child", childId);
    }

    private Object button(String id, String variant, String childId, Object action) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", id);
        m.put("component", "Button");
        m.put("variant", variant);
        m.put("child", childId);
        m.put("action", action);
        return m;
    }

    private Object action(String actionId) {
        return Map.of("actionId", actionId);
    }

    public record Result(List<Object> components) { }
}
