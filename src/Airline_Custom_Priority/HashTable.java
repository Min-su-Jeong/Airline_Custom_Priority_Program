package Airline_Custom_Priority;

import java.util.LinkedList;
import java.util.ArrayList;

public class HashTable {
	private int size = 0;
	
	class Node{
    	String key;
        Priority_Data value;
        public Node(String key, Priority_Data pd){
        	this.key = key;
            this.value = pd;
        }
        Priority_Data value(){
        	return value;
        }
        void value(Priority_Data pd){
        	this.value=pd;
        }
    }
    LinkedList<Node>[] data;
    HashTable(int size){
    	this.data = new LinkedList[size];
    }
    // �ؽ��Լ�
    public int getHashCode(String key){
    	int hashcode=0;
        for(char c : key.toCharArray()){
        	hashcode+=c;
        }
        return hashcode;
    }
    // �ε���
    public int convertToIndex(int hashcode){
    	return hashcode%data.length;
    }
    // �˻� Ű�� ���� �ش� ��� ã��
    Node searchKey(LinkedList<Node> list, String key){
    	if(list==null) return null;
        for(Node node : list){
        	if(node.key.equals(key)){
            	return node;
            }
        }
        return null;
    }
    // ������ ����
    public void put(String key, Priority_Data pd){
    	int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        
        // ������ ����� ������ �ҷ�����
        LinkedList<Node> list = data[index];
        if(list==null){ // ����Ʈ�� ������� �� ���ο� ����Ʈ�� �ؽ����̺� ����
        	list = new LinkedList<Node>();
            data[index] = list;
        }
        // ������ �ش� Ű�� ������ ��� �޾ƿ���
        Node node = searchKey(list, key);
        if(node == null){
        	list.addLast(new Node(key, pd));
        }else{
        	node.value(pd);
        }
        size++;
    }
    // ������ ��������
    public Priority_Data get(String key){
    	int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? null : node.value();
    }
    // ������ �ʱ�ȭ
    public void clear(String key) {
    	int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        this.data[index] = null;
        size = 0;
    }
    // �ؽ����̺� ũ��
    public int size() {
    	return this.size;
    }
}