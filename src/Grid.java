import java.util.Random;

public class Grid {

    private int keys[] = {1,11,17,28,5,14,16,31,38,45,55,62,33,43,52,58};
    private int getKeysSize(){
        return keys.length;
    }
    public String getOutput(){
        return output;
    }
    public String getInput(){
        return inputStr;
    }
    private char[][] charMatrix = new char[8][8];
    private String inputStr = "";
    private String output = "";

    public Grid(String input){
        this.inputStr = Parse(input);
    }
    private String Parse(String input){
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (input.length() > 64) {
            input = input.substring(0, 64);
        }
        while (input.length() < 64) {
            input += generateRandomChar();
        }
        return input.toLowerCase();
    }
    private char generateRandomChar(){
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }

    private char[][] rightRotateMatrix(char[][] matrix){
        char[][] rotatedMatrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                rotatedMatrix[j][7 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public void Encrypt(){
        output = "";
        for (int rot = 0; rot < 4; ++rot){
            for (int i = 0; i < 16; ++i){
                charMatrix[(keys[i] - 1)/8][(keys[i] - 1)%8] = inputStr.charAt((rot*16) + i);
            }
            charMatrix = rightRotateMatrix(charMatrix);
        }
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                output += charMatrix[i][j];
            }
        }
    }
    public void Decrypt(){
        output = "";
        for (int rot = 0; rot < 4; ++rot){
            for (int i = 0; i< 16; ++i){
                output += charMatrix[(keys[i] - 1)/8][(keys[i] - 1)%8];
            }
            charMatrix = rightRotateMatrix(charMatrix);
        }
    }
}
