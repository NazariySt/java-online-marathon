package Quiz3.task2;

import java.util.Iterator;

public class NameList {
    private String names[] = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;

        private Iterator() {
        }

        public boolean hasNext() {
            if (counter < names.length) {
                return true;
            }
            return false;
        }

        public String next() {
            String element = names[counter];
            counter++;
            return element;
        }
    }
}
