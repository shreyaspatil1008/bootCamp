/// ***************************************************************************
/// Copyright (c) 2009, Industrial Logic, Inc., All Rights Reserved.
///
/// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
/// used by students during Industrial Logic's workshops or by individuals
/// who are being coached by Industrial Logic on a project.
///
/// This code may NOT be copied or used for any other purpose without the prior
/// written consent of Industrial Logic, Inc.
/// ****************************************************************************

package com.industriallogic.example;

import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
	private final Employee manager = new Employee(EnumSet.of(Job.MANAGE, Job.MARKET, Job.SELL));

	@Test
	public void noJobsPerformed() {
		assertEquals(0, manager.jobsCompletedCount());
		assertEquals(0, manager.jobsSkippedCount());
	}
	
	@Test
	public void threeJobsPerformedNoneSkippedByManager() {
		manager.performJob(Job.MANAGE);
		manager.performJob(Job.MARKET);
		manager.performJob(Job.SELL);
		assertEquals(3, manager.jobsCompletedCount());
		assertEquals(0, manager.jobsSkippedCount());
	}
	
	@Test
	public void oneJobDoneOneJobSkippedByManager() {
		manager.performJob(Job.TEST);
		manager.performJob(Job.SELL);
		assertEquals(1, manager.jobsCompletedCount());
		assertEquals(1, manager.jobsSkippedCount());
	}
}
