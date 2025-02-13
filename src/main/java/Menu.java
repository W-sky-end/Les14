public enum Menu {
    ADD_PET(1, "Add a pet"),
    SHOW_ALL(2, "View all pets"),
    REMOVE_PET(3, "Adopt a pet"),
    EXIT(4, "Exit");

    private final int option;
    private final String description;

    Menu(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static Menu fromInt(int userInput) {
        for (Menu menu : values()) {
            if (menu.option == userInput) {
                return menu;
            }
        }
        return null;
    }

    public static void printMenu() {
        System.out.println("\n--- Shelter Menu ---");
        for (Menu menu : values()) {
            System.out.println(menu.option + ". " + menu.description);
        }
        System.out.print("Choose an option: ");
    }
}
