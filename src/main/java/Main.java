import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetShelter petShelter = new PetShelter();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n Menu :");
            System.out.println("1. Add Pet");
            System.out.println("2. View Pets");
            System.out.println("3. Take a pet from shelter");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number");
                sc.next();
                continue;

            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the pet name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the pet breed: ");
                    String breed = sc.nextLine();
                    System.out.println("Enter age : ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Please enter a number");
                        sc.next();
                        continue;
                    }
                    int age = sc.nextInt();
                    sc.nextLine();

                    petShelter.addPet(new Pet(name, age, breed));
                    System.out.println("Pet added successfully");
                    break;
                case 2:
                    List<Pet> pets = petShelter.getAllPets();
                    if (pets.isEmpty()) {
                        System.out.println("There are no pets");
                    } else {
                        for (int i = 0; i < pets.size(); i++) {
                            System.out.println((i + 1) + ". " + pets.get(i));
                        }
                    }
                    break;

                case 3:
                    List<Pet> currentPets = petShelter.getAllPets();
                    if (currentPets.isEmpty()) {
                        System.out.println("There are no pets available for adoption.");
                        break;
                    }
                    System.out.println("Select the number of the pet to adopt:");
                    for (int i = 0; i < currentPets.size(); i++) {
                        System.out.println((i + 1) + ". " + currentPets.get(i));
                    }
                    System.out.print("Enter the number: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next();
                        continue;
                    }

                    int petIndex = sc.nextInt() - 1;
                    sc.nextLine();

                    if (petIndex >= 0 && petIndex < currentPets.size()) {
                        petShelter.removePet(petIndex);
                        System.out.println("The pet has been taken from the shelter!");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
            }
        }

        sc.close();
    }
}

