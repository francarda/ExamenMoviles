package com.example.examen3;

import java.io.Serializable;

public class Nota implements Serializable {

    private String nota;
    private String materia;
    private String alummno;
    private String detalle;

    public Nota(String nota, String materia, String alummno, String detalle) {
        this.nota = nota;
        this.materia = materia;
        this.alummno = alummno;
        this.detalle = detalle;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAlummno() {
        return alummno;
    }

    public void setAlummno(String alummno) {
        this.alummno = alummno;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
