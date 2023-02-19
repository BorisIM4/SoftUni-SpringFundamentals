package bg.softuni.intro2.ioc;

public class Dog implements Animal{

    @Override
    public void makeNoise() {
        System.out.println("Bark bark bark ...");
    }
}
