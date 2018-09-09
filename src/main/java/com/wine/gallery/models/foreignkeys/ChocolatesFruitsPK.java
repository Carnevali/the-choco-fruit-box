package com.wine.gallery.models.foreignkeys;

import com.wine.gallery.models.chocolates.Chocolates;
import com.wine.gallery.models.chocolates.Fruits;

import java.io.Serializable;

/**
 * Created by felipecarnevalli on 9/9/18.
 */
public class ChocolatesFruitsPK implements Serializable {
    private Chocolates chocolates;
    private Fruits fruits;

    @Override
    public int hashCode(){
        return this.chocolates.hashCode() + this.chocolates.hashCode();
    }

    @Override
    public boolean equals(Object o){
        Boolean flag = false;
        ChocolatesFruitsPK myId = (ChocolatesFruitsPK) o;

        if ((o instanceof ChocolatesFruitsPK)
                && (this.chocolates.equals(myId.chocolates))
                && (this.fruits.equals(myId.fruits))){
            flag = true;
        }

        return flag;
    }
}
