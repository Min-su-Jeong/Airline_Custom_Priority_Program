package Airline_Custom_Priority;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Save {
	private Scanner input = new Scanner(System.in);
	private String filename;
	
	// �켱���� ������ ���� �޼ҵ�
	public void SavePD(ArrayList<Priority_Data> data) { 
		System.out.print("������ ���ϸ��� �Է��ϼ���.(�ҷ��� ���ϰ� ���ϸ����� �Է½� ������ ó���˴ϴ�.) : ");
		filename = input.next();
		try {
			File saveFile = new File(filename + ".txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile, false));
			bw.write("�켱����\t������ȣ\t�̸� \t���ϸ���\t���Գ⵵\n");
			int idx = 1;
			for(Priority_Data pd : data) {
				bw.write(Integer.toString(idx++) +"\t"+ Integer.toString(pd.getReg()) +"\t"+ pd.getName() +" \t"+ Integer.toString(pd.getMileage()) +"\t"+ pd.getDate() + "\n");
			}
			bw.close();
			System.out.println("----------------------------���� ���� �Ϸ�!----------------------------\n\n");
		} 
		catch (IOException e) {
			System.out.println("-----------------------------���� ���� ����-----------------------------\n\n");
			e.printStackTrace();
		}
	}
	// DataŸ�� ���� �޼ҵ�
	public void SaveD(ArrayList<Data> data) {
		try {
			File saveFile = new File("waiting_list.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile, false));
			for(Data d : data) {
				bw.write(Integer.toString(d.getReg()) +"\t"+ d.getName() +" \t"+ Integer.toString(d.getMileage()) +"\t"+ d.getDate() + "\n");
			}
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	// ���� Data ��� �Լ�
	public void Backup(ArrayList<Data> data) {
		try {
			File saveFile = new File("waiting_list(Backup).txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile, false));
			for(Data d : data) {
				bw.write(Integer.toString(d.getReg()) +"\t"+ d.getName() +" \t"+ Integer.toString(d.getMileage()) +"\t"+ d.getDate() + "\n");
			}
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}