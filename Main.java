package Challenge;

import java.io.FileNotFoundException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Problem p = new Problem();
		//System.out.println("Sum is " + p.sumMultiples(1000)); //Problem 1
		//System.out.println("Sum is " + p.sumFib(50)); //Problem 2
		//System.out.println(p.maxPrime(new BigInteger("20"))); //Problem 3
		//System.out.println(p.palindromeProduct()); //Problem 4
		//System.out.println(p.minMultiple()); //Problem 5
		//int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}; 
		//System.out.println(p.lcmArray(numbers));
		//System.out.println(p.sumSquareDifference(new BigInteger("20"))); //Problem 6
		//System.out.println(p.primeNumber(6)); //Problem 7
		//String filename = "C:\\Users\\vince\\workspace\\ProjectEuler\\Problem8.txt";
		//System.out.println(p.largestProduct(filename, 13));
		//System.out.println(p.pythagTriple(1000));
		System.out.println(p.sumPrime(2000000));
	}

}
