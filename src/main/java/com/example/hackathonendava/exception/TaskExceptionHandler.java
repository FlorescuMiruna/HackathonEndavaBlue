package com.example.hackathonendava.exception;


import com.example.hackathonendava.model.ErrorTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class TaskExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(TaskExceptionHandler.class);

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorTask handleNotFound(Exception exception) {
        BaseException baseException = (BaseException) exception;

        logger.warn("Not found exception", exception);

        return new ErrorTask(baseException.getErrorCode(), baseException.getMessage(), HttpStatus.NOT_FOUND.value());
    }

//    @ExceptionHandler
//    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorTask handleException(Exception exception){
//        logger.error("An error occured", exception);
//
//        return new ErrorTask("internal.server.error", "An error occured",HttpStatus.INTERNAL_SERVER_ERROR.value());
//    }
}

