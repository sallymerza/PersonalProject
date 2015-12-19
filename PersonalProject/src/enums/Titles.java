package enums;

/**
 * @author Sally Al
 **/
public enum Titles {
                    Main("Welcome to ..");
    private String myValue;

    Titles (String value) {
        myValue = value;
    }

    public String getValue() {
        return myValue;
    }

}
