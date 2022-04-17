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

@Controller
@RequiredArgsConstructor
public class ChattingController {

    List<ChatRoom> roomList = new ArrayList<>();

    private final ChatService chatService;


    @GetMapping("/chat")
    public void chat(@RequestParam HashMap<Object, Object> params, Model model) {
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
        String roomName = (String) params.get("roomName");

        List<ChatRoom> newRoomList = chatService.readRoomList();

        if (newRoomList != null && newRoomList.size() > 0) {
            model.addAttribute("roomName", roomName);
            model.addAttribute("roomNumber", roomNumber);
        }

    }


    @PostMapping("/createRoom")
    public @ResponseBody
    List<ChatRoom> createRoom(@RequestParam HashMap<Object, Object> params) {
        String roomName = (String) params.get("roomName");
        if (roomName != null && !roomName.trim().equals("")) {
            ChatRoom room = chatService.createRoom(roomName);
        }
        return roomList;
    }

    @GetMapping("/getRoom")
    public @ResponseBody List<ChatRoom> getRoom(@RequestParam HashMap<Object,Object> params) {

        return roomList;
    }


}
