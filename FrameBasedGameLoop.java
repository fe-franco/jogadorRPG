public class FrameBasedGameLoop extends GameLoop {
  public static void main(String[] args) {
    FrameBasedGameLoop gameLoop = new FrameBasedGameLoop();
    gameLoop.run();
  }

  @Override
  protected void processGameLoop() {
    System.out.println("Bem vindo ao RPG");

    while (isGameRunning()) {
      System.out.println("\n\n");

      render();
      processInput();
    }
  }

}