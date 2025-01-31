package org.example.store_project.chat;

import lombok.*;
import org.example.store_project.chatRoom.ChatRoomDto;
import org.example.store_project.member.MemberDto;
import org.example.store_project.product.dto.ProductDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Setter
public class ChatDto {

    private int chatId;

    private String content;

    private LocalDateTime chatDate;

    private int chatLevel;

    private boolean isRead;

    private MemberDto writer;

    private ChatRoomDto chatRoomDto;

    @Builder
    public ChatDto(int chatId, String content, LocalDateTime chatDate, int chatLevel,
                   MemberDto writer, boolean isRead, ChatRoomDto chatRoomDto) {
        this.isRead = isRead;
        this.chatId = chatId;
        this.content = content;
        this.chatDate = chatDate;
        this.chatLevel = chatLevel;
        this.writer = writer;
        this.chatRoomDto = chatRoomDto;
    }

    public static Chat toEntity(ChatDto chatDto) {
        return Chat.builder()
                .chatId(chatDto.getChatId())
                .content(chatDto.getContent())
                .chatDate(chatDto.getChatDate())
                .chatLevel(chatDto.getChatLevel())
                .writer(MemberDto.toEntity(chatDto.getWriter()))
                .chatRoom(ChatRoomDto.toEntity(chatDto.getChatRoomDto()))
                .isRead(chatDto.isRead())
                .build();
    }

    public static List<Chat> toEntityList(List<ChatDto> chatDtoList) {
        List<Chat> chatList = new ArrayList<>();
        chatDtoList.forEach(chatDto ->
                chatList.add(toEntity(chatDto))
        );
        return chatList;
    }
}
