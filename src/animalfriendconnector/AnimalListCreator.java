/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalfriendconnector;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kingm
 */
public class AnimalListCreator {
    private static ArrayList<Animal> list;
    public static void CREATE_LIST()
    {
        list= new ArrayList<Animal>();
        
        
        list.add(createAnimal("tiger"));
        
        list.add(createAnimal("horse"));
        list.add(createAnimal("cat"));
        list.add(createAnimal("dog"));
        list.add(createAnimal("elephant"));
        list.add(createAnimal("donkey"));
        
        //Collections.shuffle(list);
        
    }
    
    public static Animal createAnimal(String name)
    {
        return (new Animal(name,"Assets/images/"+name+".png","Assets/"+name+".wav"));
    }

    /**
     * @return the list
     */
    public static ArrayList<Animal> getList() {
        return list;
    }
    public static ArrayList<Animal> subList(int start, int end){
        ArrayList<Animal> ret=new ArrayList<Animal>();
        for(int i=start; i<end; i++)
        {
            ret.add(list.get(i));
        }
        return ret;
    }
    
}
