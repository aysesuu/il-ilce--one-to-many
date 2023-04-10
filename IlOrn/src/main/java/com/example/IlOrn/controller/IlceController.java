package com.example.IlOrn.controller;

import com.example.IlOrn.modal.Il;
import com.example.IlOrn.modal.Ilce;
import com.example.IlOrn.modal.IlceResponse;
import com.example.IlOrn.repository.IlRepository;
import com.example.IlOrn.service.IlService;
import com.example.IlOrn.service.IlceService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1")
public class IlceController {
    private IlceService ilceService;
    private IlService ilService;

    public IlceController(IlceService ilceService,IlService ilService) {
        this.ilceService = ilceService;
        this.ilService = ilService;
    }

    @GetMapping("/ilceler/{id}")
    public Optional<Ilce> getIlceler(@PathVariable Long id) {
        Optional<Ilce> ilce=ilceService.getIlceById(id);
        return ilce;

    }
    @PutMapping("/createIlce")
    public ResponseEntity<?> createIlce(@RequestBody Map<String,Object> params)  {
        String ilName = String.valueOf(params.get("ilName"));
        String name = String.valueOf(params.get("name"));
        Il il = ilService.getIlByName(ilName);
        Ilce ilce = new Ilce(il.getId(),name);
        ilceService.createIlce(ilce);
        return ResponseEntity.ok().body(il.getName());
    }
    @PutMapping("/updateIlce/{id}")
    public ResponseEntity<Ilce> updateIlce(@PathVariable Long id, @RequestBody Ilce newIlce)  {
        ilceService.updateIlce(id, newIlce);
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/deleteIlce/{id}")


    public ResponseEntity<Ilce> getIlce(@PathVariable Long id ) {
        ilceService.deleteIlce(Long.valueOf(id));
        return new ResponseEntity<>(OK);
    }
}
