package com.example.IlOrn.controller;


import com.example.IlOrn.modal.Il;
import com.example.IlOrn.modal.IlResponse;
import com.example.IlOrn.service.IlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1")
public class IlController {
    @Autowired
    private IlService ilService;


    @GetMapping("/getIller/{id}")
    public Optional<Il> getIller(@PathVariable Long id) {
        System.out.println("check");
        Optional<Il> il =  ilService.getIlById(id);
        return il;
    }
    @GetMapping("/{id}")
    public String getIl(@PathVariable  Long id)  {

        Optional<Il> il = ilService.getIl(id);
        Il sonuc=il.get();
        return sonuc.getName();
    }
    /*@PostMapping("/createIl")
    public ResponseEntity<Il> createIl(@RequestBody Il newIl) {

        ilService.createIl(newIl);
        return new ResponseEntity<>(CREATED);

    }*/
    @PutMapping("/createIl")
    public ResponseEntity<?> createIl(@RequestBody Map<String,Object> params) {
        String name = String.valueOf(params.get("name"));
        String nufus = String.valueOf(params.get("nufus"));
        Il il = new Il(name, nufus);
        // ilService.createIl(il);


        return new ResponseEntity<>(ilService.createIl(il), CREATED);

    }

   @PutMapping("/updateIl/{id}")
    public ResponseEntity<Il> updateIl(@PathVariable Long id, @RequestBody Il newIl)  {
        String name="";
        ilService.updateIl(id, newIl);
        return new ResponseEntity<>(OK);
    }
   @DeleteMapping("/deleteIl/{id}")

    public ResponseEntity<Il> deleteIl(@PathVariable Long id ) {
        ilService.deleteIl(Long.valueOf(id));
        return new ResponseEntity<>(OK);
    }

    private Optional<Il> getIlById (Long id) {

        return ilService.getIlById(id);
    }

    public void setIlService(IlService ilService) {
        this.ilService = ilService;
    }
}
