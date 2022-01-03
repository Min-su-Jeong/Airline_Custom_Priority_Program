package Airline_Custom_Priority;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;

public class Priority_Sort {
	private Save save = new Save();
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Priority_Data> priority = new ArrayList<Priority_Data>();
	private ArrayList<Priority_Data> rank = new ArrayList<Priority_Data>();
	private int B_MAX = 0;
	private long C_MAX = 0;
	private char YorN;
	
	// 우선순위 계산
	public void Cal_Priority(ArrayList<Data> data) {
		priority.clear();
		for(Data d : data) {
			if(B_MAX < d.getMileage()) // 최대 마일리지 찾기
				B_MAX  = d.getMileage();
			if(C_MAX < d.getUsedate()) // 최대 이용기간 찾기
				C_MAX  = d.getUsedate();
		}
		for(Data d : data) {
			String name = d.getName();
			String date = d.getDate();
			double A = d.getReg(); // 접수순번
			double B = d.getMileage(); // 총 마일리지 점수
			double C = d.getUsedate(); // 해당 프로그램 이용 기간
			double cal_priority = A - B/B_MAX*10 - C/C_MAX*5;
			priority.add(new Priority_Data(cal_priority, (int)A, name, (int)B, date)); // 우선순위를 계산하여 Priority_Data 객체에 저장
		}
	}
	// 우선순위 정렬
	public ArrayList<Priority_Data> Sort(ArrayList<Data> data) {
		int tempNum, tempMileage;
		String tempName, tempDate;
		double temp;

		rank.clear();
		this.Cal_Priority(data);

		for(int i = 0; i < priority.size(); i ++) {
			for(int j = i + 1; j < priority.size(); j++) {
				if(priority.get(i).getPriority() > priority.get(j).getPriority()) {
					tempNum = priority.get(j).getReg();
					priority.get(j).setReg(priority.get(i).getReg()); 
					priority.get(i).setReg(tempNum);

					tempName = priority.get(j).getName();
					priority.get(j).setName(priority.get(i).getName());
					priority.get(i).setName(tempName); 

					tempMileage = priority.get(j).getMileage();
					priority.get(j).setMileage(priority.get(i).getMileage());
					priority.get(i).setMileage(tempMileage);

					tempDate = priority.get(j).getDate();
					priority.get(j).setDate(priority.get(i).getDate());
					priority.get(i).setDate(tempDate);

					temp = priority.get(j).getPriority();
					priority.get(j).setPriority(priority.get(i).getPriority());
					priority.get(i).setPriority(temp);
				}
			}
			rank.add(new Priority_Data((i+1), priority.get(i).getReg(), priority.get(i).getName(), priority.get(i).getMileage(), priority.get(i).getDate()));
		}
		return this.rank;
	}
	// 우선순위정렬(Custom)
	public void Sort_Custom(ArrayList<Data> data) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int tempNum, tempMileage;
		String tempName, tempDate;
		double temp;
		
		System.out.print("정렬 기준을 선택하세요.\n1.이름순 | 2.마일리지순 | 3.가입년도순(YYYY-MM-DD) : ");
		int select = sc.nextInt();
		this.Cal_Priority(data);

