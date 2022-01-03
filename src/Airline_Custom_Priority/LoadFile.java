package Airline_Custom_Priority;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class LoadFile {
	private Date date = new Date();       
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private String line = "";
	
	// �ҷ��� ���� ���� ��� �޼ҵ�
	public void Print() {
		try { // ���� �ҷ�����
			File file = new File("waiting_list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			System.out.println("-------------�ҷ��� ���� ����-------------");
			System.out.printf("%-6s%-8s%-7s%s\n", "������ȣ", "�̸�", "���ϸ���", "���Գ⵵");
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\t");
				System.out.printf("%-10s%-7s%-11s%s\n", split[0], split[1], split[2], split[3]);
			} 
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ �о�� �� �����ϴ�.");
			e.printStackTrace();
		}
	}
	// �ҷ��� ���� ���� ��ȯ �޼ҵ�
	public ArrayList<Data> Load() {
		ArrayList<Data> AL_data = new ArrayList<Data>();
		try { // ���� �ҷ�����
			File file = new File("waiting_list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\s+"); // ���ӵ� ������ �ϳ��� �������� ����Ͽ� ����
				int reg = Integer.valueOf(split[0]);
				String name = split[1];
				int mileage = Integer.valueOf(split[2]);
				String reg_date = split[3];

				String today = df.format(date);
				long use_date = (df.parse(today).getTime() - df.parse(reg_date).getTime()) / (24*60*60*1000);
				Data data = new Data(reg, name, mileage, reg_date, use_date);
				AL_data.add(data); // �����͸� ArrayList<Data> ��ü�� ����
			} 
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ �о�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return AL_data;
	}
}