package com.example.IlOrn.modal;

import com.example.IlOrn.repository.IlRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@Table(name = "ilce")
public class Ilce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name="il_id")
    private Long ilId;

    public Ilce(Long ilId, String name) {
        this.ilId=ilId;
        this.name=name;
    }

    public Long getIlId() {
        return ilId;
    }
    public void setIlId(Long ilId) {
        this.ilId = ilId;
    }
    @ManyToOne
    @JoinColumn(name = "il_id",insertable=false, updatable=false)
    private Il il ;
    /*@JsonBackReference
    public Il getIl(Long ilId) {
        return ilRepo.findById(ilId).orElse(null);
    }*/
    public void setIl(Il il) {
        this.il = il;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


}


