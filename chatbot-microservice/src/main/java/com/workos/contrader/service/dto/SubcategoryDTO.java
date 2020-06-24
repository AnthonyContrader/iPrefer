package com.workos.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Subcategory entity.
 */
public class SubcategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String subcategoryName;

    @NotNull
    private String subcatHelpMessage;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcatHelpMessage() {
        return subcatHelpMessage;
    }

    public void setSubcatHelpMessage(String subcatHelpMessage) {
        this.subcatHelpMessage = subcatHelpMessage;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubcategoryDTO subcategoryDTO = (SubcategoryDTO) o;
        if (subcategoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), subcategoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SubcategoryDTO{" +
            "id=" + getId() +
            ", subcategoryName='" + getSubcategoryName() + "'" +
            ", subcatHelpMessage='" + getSubcatHelpMessage() + "'" +
            ", category=" + getCategoryId() +
            "}";
    }
}
