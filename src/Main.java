public class Main{
    public static void main(String[] args) {
        Grid grid = new Grid("A B C D E F G H I K L M N O P Q R S T V X Y Z A B C D E F G H I K L M N O P Q R S T V X Y Z A B C D E F G H I K L M N O P Q R S T V X Y Z");
        System.out.println(grid.getInput());
        grid.Encrypt();
        System.out.println(grid.getOutput());
        grid.Decrypt();
        System.out.println(grid.getOutput());
    }
}