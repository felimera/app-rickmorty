package com.coderbyte.apprickmorty.controller.dto;

public class AnimatedCharacterDTO {

    private Integer id;
    private String nombre;
    private String imagen;
    private String genero;
    private String estado;

    public AnimatedCharacterDTO() {
    }

    public AnimatedCharacterDTO(Integer id, String nombre, String imagen, String genero, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.genero = genero;
        this.estado = estado;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
