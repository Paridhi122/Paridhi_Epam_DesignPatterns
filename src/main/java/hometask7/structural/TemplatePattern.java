package hometask7.structural;

abstract class Game {

    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){

        initialize();
        start();
        end();
    }
}

class Ludo extends Game {
    @Override
    void initialize() {
        System.out.println("Ludo Game Initialized!");
    }
    @Override
    void start() {
        System.out.println("Game Started.");
    }
    @Override
    void end() {
        System.out.println("Game Finished!");
    }
}

class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized!");
    }

    @Override
    void start() {
        System.out.println("Game Started.");
    }

    @Override
    void end() {
        System.out.println("Game Finished!");
    }
}

class TemplatePatternDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class c = Class.forName("hometask7.structural.Cricket");
        Game game = (Game) c.newInstance();
        game.play();
    }
}
