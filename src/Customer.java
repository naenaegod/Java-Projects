public class Customer {
    private String name;
    private int age;

    // main constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', age=" + age + "}";
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
