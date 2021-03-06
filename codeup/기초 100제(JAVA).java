package com.test;

public class Main {
	public static void main(String[] args) {
		
	}
}

/*
	
	// CodeUp-1099(3)
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[][] arr=new int[10][10];
			for(int i=0;i<arr.length;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<arr[i].length;j++) {
					arr[i][j]=Integer.valueOf(st.nextToken());
				}
			}
			int point=1;
			boolean end = false;
			for(int i=1;i<arr.length;i++) {
				if(!end) {
					for(int j=point;j<arr[i].length;j++) {
						if(arr[i][j]==0) {
							arr[i][j]=9;
						}
						else if(arr[i][j]==2) {
							arr[i][j]=9;
							end=true;
							break;
						} else {
							point=j-1;
							break;
						}
					}
				} 
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					bw.write(arr[i][j]+" ");
				}
				bw.newLine();
			}
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1099(2)
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[][] arr=new int[10][10];
			for(int i=0;i<arr.length;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<arr[i].length;j++) {
					arr[i][j]=Integer.valueOf(st.nextToken());
				}
			}
			int x=1,y=1;
			while(arr[x][y]!=2) {
				arr[x][y]=9;
				if(arr[x][y+1]==0||arr[x][y+1]==2) y++;
				else x++;
				if(x==8&&y==8) break;
			}
			arr[x][y]=9;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					bw.write(arr[i][j]+" ");
				}
				bw.newLine();
			}
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// CodeUp-1099
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr=new int[10][10];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int x=1,y=1;
		while(arr[x][y]!=2) {
			arr[x][y]=9;
			if(arr[x][y+1]==0||arr[x][y+1]==2) y++;
			else x++;
			if(x==8&&y==8) break;
		}
		arr[x][y]=9;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// CodeUp-1098
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[sc.nextInt()][sc.nextInt()];
		int n = sc.nextInt();	//횟수
		
		for(int i=0;i<n;i++) {
			int l=sc.nextInt();	//길이
			int d=sc.nextInt();	//방향
			int x=sc.nextInt()-1, y=sc.nextInt()-1;	//좌표
			arr[x][y]=1;
			
			for(int j=0;j<l-1;j++) {
				if(d==0) arr[x][++y]=1;
				else arr[++x][y]=1;
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// CodeUp-1097(2)
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer s;
			int[][] arr = new int[19][19];
			for(int i=0;i<arr.length;i++) {
				s = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<arr[i].length;j++) {
					arr[i][j]=Integer.valueOf(s.nextToken());
				}
			}
			int count=Integer.valueOf(br.readLine());
			for(int i=0;i<count;i++) {
				s = new StringTokenizer(br.readLine()," ");
				int x=Integer.valueOf(s.nextToken())-1, y=Integer.valueOf(s.nextToken())-1;
				for(int j=0;j<arr.length;j++) {
					if(arr[x][j]==1) arr[x][j]=0;
					else arr[x][j]=1;
					
					if(arr[j][y]==1) arr[j][y]=0;
					else arr[j][y]=1;
				}
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					bw.write(arr[i][j]+" ");
				}
				bw.newLine();
			}
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1097
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int count=sc.nextInt();
		for(int i=0;i<count;i++) {
			int x=sc.nextInt()-1, y=sc.nextInt()-1;
			for(int j=0;j<arr.length;j++) {
				if(arr[x][j]==1) arr[x][j]=0;
				else arr[x][j]=1;
				
				if(arr[j][y]==1) arr[j][y]=0;
				else arr[j][y]=1;
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// CodeUp-1096(2)
	public static void main(String[] args) {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  =  new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[][] arr=new int[19][19];
			int count = Integer.valueOf(bi.readLine());
			for(int i=0;i<count;i++) {
				String[] s = bi.readLine().split(" ");
				arr[Integer.valueOf(s[0])-1][Integer.valueOf(s[1])-1]=1;
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					bw.write(arr[i][j]+" ");
				}
				bw.write("\n");
				bw.flush();
			}	
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1096
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count= sc.nextInt();
		int[][] arr = new int[19][19];
		
		for(int i=0;i<count;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x-1][y-1]=1;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// CodeUp-1095
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count= sc.nextInt();
		int min = 24;
		
		for(int i=0;i<count;i++) {
			int temp=sc.nextInt();
			if(min>temp) min=temp;
		}
		System.out.println(min);
	}
	
	// CodeUp-1094
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int count = Integer.valueOf(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] a = new int[count];
			int i=0;
			while(st.hasMoreTokens()) {
				a[i]=Integer.valueOf(st.nextToken());
				i++;
			}
			for(int j=count-1;j>=0;j--)
				bw.write(a[j]+" ");
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1093(2)
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int count = Integer.valueOf(br.readLine());
			StringTokenizer s = new StringTokenizer(br.readLine()," ");
			
			int[] a = new int[23];
			for(int i=0;i<a.length;i++)
				a[i]=0;
			
			while(s.hasMoreTokens())
				a[Integer.valueOf(s.nextToken())-1]++;
	
			for(int i=0;i<a.length;i++)
				bw.write(a[i]+" ");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1093
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] a = new int[23];
		for(int i=0;i<a.length;i++)
			a[i]=0;
		
		for(int i=0;i<// Count;i++)
			a[sc.nextInt()-1]++;
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	//		System.out.println(Arrays.toString(a));
	}
		
	// CodeUp-1092(2)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//3 7 9
		int[] a = new int[3];
		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		
		int day=1;
		while(day%a[0]!=0||day%a[1]!=0||day%a[2]!=0) day++;
		System.out.println(day);		
	}
	
	// CodeUp-1092
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//3 7 9
		int[] a = new int[3];
		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		
		int lcm1=a[0];
		for(int i=1;i<a.length;i++)
			lcm1=lcm(lcm1, a[i]);		
		System.out.println(lcm1);
	}
	
	//최대 공약수 - 유클리드 호제법
	// 두 수 중 작은값, 두 수를 나눈 나머지를 구한다.
	// 작은값%나머지 반복하여 작은 값이 0이 될때까지 한다.
	public static int gcb(int a, int b) {
		int r;
		if(a<b) {
			int temp=a;
			a=b;
			b=temp;
		}
		while(b!=0) {
			r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	//최소 공배수
	// 두 수 a*b / 최소공배수 gcb 
	public static int lcm(int a, int b) {
		return a*b/gcb(a, b);
	}
	
	// CodeUp-1091
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		long sum = a;
		for(int i=1;i<n;i++)
			sum=sum*m+d;
		System.out.println(sum);
	}
	
	// CodeUp-1090
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int r = sc.nextInt();
		int n = sc.nextInt();
		long sum = a;
		for(int i=1;i<n;i++)
			sum*=r;
		System.out.println(sum);
	}
	
	// CodeUp-1089
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		
		for(int i=1;i<n;i++)
			a+=d;
		System.out.println(a);
	}
	
	// CodeUp-1088
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i=1;i<=a;i++) {
			if(i%3==0) continue;
			System.out.print(i+" ");
		}
	}
	
	// CodeUp-1087
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int i=1;
		long sum=0;
		
		while(true) {
			sum+=i;
			if(sum>=a) break;
			i++;
		}
		System.out.println(sum);
	}
	
	// CodeUp-1086
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		long sum=1;
		for(int i=0;i<a.length;i++)
			sum*=Integer.valueOf(a[i]);		
		System.out.printf("%.2f MB",sum/(8.0*1024*1024));
	}
	
	// CodeUp-1085
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		long sum=1;
		for(int i=0;i<a.length;i++)
			sum*=Integer.valueOf(a[i]);		
		System.out.printf("%.1f MB",sum/(8.0*1024*1024));
	}
	
	// CodeUp-1084
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			String[] b = a.split(" ");
			int count=0;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0;i<Integer.valueOf(b[0]);i++) {
				for(int j=0;j<Integer.valueOf(b[1]);j++) {
					for(int k=0;k<Integer.valueOf(b[2]);k++) {
						bw.write(i+" "+j+" "+k+"\n");
						count++;
					}
				}
			}
			bw.write(String.valueOf(count));
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// CodeUp-1083
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		for(int i=1;i<=a;i++) {
			if(i%3==0) System.out.print("X ");
			else System.out.print(i+" ");
		}
	}
	
	// CodeUp-1082
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt(16);
		for(int i=1;i<=0xf;i++) {
			System.out.printf("%X*%X=%X\n",a,i,a*i);
		}	
	}
	
	// CodeUp-1081
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		
		for(int i=1;i<=first;i++) {
			for(int j=1;j<=second;j++) {
				System.out.println(i+" "+j);
			}
		}
	}
	
	// CodeUp-1080
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int sum=0;
		for(int i=0;;i++) {
			sum+=i;
			if(sum>=input) {
				System.out.println(i);
				break;
			}
		}
	}
	
	// CodeUp-1079
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
			if(s.equals("q")) break;
		}
	}
	
	// CodeUp-1078
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int sum=0;
		for(int i=0;i<=input;i++)
			if(i%2==0) sum+=i;
		System.out.println(sum);
	}
	
	// CodeUp-1077
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for(int i=0;i<=input;i++) {
			System.out.println(i);
		}
	}
	
	// CodeUp-1076
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		char count = 96;
		do {
			System.out.print((count+=1)+" ");
		}while(c!=count);
	}
	
	// CodeUp-1075
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while(true) {
			if(i<=0) break;
			System.out.println(i-1);
			i--;
		}
	}
	
	// CodeUp-1074
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		while(true) {
			if(i==0) break;
			System.out.println(i);
			i--;
		}
	}
	
	// CodeUp-1073
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int i = sc.nextInt();
			if(i==0) break;
			System.out.println(i);
		}
	}
	
	// CodeUp-1072
	static StringTokenizer st;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=sc.nextInt();
		sc.nextLine();
		st = new StringTokenizer(sc.nextLine()," ");
		loop(count);
	}
	
	public static void loop(int count) {
		if(count==0) return;
		System.out.println(st.nextToken());
		loop(--count);
	}
	
	// CodeUp-1071
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int i=sc.nextInt();
			if(i==0) break;
				else System.out.println(i);
		}
	}
	
	// CodeUp-1070
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();		
		switch(i) {
			case 12 :
			case 1 : 
			case 2 : System.out.println("winter"); break;
			case 3 :
			case 4 :
			case 5 : System.out.println("spring"); break;
			case 6 :
			case 7 :
			case 8 : System.out.println("summer"); break;
			default : System.out.println("fall");
		}
	}
	
	// CodeUp-1069
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);		
		switch(c) {
			case 'A' : System.out.println("best!!!"); break; 
			case 'B' : System.out.println("good!!"); break;
			case 'C' : System.out.println("run!"); break;
			case 'D' : System.out.println("slowly~"); break;
			default : System.out.println("what?");
		}
	}
	
	// CodeUp-1068
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();		
		if(a>=90&&a<=100) System.out.println("A");
		else if(a>=70&&a<=89) System.out.println("B");
		else if(a>=40&&a<=69) System.out.println("C");
		else if(a>=0&&a<=39) System.out.println("D");	
	}
	
	// CodeUp-1067
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();		
		System.out.println(a<0?"minus":"plus");
		System.out.println(a%2==0?"even":"odd");
	}
	
	// CodeUp-1066
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(a%2==0?"even":"odd");
		System.out.println(b%2==0?"even":"odd");
		System.out.println(c%2==0?"even":"odd");	
	}
	
	// CodeUp-1065
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.print(a%2==0?a+"\n":"");
		System.out.print(b%2==0?b+"\n":"");
		System.out.print(c%2==0?c+"\n":"");
	}
	
	// CodeUp-1064
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(a>b?(b>c?c:b):(a>c?c:a));
	}
	
	// CodeUp-1063
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a>b?a:b);
	}
	
	// CodeUp-1062
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a^b);
	}
	
	// CodeUp-1061
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a|b);
	}
	
	// CodeUp-1060
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a&b);
	}
	
	// CodeUp-1059
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(~a);
	}
	
	// CodeUp-1058
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a==0&&b==0?1:0);
	}
	
	// CodeUp-1057
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println((a==1&&b==1)||(a==0&&b==0)?1:0);
	}
	
	// CodeUp-1056
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a!=b?1:0);
	}
	
	// CodeUp-1055
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a==1||b==1?1:0);
	}
	
	// CodeUp-1054
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a==1&&b==1?1:0);
	}
	
	// CodeUp-1053
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(a==0?1:0);
	}
	
	// CodeUp-1052
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a!=b?1:0);
	}
	
	// CodeUp-1051
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a<=b?1:0);
	}
	
	// CodeUp-1050
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a==b?1:0);
	}
	
	// CodeUp-1049
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a>b?1:0);
	}
	
	// CodeUp-1048
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a*1<<b);
	}
	
	// CodeUp-1047
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(a<<1);
	}
	
	// CodeUp-1046
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		System.out.println(a+b+c);
		System.out.printf("%.1f",(a+b+c)/3.0);
	}
	
	// CodeUp-1045
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long i = sc.nextLong();
		long j = sc.nextLong();
		
		System.out.println(i+j);
		System.out.println(i-j);
		System.out.println(i*j);
		System.out.println(i/j);
		System.out.println(i%j);
		System.out.printf("%.2f",(float)i/j);
	}
	
	// CodeUp-1044
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long i = sc.nextLong();
		System.out.print(++i);
	}
	
	// CodeUp-1043
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(sc.nextInt()%sc.nextInt());
	}
	
	// CodeUp-1042
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(sc.nextInt()/sc.nextInt());
	}
	
	// CodeUp-1041
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c =sc.next().charAt(0);
		System.out.print(++c);
	}
	
	// CodeUp-1040	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%d",-sc.nextInt());
	}	
	
	// CodeUp-1038 & 1039
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long i = sc.nextLong();
		long j = sc.nextLong();
		System.out.println(i+j);
	}
	
	// CodeUp-1037
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		char c = (char) i;
		System.out.print(c);		
	}
	
	// CodeUp-1036
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.next().charAt(0);
		System.out.print(i);		
	}
	
	// CodeUp-1035
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = Integer.valueOf(sc.next(),16);
		System.out.printf(Integer.toOctalString(i));		
	}
	
	// CodeUp-1034
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = Integer.valueOf(sc.next(),8);
		System.out.printf("%d",i);
	}
	
	// CodeUp-1033
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%X",sc.nextLong());
	}
	
	// CodeUp-1032
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%x",sc.nextLong());
	}
	
	// CodeUp-1031
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%o",sc.nextLong());
	}
	
	// CodeUp-1030
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLong());
	}
	
	// CodeUp-1029
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%.11f",sc.nextDouble());
	}
	
	// CodeUp-1028
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLong());
	}
	
	// CodeUp-1027
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split("\\.");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			iArr[i]=Integer.parseInt(sArr[i]);
		}
		System.out.printf("%02d-%02d-%04d",iArr[2],iArr[1],iArr[0]);
	}
	
	// CodeUp-1026
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split(":");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			iArr[i]=Integer.parseInt(sArr[i]);
		}
		System.out.println(iArr[1]);
	}
	
	// CodeUp-1025
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sArr = sc.next().split("");
		int[] iArr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			int temp=1;
			for(int j=1;j<sArr.length-i;j++)
				temp*=10;	
			iArr[i]=Integer.parseInt(sArr[i])*temp;
			System.out.println("["+iArr[i]+"]");
		}
	}
	
	// CodeUp-1024
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cArr = sc.next().toCharArray();
		for(int i=0;i<cArr.length;i++)
			System.out.println("'"+cArr[i]+"'");		
	}

	// CodeUp-1020
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.next().replace("-", ""));		
	}

 	// CodeUp-1019
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] days = sc.next().split("\\.");
		int[] day = new int[days.length];
		for(int i=0;i<days.length;i++)
			day[i] = Integer.valueOf(days[i]);
				
		System.out.printf("%04d.%02d.%02d",day[0],day[1],day[2]);
	}
	
	// CodeUp-1008
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("\u250c\u252c\u2510\n"
				+ "\u251c\u253c\u2524\n"
				+ "\u2514\u2534\u2518");		
	}
*/

