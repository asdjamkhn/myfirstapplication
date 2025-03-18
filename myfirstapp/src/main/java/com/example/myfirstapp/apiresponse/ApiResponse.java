package com.example.myfirstapp.apiresponse;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse implements Serializable{
    private String message;
    private int status;
    private Object data;
}
