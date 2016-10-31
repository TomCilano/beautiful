package com.ironyard.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tom on 10/24/16.
 */
@Entity
public class Characterz {
    private String name;
    private String aClass;
    private int level;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skills> skills;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
