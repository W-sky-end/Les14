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
            Menu.printMenu();

            if (!scanner.hasNextInt()) {
                System.out.println(Message.INVALID_INPUT.getText());
                scanner.next();
                continue;
            }

            int userInput = scanner.nextInt();
            scanner.nextLine();

            Menu option = Menu.fromInt(userInput);

            if (option == null) {
                System.out.println(Message.INVALID_INPUT.getText());
                continue;
            }

            switch (option) {
                case ADD_PET:
                    addPet();
                    break;
                case SHOW_ALL:
                    showAllPets();
                    break;
                case REMOVE_PET:
                    removePet();
                    break;
                case EXIT:
                    running = false;
                    System.out.println(Message.EXITING.getText());
                    break;
            }
        }
    }

    private void addPet() {
        System.out.print(Message.ENTER_PET_NAME.getText());
        String name = scanner.nextLine();
        System.out.print(Message.ENTER_BREED.getText());
        String breed = scanner.nextLine();
        System.out.print(Message.ENTER_AGE.getText());

        if (!scanner.hasNextInt()) {
            System.out.println(Message.AGE_MUST_BE_NUMBER.getText());
            scanner.next();
            return;
        }

        int age = scanner.nextInt();
        scanner.nextLine();

        petService.addPet(name, age, breed);
        System.out.println(Message.PET_ADDED.getText());
    }

    private void removePet() {
        List<Pet> pets = petService.getAllPets();
        if (pets.isEmpty()) {
            System.out.println(Message.NO_PETS.getText());
            return;
        }

        showAllPets();
        System.out.print(Message.ENTER_PET_NUMBER.getText());

        if (!scanner.hasNextInt()) {
            System.out.println(Message.INVALID_INPUT.getText());
            scanner.next();
            return;
        }

        int petIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (petService.removePet(petIndex)) {
            System.out.println(Message.PET_ADOPTED.getText());
        } else {
            System.out.println(Message.INVALID_SELECTION.getText());
        }
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
}

