package com.fsociety.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListPerson {

    public  ListPerson(){

    }

    public static List<Person> getAllPerson(){
        List<Person> lisPerson=new ArrayList<Person>();
        Person person=new Person();
        person.setId(1);
        person.setName("Emmanuel");
        person.setFirstLastName("Hernandez");
        person.setSecondLastName("Ramirez");
        person.setDateBirth(new Date());
        person.setCurp("sdajkhamsbdma");
        Person person1=new Person();
        person1.setId(2);
        person1.setName("Orlando");
        person1.setFirstLastName("Romero");
        person1.setSecondLastName("Masias");
        person1.setDateBirth(new Date());
        person1.setCurp("sdajkhamsbdma");
        Person person2=new Person();
        person2.setId(3);
        person2.setName("Esfayro");
        person2.setFirstLastName("Fragoso");
        person2.setSecondLastName("Escarsega");
        person2.setDateBirth(new Date());
        person2.setCurp("sdajkhamsbdma");
        Person person3=new Person();
        person3.setId(4);
        person3.setName("Edgar");
        person3.setFirstLastName("Serrano");
        person3.setSecondLastName("");
        person3.setDateBirth(new Date());
        person3.setCurp("sdajkhamsbdma");
        lisPerson.add(person);
        lisPerson.add(person1);
        lisPerson.add(person2);
        lisPerson.add(person3);
        return lisPerson;
    }

}
