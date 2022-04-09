package com.maiorem.chat.service;

import com.maiorem.chat.domain.ChatRoom;
import com.maiorem.chat.repository.ChatRepository;
import com.maiorem.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatService {

    static int roomNumber = 0;
    List<ChatRoom> roomList = new ArrayList<>();

    private final ChatRepository chatRepository;

    /**
     * 채팅방 리스트
     */
    public List<ChatRoom> readRoomList() {
        return chatRepository.findAll();
    }

    /**
     * 채팅방 찾기
     */
    public ChatRoom searchChatRoom(Long chatId) {
        return chatRepository.findById(chatId).get();
    }


    /**
     * 채팅방 만들기
     */
    @Transactional
    public ChatRoom createRoom(String roomName) {
        ChatRoom room = new ChatRoom();

        room.setRoomName(roomName);
        room.setRoomNumber(++roomNumber);
        roomList.add(room);

        return room;
    }


}
