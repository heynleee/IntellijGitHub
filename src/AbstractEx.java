abstract class Player{
    boolean pause; // 일시정지 상태를 저장하기 위한 변수
    int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

    Player () { // 생성자에서 두 변수 초기화
        pause = false;
        currentPos = 0;
    }
    /** 지정된 위치 (pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다 */
    abstract void play(int pos); // 추상 메서드
    /** 재생을 즉시 멈추는 기능을 수행하도록 작성되어야한다. */
    abstract void stop(); // 추상 메서드
    // 추상 메서드로 선언되어있어, 이 클래스를 상속받는 모든 클래스는 이 메서드들을 구현해야함

    /**
     * class Player {
     *     ...
     *     void play(int pos) {}
     *     void stop() {}
     *     ...
     * }
     -> 이렇게 추상메서드로 하는 대신 아무 내용도 없는 메서드로 작성할 수 있지만,
     상속받는 자손 클래스에서는 이 메서드들이 온전히 구현된 것으로 인식하고 오버라이딩을 통해
     자신의 클래스에 맞도록 구현하지 않을 수도 있기 때문에 abstract 사용*/

    void play() {
        play(currentPos); // 추상메서드를 사용할 수 있다.
    }
    void pause() {
        if(pause) {     // pause가 true일 때 (정지상태)에서 pause가 호출되면,
            pause = false; //pause의 상태를 false로 바꾸고,
            play(currentPos); //현재 위치에서 play를 한다.
        } else { // pause가 false일 때 (play상태)에서 pause가 호출되면,
            pause = true;
            stop(); // play를 멈춘다.
        }

    }
}

class CDplayer extends Player {
    int currentTrack; // 현재 재생중인 트랙
    void play(int currentPos) {
        System.out.println("트랙" + currentTrack + "의 위치 " + currentPos + "에서 재생 시작");
        // 실제 재생 로직 구현, 조상의 추상메서드를 구현
    }
    void stop() {
        System.out.println("재생 정지");
    }

    //CDPlayer클래스에 추가로 정의된 멤버
    CDplayer() {
        currentTrack = 1;
    }
    void nextTrack() {
        currentTrack++;
        System.out.println("다음 트랙으로 이동: " + currentTrack);
        //트랙 변경 후 재생 로직 추가 가능
    }
    void preTrack() {
        if(currentTrack > 1) {
            currentTrack--;
            System.out.println("이전 트랙으로 이동: " + currentTrack);
            // 트랙 변경 후 재생 로직 추가 가능
        }
    }
}

public class AbstractEx {
    public static void main(String[] args) {
        CDplayer cdPlayer = new CDplayer();
        cdPlayer.play(0); // "트랙 1의 위치 0에서 재생 시작" 출력
        cdPlayer.pause(); // "재생 정지" 출력
        cdPlayer.pause(); // " 트랙 1의 위치 0에서 재생 시작"
        cdPlayer.nextTrack(); // " 다음 트랙으로 이동 : 2" 출력
        cdPlayer.preTrack(); // " 이전 트랙으로 이동: 1" 출력

    }
}
