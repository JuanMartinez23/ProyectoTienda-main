/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Martinez
 */
public class pila {
    private Stack<producto> pila;
    public pila(){
        this.pila = new Stack<>();
    }
    public void setPushProducto (producto p){
        if(buscarID(p.id) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este ID!");
        }else if(buscarNOM(p.nom) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este Nombre!");
        }else{
            pila.push(p);
            mainFXMLController.lista.add(p);
            JOptionPane.showMessageDialog(null, "El producto se ha registrado!");
        }
    }
    
    public producto buscarID(String id){
        producto buscar = new producto();
        int i = 0;
        while(i<pila.size()){
            buscar = (producto) pila.get(i);
            if(buscar.id.equals(id))
                return buscar;
            i++;
        }
        buscar = null;
        return buscar;
    }
    public producto buscarNOM(String nom){
        producto buscar = new producto();
        int i = 0;
        while(i<pila.size()){
            buscar = (producto) pila.get(i);
            if(buscar.nom.equals(nom))
                return buscar;
            i++;
        }
        buscar = null;
        return buscar;
    }
    public void productoexpirado(){
        String fecha = mainFXMLController.fecha;
        producto eliminar = new producto();
        for (producto lista : pila){
            eliminar = vencido(fecha);
            while(eliminar != null){
                pila.remove(eliminar);
                mainFXMLController.lista.remove(eliminar);
                eliminar = vencido(fecha);
            }
        }
    }
    public producto vencido (String FechaV){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.fechaS.equals(FechaV))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public void buscarFechal(String fechap){
        producto buscar = new producto();
        int i = 0;
        while(i<pila.size()){
            buscar = (producto) pila.get(i);
            if(buscar.fechap.equals(fechap)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha de produccion buscada es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechap + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechaS + "\n"
                                                    + "Precio: " + buscar.precio);
            }
            i++;
        }
    }
    public void buscarFechav(String fechaS){
        producto buscar = new producto();
        int i = 0;
        while(i<pila.size()){
            buscar = (producto) pila.get(i);
            if(buscar.fechaS.equals(fechaS)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha de salida buscada es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechap + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechaS + "\n"
                                                    + "Precio: " + buscar.precio);
            }
            i++;
        }
    }
    public void buscarprecio(float precio){
        producto buscar = new producto();
        int i = 0;
        while(i<pila.size()){
            buscar = (producto) pila.get(i);
            if(buscar.precio == precio){
                JOptionPane.showMessageDialog(null, "El producto con el precio buscado es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechap + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechaS + "\n"
                                                    + "Precio: " + buscar.precio);
            }
            i++;
        }
    }
    public float sacarpromedio(){
        float suma = 0;
        float promedio = 0;
        for (producto sum : pila){
            suma = sum.precio + suma;
        }
        promedio = suma / pila.size();
        return promedio;
    }
    public void menoralpromedio(){
        float promedio = sacarpromedio();
        for(producto menor : pila){
            if(menor.precio < promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio menor al promedio son:\n"
                                                    + "ID: " + menor.id + "\n"
                                                    + "Nombre: " + menor.nom + "\n"
                                                    + "Fecha lote: " + menor.fechap + "\n"
                                                    + "Fecha vencimiento: " + menor.fechaS + "\n"
                                                    + "Precio: " + menor.precio);
            }
        }
    }
    public void mayoralpromedio(){
        float promedio = sacarpromedio();
        for(producto mayor : pila){
            if(mayor.precio > promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio mayor al promedio son:\n"
                                                    + "ID: " + mayor.id + "\n"
                                                    + "Nombre: " + mayor.nom + "\n"
                                                    + "Fecha lote: " + mayor.fechap + "\n"
                                                    + "Fecha vencimiento: " + mayor.fechaS + "\n"
                                                    + "Precio: " + mayor.precio);
            }
        }
    }
    public void mayorprecio(){
        producto mayor = new producto();
        for (producto may : pila){
            if(may.precio > mayor.precio){
                mayor = may;
            }
        }
        for (producto may : pila){
            if(may.precio == mayor.precio){
                JOptionPane.showMessageDialog(null, "Los productos que tienen mayor precio son:\n"
                                                    + "ID: " + may.id + "\n"
                                                    + "Nombre: " + may.nom + "\n"
                                                    + "Fecha lote: " + may.fechap + "\n"
                                                    + "Fecha vencimiento: " + may.fechaS + "\n"
                                                    + "Precio: " + may.precio);
            }
        }
    }
    public void menorprecio(){
        producto mayor = new producto();
        for (producto may : pila){
            if(may.precio > mayor.precio){
                mayor = may;
            }
        }
        for (producto men : pila){
            if(men.precio < mayor.precio){
                mayor = men;
            }
        }
        for (producto men : pila){
            if(men.precio == mayor.precio){
                JOptionPane.showMessageDialog(null, "Los productos con mayor precio son:\n"
                                                    + "ID: " + men.id + "\n"
                                                    + "Nombre: " + men.nom + "\n"
                                                    + "Fecha lote: " + men.fechap + "\n"
                                                    + "Fecha vencimiento: " + men.fechaS+ "\n"
                                                    + "Precio: " + men.precio);
            }
        }
    }
}
