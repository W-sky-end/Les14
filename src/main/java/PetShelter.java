import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetShelter {
    private static final String NAME_FILE = "pets.json";
    private List<Pet> pets;
    private final ObjectMapper mapper = new ObjectMapper();

    public PetShelter() {
        this.pets = loadPets();
    }

    private List<Pet> loadPets() {
        File file = new File(NAME_FILE);
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Pet>>() {});
            } catch (IOException e) {
                System.out.println("Error load data " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }
    public void addPet(Pet pet) {
        pets.add(pet);
        savePets();
    }

    public void removePet(int index) {
        if (index >= 0 && index < pets.size()) {
            pets.remove(index);
            savePets();
        }
    }

    public List<Pet> getAllPets() {
        return pets;
    }

    private void savePets() {
        try {
            mapper.writeValue(new File(NAME_FILE), pets);
        } catch (IOException e) {
            System.out.println("Error save data " + e.getMessage());
        }
    }
}

