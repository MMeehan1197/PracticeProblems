package com.euler.practice.questions;

import java.util.ArrayList;

import org.apache.tomcat.jni.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class QuestionsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(QuestionsApplication.class, args);
		
		question8();
	}

	public static void question8(){
		String reallyLongNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		int beginIndex = 0;
		int endIndex = 13;
		int product;
		int lengthOfString = reallyLongNumber.length();
		String numbersInLargestProduct;
		int currentLargestProduct = 0;
		String currentString;

		while(endIndex < lengthOfString){
			currentString = reallyLongNumber.substring(beginIndex, endIndex);
			product = findProductOfNumbers(currentString);
			if(product > currentLargestProduct){
				currentLargestProduct = product;
				numbersInLargestProduct = currentString;
				System.out.println("New largest product is " + product + " with the numbers " + currentString);
			}
			endIndex++;
			beginIndex++;
		}
	}

	private static int findProductOfNumbers(String numberString){
		int product = 1;
		for(char character : numberString.toCharArray()){
			product = product * Character.getNumericValue(character);
		}
		return product;
	}

	public static void question7(int sequenceNumber){
		int counter = 0;
		int currentNumber = 1;

		while(counter < sequenceNumber){
			if(Check_Prime(currentNumber)){
				counter++;
				System.out.println(currentNumber + " is a prime number. Counter now at " + counter);
			}
			currentNumber++;
		}
		System.out.println("The " + sequenceNumber + "st prime number is " + currentNumber);
	}

	private static boolean Check_Prime(int number) {
		int i;
		for (i = 2; i <= number - 1; i++)
		{
			if (number % i == 0)
			{
			   return false;
			}
		}
		if (i == number)
		{
			return true;
		}
		return false;
	}    

	public static void question6(int firstXNumbers){
		int sumOfSquares = 0;
		int squareOfSum = 0;

		for(int i = 1; i < firstXNumbers; i++){
			sumOfSquares += (i*i);
			squareOfSum += i;
		}
		squareOfSum = squareOfSum * squareOfSum;
		System.out.println("The difference between " + squareOfSum + " and " + sumOfSquares + " is " + (squareOfSum - sumOfSquares));
	}


	public static void question5(){
		int numberBeingTested = 20;
		int divisibleNumber = 1;

		while(divisibleNumber < 21){
			if(numberBeingTested % divisibleNumber == 0){
				divisibleNumber++;
				continue;
			}
			numberBeingTested++;
			divisibleNumber = 1;
		}
		System.out.println("The number is: " + numberBeingTested);
	}

	public static void question4(){
		int number1 = 100;
		int number2 = 100;
		int currentLargestPalindrome = 0;
		int productOfNumbers = 0;

		while(number1 < 1000){
			while(number2 < 1000){
				productOfNumbers = number1 * number2;
				if(isPalindrome(productOfNumbers) && productOfNumbers > currentLargestPalindrome){
					System.out.println("The current largest palindrome is: " + currentLargestPalindrome);
					currentLargestPalindrome = productOfNumbers;
				}
				number2++;
			}
			number1++;
			number2 = 100;
		}
		System.out.println("The FINAL largest palindrome is: " + currentLargestPalindrome);
	}

	private static boolean isPalindrome(int number){
		String numberString = Integer.toString(number);
		int lengthOfNumber = numberString.length();
		int addOne = ((lengthOfNumber % 2 == 0) ? 0 : 1);
		int lengthOfSymmetry = (int) Math.floor(lengthOfNumber / 2);
		StringBuffer secondHalfReversed = new StringBuffer(numberString.substring(lengthOfSymmetry + addOne, lengthOfNumber));
		secondHalfReversed.reverse();
		String firstHalf = numberString.substring(0, lengthOfSymmetry);
		return firstHalf.equals(secondHalfReversed.toString());
	}

	public static void question3(long largePrime){
		long smallPrime = 2;
		long currentLargestPrimeFactor;
		long originalPrime = largePrime;
		while(smallPrime < Math.sqrt(originalPrime)){
			if(largePrime % smallPrime == 0){
				System.out.println(largePrime + " / " + smallPrime);
				largePrime = largePrime / smallPrime;
				currentLargestPrimeFactor = smallPrime;
				System.out.println("Current largest set to: " + currentLargestPrimeFactor + " and largePrime is now " + largePrime);
				smallPrime = 2; //reset small prime
				continue;
			}
			smallPrime++;
		}
	}

	public static void question2(){
		int answer = 0;
		int currentFibonacci = 1;
		int previousFibonacci = 1;
		while(currentFibonacci < 4000000){
			int amountToAdd = previousFibonacci;
			previousFibonacci = currentFibonacci;
			currentFibonacci += amountToAdd;

			if(currentFibonacci % 2 == 0){
				System.out.println("Added: " + currentFibonacci + " to " + answer + " for new total of " + currentFibonacci + answer);
				answer += currentFibonacci;
			}
		}
	}

	public void question1(){
		ArrayList listOfMultiples = new ArrayList<>();

			int number;
			int answer = 0;
			for(number = 0; number < 1000; number++){
				if(number % 3 == 0 || number % 5 == 0){
					System.out.println(number);
					answer += number;
				}
			}
			System.out.println(answer);
		}
}