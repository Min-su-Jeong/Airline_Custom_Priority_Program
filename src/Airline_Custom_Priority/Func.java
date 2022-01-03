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
	
	// �˻�
	public String Search() {
		String name = "";
		data = load.Load();
		pd_data = sort.Sort(data);
		
		// �ؽ����̺� �ʱ�ȭ
		for(Priority_Data pd : pd_data) {
			ht.clear(pd.getName());
		}
		//�ؽ����̺� �� ����
		for(Priority_Data pd : pd_data) {
			ht.put(pd.getName(), pd);
		}
		// �ؽ����̺��� ���� ������ �˻�
		System.out.println("�˻��� �̸��� �Է��ϼ��� : ");
		name = sc.next();
		
		while(true) {
			if(ht.get(name) == null) {
				System.out.println("�˻��Ͻ� �����Ͱ� �������� �ʽ��ϴ�.");
				System.out.print("��˻� �Ͻðڽ��ϱ�?(Y/N) : ");
				char YorN = sc.next().charAt(0);
				if(YorN == 'Y' || YorN == 'y') {
					System.out.println("�˻��� �̸��� �Է��ϼ��� : ");
					name = sc.next();
					continue;
				} else if(YorN == 'N' || YorN == 'n') {
					System.out.println("\n");
					break;
				} 
			}
			else {
				System.out.println("---------------------�˻� ���---------------------");
				System.out.printf("%-6s%-6s%-8s%-7s%s\n", "�켱����", "������ȣ", "�̸�", "���ϸ���", "���Գ⵵");
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
	// �߰�
	public void Add() throws ParseException {
		int mileage;
		String name, reg_date;
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		data = load.Load();
		System.out.println("�߰��� ������ �Է��ϼ���.");
		
		System.out.print("�̸� : ");
		name = sc.next();
		
		System.out.print("���ϸ��� : ");
		mileage = sc.nextInt();
		
		System.out.print("���Գ⵵(YYYY-MM-DD) : ");
		reg_date = sc.next();
		
		String today = df.format(date);
		long use_date = (df.parse(today).getTime() - df.parse(reg_date).getTime()) / (24*60*60*1000);
		data.add(new Data(data.size()+1, name, mileage, reg_date, use_date));
		save.SaveD(data);
		System.out.println("-------------------------������ �߰� �Ϸ�!-------------------------\n\n");
		
	}
	// ����
	public void Delete() {
		int delIdx = 0;
		data = load.Load();
		String name = this.Search();
		
		if(name == null) {
			return;
		}
		// ������ �������� �ε��� �� ã��
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getName().equals(name)) {
				delIdx = i;
			}
		}
		// �˻��� ������ ���� ����
		while(true) {
			System.out.print("�˻��Ͻ� ���� ������ ���� �Ͻðڽ��ϱ�?(Y/N) : ");
			char YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				data.remove(delIdx);
				for(int i = delIdx; i<data.size(); i++) {
					data.get(i).setReg(i+1);
				}
				save.SaveD(data);
				System.out.println("-------------------------������ ���� �Ϸ�!-------------------------\n\n");
				break;
			} else if(YorN == 'N' || YorN == 'n') {
				System.out.println("\n");
				break;
			}
		} 
	}
	// ����
	public void Renew() {
		char YorN;
		int select;
		int changeIdx = 0;
		boolean flag = true;
		data = load.Load();
		String name = this.Search();
		if(name == null)
			return;
		
		// ������ �������� �ε��� �� ã��
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getName().equals(name)) {
				changeIdx = i;
			}
		}

		while(true) {
			System.out.print("�˻��Ͻ� ���� ������ ���� �Ͻðڽ��ϱ�?(Y/N) : ");
			YorN = sc.next().charAt(0);
			if(YorN == 'Y' || YorN == 'y') {
				break;
			} else if(YorN == 'N' || YorN == 'n') {
				System.out.println("\n");
				return;
			}
		}
		// �˻��� ������ ���� ����
		System.out.print("�����Ͻ� ������ �����ϼ���.\n1.�̸� | 2.���ϸ��� | 3.���Գ⵵(YYYY-MM-DD) : ");
		select = sc.nextInt();
		while(flag) {
			switch(select) {
			case 1:
				System.out.print("������ �̸��� �Է��ϼ��� : ");
				String changeName = sc.next();
				data.get(changeIdx).setName(changeName);
				flag = false;
				break;
			case 2:
				System.out.print("������ ���ϸ��� ���� �Է��ϼ��� : ");
				int changeMileage = sc.nextInt();
				data.get(changeIdx).setMileage(changeMileage);
				flag = false;
				break;
			case 3:
				System.out.print("������ ���Գ⵵�� �Է��ϼ��� : ");
				String changeDate = sc.next();
				data.get(changeIdx).setDate(changeDate);
				flag = false;
				break;
			default:
				System.out.print("���ڸ� �ٽ� �Է����ּ��� : ");
				select = sc.nextInt();
				break;
			}
		}
		save.SaveD(data);
		System.out.println("-------------------------������ ���� �Ϸ�!-------------------------\n\n");
	}
}
