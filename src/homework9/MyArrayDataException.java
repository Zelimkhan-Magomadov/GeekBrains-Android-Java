package homework9;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super(String.format("Неверные данные в ячейке с индексом: [%d][%d]", i, j));
    }
}
