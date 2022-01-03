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
	
	// 불러온 파일 내용 출력 메소드
	public void Print() {
		try { // 파일 불러오기
			File file = new File("waiting_list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			System.out.println("-------------불러온 파일 내용-------------");
			System.out.printf("%-6s%-8s%-7s%s\n", "접수번호", "이름", "마일리지", "가입년도");
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\t");
				System.out.printf("%-10s%-7s%-11s%s\n", split[0], split[1], split[2], split[3]);
			} 
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 읽어올 수 없습니다.");
			e.printStackTrace();
		}
	}
	// 불러온 파일 내용 반환 메소드
	public ArrayList<Data> Load() {
		ArrayList<Data> AL_data = new ArrayList<Data>();
		try { // 파일 불러오기
			File file = new File("waiting_list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\s+"); // 연속된 공백을 하나의 공백으로 취급하여 분할
				int reg = Integer.valueOf(split[0]);
				String name = split[1];
				int mileage = Integer.valueOf(split[2]);
				String reg_date = split[3];

				String today = df.format(date);
				long use_date = (df.parse(today).getTime() - df.parse(reg_date).getTime()) / (24*60*60*1000);
				Data data = new Data(reg, name, mileage, reg_date, use_date);
				AL_data.add(data); // 데이터를 ArrayList<Data> 객체에 저장
			} 
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 읽어올 수 없습니다.");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return AL_data;
	}
}