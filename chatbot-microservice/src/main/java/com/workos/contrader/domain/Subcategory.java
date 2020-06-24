package com.workos.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Subcategory.
 */
@Entity
@Table(name = "subcategory")
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "subcategory_name", nullable = false)
    private String subcategoryName;

    @NotNull
    @Column(name = "subcat_help_message", nullable = false)
    private String subcatHelpMessage;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public Subcategory subcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
        return this;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcatHelpMessage() {
        return subcatHelpMessage;
    }

    public Subcategory subcatHelpMessage(String subcatHelpMessage) {
        this.subcatHelpMessage = subcatHelpMessage;
        return this;
    }

    public void setSubcatHelpMessage(String subcatHelpMessage) {
        this.subcatHelpMessage = subcatHelpMessage;
    }

    public Category getCategory() {
        return category;
    }

    public Subcategory category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subcategory subcategory = (Subcategory) o;
        if (subcategory.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), subcategory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Subcategory{" +
            "id=" + getId() +
            ", subcategoryName='" + getSubcategoryName() + "'" +
            ", subcatHelpMessage='" + getSubcatHelpMessage() + "'" +
            "}";
    }
}
