package storage;

public class PersonComparator /* implements Comparable<Person> */{

    public int compare(Person p1, Person p2){
        return p1.getFIO().compareTo(p2.getFIO());
    }

}
