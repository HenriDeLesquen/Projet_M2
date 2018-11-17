/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Romain
 */

@ManagedBean
public class EffectView {
   
    private String text;
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
     
    public void echo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vous avez supprimé:'" + text + "'"));
    }
}
