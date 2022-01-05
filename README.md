# Airline_Custom_Priority_Program
항공사 우선순위 계산 프로그램 개발 Repository 입니다.
<br/><br/>


# 개요
### 문제
한 항공사에는 이미 예약이 완료된 비행기에 대한 고객들의 후보 순위를 결정하기 
위해 아래와 같은 식에 따라 대기 리스트(waiting list)를 운영한다.<br/>
- 우선순위 = A – (B/B_MAX)*10 – (C/C_MAX)*5<br/><br/>
    A: 고객이 이미 예약 완료된 비행기를 예약하기 위해 접수한 순번<br/>
    B: 고객이 과거 이용한 총 마일리지 점수, B_MAX: 최대 마일리지<br/>
    C: 고객이 항공사의 해당 프로그램을 이용한 기간(일), C_MAX: 최대 기간(일)<br/>
    
이미 예약 완료된 비행기에 대한 대기 고객들에 대한 파일이 주어질 경우, 이 파일에서 개인별 정보를 입력하여 각 고객의 우선순위를 결정한 후 우선순위의 내림차순으로 정렬한다.(우선순위가 높은 고객이 먼저 나온다.)
<br/><br/>


### 확장 기능
- 빠른 검색을 위해 인덱스 트리(이진 탐색 트리나 해쉬 테이블)를 사용하여 고객을 관리한다.(동일한 이름 처리)
- 예약자의 검색, 추가, 삭제 및 갱신이 가능하며 갱신된 데이터를 파일에 주기적으로 저장한다.
<br/><br/><br/>


# 개발
### 목표 설정
- 항공사의 고객 대기 리스트 파일을 읽어 각 고객의 우선순위를 결정한 후 오름차순으로 정렬하여 화면에 출력하는 것을 중점적 목표로 둔다. 또한, 확장 및 추가 기능을 구현하여 이외의 다양한 기능을 제공하는 프로그램을 만드는 것을 목표로 한다.

### 개발 환경
- H/W
  - CPU : 11𝑡ℎ Gen Intel® Core™ i5-1135G7 @ 2.40GHz(8cpus) ~ 2.4GHz
  - RAM : 16GB
  - GPU : Internal – Intel® Iris® Xe Graphics, External – NVIDIA GeForce MX450

- S/W
  - OS : WINDOW 10
  - Develop Tool: Eclipse IDE - Java
  - Version : JDK 16
<br/><br/><br/>

# 자료구조
- 파일의 내용 및 변동되는 데이터를 담기 위한 구조체 클래스(Data)
  
|자료형|변수명|내용|
|:---:|:---:|:---:|
|int|reg|고객의 접수번호를 저장하는 변수|
|String|name|고객의 이름을 저장하는 변수|
|int|mileage|고객의 과거 이용한 총 마일리지 점수를 저장하는 변수|
|String|date|고객의 가입년도를 저장하는 변수|
|long|use_date|고객의 항공사 이용기간을 저장하는 변수|
<br/>

- 우선순위+고객 데이터를 담기 위한 구조체 클래스(Priority_Data)
  
|자료형|변수명|내용|
|:---:|:---:|:---:|
|double|priority|고객의 우선순위를 저장하는 변수|
|int|reg|고객의 접수번호를 저장하는 변수|
|String|name|고객의 이름을 저장하는 변수|
|int|mileage|고객의 과거 이용한 총 마일리지 점수를 저장하는 변수|
|String|date|고객의 가입년도를 저장하는 변수|
<br/>

- 해시테이블(HashTable)
  
|자료형|변수명|내용|
|:---:|:---:|:---:|
|String|key|고객의 이름을 입력으로 받는 HashTable의 Key에 해당하는 변수|
|Priority_Data|pd|고객의 데이터를 입력으로 받는 HashTable의 Value에 해당하는 변수|
|int|hashcode|고객의 이름을 해시코드로 변환한 값을 저장하기 위한 변수|
|int|index|해시코드를 인덱스로 변환한 값을 저장하기 위한 변수|
|LinkedList<Node>|list|해시테이블에 데이터를 저장하기 위한 변수|
    
<br/><br/>
    
# 실행 흐름도
<p align="center">
  <img src="https://user-images.githubusercontent.com/74342121/148162412-1c657fca-498b-4d04-8f50-91e9eb97829f.png" width="1000" height="700">
</p>
    
<br/><br/>
    
# 시스템 구성
<p align="center">
  <img src="https://user-images.githubusercontent.com/74342121/148162787-68e42e23-e6a7-47f2-b89a-e3cf5e481ae3.png" width="800" height="450">
</p>
