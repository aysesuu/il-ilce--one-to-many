package com.example.IlOrn.service;

import com.example.IlOrn.modal.Ilce;
import com.example.IlOrn.modal.IlceResponse;
import com.example.IlOrn.repository.IlceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IlceService {

    private IlceRepository ilceRepository;

    public IlceService(IlceRepository ilceRepository) {
        this.ilceRepository = ilceRepository;
    }


   public IlceResponse createIlce(Ilce newIlce) {
      return new IlceResponse(ilceRepository.save(newIlce),HttpStatus.CREATED);

   }
    public IlceResponse updateIlce(Long id, Ilce newIlce) {

        Optional<Ilce> oldIlce = ilceRepository.findById(id);
        Ilce  sonuc= oldIlce.get();
        sonuc.setId(newIlce.getId());
        sonuc.setName(newIlce.getName());

        return new IlceResponse(ilceRepository.save(sonuc), HttpStatus.OK);
    }
    public Optional<Ilce> getIlceById(Long id) {

        return ilceRepository.findById(id);
    }
    public void deleteIlce(Long id) {
        //System.out.println("check 2");
        ilceRepository.deleteById(id);
    }
}
