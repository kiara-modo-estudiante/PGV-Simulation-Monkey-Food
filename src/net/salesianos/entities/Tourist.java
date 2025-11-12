package net.salesianos.entities;

import java.util.Arrays;

public class Tourist {

    // ----------- Attributes -----------
    private int id;
    private String name;
    private int total_quantity_to_produce;
    private String[] food;
    private int max_time_to_produce;
    // private shared resource

    // ----------- Complete Constructor -----------
    public Tourist(int id, String name, int total_quantity_to_produce, String[] food, int max_time_to_produce) {
        this.id = id;
        this.name = name;
        this.total_quantity_to_produce = total_quantity_to_produce;
        this.food = food;
        this.max_time_to_produce = max_time_to_produce;
    }

    // ----------- Getters and Setters -----------
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

    public int getTotal_quantity_to_produce() {
        return total_quantity_to_produce;
    }

    public void setTotal_quantity_to_produce(int total_quantity_to_produce) {
        this.total_quantity_to_produce = total_quantity_to_produce;
    }

    public String[] getFood() {
        return food;
    }

    public void setFood(String[] food) {
        this.food = food;
    }

    public int getMax_time_to_produce() {
        return max_time_to_produce;
    }

    public void setMax_time_to_produce(int max_time_to_produce) {
        this.max_time_to_produce = max_time_to_produce;
    }

    // ----------- toString -----------
    @Override
    public String toString() {
        return "Tourist [id=" + id + ", name=" + name + ", total_quantity_to_produce=" + total_quantity_to_produce
                + ", food=" + Arrays.toString(food) + ", max_time_to_produce=" + max_time_to_produce + "]";
    }

}
