package stream;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class Bench {
	
	public final static long LIMIT = 100_000_000L;
	
	@GenerateMicroBenchmark
	public long atomicSeq() {
		AtomicLong sum = new AtomicLong(0L);
		LongStream.rangeClosed(1, LIMIT).parallel()
				.forEach(i -> sum.getAndAdd(i));
		return sum.get();
	}
	public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder()
                .include(".*" + Bench.class.getSimpleName() + ".*")
                .build();

       new Runner(opts).run();
      
    }

}
