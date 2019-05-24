package com.company;

import java.util.List;

public class FactoryIceCream {
    private String type;
    private int size;
    private List<Ingredients> ingredients;

    public FactoryIceCream(String type,int size,List<Ingredients> ingredients){
        this.type =type;
        this.size=size;
        this.ingredients=ingredients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }


}
