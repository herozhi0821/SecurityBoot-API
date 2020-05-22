package net.cnki.token.handler;

import net.cnki.common.ResultCode;
import net.cnki.common.ResultGenerator;
import net.cnki.token.exception.TokenAuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TokenAuthenticationExceptionHandler {
	@Autowired
	ResultGenerator resultGenerator;
	
    @ResponseBody
    @ExceptionHandler(TokenAuthenticationException.class)
    public Object handleException(TokenAuthenticationException e) {
        return resultGenerator.getFreeResult(ResultCode.FAIL_TOKEN,e.getMsg());
    }
}
