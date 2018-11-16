/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ClientFacadeLocal;
import entity.Client;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Romain
 */
@Named(value="vclient")
@SessionScoped
public class ClientView implements Serializable {

    @EJB
    ClientFacadeLocal clientDao;
    
    private Client client;
    private String nom;
    private int idTarget;
    
    // CONSTRCUTOR
    public ClientView() {
    }
    
    @PostConstruct
    public void ini(){
        
        client = new Client();
    }
    
    public List<Client> getAllClient(){
        return clientDao.findAll();
    }
    public Client getClient(){
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public String getNom() {
        return nom;
    }

    // GETTER & SETTER
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdTarget() {
        return idTarget;
    }

    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }
    
    

    // QUERY
    public void addClient() {
        clientDao.create(client);
        client = new Client();
    }
    
    public void deleteClient(){
        Client c = clientDao.find(idTarget);
        clientDao.remove(c);
//       Client c = clientDao.findByName(nom);
//        clientDao.remove(c);
        
    }
    
    public void updateNomClient(){
        Client c = clientDao.find(idTarget);
        c.setNom(nom);
        clientDao.edit(c);

    }
    
}
