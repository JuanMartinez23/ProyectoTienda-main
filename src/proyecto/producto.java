/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Juan Martinez
 */
public class producto {
   
    String id;
    String nom;
    String fechap;
    String fechaS;
    float precio;
    
    public producto(){
        id = "";
        nom = "";
        fechap = "";
        fechaS = "";
        precio = -1;
    }
    public producto (String id, String nom, String fechal, String fechav, float precio){
        this.id = id;
        this.nom = nom;
        this.fechap = fechal;
        this.fechaS = fechav;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFechal() {
        return fechap;
    }

    public void setFechal(String fechal) {
        this.fechap = fechal;
    }

    public String getFechav() {
        return fechaS;
    }

    public void setFechav(String fechav) {
        this.fechaS = fechav;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
