package com.maiorem.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatRoom {

    int roomNumber;
    String roomName;

    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }

}

