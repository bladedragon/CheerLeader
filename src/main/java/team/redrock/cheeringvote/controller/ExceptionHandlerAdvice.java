package team.redrock.cheeringvote.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import team.redrock.cheeringvote.exception.ValidException;
import team.redrock.cheeringvote.pojo.response.ErrorResponse;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ValidException.class)
    public ErrorResponse handleException(ValidException e) {
        String msg =  e.getMessage();
        if(msg.equals("Fail to get openid")||msg.equals("Fail to get total cheerleaders")){
            return new ErrorResponse(416, e.getMessage());
        }
        if(msg.equals("Index out of bound")){
            return new ErrorResponse(417, e.getMessage());
        }


        return  new ErrorResponse(415,e.getMessage());
    }
}