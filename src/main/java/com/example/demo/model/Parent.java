package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
@Audited
public abstract class Parent extends Ancestor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", length = 200)
    protected String name;

    @Column(name="type", updatable = false, insertable = false)
    @Enumerated(EnumType.STRING)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected ParentType ParentType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.demo.model.ParentType getParentType() {
        return ParentType;
    }

    public void setParentType(com.example.demo.model.ParentType parentType) {
        ParentType = parentType;
    }
}
