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
		String [] prize = new String[6]; // ��÷�� �� �̸��� �����ϱ� ���� ���ڿ� �迭
		data = load.Load();
		
        Set<Integer> randomSet = new LinkedHashSet<Integer>(6);
        for( Random random = new Random() ; randomSet.size() < 6 && randomSet.size() < data.size() ;)
            randomSet.add(1 + random.nextInt( data.size() ));
        
        Iterator<Integer> iter = randomSet.iterator();
        for(int i = 0 ; iter.hasNext() ; i++) {
        	if(i < 3) { // 3�� ��ǰ ��÷��
		    	int idx = iter.next();
				int currentMileage = data.get(idx).getMileage();
				prize[i] = data.get(idx).getName();
				data.get(idx).setMileage(currentMileage + 30000);
				save.SaveD(data);
        	} else if(i >= 3  && i < 5) { // 2�� ��ǰ ��÷��
        		int idx = iter.next();
        		prize[i] = data.get(idx).getName();
        	} else if(i == 5) { // 1�� ��ǰ ��÷��
        		int idx = iter.next();
        		prize[i] = data.get(idx).getName();
        	}
        }
        System.out.println("==================================================================================");
		System.out.println("                                 ---------------------                            ");
		System.out.println("                                  �װ��� �̺�Ʈ ��÷��                                 ");
		System.out.println("                                 ---------------------                          \n");
		System.out.println("                            1�� | ���� �պ� �װ��� 1��(1��)                           \n");
		System.out.printf ("                                       %s ��\n\n",                          prize[5]);
		System.out.println("                          2�� | �¼� Ŭ���� ���� ���׷��̵�(2��)                        \n");
		System.out.printf ("                                  %s ��  %s ��\n\n",               prize[3],prize[4]);
		System.out.println("                          3�� | �װ��� ���ϸ��� 3�� ����Ʈ(3��)                         \n");
		System.out.printf ("                             %s ��  %s ��  %s ��\n\n",      prize[0],prize[1],prize[2]);
		System.out.println("�װ��� �̺�Ʈ�� ��÷�ǽ� ���� �������� ���ϵ帳�ϴ�!                                            ");
		System.out.println("1��, 2�� ��ǰ�� ��÷�ǽ� �е��� ���Ŀ� ������ ������ �帱 �����Դϴ�.                              ");
		System.out.println("3�� ��ǰ�� ��÷�ǽ� �е��� 3�� ����Ʈ�� �ڵ����� �˴ϴ�.                                        ");
		System.out.println("�װ��縦 �̿��� �ֽô� ���е鲲 ����帮�� �׻� �� ���� ���񽺷� ã�ƺ˰ڽ��ϴ�.                      ");
		System.out.println("==================================================================================\n");
    }
}
