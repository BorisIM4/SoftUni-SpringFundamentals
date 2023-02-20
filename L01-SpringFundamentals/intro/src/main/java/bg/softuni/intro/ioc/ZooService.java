package bg.softuni.intro.ioc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {
    private List<Animal> animals;

//    private final Animal animal;
//
//    public ZooService(Animal animal) {
//        this.animal = animal;
//    }
//
//    public void doWork(){
//        animal.makeNoise();
//    }

    public ZooService(List<Animal> animals) {
        this.animals = animals;
    }

    public void doWork() {
        animals.stream().forEach(
                Animal::makeNoise
        );
    }
}
