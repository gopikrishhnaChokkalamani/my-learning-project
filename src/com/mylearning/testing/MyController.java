package com.example.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/sse")
@AllArgsConstructor
public class MyController {

    private final AgentToA2uiMapper agentToA2uiMapper;

    private final ObjectMapper objectMapper;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamA2ui() {
        return
                Flux.concat(
                        Flux.defer(() -> {
                            List<Object> msgs = null;
                            try {
                                msgs = agentToA2uiMapper.map("surface-chat-123", "[{\"type\":\"TEXT\",\"content\":\"I suggest moving $600 from your savings account to cover this purchase.\"},{\"type\":\"ACTION\",\"label\":\"TransferFunds\",\"actionId\":\"transfer_funds\"},{\"type\":\"LINK\",\"label\":\"Chat for more options\",\"actionId\":\"open_chat\"}]");

                                //msgs = agentToA2uiMapper.map("surface-chat-123", "[{\"type\":\"TEXT\",\"content\":\"Here is a summary of your accounts.\"},{\"type\":\"TABLE\",\"title\":\"Account Balances\",\"columns\":[\"Account\",\"Balance\"],\"rows\":[[\"Checking\",\"$12,430\"],[\"Savings\",\"$8,900\"]]},{\"type\":\"ACTION\",\"label\":\"Download Statement\",\"actionId\":\"download_statement\"}]");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                            return Flux.fromIterable(msgs)
                                    .map(msg -> ServerSentEvent.builder(serialize(msg))
                                            .event("a2ui")
                                            .build());
                        }),

                        Flux.just(ServerSentEvent.builder("[DONE]")
                                .event("a2ui")
                                .build())
                );
    }

    private String serialize(Object msg) {
        try {
            return objectMapper.writeValueAsString(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
