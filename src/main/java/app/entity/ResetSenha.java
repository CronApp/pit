
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
* Classe que representa a tabela RESET_SENHA
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"RESET_SENHA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ResetSenha")
public class ResetSenha implements Serializable {
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataLimite", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dataLimite;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User user;


    /**
    * Construtor
    * @generated
    */
    public ResetSenha(){
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
    public ResetSenha setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém dataLimite
    * return dataLimite
    * @generated
    */
    public java.util.Date getDataLimite() {
        return this.dataLimite;
    }

    /**
    * Define dataLimite
    * @param dataLimite dataLimite
    * @generated
    */
    public ResetSenha setDataLimite(java.util.Date dataLimite) {
        this.dataLimite = dataLimite;
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
    public ResetSenha setUser(User user) {
        this.user = user;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ResetSenha object = (ResetSenha)obj;
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