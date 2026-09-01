package com.example.LogiTrack.Exception;

import java.time.LocalDateTime;

public record ErrorResponse (
        LocalDateTime timestamp, int status, String message, String errorCode
){

}