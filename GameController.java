//import java.util.Random;

public class GameController {

  protected final Jogador j1;
  protected final Jogador j2;
  protected final Jogador j3;

  Jogador selected;

  public GameController() {
    j1 = new Jogador("Jorge");
    selected = j1;
    j2 = new Jogador("Carlos");
    j3 = new Jogador("Wesley");
    //int rand = new Random().nextInt(3);
    //switch (rand) {
    //  case 1:
    //    selected = j1;
    //    break;
    //  case 2:
    //    selected = j2;
    //    break;
    //  case 3:
    //    selected = j3;
    //    break;
    //
    //  default:
    //    selected = j1;
    //    break;
    //}
  }
  public Jogador getJ2() {
    return j2;
  }
  public Jogador getJ3() {
    return j3;
  }

  public void atacar(Jogador jogadorAtacado) {
    System.out.println("Você atacou o " + jogadorAtacado.nome + " ]com " + selected.getXp() + " de dano");
    jogadorAtacado.receberDano(selected.getXp());
    if (jogadorAtacado.getHp() <= 0) {
      System.out.println("Ele desviveu!");
      System.out.println(jogadorAtacado.getXp() + " xp ganho!");

      selected.ganharExperiencia(jogadorAtacado.getXp());
    }
  }

}
