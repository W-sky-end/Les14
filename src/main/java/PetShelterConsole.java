import java.util.List;
import java.util.Scanner;

public class PetShelterConsole {
    private final PetService petService;
    private final Scanner scanner;

    public PetShelterConsole(PetService petService) {
        this.petService = petService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Shelter Menu ---");
            System.out.println("1. Add a pet");
            System.out.println("2. View all pets");
            System.out.println("3. Adopt a pet");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, please try again.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    showAllPets();
                    break;
                case 3:
                    removePet();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    private void addPet() {
        System.out.print("Enter the pet's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter the age: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: Age must be a number.");
            scanner.next();
            return;
        }

        int age = scanner.nextInt();
        scanner.nextLine();

        petService.addPet(name, age, breed);
        System.out.println("The pet has been added to the shelter!");
    }

    private void showAllPets() {
        List<Pet> pets = petService.getAllPets();
        if (pets.isEmpty()) {
            System.out.println("There are no pets in the shelter.");
        } else {
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i + 1) + ". " + pets.get(i));
            }
        }
    }

    private void removePet() {
        List<Pet> pets = petService.getAllPets();
        if (pets.isEmpty()) {
            System.out.println("There are no pets in the shelter.");
            return;
        }

        showAllPets();
        System.out.print("Enter the number of the pet to adopt: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a number.");
            scanner.next();
            return;
        }

        int petIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (petService.removePet(petIndex)) {
            System.out.println("The pet has been adopted from the shelter!");
        } else {
            System.out.println("Invalid selection.");
        }
    }
}
