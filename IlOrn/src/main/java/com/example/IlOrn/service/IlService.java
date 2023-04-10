package com.example.IlOrn.service;

import com.example.IlOrn.modal.Il;
import com.example.IlOrn.modal.IlResponse;
import com.example.IlOrn.repository.IlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IlService {
    @Autowired
    private IlRepository ilRepository;
    public Optional<Il> getIlById(Long id) {
       System.out.println("check 2");
        return ilRepository.findById(id);
    }

    public Il getIlByName(String name) {
        try {
            return ilRepository.findByName(name);
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public IlResponse createIl(Il newIl) {

        return new IlResponse(ilRepository.save(newIl),HttpStatus.OK);
    }

    public IlResponse updateIl(Long id, Il newIl) {

        Optional<Il> oldIl = ilRepository.findById(id);
        Il  sonuc=oldIl.get();

        sonuc.setName(newIl.getName());
        sonuc.setNufus(newIl.getNufus());
        return new IlResponse(ilRepository.save(sonuc), HttpStatus.OK);
    }
    public void deleteIl(Long id) {

        ilRepository.deleteById(id);
    }
    public Optional<Il> getIl(Long id) {

        return ilRepository.findById(id);
    }
}