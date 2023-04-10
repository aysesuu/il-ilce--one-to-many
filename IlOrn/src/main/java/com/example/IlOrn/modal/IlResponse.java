package com.example.IlOrn.modal;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class IlResponse {

    private Il il;


    public <S extends IlResponse> IlResponse(Object save, HttpStatus ok) {
    }

    public Il getIl() {
        return il;
    }

    public void setIl(Il il) {
        this.il = il;
    }
}


