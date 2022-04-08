package com.maiorem.chat.service;

import com.maiorem.chat.domain.ChatRoom;
import com.maiorem.member.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ChatService {

    static int roomNumber = 0;
    List<ChatRoom> roomList = new ArrayList<>();

    /**
     * 채팅방 리스트
     */
    public List<ChatRoom> readRoomList() {
        return roomList
                .stream()
                .filter( o-> o.getRoomNumber() == roomNumber)
                .collect(Collectors.toList());
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
