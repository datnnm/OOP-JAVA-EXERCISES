package tuan01;

public class ToaDoMain {
    public static void main(String[] args) {
        System.out.println(new ToaDo());
        ToaDo diem = new ToaDo("A", 2, 3);
        diem.setY(4.5);
        System.out.println(diem);
    }
}
