/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyecto;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Martinez
 */
public class mainFXMLController implements Initializable {
    public pila pila = new pila();
    Calendar calendario = new GregorianCalendar();
    int dia = calendario.get(Calendar.DATE);
    int mes = calendario.get(Calendar.MONTH);
    int año = calendario.get(Calendar.YEAR);
    int diav, mesv, añov;
    public static String fecha;
    
    @FXML
    private TableView<producto> tabla;
    @FXML
    private TableColumn<producto, String> id;
    @FXML
    private TableColumn<producto, String> nom;
    @FXML
    private TableColumn<producto, String> fechal;
    @FXML
    private TableColumn<producto, String> fechav;
    @FXML
    private TableColumn<producto, Float> precio;
    
    public static ObservableList<producto> lista = FXCollections.observableArrayList();
    
    @FXML
    private TextField txtfechav, txtfechal, txtNom, txtPrecio, txtID;
    
    @FXML
    private Button btnregistro, btnexit, btnm10, btnm1, btnM1, btnM10;
    
    @FXML
    private MenuItem menuid, menunom, menufechal, menufechav, menuprecio, menuprom, menumayprom, menumenprom, mayprecio, menprecio;
    
    @FXML
    private void actionEvent(ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btnregistro)){
            String ida = txtID.getText();
            String noma = txtNom.getText();
            String fechala = txtfechal.getText();
            String fechava = txtfechav.getText();
            float precioa = Float.parseFloat(txtPrecio.getText());
            producto agregar = new producto(ida, noma, fechala, fechava, precioa);
            pila.setPushProducto(agregar);
            txtID.setText("");
            txtNom.setText("");
            txtPrecio.setText("");
        }
        if(evt.equals(menuid)){
            String id = JOptionPane.showInputDialog("Ingrese el ID de producto que desea buscar:");
            if (pila.buscarID(id) != null){
                producto buscar = pila.buscarID(id);
                JOptionPane.showMessageDialog(null, "El producto con el ID buscado es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechap + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechaS + "\n"
                                                    + "Precio: " + buscar.precio);
            }
        }
        if(evt.equals(menunom)){
            String nom = JOptionPane.showInputDialog("Ingrese el nombre de producto que desea buscar:");
            if (pila.buscarNOM(nom) != null){
                producto buscar = pila.buscarNOM(nom);
                JOptionPane.showMessageDialog(null, "El producto con el nombre buscado es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechap + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechaS + "\n"
                                                    + "Precio: " + buscar.precio);
            }
        }
        if(evt.equals(menufechal)){
            String fechap = JOptionPane.showInputDialog("Ingrese la fecha de produccion que desea buscar");
            pila.buscarFechal(fechap);
        }
        if(evt.equals(menufechav)){
            String fechaS = JOptionPane.showInputDialog("Ingrese la fecha de salida que desea buscar");
            pila.buscarFechav(fechaS);
        }
        if(evt.equals(menuprecio)){
            float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto que desea buscar"));
            pila.buscarprecio(precio);
        }
        if(evt.equals(menuprom)){
            float prom = pila.sacarpromedio();
            JOptionPane.showMessageDialog(null, "El promedio de precio de los productos es:\n"
                                                + prom);
        }
        if(evt.equals(menumayprom)){
            pila.mayoralpromedio();
        }
        if(evt.equals(menumenprom)){
            pila.menoralpromedio();
        }
        if(evt.equals(mayprecio)){
            pila.mayorprecio();
        }
        if(evt.equals(menprecio)){
            pila.menorprecio();
        }
        if(evt.equals(btnm10)){
            calendario.add(Calendar.DATE, -10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            pila.productoexpirado();
        }
        if(evt.equals(btnm1)){
            calendario.add(Calendar.DATE, -1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            pila.productoexpirado();
        }
        if(evt.equals(btnM1)){
            calendario.add(Calendar.DATE, 1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            pila.productoexpirado();
        }
        if(evt.equals(btnM10)){
            calendario.add(Calendar.DATE, 10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            txtfechal.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            txtfechav.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            pila.productoexpirado();
        }
        if(evt.equals(btnexit)){
            System.exit(0);
        }
    }
    
    @FXML
    private void keyEvent(KeyEvent e){
        Object evt = e.getSource();
        if (evt.equals(txtID) || evt.equals(txtPrecio)){
            if(!Character.isDigit(e.getCharacter().charAt(0))){
                e.consume();
            }
        }
        if(evt.equals(txtNom)){
            if(!Character.isLetter(e.getCharacter().charAt(0))){
                e.consume();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calendario.add(Calendar.DATE, 31);
        diav = calendario.get(Calendar.DATE);
        mesv = calendario.get(Calendar.MONTH);
        añov = calendario.get(Calendar.YEAR);
        fecha = String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov);
        txtfechav.setText(fecha);
        calendario.add(Calendar.DATE, -31);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
        txtfechal.setText(fecha);
        
        id.setCellValueFactory(new PropertyValueFactory<producto, String>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<producto, String>("nom"));
        fechal.setCellValueFactory(new PropertyValueFactory<producto, String>("fechal"));
        fechav.setCellValueFactory(new PropertyValueFactory<producto, String>("fechav"));
        precio.setCellValueFactory(new PropertyValueFactory<producto, Float>("precio"));
        tabla.setItems(lista);
        // TODO
    }    
    
}
