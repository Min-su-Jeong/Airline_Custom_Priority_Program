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
	
	// 우선순위 데이터 저장 메소드
	public void SavePD(ArrayList<Priority_Data> data) { 
		System.out.print("저장할 파일명을 입력하세요.(불러온 파일과 동일명으로 입력시 덮어쓰기로 처리됩니다.) : ");
		filename = input.next();
		try {
			File saveFile = new File(filename + ".txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile, false));
			bw.write("우선순위\t접수번호\t이름 \t마일리지\t가입년도\n");
			int idx = 1;
			for(Priority_Data pd : data) {
				bw.write(Integer.toString(idx++) +"\t"+ Integer.toString(pd.getReg()) +"\t"+ pd.getName() +" \t"+ Integer.toString(pd.getMileage()) +"\t"+ pd.getDate() + "\n");
			}
			bw.close();
			System.out.println("----------------------------파일 저장 완료!----------------------------\n\n");
		} 
		catch (IOException e) {
			System.out.println("-----------------------------파일 저장 실패-----------------------------\n\n");
			e.printStackTrace();
		}
	}
	// Data타입 저장 메소드
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
	// 원본 Data 백업 함수
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