package com.example.IlOrn.modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "il")
public class Il {

    //@SequenceGenerator(name="Il_SEQ",sequenceName="Il_SEQ")
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Il_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //protected Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "nufus")
    private String nufus;

    @OneToMany(cascade =CascadeType.ALL ,mappedBy = "il", fetch = FetchType.EAGER)
    private List<Ilce> ilceler;
    //private List<Ilce> ilceler =  new ArrayList<>();
    @JsonManagedReference
    public List<Ilce> getIlceler() {
        return ilceler;
    }
    public void setIlceler(List<Ilce> ilceler) {
        this.ilceler = ilceler;
    }
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNufus() {return nufus;}

    public void setNufus(String nufus) {this.nufus = nufus;}

    public Il(){
    }
    public Il(String name,String nufus) {
        this.name = name;
        this.nufus = nufus;
    }
}
