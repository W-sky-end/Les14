import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetShelterRepository {
    private static final String NAME_FILE = "pets.json";
    private final ObjectMapper mapper = new ObjectMapper();


    public List<Pet> loadPets() {
        File file = new File(NAME_FILE);
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Pet>>() {});
            } catch (IOException e) {
                System.out.println("Error load data: " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }


    public void savePets(List<Pet> pets) {
        try {
            mapper.writeValue(new File(NAME_FILE), pets);
        } catch (IOException e) {
            System.out.println("Error save data " + e.getMessage());
        }
    }
}

