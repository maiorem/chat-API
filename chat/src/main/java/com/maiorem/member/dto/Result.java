package com.maiorem.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int count; //νλμΆκ°
    private T data;
}