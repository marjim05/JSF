/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import dao.BoletaDAO;
import dao.EventoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Boleta;
import modelo.Evento;

/**
 *
 * @author marce
 */
@ManagedBean
@ApplicationScoped
public class BoletaBean {
    Boleta boleta = new Boleta();
    List<Boleta> lstBole = new ArrayList<>();
    List<Boleta> lstBoleFiltered = new ArrayList<>();
    List<Evento> lstEven = new ArrayList<>();
    BoletaDAO boleDAO = new BoletaDAO();


    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public List<Boleta> getLstBole() {
        return lstBole;
    }

    public void setLstBole(List<Boleta> lstBole) {
        this.lstBole = lstBole;
    }

    public List<Boleta> getLstBoleFiltered() {
        return lstBoleFiltered;
    }

    public void setLstBoleFiltered(List<Boleta> lstBoleFiltered) {
        this.lstBoleFiltered = lstBoleFiltered;
    }

    public List<Evento> getLstEven() {
        return lstEven;
    }

    public void setLstEven(List<Evento> lstEven) {
        this.lstEven = lstEven;
    }
    
    public void listar (){
        boleta = new Boleta();
        lstBole = boleDAO.listar();
    }
    
    public void listarEven(){
        EventoDAO evenDAO = new EventoDAO();
        lstEven = evenDAO.listar();
    }
    
    public void guardar (){
        boleDAO.guardar(boleta);
    }
    
    public void buscar (int id_boleta){
        boleta = boleDAO.buscar(id_boleta);
    }
    
    public void actualizar (){
        boleDAO.actualizar(boleta);
    }
    
    public void eliminar (int id_boleta){
        boleDAO.eliminar(id_boleta);
    }
}
