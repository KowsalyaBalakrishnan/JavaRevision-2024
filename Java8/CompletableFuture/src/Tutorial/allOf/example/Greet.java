package Tutorial.allOf.example;

public class Greet {

    private String greet;

    public Greet(String greet) {
        this.greet = greet;
    }

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }

    @Override
    public String toString() {
        return "Greet{" +
                "greet='" + greet + '\'' +
                '}';
    }
}
