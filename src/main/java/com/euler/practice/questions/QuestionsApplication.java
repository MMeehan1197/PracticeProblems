package com.euler.practice.questions;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.apache.tomcat.jni.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class QuestionsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(QuestionsApplication.class, args);
		
		question11();
	}

	public static void question11(){
		int currentLargest = -1;
		int currentValue = -1;
		for(int y = 0; y < SQUARE.length; y++){
			for(int x = 0; x < SQUARE.length; x++){
				if(arrayInBounds(x, y)){
					currentValue = getLargestProductOfNumbersAtPoint(x, y);
					currentLargest = ((currentValue > currentLargest) ? currentValue : currentLargest);
				}
			}
		}
		System.out.println("Largest found value is " + currentLargest);
	}

	public static final int SIZE_OF_PRODUCT = 4;

	private static int getLargestProductOfNumbersAtPoint(int x, int y){
		int leftToRightHorizontal = -1;
		int leftToRightDown = -1;
		int leftToRightUp = -1;
		int straightDown = -1;

		if(arrayInBounds(x + SIZE_OF_PRODUCT, y)){
			leftToRightHorizontal = SQUARE[y][x] * SQUARE[y][x+1] * SQUARE[y][x+2] * SQUARE[y][x+3];
			System.out.println("leftToRightHorizontal: " + leftToRightHorizontal);
		}
		if(arrayInBounds(x + SIZE_OF_PRODUCT, y + SIZE_OF_PRODUCT)){
			leftToRightDown = SQUARE[y][x] * SQUARE[y+1][x+1] * SQUARE[y+2][x+2] * SQUARE[y+3][x+3];
			System.out.println("leftToRightDown: " + leftToRightDown);
		}
		if(arrayInBounds(x + SIZE_OF_PRODUCT, y - SIZE_OF_PRODUCT)){
			leftToRightUp = SQUARE[y][x] * SQUARE[y-1][x+1] * SQUARE[y-2][x+2] * SQUARE[y-3][x+3];
			System.out.println("leftToRightUp: " + leftToRightUp);
		}
		if(arrayInBounds(x, y + SIZE_OF_PRODUCT)){
			straightDown = SQUARE[y][x] * SQUARE[y+1][x] * SQUARE[y+2][x] * SQUARE[y+3][x];
			System.out.println("straightDown: " + straightDown);

		}
		int largestProductAtThisPoint = Math.max(Math.max(Math.max(leftToRightHorizontal, leftToRightDown), leftToRightUp), straightDown);
		System.out.println("The largest product at this point is " + largestProductAtThisPoint + " at point x = " + x + " and y = " + y);
		return largestProductAtThisPoint;
	}

	private static boolean arrayInBounds(int x, int y){
		return x < SQUARE.length && x > 0 && y < SQUARE.length && y > 0;
	}

	private static int[][] SQUARE = {
		{ 8, 2,22,97,38,15, 0,40, 0,75, 4, 5, 7,78,52,12,50,77,91, 8},
		{49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48, 4,56,62, 0},
		{81,49,31,73,55,79,14,29,93,71,40,67,53,88,30, 3,49,13,36,65},
		{52,70,95,23, 4,60,11,42,69,24,68,56, 1,32,56,71,37, 2,36,91},
		{22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
		{24,47,32,60,99, 3,45, 2,44,75,33,53,78,36,84,20,35,17,12,50},
		{32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
		{67,26,20,68, 2,62,12,20,95,63,94,39,63, 8,40,91,66,49,94,21},
		{24,55,58, 5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
		{21,36,23, 9,75, 0,76,44,20,45,35,14, 0,61,33,97,34,31,33,95},
		{78,17,53,28,22,75,31,67,15,94, 3,80, 4,62,16,14, 9,53,56,92},
		{16,39, 5,42,96,35,31,47,55,58,88,24, 0,17,54,24,36,29,85,57},
		{86,56, 0,48,35,71,89, 7, 5,44,44,37,44,60,21,58,51,54,17,58},
		{19,80,81,68, 5,94,47,69,28,73,92,13,86,52,17,77, 4,89,55,40},
		{ 4,52, 8,83,97,35,99,16, 7,97,57,32,16,26,26,79,33,27,98,66},
		{88,36,68,87,57,62,20,72, 3,46,33,67,46,55,12,32,63,93,53,69},
		{ 4,42,16,73,38,25,39,11,24,94,72,18, 8,46,29,32,40,62,76,36},
		{20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74, 4,36,16},
		{20,73,35,29,78,31,90, 1,74,31,49,71,48,86,81,16,23,57, 5,54},
		{ 1,70,54,71,83,51,54,69,16,92,33,48,61,43,52, 1,89,19,67,48},
	};

	public static void question10(){
		//Brute force answer
		int answer = IntStream.iterate(0, i -> i + 1).parallel().limit(2000000).filter(number -> filterFirstCouplePrimes(number)).filter(number -> Check_Prime(number)).sum();
		System.out.println("The sum of the primes below 2000000 is " + answer);
	}

	private static boolean filterFirstCouplePrimes(int number){
		for(int i = 2; i < 12; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

	public static void question9(){
		int maxValue = 1000;
		int c;
		for(int a = 1; a < maxValue; a++){
			for(int b = a + 1; b < maxValue; b++){
				c = maxValue - a - b;
				if(a * a + b * b == c * c){
					System.out.println("The value a is " + a + " b is " + b + " and c is " + c);
				}
			}
		}
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