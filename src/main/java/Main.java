public class Main {
    public static void main(String[] args) {
        PetShelterRepository repository = new PetShelterRepository();
        PetService petService = new PetService(repository);
        PetShelterConsole console = new PetShelterConsole(petService);

        console.start();
    }
}
