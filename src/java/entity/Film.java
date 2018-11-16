/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Romain
 */
@Entity
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findByIdFilm", query = "SELECT f FROM Film f WHERE f.idFilm = :idFilm")
    , @NamedQuery(name = "Film.findByNomFilm", query = "SELECT f FROM Film f WHERE f.nomFilm = :nomFilm")
    , @NamedQuery(name = "Film.findByIdSalle", query = "SELECT f FROM Film f WHERE f.idSalle = :idSalle")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_film")
    private Integer idFilm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_film")
    private String nomFilm;
    @Column(name = "id_salle")
    private Integer idSalle;

    public Film() {
    }

    public Film(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public Film(Integer idFilm, String nomFilm) {
        this.idFilm = idFilm;
        this.nomFilm = nomFilm;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFilm != null ? idFilm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.idFilm == null && other.idFilm != null) || (this.idFilm != null && !this.idFilm.equals(other.idFilm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Film[ idFilm=" + idFilm + " ]";
    }
    
}
