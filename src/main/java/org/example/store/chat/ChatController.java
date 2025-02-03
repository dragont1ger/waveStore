package org.example.store.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController //ajax 처리 >> 추후 합칠 때 apiController 에 같이 넣어준다
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // 방번호로 채팅방 조회, 채팅내역 가져오기 + 읽음 처리
    @PostMapping("/chat/list/{roomId}")
    public Map<String, Object> getList(@PathVariable int roomId) {
        List<ChatDto> chatDtoList = chatService.getList(roomId);

        return chatDtoList != null
                ? Map.of("chatList", chatDtoList, "success", true)
                : Map.of("success", false);
    }
}
