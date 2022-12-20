package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Audited
@DiscriminatorValue("OPTION")
public class Child extends Parent{

    private String propA;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "recursive_children_child", joinColumns = {@JoinColumn(name = "child_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "recursive_id", nullable = false, updatable = false)})
    @NotAudited
    @OrderBy("propA DESC")
    private List<Child> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "recursive_children_child", joinColumns = {@JoinColumn(name = "recursive_id")}, inverseJoinColumns = {@JoinColumn(name = "child_id")})
    @NotAudited
    private Child recursiveChild;
    public Child(String propA) {
        this.propA = propA;
    }

    public Child() {

    }

    public String getPropA() {
        return propA;
    }

    public void setPropA(String propA) {
        this.propA = propA;
    }
}