		switch(select) {
		case 1:
			for(int i = 0; i < priority.size(); i ++) {
				for(int j = i + 1; j < priority.size(); j++) {
					if(priority.get(i).getName().compareTo(priority.get(j).getName()) > 0) {
						tempNum = priority.get(j).getReg();
						priority.get(j).setReg(priority.get(i).getReg()); 
						priority.get(i).setReg(tempNum);

						tempName = priority.get(j).getName();
						priority.get(j).setName(priority.get(i).getName());
						priority.get(i).setName(tempName); 

						tempMileage = priority.get(j).getMileage();
						priority.get(j).setMileage(priority.get(i).getMileage());
						priority.get(i).setMileage(tempMileage);

						tempDate = priority.get(j).getDate();
						priority.get(j).setDate(priority.get(i).getDate());
						priority.get(i).setDate(tempDate);

						temp = priority.get(j).getPriority();
						priority.get(j).setPriority(priority.get(i).getPriority());
						priority.get(i).setPriority(temp);
					}
				}
			}
			break;
		case 2:
			for(int i = 0; i < priority.size(); i ++) {
				for(int j = i + 1; j < priority.size(); j++) {
					if(priority.get(i).getMileage() < priority.get(j).getMileage()) {
						tempNum = priority.get(j).getReg();
						priority.get(j).setReg(priority.get(i).getReg()); 
						priority.get(i).setReg(tempNum);

						tempName = priority.get(j).getName();
						priority.get(j).setName(priority.get(i).getName());
						priority.get(i).setName(tempName); 

						tempMileage = priority.get(j).getMileage();
						priority.get(j).setMileage(priority.get(i).getMileage());
						priority.get(i).setMileage(tempMileage);

						tempDate = priority.get(j).getDate();
						priority.get(j).setDate(priority.get(i).getDate());
						priority.get(i).setDate(tempDate);

						temp = priority.get(j).getPriority();
						priority.get(j).setPriority(priority.get(i).getPriority());
						priority.get(i).setPriority(temp);
					}
				}
			}
			break;
		case 3:
			for(int i = 0; i < priority.size(); i ++) {
				for(int j = i + 1; j < priority.size(); j++) {
					if(df.parse(priority.get(i).getDate()).compareTo(df.parse(priority.get(j).getDate())) > 0) {
						tempNum = priority.get(j).getReg();
						priority.get(j).setReg(priority.get(i).getReg()); 
						priority.get(i).setReg(tempNum);

						tempName = priority.get(j).getName();
						priority.get(j).setName(priority.get(i).getName());
						priority.get(i).setName(tempName); 

						tempMileage = priority.get(j).getMileage();
						priority.get(j).setMileage(priority.get(i).getMileage());
						priority.get(i).setMileage(tempMileage);

						tempDate = priority.get(j).getDate();
						priority.get(j).setDate(priority.get(i).getDate());
						priority.get(i).setDate(tempDate);

						temp = priority.get(j).getPriority();
						priority.get(j).setPriority(priority.get(i).getPriority());
						priority.get(i).setPriority(temp);
					}
				}
			}
			break;
		default:
			System.out.print("정렬 기준을 선택하세요.\n1.이름순 | 2.마일리지순 | 3.가입년도순(YYYY-MM-DD) : ");
			select = sc.nextInt();
		}
			
		if(select != 1 && select != 2 && select != 3) {
			System.out.println("잘못 입력하셨습니다. 처음부터 다시 시도해주세요.\n\n");
			return;
		}
		// 우선순위 정렬된 내용 출력
		System.out.println();
		System.out.println("--------------------우선순위정렬--------------------");
		System.out.printf("%-6s%-6s%-8s%-7s%s\n", "우선순위", "접수번호", "이름", "마일리지", "가입년도");
		int idx = 1;
		for(Priority_Data pd : priority) {
			System.out.printf("%-10s%-10s%-7s%-11s%s\n", idx++, pd.getReg(), pd.getName(), pd.getMileage(), pd.getDate());
		}
		System.out.println();
		// 파일 저장 여부 묻기
		while(true) {
			System.out.print("파일을 저장하시겠습니까?(Y/N) : ");
			YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				save.SavePD(priority);
				break;
			}
			else if(YorN == 'N' || YorN == 'n') {
				System.out.println();
				break;
			}
		}
	}
	// 우선순위 정렬 결과출력 및 저장여부 확인
	public void Print(ArrayList<Data> data)
	{
		rank = this.Sort(data);
		
		System.out.println("--------------------우선순위정렬--------------------");
		System.out.printf("%-6s%-6s%-8s%-7s%s\n", "우선순위", "접수번호", "이름", "마일리지", "가입년도");
		int idx = 1;
		for(Priority_Data pd : rank) {
			System.out.printf("%-10s%-10s%-7s%-11s%s\n", idx++, pd.getReg(), pd.getName(), pd.getMileage(), pd.getDate());
		}
		System.out.println();
		
		while(true) {
			System.out.print("파일을 저장하시겠습니까?(Y/N) : ");
			YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				save.SavePD(priority);
				break;
			}
			else if(YorN == 'N' || YorN == 'n') {
				System.out.println();
				break;
			}
		}
	}
}