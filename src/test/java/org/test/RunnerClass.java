package org.test;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FBLoginTest.class,AdactinLoginTest.class})

public class RunnerClass {

	public static void main(String[] args) {
		Result rs = JUnitCore.runClasses(FBLoginTest.class,AdactinLoginTest.class);

		// Ignore Count
		int ignoreCount = rs.getIgnoreCount();
		System.out.println("Ignored Test Case Count is : " + ignoreCount);

		// Failed Count
		int failureCount = rs.getFailureCount();
		System.out.println("Failure Test Case Count is : " + failureCount);

		// Over All Count
		int runCount = rs.getRunCount();
		System.out.println("Over all Test Case Count is : " + runCount);

		// Passed Test case Count
		int passedCount = rs.getRunCount() - rs.getFailureCount();
		System.out.println("Passed Test Case Count is : " + passedCount);

		// Total test case run time
		long runTime = rs.getRunTime();
		System.out.println("Total test case run time was : " + runTime);

		// Suite level execution was pass or not
		boolean wasSuccessful = rs.wasSuccessful();
		System.out.println("Was Suite level test is pass : " + wasSuccessful);

		// To get the Failure tests with expected
		List<Failure> failures = rs.getFailures();
		System.out.println("\nFailure Tests are : \n===================\n");
		for (Failure failure : failures) {
			System.out.println("--> "+failure);
		}
	}

}
