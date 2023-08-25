
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
* Classe que representa a tabela CONFIGURACAO_AMBIENTE
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"CONFIGURACAO_AMBIENTE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ConfiguracaoAmbiente")
public class ConfiguracaoAmbiente implements Serializable {
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
    @Column(name = "ativo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean ativo;


    /**
    * @generated
    */
    @Column(name = "email_host", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String emailHost;


    /**
    * @generated
    */
    @Column(name = "email_porta", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String emailPorta;


    /**
    * @generated
    */
    @Column(name = "email_remetente", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String emailRemetente;


    /**
    * @generated
    */
    @Column(name = "login", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String login;


    /**
    * @generated
    */
    @Column(name = "protocolo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String protocolo;


    /**
    * @generated
    */
    @Column(name = "senha", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String senha;


    /**
    * Construtor
    * @generated
    */
    public ConfiguracaoAmbiente(){
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
    public ConfiguracaoAmbiente setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém ativo
    * return ativo
    * @generated
    */
    public java.lang.Boolean getAtivo() {
        return this.ativo;
    }

    /**
    * Define ativo
    * @param ativo ativo
    * @generated
    */
    public ConfiguracaoAmbiente setAtivo(java.lang.Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    /**
    * Obtém emailHost
    * return emailHost
    * @generated
    */
    public java.lang.String getEmailHost() {
        return this.emailHost;
    }

    /**
    * Define emailHost
    * @param emailHost emailHost
    * @generated
    */
    public ConfiguracaoAmbiente setEmailHost(java.lang.String emailHost) {
        this.emailHost = emailHost;
        return this;
    }
    /**
    * Obtém emailPorta
    * return emailPorta
    * @generated
    */
    public java.lang.String getEmailPorta() {
        return this.emailPorta;
    }

    /**
    * Define emailPorta
    * @param emailPorta emailPorta
    * @generated
    */
    public ConfiguracaoAmbiente setEmailPorta(java.lang.String emailPorta) {
        this.emailPorta = emailPorta;
        return this;
    }
    /**
    * Obtém emailRemetente
    * return emailRemetente
    * @generated
    */
    public java.lang.String getEmailRemetente() {
        return this.emailRemetente;
    }

    /**
    * Define emailRemetente
    * @param emailRemetente emailRemetente
    * @generated
    */
    public ConfiguracaoAmbiente setEmailRemetente(java.lang.String emailRemetente) {
        this.emailRemetente = emailRemetente;
        return this;
    }
    /**
    * Obtém login
    * return login
    * @generated
    */
    public java.lang.String getLogin() {
        return this.login;
    }

    /**
    * Define login
    * @param login login
    * @generated
    */
    public ConfiguracaoAmbiente setLogin(java.lang.String login) {
        this.login = login;
        return this;
    }
    /**
    * Obtém protocolo
    * return protocolo
    * @generated
    */
    public java.lang.String getProtocolo() {
        return this.protocolo;
    }

    /**
    * Define protocolo
    * @param protocolo protocolo
    * @generated
    */
    public ConfiguracaoAmbiente setProtocolo(java.lang.String protocolo) {
        this.protocolo = protocolo;
        return this;
    }
    /**
    * Obtém senha
    * return senha
    * @generated
    */
    public java.lang.String getSenha() {
        return this.senha;
    }

    /**
    * Define senha
    * @param senha senha
    * @generated
    */
    public ConfiguracaoAmbiente setSenha(java.lang.String senha) {
        this.senha = senha;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ConfiguracaoAmbiente object = (ConfiguracaoAmbiente)obj;
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