package com.maiorem.chat.controller;

import com.maiorem.chat.domain.ChatRoom;
import com.maiorem.chat.service.ChatService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChattingController {

    private final ChatService chatService;

    @ApiOperation(value="채팅방 리스트", notes="현재 존재하는 채팅방 리스트를 가져온다")
    @GetMapping("/chat")
    public List<ChatRoom> chat(@RequestParam HashMap<Object, Object> params, Model model) {
        List<ChatRoom> newRoomList = chatService.readRoomList();
        return newRoomList;

    }



    @ApiOperation(value="채팅방 create", notes="new chat room 만들기")
    @PostMapping("/chat")
    public ChatRoom createRoom(@RequestParam HashMap<Object,Object> params) {
        String roomName = (String) params.get("roomName");
        ChatRoom room = null;
        if(roomName != null && !roomName.trim().equals("")) {
            room = chatService.createRoom(roomName);
        }
        return room;
    }

    @ApiOperation(value="채팅방 열기", notes="선택한 채팅방 열기")
    @GetMapping("/getRoom")
    public ChatRoom getRoom(@RequestParam HashMap<Object,Object> params) {
        Long roomNumber = (Long) params.get("roomNumber");
        ChatRoom room = chatService.searchChatRoom(roomNumber);
        return room;
    }




}
