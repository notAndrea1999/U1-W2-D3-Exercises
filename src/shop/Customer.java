package shop;

import java.util.Random;

public class Customer {
    public String name;
    private long id;
    private Integer tier;

    public Customer(String name, Integer tier) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
}
