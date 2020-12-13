package Quiz5.task4;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) throws NameException {
        if (firstName.equals(firstName.substring(0, 1).toUpperCase() + firstName.substring(1))
                && !firstName.contains(" ")
                && !firstName.contains("-")) {
            this.firstName = firstName;
        } else {
            throw new NameException("Incorrect value " + firstName + " for firstName (should start from upper case and contains only alphabetic characters and -, _)");
        }
    }

    public void setLastName(String lastName) throws NameException {
        if (lastName.equals(lastName.substring(0, 1).toUpperCase() + lastName.substring(1)) && !lastName.contains(" ") && !lastName.contains("-")) {
            this.lastName = lastName;
        } else {
            throw new NameException("Incorrect value " + lastName + " for lastName (should start from upper case and contains only alphabetic characters and -, _)");
        }
    }

    public void setIdCode(String idCode) throws CodeException {
        if (idCode.matches("[a-zA-Z]+") && idCode.length() == 10) {
            throw new CodeException("Incorrect value" + idCode + "for code (should contains exactly 10 digits)");
        }
        if (idCode.length() == 10 && idCode.matches("[0-9]+")) {
            this.idCode = idCode;
        } else {
            throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
        }
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        String result = "";
        Person person = new Person();

        try {
            person.setFirstName(firstName);
        } catch (NameException nameEX) {
            result += "Incorrect value " + firstName + " for firstName (should start from upper case and contains only alphabetic characters and -, _);";
        }
        try {
            person.setLastName(lastName);
        } catch (NameException nameEX) {
            result += "Incorrect value " + lastName + " for lastName (should start from upper case and contains only alphabetic characters and -, _);";
        }
        try {
            person.setIdCode(idCode);
        } catch (CodeException codeEX) {
            result += "Incorrect value " + idCode + " for code (should contains exactly 10 digits)";
        }
        if (result.isEmpty() && !person.equals(null)) {
            return person;
        } else {
            throw new IllegalArgumentException(result);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}
