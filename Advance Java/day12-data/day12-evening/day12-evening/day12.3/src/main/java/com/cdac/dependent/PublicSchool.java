package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	private PublicSchool(Teacher myTeacher,Coach coach) {
		this.subjectTeacher = myTeacher;
		this.sportsCoach=coach;
		System.out.println("In constructor - " + getClass());
	}

	@Override
	// B.L
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	@Override
	public void organizeSportsEvent() {
		System.out.println("organize sports event ....");
		System.out.println(sportsCoach.getDailyWorkout());

	}

	// custom init method
	public void myInit() {
		System.out.println("in init");
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}
	//Factory method based D.I
	public static PublicSchool myFactory(Teacher myTeacher1,Coach coach1) {
		System.out.println("in factory method");
		return new PublicSchool(myTeacher1,coach1);
		
	}

}
