package com.qthreads.be.utility;

import com.qthreads.be.dto.QthreadsAppResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommonUtility {

    public ResponseEntity<QthreadsAppResponseDto> getResponseSuccessObject(
            final Map<Object, Object> data, final String message
    ){
        final QthreadsAppResponseDto response = new QthreadsAppResponseDto();
        response.setSuccess(true);
        response.setStatus("SUCCESS");
        response.setMessage(message);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<QthreadsAppResponseDto> getResponseFailureObject(
            final Map<Object, Object> data, final String message
    ){
        final QthreadsAppResponseDto response = new QthreadsAppResponseDto();
        response.setSuccess(false);
        response.setStatus("UNSUCCESS");
        response.setMessage(message);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
