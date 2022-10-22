public class Start {
    
    /**
     * Start of the program
     * @param args
     */

    public static void main(String[] args) {
        short width = 600;
        short height = 800;

        Screen1 screen1 = new Screen1(width, height);
        GuiRoot guiRoot = new GuiRoot(width, height, screen1);

        guiRoot.setUp();
    }
}
