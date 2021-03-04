package workshop02.com.Test3;

public class StudentTest {
	public static void main(String[] args) {
		Student[] studentArray = new Student[3];
		studentArray[0] = new Student("홍길동",15,170,80);
		studentArray[1] = new Student("한사람",13,180,70);
		studentArray[2] = new Student("임걱정",16,175,65);
		
		double ageAvg=0.0, heightAvg=0.0, weightAvg=0.0;
		int minAge=0,minHeight=0,minWeight=0;
		int maxAge=0,maxHeight=0,maxWeight=0;
		
		System.out.println("이름\t나이\t신장\t몸무게");
		for(int i=0;i<studentArray.length;i++) {
			System.out.println(studentArray[i].studentInfo());
			ageAvg+=studentArray[i].getAge();
			heightAvg+=studentArray[i].getHeight();
			weightAvg+=studentArray[i].getWeight();
			
			if(studentArray[i].getAge() < studentArray[minAge].getAge()) minAge=i;
			if(studentArray[i].getHeight() < studentArray[minHeight].getHeight()) minHeight=i;
			if(studentArray[i].getWeight() < studentArray[minWeight].getWeight()) minWeight=i;
			if(studentArray[i].getAge() > studentArray[maxAge].getAge()) maxAge=i;
			if(studentArray[i].getHeight() > studentArray[maxHeight].getHeight()) maxHeight=i;
			if(studentArray[i].getWeight() > studentArray[maxWeight].getWeight()) maxWeight=i;
			
		}		
		System.out.printf("나이 평균 : %.3f\n",ageAvg/studentArray.length);
		System.out.printf("나이 평균 : %.3f\n",heightAvg/studentArray.length);
		System.out.printf("나이 평균 : %.3f\n",weightAvg/studentArray.length);
		System.out.println();
		
		System.out.println("나이가 가장 많은 학생 : "+studentArray[maxAge].getName());
		System.out.println("나이가 가장 적은 학생 : "+studentArray[minAge].getName());
		
		System.out.println("신장이 가장 큰 학생 : "+studentArray[maxHeight].getName());
		System.out.println("신장이 가장 작은 학생 : "+studentArray[minHeight].getName());
		
		System.out.println("몸무게가 가장 많이 나가는 학생 : "+studentArray[maxWeight].getName());
		System.out.println("몸무게가 가장 적은 학생 : "+studentArray[minWeight].getName());
	}
}
