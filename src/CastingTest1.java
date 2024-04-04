/*public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; //조상 <- 자손, car =(Car)fe;에서 형변환이 생략된 형태
        //car.water(); // 컴파일 에러 -> Car 타입의 참조변수로는 water()을 호출할 수 없다
        fe2 = (FireEngine)car; // 자손타입 <- 조상타입
        fe2.water();
    }
}
class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brr~");
    }
    void stop() {
        System.out.println("stop!!");
    }
}
class FireEngine extends Car {
    void water() {
        System.out.println("water!!");
    }
}
*/