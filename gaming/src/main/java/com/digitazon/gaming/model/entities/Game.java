package com.digitazon.gaming.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;
    @Column(name = "playstation_version")
    private boolean psVersion;
    @Column(name = "xbox_version")
    private boolean xboxVersion;
    @Column(name = "pc_version")
    private boolean pcVersion;
    @Column(name = "phone_version")
    private boolean phoneVersion;
    @Column(name = "img")
    private String img;

    public Game() {
    }

    public Game(int id, String name, String description, double price, Category category, Creator creator,
                boolean psVersion, boolean xboxVersion, boolean pcVersion, boolean phoneVersion, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.creator = creator;
        this.psVersion = psVersion;
        this.xboxVersion = xboxVersion;
        this.pcVersion = pcVersion;
        this.phoneVersion = phoneVersion;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public boolean isPsVersion() {
        return psVersion;
    }

    public void setPsVersion(boolean psVersion) {
        this.psVersion = psVersion;
    }

    public boolean isXboxVersion() {
        return xboxVersion;
    }

    public void setXboxVersion(boolean xboxVersion) {
        this.xboxVersion = xboxVersion;
    }

    public boolean isPcVersion() {
        return pcVersion;
    }

    public void setPcVersion(boolean pcVersion) {
        this.pcVersion = pcVersion;
    }

    public boolean isPhoneVersion() {
        return phoneVersion;
    }

    public void setPhoneVersion(boolean phoneVersion) {
        this.phoneVersion = phoneVersion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
