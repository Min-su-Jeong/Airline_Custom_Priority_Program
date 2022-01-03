package Airline_Custom_Priority;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
public class Event {
	private Save save = new Save();
	private LoadFile load = new LoadFile();
	private ArrayList<Data> data = new ArrayList<Data>();
	
	public void Event() {
		String [] prize = new String[6]; // 당첨된 고객 이름을 저장하기 위한 문자열 배열
		data = load.Load();
		
        Set<Integer> randomSet = new LinkedHashSet<Integer>(6);
        for( Random random = new Random() ; randomSet.size() < 6 && randomSet.size() < data.size() ;)
            randomSet.add(1 + random.nextInt( data.size() ));
        
        Iterator<Integer> iter = randomSet.iterator();
        for(int i = 0 ; iter.hasNext() ; i++) {
        	if(i < 3) { // 3등 상품 당첨자
		    	int idx = iter.next();
				int currentMileage = data.get(idx).getMileage();
				prize[i] = data.get(idx).getName();
				data.get(idx).setMileage(currentMileage + 30000);
				save.SaveD(data);
        	} else if(i >= 3  && i < 5) { // 2등 상품 당첨자
        		int idx = iter.next();
        		prize[i] = data.get(idx).getName();
        	} else if(i == 5) { // 1등 상품 당첨자
        		int idx = iter.next();
        		prize[i] = data.get(idx).getName();
        	}
        }
        System.out.println("==================================================================================");
		System.out.println("                                 ---------------------                            ");
		System.out.println("                                  항공사 이벤트 당첨자                                 ");
		System.out.println("                                 ---------------------                          \n");
		System.out.println("                            1등 | 유럽 왕복 항공권 1매(1명)                           \n");
		System.out.printf ("                                       %s 님\n\n",                          prize[5]);
		System.out.println("                          2등 | 좌석 클래스 무료 업그레이드(2명)                        \n");
		System.out.printf ("                                  %s 님  %s 님\n\n",               prize[3],prize[4]);
		System.out.println("                          3등 | 항공사 마일리지 3만 포인트(3명)                         \n");
		System.out.printf ("                             %s 님  %s 님  %s 님\n\n",      prize[0],prize[1],prize[2]);
		System.out.println("항공사 이벤트에 당첨되신 것을 진심으로 축하드립니다!                                            ");
		System.out.println("1등, 2등 상품에 당첨되신 분들은 추후에 별도로 연락을 드릴 예정입니다.                              ");
		System.out.println("3등 상품에 당첨되신 분들을 3만 포인트가 자동적립 됩니다.                                        ");
		System.out.println("항공사를 이용해 주시는 고객분들께 감사드리며 항상 더 좋은 서비스로 찾아뵙겠습니다.                      ");
		System.out.println("==================================================================================\n");
    }
}
