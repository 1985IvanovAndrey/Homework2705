package task1;

import lombok.Data;
public class Person {

    private String name;
    private String serName;
    private String adres;
    private String phone;
    private int age;
    private int id;


    public Person(String name, String serName, String adres, String phone, int age) {
        this.name = name;
        this.serName = serName;
        this.adres = adres;
        this.phone = phone;
        this.age = age;
    }

    public Person(String name, String serName) {
        this.name = name;
        this.serName = serName;
    }

    public Person(int id,String name, String serName) {
        this.id = id;
        this.name = name;
        this.serName = serName;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
