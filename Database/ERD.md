# **ERD**

## **ERD란?**
+ ERDFKS Entity Relationship Diagram의 약어로, 데이터베이스 구조를 한눈에 알아보기 위해서 쓰인다.
+ DB를 개발하기 전에 보다 많은 아이디어를 도출하고, 데이터베이트 설계에대한 이해를 높이기 위해 데이터 모델링을 실시한다.
+ 쿼리물을 작성할 때 테이블들이 구조화된 다이어그램을 보면서 도움을 받을 수 있다.
+ 데이터의 다양한 특징을 확인할 수 있어 ㅇㅛ구사항을 그에 마자게 개발할 수 있다.

> ERD의 핵심은 세 가지이다. **"Entity"** 와 **"Relationship"**, 그리고 **"Attribute"** 이다.

### **Entity(개체)**
+ Entity는 관리하고자 하는 정보의 실체이며, 사람, 객체 혹은 개념이라고 이해하면 된다.
+ 데이터베이스는 설계할 때, 쉽게는 테이블이 Entity로 정의될 수 있다.
+ 모든 Entity는 하나 이상의 삭별자(UID)를 지녀야 하며, UID가 없다면 Entity라고 할 수 없다.

- **Weak Entity**
    - 개체가 가진 속성으로는 개체를 고유하게 정의할 수 없는 개체를 의미. 다른 개체에 의존해야하는 Entity를 의미한다.
    
### **Relationship**
- Entity간의 관계를 의미
- 두 Entity 간에 선을 긋고, 관계 명칭을 기록하게 된다.
- 선택 사항을 표시한다.
    - 점선을 선택적인 사항을 의미한다.
    - 실선은 필수적인 사항을 의미한다.
- 관계 형태를 표시한다.
    - 삼지창 모양은 하나 이상을 의미한다.
    - 단선은 하나를 의미한다.

    <br />

![image](https://user-images.githubusercontent.com/103401991/181906760-f515794a-85cb-4005-8fed-1886f02a6b94.png)

### **Attribute(속성)**
- Attribute는 Entity를 구성하고 있는 구성 요소이다.
- 데이터 타입
    - **Key Attribute**
        - 다른 객체들과 중복되지 않는 고유한 값을 가진 Attribute로, 객체를 식별하는데 사용된다.
    - **Composite Arrtibute**
        - 여러개의 독립적인 Attribute들이 모여서 생성된 Attribute를 의미한다.
    - **Multi-Valued Attribute**
        - 하나의 Attribute가 여러개의 값을 가지는 Attrinute를 의미한다.
    - **Derived Attribute**
        - 다른 Atrribute가 갖고 있는 값으로부터 유도된 속성을 의미한다.

## 관계형태(Cardinality)

<br />

### **1:1 관게**
- 양쪽 모두 단 하나씩 존재하는 경우.

![image](https://user-images.githubusercontent.com/103401991/181907910-15c00050-dfd6-49dd-88cc-ebee0a6652b2.png)

### **1:N 관계**
- 일대다/다대일 관계는 하나의 원소가 두개 이상의 원소와 관계를 맺는 것을 의미한다.
> 이를 관계 모델로 바꿀 때 따로 relationship의 table을 만들지 않고, "Many" 쪽에 있는 entity에 "one" 쪽의 primary key를 Attribute로 추가하게 된다.

![image](https://user-images.githubusercontent.com/103401991/181908433-f4e8ba20-43f9-4159-b71b-ec29036fe49c.png)

### **N:M 관계**
- 다대다 관계라고 하며, 양쪽 모두 하나 이상과 연관될 수 있다. 
> M:N 관계를 M:1 관계로 분할한다. 관계를 맺는 두 entity의 primary key를 가져와 하나의 relation을 생성한다. 

![image](https://user-images.githubusercontent.com/103401991/181908715-1e9bf82c-52be-448e-910b-37c4dc69463e.png)

## **ERD 설계 과정**
- Entity와 Attribute 추출
    - 
    관계형 데이터 모델링