public class Main {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.MakeFrame();
        GameLogic frameLogic =new GameLogic();
        frameLogic.startGame();
    }
}