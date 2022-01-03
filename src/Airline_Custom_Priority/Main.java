package Airline_Custom_Priority;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
	private Scanner sc = new Scanner(System.in); // ��ĳ�� ��ü
	private Save save = new Save(); // ���� ���� ��ü
	private Func func = new Func(); // ��� ��ü
	private LoadFile loadfile = new LoadFile(); // ���Ϻҷ����� ��ü
	private Priority_Sort sort = new Priority_Sort(); // �켱�������� ��ü
	private Event event = new Event(); // ��ǰ ��÷ ��ü
	private int num = 0;
	private boolean run = true;
	
	public void startMenu() throws ParseException {
		System.out.println("=======================================================================================================================");
		System.out.println("                                        ----------------------------------------                                       ");
		System.out.println("                                        Airline Customer Waiting List Management                                       ");
		System.out.println("                                        ----------------------------------------                                     \n");
		System.out.println("             �� ���α׷��� �̹� ������ �Ϸ�� ����⿡ ���� ������ �ĺ� ������ �����ϱ� ���Կ� �ֽ��ϴ�.                                  \n");
		System.out.println("- Program Description -"                                                                                                );
		System.out.println("���α׷� ���� �� ���� ������ �ڵ� ����˴ϴ�."                                                                                     );
		System.out.println("�ʱ� ���� �߻� ��, �ҷ��� ���ϸ��� 'waiting_list.txt'�� �����Ͽ� ��������(.exe)�� ������ ��ο� �������ֽñ� �ٶ��ϴ�."                        );
		System.out.println("'3.�߰�, 4.����, 5.����' �޴� ����� �� ����� �����ʹ� �ڵ� ����˴ϴ�."                                                              );
		System.out.println("�켱 ������ ������ ����, ���� �̿��� �� ���ϸ��� ����, ���α׷� �̿�Ⱓ�� ���� ����˴ϴ�.                                                  ");
		System.out.println("�켱 ������ ��� ���� ������ ���Ͻø� '6.�켱��������' �Ǵ� '7.�켱��������(Custom)'�� �����Ͽ� ������ �Ϸ��Ͻ� �� �ֽ��ϴ�."                      );
		System.out.println("                                                                                                     - Made by. MSJ -  " );
		System.out.println("=======================================================================================================================\n");
		save.Backup(loadfile.Load());
		
		while(run) {
			System.out.println("1.���Ϻҷ����� | 2.�˻� | 3.�߰� | 4.���� | 5.���� | 6.�켱�������� | 7.�켱��������(Custom) | 8.��ǰ ��÷ |  9.����");
			System.out.print("��ȣ�� �������ּ��� : ");
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
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("��ȣ�� �ٽ� �Է����ּ���.");
				break;
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		Main main = new Main();
		main.startMenu();
	}
}