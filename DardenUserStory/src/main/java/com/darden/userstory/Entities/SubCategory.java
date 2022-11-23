package com.darden.userstory.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sub_category_id_generator")
    @TableGenerator(name = "sub_category_id_generator", table = "sub_category_id", allocationSize = 1)
    @Column(name = "sub_category_id_1", nullable = false)
    private Long subCategoryId;

    @Column(nullable = false,unique = true)
    private String entreeItem;
    private boolean flagStatus;
    private String subCategoryType;


    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }


}
