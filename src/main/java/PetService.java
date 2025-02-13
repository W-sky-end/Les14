import java.util.ArrayList;
import java.util.List;

public class PetService {
    private final PetShelterRepository repository;
    private List<Pet> pets;

    public PetService(PetShelterRepository repository) {
        this.repository = repository;
        this.pets = repository.loadPets();
    }
    public void addPet(String name, int age,String breed) {
        Pet pet = new Pet(name, age, breed);
        pets.add(pet);
        repository.savePets(pets);

    }
    public List<Pet> getAllPets() {
        return pets;
    }

    public boolean removePet(int index) {
        if (index >= 0 && index < pets.size()) {
            pets.remove(index);
            repository.savePets(pets);
            return true;
        }
        return false;
    }
}

