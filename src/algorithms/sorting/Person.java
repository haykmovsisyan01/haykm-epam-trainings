package algorithms.sorting;

public class Person implements Comparable<Person>{
    private int age;

    public Person(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age > o.age){
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}