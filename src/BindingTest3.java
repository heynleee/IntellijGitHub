public class BindingTest3 {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}
class Child extends Parent {
    int x = 200;

    void method () {
        System.out.println("x=" + x); //this.x와 같다
        System.out.println("super.x=" + super.x);//Parent에 선언된 인스턴스변수 x를 뜻함
        System.out.println("this.x=" + this.x);//child 클래스의 인스턴스변수 x
    }
}
