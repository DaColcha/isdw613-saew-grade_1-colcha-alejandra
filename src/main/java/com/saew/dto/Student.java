package com.saew.dto;

public class Student {

    private Integer id;
    private String nombre;
    private String correo;
    private Float gpa;

    public Student(Integer id, String nombre, String correo, Float gpa) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.gpa = gpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", gpa=" + gpa;
    }
}
