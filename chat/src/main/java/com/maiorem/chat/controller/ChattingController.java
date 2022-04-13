package com.maiorem.chat.controller;

import com.maiorem.chat.domain.ChatRoom;
import com.maiorem.chat.service.ChatService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ChattingController {

    private final ChatService chatService;

    @ApiOperation(value="채팅방 리스트", notes="현재 존재하는 채팅방 리스트를 가져온다")
    @GetMapping("/chat")
    public List<ChatRoom> chat() {
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




}
