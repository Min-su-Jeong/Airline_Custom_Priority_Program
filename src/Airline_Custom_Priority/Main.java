package Airline_Custom_Priority;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
	private Scanner sc = new Scanner(System.in); // 스캐너 객체
	private Save save = new Save(); // 파일 저장 객체
	private Func func = new Func(); // 기능 객체
	private LoadFile loadfile = new LoadFile(); // 파일불러오기 객체
	private Priority_Sort sort = new Priority_Sort(); // 우선순위정렬 객체
	private Event event = new Event(); // 경품 추첨 객체
	private int num = 0;
	private boolean run = true;
	
	public void startMenu() throws ParseException {
		System.out.println("=======================================================================================================================");
		System.out.println("                                        ----------------------------------------                                       ");
		System.out.println("                                        Airline Customer Waiting List Management                                       ");
		System.out.println("                                        ----------------------------------------                                     \n");
		System.out.println("             위 프로그램은 이미 예약이 완료된 비행기에 대해 고객들의 후보 순위를 결정하기 위함에 있습니다.                                  \n");
		System.out.println("- Program Description -"                                                                                                );
		System.out.println("프로그램 시작 시 원본 파일은 자동 백업됩니다."                                                                                     );
		System.out.println("초기 에러 발생 시, 불러올 파일명을 'waiting_list.txt'로 저장하여 실행파일(.exe)과 동일한 경로에 저장해주시기 바랍니다."                        );
		System.out.println("'3.추가, 4.삭제, 5.갱신' 메뉴 사용할 시 변경된 데이터는 자동 저장됩니다."                                                              );
		System.out.println("우선 순위는 접수한 순번, 과거 이용한 총 마일리지 점수, 프로그램 이용기간에 의해 산출됩니다.                                                  ");
		System.out.println("우선 순위가 담긴 파일 저장을 원하시면 '6.우선순위정렬' 또는 '7.우선순위정렬(Custom)'을 선택하여 저장을 완료하실 수 있습니다."                      );
		System.out.println("                                                                                                     - Made by. MSJ -  " );
		System.out.println("=======================================================================================================================\n");
		save.Backup(loadfile.Load());
		
		while(run) {
			System.out.println("1.파일불러오기 | 2.검색 | 3.추가 | 4.삭제 | 5.갱신 | 6.우선순위정렬 | 7.우선순위정렬(Custom) | 8.경품 추첨 |  9.종료");
			System.out.print("번호를 선택해주세요 : ");
			num = sc.nextInt();
			System.out.println();
			switch(num) {
			case 1:
				loadfile.Print();
				break;
			case 2:
				func.Search();
				break;
			case 3:
				func.Add();
				break;
			case 4:
				func.Delete();
				break;
			case 5:
				func.Renew();
				break;
			case 6:
				sort.Print(loadfile.Load());
				break;
			case 7:
				sort.Sort_Custom(loadfile.Load());
				break;
			case 8:
				event.Event();
				break;
			case 9:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("번호를 다시 입력해주세요.");
				break;
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		Main main = new Main();
		main.startMenu();
	}
}