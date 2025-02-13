

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                '}';
    }

    private String breed;

    public Pet(@JsonProperty("name") String name,@JsonProperty("age") int age,@JsonProperty("breed") String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;


    }
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getBreed() {return breed;}


}

