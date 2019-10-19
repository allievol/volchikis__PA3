import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI {

    //Method used to complete the questions of users choice
    private static String expressions(int expressionNum) {
        Random randExpression = new Random();
        String expressionWord = "";

        //Complete the expression
        if (expressionNum == 1) {
            expressionWord = " plus ";
        }
        else if (expressionNum == 2) {
            expressionWord = " times ";
        }
        else if (expressionNum == 3) {
            expressionWord = " minus ";
        }
        else if (expressionNum == 4) {
            expressionWord = " divided by ";
        }
        //Randomize the expression
        else if (expressionNum ==5){
            switch (randExpression.nextInt(4)+1) {
                case 1:
                    expressionWord = " plus ";
                    break;
                case 2:
                    expressionWord = " times ";
                    break;
                case 3:
                    expressionWord = " minus ";
                    break;
                case 4:
                    expressionWord = " divided by ";
                    break;
            }
        }
        //Return words to complete the sentence in nextQuestion method
        return expressionWord;
    }

    //Method to give user new questions
    private static double nextQuestion(int arithmeticProblem, int userDifficulty) {
        SecureRandom random = new SecureRandom();

        //Initialize variables
        String one   = "plus";
        String two   = "times";
        String three = "minus";
        String four  = "divided by";
        int   num1 = 0;
        int   num2 = 0;
        float num3 = 0;

        //Use a switch statement to pick difficulty
        switch(userDifficulty) {
            case 1:
                num1 = random.nextInt(10);
                num2 = random.nextInt(10);
                System.out.print("How much is " + num1 + expressions(arithmeticProblem) + num2 + "?");
                break;
            case 2:
                num1 = random.nextInt(100) ;
                num2 = random.nextInt(100) ;
                System.out.print("How much is " + num1 + expressions(arithmeticProblem) + num2 + "?");
                break;
            case 3:
                num1 = random.nextInt(1000) ;
                num2 = random.nextInt(1000) ;
                System.out.print("How much is " + num1 + expressions(arithmeticProblem) + num2 + "?");
                break;
            case 4:
                num1 = random.nextInt(10000) ;
                num2 = random.nextInt(10000) ;
                System.out.print("How much is " + num1 + expressions(arithmeticProblem) + num2 + "?");
                break;
        }

        //If statements
        if(arithmeticProblem == 1)
            num3 = (num1 + num2);

        if(arithmeticProblem == 2)
            num3  = (num1 * num2);

        if(arithmeticProblem ==3)
            num3  = (num1 - num2);

        if(arithmeticProblem == 4)
            num3  = ((float)num1/num2);

        if(arithmeticProblem == 5) {

            //Use if statements to compare strings
            if(one.equals(expressions(5)))
                num3 =(num1+num2);

            if(two.equals(expressions(5)))
                num3 =(num1*num2);

            if(three.equals(expressions(5)))
                num3=(num1-num2);

            if(four.equals(expressions(5)))
                num3 =((float)num1 /num2);
        }


        return num3;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //initialize to keep user in the game
        char userChar = 'y';

        //while loop to start the game
        while (userChar == 'y') {

            //Restart points every time loop restarts
            int incorrectPoints = 0;
            int correctPoints   = 0;

            //Start Game
            System.out.println("You'll be given 10 questions, try to answer as best as you can!");

            //Ask to pick arithmetic problem
            System.out.println("Pick the type of arithmetic problem you'd like to be tested on (1-5)\n 1: addition\n 2: multiplication\n 3: subtraction\n 4: division\n 5: random mixture");
            int typeProblem = scnr.nextInt();

            //Ask to pick difficulty of the arithmetic problem
            System.out.println("Pick a level of difficulty (1-4)\n 1: single digits\n 2: double digits\n 3: triple digits\n 4: quadruple digits");
            int levelDiff = scnr.nextInt();

            //Use for loop to prompt and have user answer 10 questions
            for (int i = 0; i < 10; ++i) {
                float correctAnswer = (float) nextQuestion(typeProblem, levelDiff);
                float answer = scnr.nextFloat();

                //Add points
                if (answer == correctAnswer)
                    correctPoints++;

                else {
                    incorrectPoints++;
                }
            }

            //calculate the amount of correct answers
            double percentageCorrect = (correctPoints / 10.0) * 100;

            //display output
            if (percentageCorrect < 75.0) {
                System.out.println("Please ask your teacher for extra help\n");
                System.out.println("You got " + correctPoints + " right");
                System.out.println("You got " + incorrectPoints + " wrong");
                System.out.println("= " + percentageCorrect + "%");
            }
            else {
                System.out.print("Congratulations, you are ready to go to the next level!\n");
                System.out.println("You got " + correctPoints + " right");
                System.out.println("And " + incorrectPoints + " wrong");
                System.out.println("= " + percentageCorrect + "%\n");
            }

            //Ask user if they would like to continue by pressing "y"
            System.out.println("Type y to continue, any other letter to quit: ");
            userChar = scnr.next().charAt(0);
        }
    }
}






