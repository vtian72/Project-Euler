package Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Java Class used to solve the Project Euler Questions
 * @author vince
 * 16/06/2018
 */
public class Problem {
	/**
	 * Problem 1
	 * Given a 'number', this method will calculate the sum of all numbers that are multiples of 3 or 5 and
	 * less than the 'number'.
	 * @param number Given number
	 * @return sum
	 */
	public int sumMultiples(int number) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 3; i < number; i++) {
			if (i % 3 == 0) {
				numbers.add(i);
				System.out.println(i + " is a multiple of 3");
			}
			if (i % 5 == 0) {
				numbers.add(i);
				System.out.println(i + " is a multiple of 5");
			}
		}
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}
	
	/**
	 * Problem 2
	 * Given a 'number', method will find the sum of all the even Fibonacci numbers before that 'number'
	 * @param number Given number
	 * @return sum
	 */
	
	public int sumFib(int number){
		int f1 = 1;
		int f2 = 2;
		int f3 = f1 + f2;
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(f1);
		numbers.add(f2);
		numbers.add(f3);
		while(f2 + f3 < number){
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
			numbers.add(f3);
		}
		int sum = 0;
		for(int num: numbers){
			if(num%2 == 0){
				sum += num;
			}
		}
		return sum;
	}
	
	/**
	 * Problem 3
	 * Method to find the highest prime factor for a specific number
	 * @param number Given number
	 * @return highest prime factor of the 'number'
	 */
	public BigInteger maxPrime(BigInteger number){
		ArrayList<BigInteger> factors = new ArrayList<>();
		for(BigInteger i = new BigInteger("2"); i.compareTo(number) == -1; i = i.add(new BigInteger("1"))){
			while(number.mod(i).equals(new BigInteger("0"))){
				factors.add(i);
				number = number.divide(i);
			}
		}
		if(number.compareTo(new BigInteger("1")) == 1){
			factors.add(number);
		}
		
		BigInteger max = new BigInteger("0");
		for(int j = 0; j < factors.size(); j++){
			if(max.compareTo(factors.get(j)) == -1){
				max = factors.get(j);
			}
		}
		return max;
	}
	
	/**
	 * Problem 4
	 * Method to find the greatest palindrome that is the product of 2, 3 digit numbers
	 * @return palindrome number
	 */
	
	public int palindromeProduct(){
		int palMax = 0;
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				int num = i * j;
				StringBuilder sb = new StringBuilder("" + num); 
				String numString = "" + num;
				sb.reverse();
				if(numString.equals(sb.toString()) && palMax < num){
					palMax = num;
				}
			}
		}
		return palMax;
	}
	
	/**
	 * Method to return the LCM between 2 numbers
	 * @param a first int
	 * @param b second int
	 * @return a and b LCM
	 */
	
	public int lcm(int a, int b){
		int greater = 0;
		int lcm;
		if(a > b){
			greater = a;
		}
		else{
			greater = b;
		}
		while(true){
			if(greater % a == 0 && greater % b == 0){
				lcm = greater;
				break;
			}
			greater = greater + 1;
		}
		return lcm;
	}
	
	/**
	 * Problem 5
	 * Given an array of numbers, method will return the least common multiple
	 * @param numbers array
	 * @return lcm of the numbers in the array
	 */
	
	public int lcmArray(int[] numbers){
		int lcm = 1;
		int divisor = 2;
		while(true){
			int counter = 0;
			boolean divisible = false;
			for(int i = 0; i < numbers.length; i++){
				if(numbers[i] == 0){
					return 0;
				}
				else if(numbers[i] < 0){
					numbers[i] = numbers[i] * -1;
				}
				if(numbers[i] == 1){
					counter++;
				}
				if(numbers[i] % divisor == 0){
					divisible = true;
					numbers[i] = numbers[i] / divisor;
				}
			}
			if(divisible){
				lcm = lcm * divisor;
			}
			else{
				divisor++;
			}
			if(counter == numbers.length){
				return lcm;
			}
		}
	}
	
	/**
	 * Problem 6
	 * Method that returns the difference between the square of the sum of numbers and the sum of the squares of numbers
	 * @param n number n to go up to
	 * @return the difference
	 */
	public BigInteger sumSquareDifference(BigInteger n){
		BigInteger one = new BigInteger("1"); //stores number 1
		BigInteger newN = n.add(one); //new n value as the .compareTo method cuts one value off
		BigInteger squaredSum = new BigInteger("0"); //Sum of the squared numbers
		BigInteger sumSquared = new BigInteger("0"); //Square of the sum of the numbers
		BigInteger difference = new BigInteger("0"); //Difference between sumSquared and squaredSum
		 
		for(BigInteger i = new BigInteger("1"); i.compareTo(newN) == -1; i = i.add(new BigInteger("1"))){
			squaredSum = i.pow(2).add(squaredSum);
		}
		for(BigInteger i = new BigInteger("1"); i.compareTo(newN) == -1; i = i.add(new BigInteger("1"))){
			sumSquared = sumSquared.add(i);
		}
		sumSquared = sumSquared.pow(2);
		difference = sumSquared.subtract(squaredSum);
		System.out.println("The squared sum is " + squaredSum);
		System.out.println("The sum squared is " + sumSquared);
		return difference;
	}
	
	/**
	 * Problem 7
	 * Initialises an arraylist of prime numbers
	 */
	
	ArrayList<Integer> primes = new ArrayList<>();
	
	/**
	 * code to find the nth prime number
	 * @param number specified n
	 * @return the nth prime number
	 */
	
	public int primeNumber(int number){
		int count = 0;
		for(int i = 2; count < number; i++){
			if(isPrime(i)){
				primes.add(i);
				count++;
			}
		}
		int index = primes.size() - 1;
		int maxPrime = primes.get(index);
		return maxPrime;
	}
	
	/**
	 * Problem 7
	 * checks if a number is prime
	 * @param n number to be checked
	 * @return true if n is prime, false if n is not prime
	 */
	
	public boolean isPrime(int n){
		for(int num: primes){
			if (n % num == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Problem 8
	 * Given a file, return the largest product of consecutive ints that can be formed
	 * @param filename file to execute code
	 * @param number of consecutive ints
	 * @return largest product formed
	 * @throws FileNotFoundException
	 */
	
	public int largestProduct(String filename, int number) throws FileNotFoundException{
		int ans = 0;
		StringBuilder sum = new StringBuilder("");
		Scanner inFile = new Scanner(new File(filename));
		while(inFile.hasNext()){
			StringBuilder value1 = new StringBuilder("" + inFile.nextBigInteger());
			StringBuilder value2 = new StringBuilder("" + inFile.nextBigInteger());
			sum = sum.append(value1).append(value2);
		}	
	    int length = sum.length();
	    //String ints = "";
	    for(int i = 0; i <= length - number; i++){//starting position of each product
	    	int temp = 1;
	    	for(int j = i; j < i+number; j++){ //j is used to find product of the number of ints
	    		temp = Integer.parseInt(sum.substring(j, j+1)) * temp;
	    	}
	    	if(temp > ans){
	    		ans = temp;
	    		//ints = sum.substring(i, i + number); prints out the consecutive digits
	    	}
	    }
		inFile.close();
		return ans;
	}
	
	/**
	 * Problem 9
	 * Given a number, find a pythagorean triple: a,b,c such that a + b + c = number
	 * could be improved
	 * @param number
	 * @return a*b*c
	 */
	public int pythagTriple(int number){
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i = 1; i < 1000; i++){
			for(int j = 1; j < 1000; j++){
				for(int k = 1; k < 1000; k++){
					if((Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) && (i + j + k == number)){
						a = i;
						b = j;
						c = k;
					}
				}
			}
		}
		return a*b*c;
	}
	
	/**
	 * ArrayList to store prime numbers, used below **bad coding**
	 */
	
	ArrayList<Integer> prime = new ArrayList<>();
	
	/**
	 * Method to find the sum of all prime numbers less than a given 'number'
	 * @param number given number
	 * @return sum of all primes below the 'number'
	 */
	
	public int sumPrime(int number){
		int sum = 0;
		for(int i = 2; i < number; i++){
			if(isPrime2(i)){
				prime.add(i);
			}
		}
		for(int num: prime){
			sum = sum + num;
		}
		return sum;
	}
	
	/**
	 * Method to check if a number is a prime
	 * @param n number to be checked
	 * @return true if prime, else false
	 */
	
	public boolean isPrime2(int n){
		for(int num: prime){
			if (n % num == 0){
				return false;
			}
		}
		return true;
	}
}
