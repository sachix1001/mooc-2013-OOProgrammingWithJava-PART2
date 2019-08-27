package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        
        if (name == null || name.equals("") || 40 < name.length()) {
            throw new IllegalArgumentException("enter name");
        }
        
        if (age < 0 || 120 < age) {
            throw new IllegalArgumentException("enter between 0 -120");
        }

        

        this.name = name;

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
