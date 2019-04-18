package sk.tuke.oop.game.items;


import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

import java.util.*;

/**
 * Created by Martina on 11/13/2016.
 */
public class BackpackImpl implements Backpack {
    private int capacity;

    private List<Item> items=new ArrayList<>();

    public BackpackImpl(int capacity){
        this.capacity=capacity;
    }


    public void add(Item item) {
        if(this.capacity==items.size()){
            throw new ArrayIndexOutOfBoundsException();}
        else {
            items.add(0,item);
        }
    }


    public void remove(Item item) {
        Set<Item> set = new HashSet<>(items);
        if (set.contains(item)) {
            items.remove(item);
        } else {
            throw new NoSuchElementException();
        }
    }


    public Item getItem(String name){
        for(int i=0; i< items.size(); i++){
            if(Objects.equals(items.get(i).getName(), name)){
                return items.get(i);
            }
        }
        return null;
    }

    public List<Item> getItemsList() {
        return items;
    }


    public int getCapacity() {
        return this.capacity;
    }


    public Iterator<Item> iterator() {
        return this.items.iterator();
    }

    public Item getLastItem() {
        return items.get(0);
    }

    public int getSize(){
        return items.size();
    }

    public Item getItem(int i){
        return items.get(i);
    }

    public Item setItem(int i, Item item){
        return items.set(i,item);
    }
}
