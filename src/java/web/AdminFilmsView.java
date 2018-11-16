/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.FilmFacadeLocal;
import entity.Film;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author Romain
 */  

@ManagedBean
@Named(value = "AdminFilmsView")
public class AdminFilmsView  implements Serializable  {
 
    @EJB
    FilmFacadeLocal filmdao;
    
    private List<Film> droppedFilms;
    private List<Film> availableFilms;
     
    private Film selectedFilm;
     
    @PostConstruct
    public void init() {
        availableFilms = new ArrayList<Film>();
        droppedFilms = new ArrayList<Film>();
    }
     
    public void onFilmDrop(DragDropEvent ddEvent) {
        Film film = ((Film) ddEvent.getData());
  
        droppedFilms.add(film);
        availableFilms.remove(film);
    }
     
 
    // GETTER & SETTER
    public List<Film> getFilms() {
        return availableFilms;
    }
    public List<Film> getDroppedFilms() {
        return droppedFilms;
    }    
    public Film getSelectedFilm() {
        return selectedFilm;
    }
    public void setSelectedFilm(Film selectedFilm) {
        this.selectedFilm = selectedFilm;
    }  
    
    public List<Film> getAllFilms (){
        return filmdao.findAll();
    };

}
