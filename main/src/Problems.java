// 자바 프로그래밍 중간고사

import java.util.Scanner;
import java.util.InputMismatchException;

class asmd {
    int x, y;

    asmd(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int add() {
        return (x + y);
    }

    int sub() {
        return (x - y);
    }

    int mul() {
        return (x * y);
    }

    double div() {
        if (y == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return ((double)x / y);
    }
}

public class Problems {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double floorHeight = 3.5; // 한 층의 높이
        double riserHeight = 0.1;

        System.out.print("몇 층짜리 건물입니까? ");
        int floor = input.nextInt();

        System.out.println("건물의 높이는 " + (floorHeight * floor) + "m입니다."); // 건물의 높이
        System.out.println("계단의 총 개수는 " + (int)((floorHeight / riserHeight) * (floor - 1)) + "개입니다."); // 계단의 총 개수

        // input.close();
        
        System.out.print("금액을 입력하세요: ");
        int money = input.nextInt();
        int coinTypes[] = {500, 100, 50, 10, 1};

        for (int i = 0; i < coinTypes.length; i++) {
            int count = money / coinTypes[i];
            money %= coinTypes[i];
            System.out.println(coinTypes[i] + "원: " + count + "개");
        }

        // input.close();

        System.out.print("10개의 정수를 입력하세요: ");
        String word = input.nextLine();
        String nums[] = word.split(" ");
        int array[] = new int[10];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);

            if (num % 5 == 0) {
                array[index] = num;
                index++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) continue;
            System.out.print(array[i] + ", ");
        } 
     
        System.out.print(array[array.length - 1]);

        // input.close();

                String words[][] = new String[5][2];
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "번째 영단어와 뜻을 한 쌍으로 입력하세요: ");
            String wordMean = input.nextLine();
            String wordArray[] = wordMean.split(" ");
            
            words[i][0] = wordArray[0];
            words[i][1] = wordArray[1];
        }


        while (true) {
        	System.out.print("영단어를 입력하세요: ");
        	
        	String checkWord = input.next();
        	boolean found = false;
        	
        	if (checkWord.equals("x") || checkWord.equals("X")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        	
        	for (int i = 0; i < words.length; i++) {
                if (checkWord.equals(words[i][0])) {
                	System.out.println("뜻: " + words[i][1]);
                	found = true;
                	break;
                }
            }

        	if (!found) System.out.println("사전에 등록되지 않은 단어입니다.");
        }

        for (int i = 1; i < 5; i++) {  // 줄 개수
            for (int j = 0; j < 5 - i; j++) {
                    System.out.print(" ");
                }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j % 2 == 1 ? "O" : "X");
            }
            
            System.out.println(); // 줄 바꿈
        }

        try {
            System.out.print("정수 2개 입력: ");
            int x = input.nextInt();
            int y = input.nextInt();

            System.out.print("연산자 입력(+ - * /): ");
            String check = input.next();

            asmd xy = new asmd(x, y);

            double result = 0;

            if (check.equals("+")) {
                result = xy.add();
            } 
            
            else if (check.equals("-")) {
                result = xy.sub();
            } 
            
            else if (check.equals("*")) {
                result = xy.mul();
            } 
            
            else if (check.equals("/")) {
                result = xy.div();
                System.out.printf("결과: %.3f\n", result);
                return;
                
            } 
            
            else {
                System.out.println("잘못된 연산자입니다.");
                return;
            }

            System.out.println("결과: " + result);

        } 
        
        catch (InputMismatchException e) {
            System.out.println("입력 오류: 정수를 입력해야 합니다.");
        } 
        
        catch (ArithmeticException e) {
            System.out.println("수학 오류: " + e.getMessage());
        } 
        
        catch (Exception e) {
            System.out.println("알 수 없는 오류 발생");
        } 
        
        finally {
            input.close();
        }
    }
}
