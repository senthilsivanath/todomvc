package com.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A A.
 */
@Table("a")
public class A implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull(message = "must not be null")
    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Transient
    @JsonIgnoreProperties(value = { "a" }, allowSetters = true)
    private Set<B> bs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public A id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public A name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public A age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<B> getBs() {
        return this.bs;
    }

    public A bs(Set<B> bs) {
        this.setBs(bs);
        return this;
    }

    public A addB(B b) {
        this.bs.add(b);
        b.setA(this);
        return this;
    }

    public A removeB(B b) {
        this.bs.remove(b);
        b.setA(null);
        return this;
    }

    public void setBs(Set<B> bs) {
        if (this.bs != null) {
            this.bs.forEach(i -> i.setA(null));
        }
        if (bs != null) {
            bs.forEach(i -> i.setA(this));
        }
        this.bs = bs;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof A)) {
            return false;
        }
        return id != null && id.equals(((A) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "A{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", age=" + getAge() +
            "}";
    }
}
