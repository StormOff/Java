package stream;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class A {

	public static final long LIMIT = 100_000_000L;

	static List<String> listStr = Arrays.asList("Green", "Blue", "White",
			"Red", "Black", "Yellow", "Grey");

	public static void main(String[] args) {

		// System.out.println(listStr.stream()
		// .sorted(comparingInt((String s)->s.length())
		// .thenComparing(reverseOrder()) )
		// .collect(toList())
		// );

		// System.out.println(listStr.parallelStream()
		// .peek(s->sleepUninterrupted(500L))
		// .collect(toList())
		// );
		//
		List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
		List<Integer> list2 = IntStream.range(0, 20).boxed()
				.peek(i -> list1.add(i)).collect(toList());

		System.out.println(list1);
		System.out.println(list2);

//		long sum = 0L;
//		for (long i = 1; i <= LIMIT; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		//Заменим суммирование выше используя java8
		
		//использовать один элемент массива чтобы можно было передать в лямбда выражение плохая идея, 
		//при паралелизме будет ерунда из за того что переменная в хипе
		
//		AtomicLong sum=new AtomicLong(0L);
//		LongStream.rangeClosed(1, LIMIT).parallel().forEach(i->sum.getAndAdd(i));
//		System.out.println(sum.get());
//ЛУЧШЕ и быстрее
	
//		System.out.println(LongStream.rangeClosed(1, LIMIT).parallel().reduce(0,(i,j)->i+j));
//ИЛИ ЛУЧШЕ
		System.out.println(LongStream.rangeClosed(1, LIMIT).parallel().sum());

	}

	private static void sleepUninterrupted(long milles) {
		try {
			Thread.sleep(milles);
		} catch (InterruptedException e) {

		}

	}

}
