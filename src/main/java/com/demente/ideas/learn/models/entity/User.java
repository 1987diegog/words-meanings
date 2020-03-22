package com.demente.ideas.learn.models.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SPRING_LEARN_T_USERS")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id // indica que este atributo es la llave primaria (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // indica cual es la estrategia para generar el id
    // el motor de BD, por eje; auto incremental
    private Long id;

    private String username;
    private String name;
    private String lastname;
    private String email;

    // Los atributos createdAt y updatedAt con sus respectivas annotations @CreatedDate y @LastModifiedDate
    // seran manejados por Spring Data utilizando JPA Auditing, para activar esta funcionalidad
    // se necesitan dos pasos:

    // 1. Agregar Spring Data JPA’s AuditingEntityListener al modelo (Entity), lo hacemos
    //    anotando nuestra entity con @EntityListeners(AuditingEntityListener.class).
    // 2. Activar JPA Auditing (@EnableJpaAuditing) en nuestro main Application, en este
    //    caso en la clase LearnSpringApplication

    @Column(name="CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name="UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public User () {
    }

    public User(String username, String name, String lastname, String email) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}