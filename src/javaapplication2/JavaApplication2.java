/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class JavaApplication2 {
    // giá trị lớn nhất của số may mắn
    public static final int MAXIMUM = 100;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner console = new Scanner(System.in);
        // Khai báo biến cho kết quả in
        int totalGames =0;
        int totalGuesses =0;
        int bestGame = 0;
        boolean willContinue = true;
        // gọi hàm play()
        while(willContinue){
            totalGames++;
            int thisGuess = play(console);
            totalGuesses += thisGuess;
            // tìm kiếm lần chơi nhanh nhất
            if(bestGame < 1 ||bestGame > thisGuess){
                bestGame = thisGuess;
            }
            // tiếp tục trò chơi nếu câu trả lời y, Y, yes, YES.
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            String game = console.next();
            if(!(game.equalsIgnoreCase("yes") || game.equalsIgnoreCase("Y"))){
                willContinue = false;
            }
        }
        // gọi hàm report() in kết quả
        report(totalGames, totalGuesses, bestGame);
    }
    public static int play(Scanner console){
        int guesses = 1;
        // random 1 số tự nhiên từ 0 - 100
        double randomMath = Math.random();
        randomMath = randomMath * MAXIMUM+1;
        int randomNum = (int)randomMath;
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100...");
        // đoán lucky number
        System.out.print("Bạn đoán? ");
        int pickNum = console.nextInt();
        // so sánh số dự đoán và lucky number
        do{ 
            if(pickNum>randomNum){
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            }else if(pickNum<randomNum){
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
            }
            System.out.print("Bạn đoán? ");
            int luckyNum = console.nextInt();
            pickNum = luckyNum;
            guesses++;
        }while( pickNum != randomNum); 
        // trả kết quả số lần đoán được số lucky number
        System.out.println("Chúc mừng bạn đã đoán số đúng số may măn sau "+guesses+" lần dự đoán!");
        return guesses;    
    }
    public static void report(int totalGames, int totalGuesses, int bestGame){
        // Kết quả tổng quát trò chơi
        System.out.println("*******************************");
        System.out.println("Kết quả tổng quát trò chơi: ");
        System.out.println("Tổng số lần chơi: "+totalGames);
        System.out.println("Số lần chơi dự đoán: "+totalGuesses);
        // chuyển kiểu dữ liệu, lấy giá trị thập phân
        double averageGuesses = (double) totalGuesses/totalGames;
        System.out.println("Số lần dự đoán trung bình mỗi lượt: " + averageGuesses);
        System.out.println("Số lần dự đoán ít nhất: " + bestGame);
    }       
}
    
