package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class BigmacBuilder{
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun){
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers){
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient){
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build(){
            if (!(bun.equals("with sesame") || bun.equals("without sesame"))){
                throw new IllegalStateException("Bun can only be with or without sesame");
            }
            if(burgers == 0){
                throw new IllegalStateException("You cannot have burger without burgers!!");
            }
            if (!Arrays.asList("normal", "barbecue", "thousand island").contains(sauce)){
                throw new IllegalStateException("We don't have that sauce in our menu. We only have normal, barbecue, thousand island");
            }
            boolean ingredient = false;
            for (int i=0; i<ingredients.size(); i++){
                if (Arrays.asList("lettuce", "onion", "bacon", "cucumber", "chilli", "mushrooms", "prawn", "cheese")
                        .contains(ingredients.get(i))){
                    ingredient = true;
                    break;
                }
            }
            if (!ingredient){
                throw new IllegalStateException("In Your burgers is ingredient that we don't have - please reconsider Your choice");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
