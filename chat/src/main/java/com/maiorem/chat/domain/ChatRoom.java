package com.maiorem.chat.domain;

import com.maiorem.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatRoom {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;

    private int roomNumber;

    private String roomName;

    @OneToMany
    private List<Member> members;


    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }

}

