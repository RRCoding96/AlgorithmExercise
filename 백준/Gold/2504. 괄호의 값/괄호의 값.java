import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        int answer = 0;
        int count = 1;

        for(int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if(now == '(') {
                deque.addLast(now);
                count *= 2;
            } else if(now == '[') {
                deque.addLast(now);
                count *= 3;
            } else {
                if(now == ')') {
                    if(deque.isEmpty() || deque.peekLast() != '(') {
                        answer = 0;;
                        break;
                    }
                    if(input.charAt(i - 1) == '(') {
                        answer += count;
                    }
                    deque.pollLast();
                    count /= 2;
                } else if(now == ']') {
                    if(deque.isEmpty() || deque.peekLast() != '[') {
                        answer = 0;;
                        break;
                    }
                    if(input.charAt(i - 1) == '[') {
                        answer += count;
                    }
                    deque.pollLast();
                    count /= 3;
                } else {
                    answer = 0;
                    break;
                }
            }
        }

        if(!deque.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

}
