package com.semicolon.africa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class ApiResponse {
    boolean isSuccessful;
    Object data;
}
