
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela VIEW
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"VIEW\"")
@XmlRootElement
@CronappSecurity(post = "Administrators", get = "Administrators", delete = "Administrators", put = "Administrators")
@JsonFilter("app.entity.View")
@CronappTable(role=CronappTableRole.ASSOCIATION_CLASS)
public class View implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="securable_id", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Securable securable;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Pattern")
    @Column(name = "pattern", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String pattern;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Get Method Allowed")
    @Column(name = "getMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean getMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Head Method Allowed")
    @Column(name = "headMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean headMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Put Method Allowed")
    @Column(name = "putMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean putMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Post Method Allowed")
    @Column(name = "postMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean postMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Patch Method Allowed")
    @Column(name = "patchMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean patchMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Delete Method Allowed")
    @Column(name = "deleteMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean deleteMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Options Method Allowed")
    @Column(name = "optionsMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean optionsMethodAllowed;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Trace Method Allowed")
    @Column(name = "traceMethodAllowed", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean traceMethodAllowed;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="application_id", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Application application;


    /**
    * Construtor
    * @generated
    */
    public View(){
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
    public View setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém securable
    * return securable
    * @generated
    */
    public Securable getSecurable() {
        return this.securable;
    }

    /**
    * Define securable
    * @param securable securable
    * @generated
    */
    public View setSecurable(Securable securable) {
        this.securable = securable;
        return this;
    }
    /**
    * Obtém pattern
    * return pattern
    * @generated
    */
    public java.lang.String getPattern() {
        return this.pattern;
    }

    /**
    * Define pattern
    * @param pattern pattern
    * @generated
    */
    public View setPattern(java.lang.String pattern) {
        this.pattern = pattern;
        return this;
    }
    /**
    * Obtém getMethodAllowed
    * return getMethodAllowed
    * @generated
    */
    public java.lang.Boolean getGetMethodAllowed() {
        return this.getMethodAllowed;
    }

    /**
    * Define getMethodAllowed
    * @param getMethodAllowed getMethodAllowed
    * @generated
    */
    public View setGetMethodAllowed(java.lang.Boolean getMethodAllowed) {
        this.getMethodAllowed = getMethodAllowed;
        return this;
    }
    /**
    * Obtém headMethodAllowed
    * return headMethodAllowed
    * @generated
    */
    public java.lang.Boolean getHeadMethodAllowed() {
        return this.headMethodAllowed;
    }

    /**
    * Define headMethodAllowed
    * @param headMethodAllowed headMethodAllowed
    * @generated
    */
    public View setHeadMethodAllowed(java.lang.Boolean headMethodAllowed) {
        this.headMethodAllowed = headMethodAllowed;
        return this;
    }
    /**
    * Obtém putMethodAllowed
    * return putMethodAllowed
    * @generated
    */
    public java.lang.Boolean getPutMethodAllowed() {
        return this.putMethodAllowed;
    }

    /**
    * Define putMethodAllowed
    * @param putMethodAllowed putMethodAllowed
    * @generated
    */
    public View setPutMethodAllowed(java.lang.Boolean putMethodAllowed) {
        this.putMethodAllowed = putMethodAllowed;
        return this;
    }
    /**
    * Obtém postMethodAllowed
    * return postMethodAllowed
    * @generated
    */
    public java.lang.Boolean getPostMethodAllowed() {
        return this.postMethodAllowed;
    }

    /**
    * Define postMethodAllowed
    * @param postMethodAllowed postMethodAllowed
    * @generated
    */
    public View setPostMethodAllowed(java.lang.Boolean postMethodAllowed) {
        this.postMethodAllowed = postMethodAllowed;
        return this;
    }
    /**
    * Obtém patchMethodAllowed
    * return patchMethodAllowed
    * @generated
    */
    public java.lang.Boolean getPatchMethodAllowed() {
        return this.patchMethodAllowed;
    }

    /**
    * Define patchMethodAllowed
    * @param patchMethodAllowed patchMethodAllowed
    * @generated
    */
    public View setPatchMethodAllowed(java.lang.Boolean patchMethodAllowed) {
        this.patchMethodAllowed = patchMethodAllowed;
        return this;
    }
    /**
    * Obtém deleteMethodAllowed
    * return deleteMethodAllowed
    * @generated
    */
    public java.lang.Boolean getDeleteMethodAllowed() {
        return this.deleteMethodAllowed;
    }

    /**
    * Define deleteMethodAllowed
    * @param deleteMethodAllowed deleteMethodAllowed
    * @generated
    */
    public View setDeleteMethodAllowed(java.lang.Boolean deleteMethodAllowed) {
        this.deleteMethodAllowed = deleteMethodAllowed;
        return this;
    }
    /**
    * Obtém optionsMethodAllowed
    * return optionsMethodAllowed
    * @generated
    */
    public java.lang.Boolean getOptionsMethodAllowed() {
        return this.optionsMethodAllowed;
    }

    /**
    * Define optionsMethodAllowed
    * @param optionsMethodAllowed optionsMethodAllowed
    * @generated
    */
    public View setOptionsMethodAllowed(java.lang.Boolean optionsMethodAllowed) {
        this.optionsMethodAllowed = optionsMethodAllowed;
        return this;
    }
    /**
    * Obtém traceMethodAllowed
    * return traceMethodAllowed
    * @generated
    */
    public java.lang.Boolean getTraceMethodAllowed() {
        return this.traceMethodAllowed;
    }

    /**
    * Define traceMethodAllowed
    * @param traceMethodAllowed traceMethodAllowed
    * @generated
    */
    public View setTraceMethodAllowed(java.lang.Boolean traceMethodAllowed) {
        this.traceMethodAllowed = traceMethodAllowed;
        return this;
    }
    /**
    * Obtém application
    * return application
    * @generated
    */
    public Application getApplication() {
        return this.application;
    }

    /**
    * Define application
    * @param application application
    * @generated
    */
    public View setApplication(Application application) {
        this.application = application;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
View object = (View)obj;
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
