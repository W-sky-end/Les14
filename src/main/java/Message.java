public enum Message {
    INVALID_INPUT("Invalid input, please try again."),
    ENTER_PET_NAME("Enter the pet's name: "),
    ENTER_BREED("Enter the breed: "),
    ENTER_AGE("Enter the age: "),
    AGE_MUST_BE_NUMBER("Error: Age must be a number."),
    PET_ADDED("The pet has been added to the shelter!"),
    NO_PETS("There are no pets in the shelter."),
    ENTER_PET_NUMBER("Enter the number of the pet to adopt: "),
    PET_ADOPTED("The pet has been adopted from the shelter!"),
    INVALID_SELECTION("Invalid selection."),
    EXITING("Exiting the program...");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
