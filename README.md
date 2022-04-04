# 22-1Database
22년 1학기 데이터베이스 프로젝트

<h1>카페 시스템</h1>
커피 카테고리 관리<br>
<br>
커피의 카테고리 번호(기본키), 이름을 관리한다.<br>
<br>
<br>
<br>
커피 메뉴 관리<br>
<br>
커피의 카테고리 번호(외래키), 메뉴 번호(기본키), 메뉴 이름, 온도(Only HOT or Only ICED or Both or Neither)를 관리한다.<br>
<br>
<br>
<br>
커피 옵션 관리<br>
<br>
커피 옵션을 유료와 무료 기준으로 나눈다.<br>
<br>
커피 옵션을 기준과 함께 메뉴로 등록한다. <br>
<br>
<br>
<br>
일일 주문 관리<br>
<br>
주문 번호, 메뉴번호, 메뉴 이름, 주문날짜시각을 관리한다.<br>
<br>
<br>
<br>
멤버십 회원 관리<br>
<br>
회원번호 , 이름, 전화번호, 포인트 점수를 관리한다.<br>
<br>
<br>
<br>


<hr>
<hr>
<h6>커피 메뉴관리</h6>
<h7>카테고리, 메뉴 이름, 가격, 온도(HOT or ICED or Both or Neither)</h7><br>
-> 카테고리 별 view 생성<br>

<h6>커피 옵션관리</h6>
<table>
  <thead>
    <th>옵션 이름</th>
    <th>옵션 번호</th>
  </thead>
  <tbody>
    <tr>
      <td>유료 옵션</td>
      <td>01</td>
    </tr>
    <tr>
      <td>무료 옵션</td>
      <td>02</td>
    </tr>
  </tbody>
</table>

<h6>커피 일일주문관리</h6><br>
<h6>멤버십 회원관리</h6><br>
erDiagram
    CAR ||--o{ NAMED-DRIVER : allows
    CAR {
        string registrationNumber
        string make
        string model
    }
    PERSON ||--o{ NAMED-DRIVER : is
    PERSON {
        string firstName
        string lastName
        int age
    }
