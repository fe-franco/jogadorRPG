import java.util.InputMismatchException;
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
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                Jogador player1 = controller.getJ2();
                Jogador player2 = controller.getJ3();
               

                System.out.print("Qual jogador você quer atacar?");
                int id = input.nextInt();
         
                if (id == 1) {
                    controller.atacar(player1);
                    break;
                } else if (id == 2) {
                    controller.atacar(player2);
                    break;
                } else {
                    System.out.println("Opção inválida. Digite 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                input.next(); // consume invalid input
            }
        }
    }
    protected void render() {
        Jogador player1 = controller.getJ2();
        Jogador player2 = controller.getJ3();
        System.out.println("Jogadores:");
        System.out.println("1: "+player1.nome+" - hp: " + player1.getHp()+ " - xp: " +player1.getXp() + (player1.isEnvenenado()? " - envenenado" : ""));
        System.out.println("2: "+player2.nome+" - hp: " + player2.getHp()+ " - xp: " +player2.getXp() + (player1.isEnvenenado()? " - envenenado" : ""));
       
        System.out.println("Seu personagem é o " + controller.selected.nome);
        System.out.println("Vida: " + controller.selected.getHp());
        System.out.println("XP:" + controller.selected.getXp());
        System.out.println("Envenenado: " + controller.selected.isEnvenenado());
        

    }

    protected abstract void processGameLoop();
}
