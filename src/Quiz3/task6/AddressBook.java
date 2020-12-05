package Quiz3.task6;

import java.util.*;

public class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean isUnique(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.firstName.equals(firstName) &&
                    addressBook[i].person.lastName.equals(lastName)) {
                return false;
            }
        }
        return true;
    }

    public boolean create(String firstName, String lastName, String address) {
        if (counter >= addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length * 2];
            for (int i = 0; i < counter; i++) {
                newAddressBook[i] = addressBook[i];
            }
            addressBook = newAddressBook;
        }

        if (isUnique(firstName, lastName)) {
            addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
            counter++;
            return true;
        }
        return false;
    }

    public String read(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.firstName.equals(firstName) &&
                    addressBook[i].person.lastName.equals(lastName)) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.firstName.equals(firstName) &&
                    addressBook[i].person.lastName.equals(lastName)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.firstName.equals(firstName) &&
                    addressBook[i].person.lastName.equals(lastName)) {
                for (int j = i; j < counter - 1; j++) {
                    addressBook[j] = addressBook[j + 1];
                }
                addressBook[counter - 1] = null;
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                int compareFirstName = o1.person.firstName.compareTo(o2.person.firstName);
                if (compareFirstName == 0) {
                    return o1.person.lastName.compareTo(o2.person.lastName);
                } else {
                    return compareFirstName;
                }
            }
        });
        if (order == SortOrder.DESC) {
            Collections.reverse(Arrays.asList(addressBook));
        }
    }

    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }
        }
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        private AddressBookIterator() {
        }

        public boolean hasNext() {
            if (counter < size()) {
                return true;
            }
            return false;
        }

        public String next() {
            NameAddressPair curr = addressBook[counter];
            counter++;
            return "First name: " + curr.person.firstName + ", Last name: " + curr.person.lastName + ", Address: " + curr.address;
        }
    }
}
