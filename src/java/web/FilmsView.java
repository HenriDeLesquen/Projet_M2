/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.FilmFacadeLocal;
import entity.Film;
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
@Named(value="vfilm")
@SessionScoped

public class FilmsView implements Serializable{
    @EJB
    FilmFacadeLocal filmDao;
    
    private Film film;
    private String nom_film;
    private int idTarget;
    
    // CONSTRCUTOR
    public FilmsView() {
    }
    
    @PostConstruct
    public void ini(){
        
        film = new Film();
    }
    
    
    public List<Film> getAllFilm(){
        return filmDao.findAll();
    }
    public Film getFilm(){
        return film;
    }

    public void setNomFilm(Film film) {
        this.film = film;
    }
    public String getNom() {
        return nom_film;
    }

    // GETTER & SETTER
    public void setNom(String nom_film) {
        this.nom_film = nom_film;
    }

    public int getIdTarget() {
        return idTarget;
    }

    public void setIdTarget(int idTarget) {
        this.idTarget = idTarget;
    }
    
    

    // QUERY
    public void addFilm() {
        filmDao.create(film);
        film = new Film();
    }
    
    public void deleteFilm(){
        Film f= filmDao.find(idTarget);
        filmDao.remove(f);
//       Filmf= filmDao.findByName(nom_film);
//        filmDao.remove(c);
        
    }
    
    public void updateNomFilm(){
        Film f= filmDao.find(idTarget);
        f.setNomFilm(nom_film);
        filmDao.edit(f);

    }
      
}
