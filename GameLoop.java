import java.util.Scanner;

public abstract class GameLoop {

    protected volatile GameStatus status;

    protected GameController controller;

    private Thread gameThread;

    public GameLoop() {
        controller = new GameController();
        status = GameStatus.STOPPED;
    }

    public void run() {
        status = GameStatus.RUNNING;
        gameThread = new Thread(this::processGameLoop);
        gameThread.start();
    }

    public void stop() {
        status = GameStatus.STOPPED;
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    protected void processInput() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Qual jogador você quer atacar?");
            System.out.println("1:" + controller.j2.nome);
            System.out.println("hp:" + controller.j2.getHp());
            System.out.println("xp:" + controller.j2.getHp());
            System.out.println("envenenado:" + controller.j2.isEnvenenado());
            System.out.println("2:" + controller.j3.nome);
            System.out.println("hp:" + controller.j3.getHp());
            System.out.println("xp:" + controller.j3.getHp());
            System.out.println("envenenado:" + controller.j3.isEnvenenado());

            int id = input.nextInt();
            input.close();
            switch (id) {
                case 1:
                    controller.atacar(controller.j2);
                    break;
                case 2:
                    controller.atacar(controller.j3);
                    break;

                default:
                    controller.atacar(controller.j2);
                    break;
            }

        } finally {
            
        }
    }

    protected void render() {
        System.out.println("Bem vindo ao RPG");
        System.out.println("Seu personagem é o " + controller.selected.nome);
        System.out.println("Vida: " + controller.selected.getHp());
        System.out.println("XP:" + controller.selected.getXp());
        System.out.println("Envenenado: " + controller.selected.isEnvenenado());

    }

    protected abstract void processGameLoop();
}
