package com.maiorem.chat.controller;

import com.maiorem.chat.domain.ChatRoom;
import com.maiorem.chat.service.ChatService;
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


    @GetMapping("/chat")
    public List<ChatRoom> chat() {
        List<ChatRoom> newRoomList = chatService.readRoomList();
        return newRoomList;

    }


    @PostMapping("/createRoom")
    public ChatRoom createRoom(@RequestParam HashMap<Object,Object> params) {
        String roomName = (String) params.get("roomName");
        ChatRoom room = null;
        if(roomName != null && !roomName.trim().equals("")) {
            room = chatService.createRoom(roomName);
        }
        return room;
    }


}
