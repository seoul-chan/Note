package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("======== 학생 정보 출력 ========");
		Student[] stu = ssm.printStudent();
		for(int i=0;i<stu.length;i++) {
			System.out.println(stu[i].inform());
		}
		
		System.out.println("\n======== 학생 성적 출력 ========");
		double[] avg = ssm.avgScore();
		
		System.out.printf("학생 점수 합계 : %.0f \n",avg[0]);
		System.out.print("학생 점수 평균 : "+avg[1]+"\n");
		
		System.out.println("\n======== 성적 결과 출력 ========");
		for(int i=0;i<stu.length;i++) {
			if(stu[i].getScore()<ssm.CUT_LINE) {
				System.out.println(stu[i].getName()+"학생은 재시험 대상입니다.");
			} else {
				System.out.println(stu[i].getName()+"학생은 통과입니다.");
			}
		}
	}
}
