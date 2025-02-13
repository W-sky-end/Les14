public enum Menu {
    ADD_PET(1),
    SHOW_ALL(2),
    REMOVE_PET(3),
    EXIT(4);

    private final int value;

    Menu(int value) {
    this.value = value;}

    public int getValue() {
        return value;
    }
    public static Menu fromInt(int input) {
        for (Menu menu : values()) {
            if (menu.getValue() == input) {
                return menu;
            }
        }
        return null;

    }
}
