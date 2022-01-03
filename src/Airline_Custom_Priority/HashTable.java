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
    // 해시함수
    public int getHashCode(String key){
    	int hashcode=0;
        for(char c : key.toCharArray()){
        	hashcode+=c;
        }
        return hashcode;
    }
    // 인덱스
    public int convertToIndex(int hashcode){
    	return hashcode%data.length;
    }
    // 검색 키를 통해 해당 노드 찾기
    Node searchKey(LinkedList<Node> list, String key){
    	if(list==null) return null;
        for(Node node : list){
        	if(node.key.equals(key)){
            	return node;
            }
        }
        return null;
    }
    // 데이터 저장
    public void put(String key, Priority_Data pd){
    	int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        
        // 기존에 저장된 데이터 불러오기
        LinkedList<Node> list = data[index];
        if(list==null){ // 리스트가 비어있을 시 새로운 리스트를 해시테이블에 삽입
        	list = new LinkedList<Node>();
            data[index] = list;
        }
        // 기존에 해당 키의 데이터 노드 받아오기
        Node node = searchKey(list, key);
        if(node == null){
        	list.addLast(new Node(key, pd));
        }else{
        	node.value(pd);
        }
        size++;
    }
    // 데이터 가져오기
    public Priority_Data get(String key){
    	int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? null : node.value();
    }
    // 데이터 초기화
    public void clear(String key) {
    	int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        this.data[index] = null;
        size = 0;
    }
    // 해시테이블 크기
    public int size() {
    	return this.size;
    }
}