
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela CONTROLEVOTACAO
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"CONTROLEVOTACAO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ControleVotacao")
public class ControleVotacao implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "votos", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String votos;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User user;


    /**
    * @generated
    */
    @Column(name = "votou", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean votou;


    /**
    * Construtor
    * @generated
    */
    public ControleVotacao(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public ControleVotacao setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém votos
    * return votos
    * @generated
    */
    public java.lang.String getVotos() {
        return this.votos;
    }

    /**
    * Define votos
    * @param votos votos
    * @generated
    */
    public ControleVotacao setVotos(java.lang.String votos) {
        this.votos = votos;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    public User getUser() {
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public ControleVotacao setUser(User user) {
        this.user = user;
        return this;
    }
    /**
    * Obtém votou
    * return votou
    * @generated
    */
    public java.lang.Boolean getVotou() {
        return this.votou;
    }

    /**
    * Define votou
    * @param votou votou
    * @generated
    */
    public ControleVotacao setVotou(java.lang.Boolean votou) {
        this.votou = votou;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ControleVotacao object = (ControleVotacao)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}