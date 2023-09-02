
package com.royalideas.ARPAweb.animales;

/**
 *
 * @author daiau
 */
public class PerroDTO {    
     
    private String raza;
   
    private Integer edad;
   
    private String nombre;
    
    private String genero;
    
    private Boolean castrado;
  
    private Integer adoptanteID;  
  
    private String condicion;
    
    private String compatibilidad;
    
    private Integer protectora;
    
    private String tipo;
    
    private String tamano;    

    public PerroDTO(String raza, Integer edad, String nombre, String genero, Boolean castrado, Integer adoptanteID, String condicion, String compatibilidad, Integer protectora, String tipo, String tamano) {
        this.raza = raza;
        this.edad = edad;
        this.nombre = nombre;
        this.genero = genero;
        this.castrado = castrado;
        this.adoptanteID = adoptanteID;
        this.condicion = condicion;
        this.compatibilidad = compatibilidad;
        this.protectora = protectora;
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public String getRaza() {
        return raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public Integer getAdoptanteID() {
        return adoptanteID;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public Integer getProtectora() {
        return protectora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamano() {
        return tamano;
    }
   
    
}
