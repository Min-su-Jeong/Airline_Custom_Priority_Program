package Airline_Custom_Priority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Func {
	private int HT_SIZE = 700;
	private Save save = new Save();
	private LoadFile load = new LoadFile();
	private Scanner sc = new Scanner(System.in);
	private Priority_Sort sort = new Priority_Sort();
	private ArrayList<Data> data = new ArrayList<Data>();
	private ArrayList<Priority_Data> pd_data = new ArrayList<Priority_Data>();
	private HashTable ht = new HashTable(HT_SIZE);
	
	// 검색
	public String Search() {
		String name = "";
		data = load.Load();
		pd_data = sort.Sort(data);
		
		// 해시테이블 초기화
		for(Priority_Data pd : pd_data) {
			ht.clear(pd.getName());
		}
		//해시테이블에 값 삽입
		for(Priority_Data pd : pd_data) {
			ht.put(pd.getName(), pd);
		}
		// 해시테이블을 통한 데이터 검색
		System.out.println("검색할 이름을 입력하세요 : ");
		name = sc.next();
		
		while(true) {
			if(ht.get(name) == null) {
				System.out.println("검색하신 데이터가 존재하지 않습니다.");
				System.out.print("재검색 하시겠습니까?(Y/N) : ");
				char YorN = sc.next().charAt(0);
				if(YorN == 'Y' || YorN == 'y') {
					System.out.println("검색할 이름을 입력하세요 : ");
					name = sc.next();
					continue;
				} else if(YorN == 'N' || YorN == 'n') {
					System.out.println("\n");
					break;
				} 
			}
			else {
				System.out.println("---------------------검색 결과---------------------");
				System.out.printf("%-6s%-6s%-8s%-7s%s\n", "우선순위", "접수번호", "이름", "마일리지", "가입년도");
				System.out.printf("%-10s%-10s%-7s%-11s%s\n", (int)ht.get(name).getPriority(), ht.get(name).getReg(), ht.get(name).getName(), ht.get(name).getMileage(), ht.get(name).getDate());
				System.out.println("---------------------------------------------------\n");
				break;
			}
		}
		if(ht.get(name) == null)
			return null;
		else
			return ht.get(name).getName();
	}
	// 추가
	public void Add() throws ParseException {
		int mileage;
		String name, reg_date;
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		data = load.Load();
		System.out.println("추가할 정보를 입력하세요.");
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("마일리지 : ");
		mileage = sc.nextInt();
		
		System.out.print("가입년도(YYYY-MM-DD) : ");
		reg_date = sc.next();
		
		String today = df.format(date);
		long use_date = (df.parse(today).getTime() - df.parse(reg_date).getTime()) / (24*60*60*1000);
		data.add(new Data(data.size()+1, name, mileage, reg_date, use_date));
		save.SaveD(data);
		System.out.println("-------------------------데이터 추가 완료!-------------------------\n\n");
		
	}
	// 삭제
	public void Delete() {
		int delIdx = 0;
		data = load.Load();
		String name = this.Search();
		
		if(name == null) {
			return;
		}
		// 삭제할 데이터의 인덱스 값 찾기
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getName().equals(name)) {
				delIdx = i;
			}
		}
		// 검색한 데이터 정보 삭제
		while(true) {
			System.out.print("검색하신 위의 정보를 삭제 하시겠습니까?(Y/N) : ");
			char YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				data.remove(delIdx);
				for(int i = delIdx; i<data.size(); i++) {
					data.get(i).setReg(i+1);
				}
				save.SaveD(data);
				System.out.println("-------------------------데이터 삭제 완료!-------------------------\n\n");
				break;
			} else if(YorN == 'N' || YorN == 'n') {
				System.out.println("\n");
				break;
			}
		} 
	}
	// 갱신
	public void Renew() {
		char YorN;
		int select;
		int changeIdx = 0;
		boolean flag = true;
		data = load.Load();
		String name = this.Search();
		if(name == null)
			return;
		
		// 갱신할 데이터의 인덱스 값 찾기
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getName().equals(name)) {
				changeIdx = i;
			}
		}

		while(true) {
			System.out.print("검색하신 위의 정보를 갱신 하시겠습니까?(Y/N) : ");
			YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				break;
			} else if(YorN == 'N' || YorN == 'n') {
				System.out.println("\n");
				return;
			}
		}
		// 검색한 데이터 정보 갱신
		System.out.print("갱신하실 정보를 선택하세요.\n1.이름 | 2.마일리지 | 3.가입년도(YYYY-MM-DD) : ");
		select = sc.nextInt();
		while(flag) {
			switch(select) {
			case 1:
				System.out.print("변경할 이름을 입력하세요 : ");
				String changeName = sc.next();
				data.get(changeIdx).setName(changeName);
				flag = false;
				break;
			case 2:
				System.out.print("변경할 마일리지 값을 입력하세요 : ");
				int changeMileage = sc.nextInt();
				data.get(changeIdx).setMileage(changeMileage);
				flag = false;
				break;
			case 3:
				System.out.print("변경할 가입년도를 입력하세요 : ");
				String changeDate = sc.next();
				data.get(changeIdx).setDate(changeDate);
				flag = false;
				break;
			default:
				System.out.print("숫자를 다시 입력해주세요 : ");
				select = sc.nextInt();
				break;
			}
		}
		save.SaveD(data);
		System.out.println("-------------------------데이터 갱신 완료!-------------------------\n\n");
	}
}
