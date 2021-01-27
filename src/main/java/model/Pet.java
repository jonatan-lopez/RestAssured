package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Pet {
    private int id;
    Category CategoryObject;
    private String name;
    ArrayList<String> photoUrls = new ArrayList<>();
    ArrayList <String> tags = new ArrayList<>();
    private String status;


    // Getter Methods

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return CategoryObject;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pet other = (Pet) obj;
        return other.getId() == this.id &&
                other.getCategory().getId() == this.getCategory().getId() &&
                other.getCategory().getName().equals(this.getCategory().getName()) &&
                Arrays.equals(new ArrayList[]{other.getPhotoUrls()}, new ArrayList[]{this.photoUrls}) &&
                Arrays.equals(new ArrayList[]{other.getTags()}, new ArrayList[]{this.tags});

    }
}
