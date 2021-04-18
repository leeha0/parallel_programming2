package chapter13;

import javax.swing.JOptionPane;

public class ThreadEx14 {

    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // interrupt() 호출하면, interrupted 상태가 true가 된다.
        System.out.println("isInterrupted(): " + th1.isInterrupted()); // true or false
    }
}
