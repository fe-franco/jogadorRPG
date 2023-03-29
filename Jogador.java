import java.util.Random;

public class Jogador {
  String nome;
  int xp;
  int hp;
  boolean envenenado;

  public Jogador(String name) {
    nome = name;
    xp = new Random().nextInt(50);
    hp = 100;
  }
  
  public int getXp(){
    return xp;
  }

  public int getHp(){
    return hp;
  }

  public boolean isEnvenenado(){
    return envenenado;
  }

  public void receberDano(int dano){
    hp -=dano;
  }
  
  public void receberCura(int cura){
    hp +=cura;
  }

  public void ganharExperiencia(int exp){
    xp += exp;
  }

  public void receberAntiduto(){
    envenenado = !envenenado;
  }

 
}