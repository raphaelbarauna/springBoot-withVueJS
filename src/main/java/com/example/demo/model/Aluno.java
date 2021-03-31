package com.example.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    @Column(name = "NAME")
    String nomeESobrenome;

    String sala;

    @ManyToOne
    Escola escola;

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeESobrenome='" + nomeESobrenome + '\'' +
                ", escola=" + escola +
                '}';
    }

}
