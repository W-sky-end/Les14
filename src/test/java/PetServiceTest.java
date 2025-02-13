import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

class PetServiceTest {

    @Test
    void testAddPet() {
        PetShelterRepository repository = new PetShelterRepository();
        PetService petService = new PetService(repository);

        petService.addPet("Buddy", 3, "Labrodudel");
        List<Pet> pets = petService.getAllPets();

        assertFalse(pets.isEmpty());
        assertEquals("Buddy", pets.get(0).getName());
        assertEquals("Labrodudel", pets.get(0).getBreed());
        assertEquals(3, pets.get(0).getAge());
    }

    @Test
    void testRemovePet() {
        File file = new File("pets.json");
        if (file.exists()) {
            file.delete();
        }

        PetShelterRepository repository = new PetShelterRepository();
        PetService petService = new PetService(repository);

        petService.addPet("Buddy", 3, "Labrodudel");
        assertFalse(petService.getAllPets().isEmpty());


        assertTrue(petService.removePet(0));
        assertTrue(petService.getAllPets().isEmpty());
    }
}


