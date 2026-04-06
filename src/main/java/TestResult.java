import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.testng.annotations.Test;
import org.testng.test.sample.AnotherClass;
import org.testng.test.sample.SampleTestNewGeneration;

public class TestResult {

	@Test
	private void test1() {
		Result res = JUnitCore.runClasses(AnotherClass.class,SampleTestNewGeneration.class);
		System.out.println(res.getRunCount());
		System.out.println(res.getRunTime());
		System.out.println(res.getIgnoreCount());
		System.out.println(res.getIgnoreCount());

	}
}
