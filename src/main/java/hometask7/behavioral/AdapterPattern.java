package hometask7.behavioral;

interface Dog {
    void run();
    void soundOfDog();
}

class Labrador implements Dog {
    @Override
    public void run() {
        System.out.println("Labrador starts running.");
    }

    @Override
    public void soundOfDog() {
        System.out.println("Barking.");
    }
}

interface Bird {
    void soundOfBird();
}

class RubberBird implements Bird {
    @Override
    public void soundOfBird() {
        System.out.println("Squeaking.");
    }
}

class DogAdapter implements Bird {
    Dog dog;

    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    @Override
    public void soundOfBird() {
        dog.soundOfDog();
    }
}

public class AdapterPattern{
    public static void main(String[] args){
        Labrador labrador = new Labrador();
        Bird bird = new RubberBird();
        Bird dogAdapter = new DogAdapter(labrador);

        System.out.println("*** Labrador ***");
        labrador.run();
        labrador.soundOfDog();

        System.out.println("*** RubberBird ***");
        bird.soundOfBird();

        System.out.println("*** Dog Adapter ***");
        dogAdapter.soundOfBird();
    }
}
