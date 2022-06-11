양식 수정 : 220522
<hr>
# 22-1Database
22년 1학기 데이터베이스 프로젝트
<!--
<h1>카페 시스템</h1>
<br>
<h4>커피 카테고리 관리</h4>
커피의 카테고리 번호(기본키), 이름을 관리한다.<br>
<br>
<h5>커피 메뉴 관리</h5>
커피의 카테고리 번호(외래키), 메뉴 번호(기본키), 메뉴 이름, 온도(Only HOT or Only ICED or Both or Neither)를 관리한다.<br>
<br>
<h5>커피 옵션 관리</h5>
커피 옵션을 유료와 무료 기준으로 나눈다.<br>
커피 옵션을 기준과 함께 메뉴로 등록한다. <br>
<br>
<h5>일일 주문 관리</h5>
주문 번호, 메뉴번호, 메뉴 이름, 주문날짜시각을 관리한다.<br>
<br>
<h5>멤버십 회원 관리</h5>
회원번호 , 이름, 전화번호, 포인트 점수를 관리한다.<br>
<hr>
<hr>
<h6>커피 메뉴관리</h6>
<h7>카테고리, 메뉴 이름, 가격, 온도(HOT or ICED or Both or Neither)</h7>
<br>-> 카테고리 별 view 생성
<br>
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
<h6>커피 일일주문관리</h6>
<br><h6>멤버십 회원관리</h6>
-->
<br>
<hr>
<h4><del>220513, 수정 1차 : 220522</del></h4>
<del>
1. 카페 멤버십 회원으로 가입하기 위해서는 이름, 핸드폰 번호, 나이, 직업을 입력해야한다.<br>
2. 멤버십 회원은 핸드폰 번호로 식별한다.<br>
3. 멤버십 회원에게는 적립금이 부여된다.<br>
4. 메뉴는 카테고리 번호, 메뉴 번호, 이름, 가격, 온도(only iced, only hot, both)를 입력받는다.<br>
5. 메뉴는 메뉴번호로 식별한다.<br>
6. 메뉴는 카테고리 별로 소속되며 카테고리 번호를 지정 받는다.<br>
7. 메뉴는 한 개의 카테고리에만 소속될 수 있다.<br>
8. 메뉴에는 옵션을 부여할 수 있으며 옵션은 따로 관리된다.<br>
9. 한 개의 메뉴에 여러 개의 옵션을 부여할 수 있다.<br>
10. 옵션은 옵션 번호, 옵션 이름, 옵션 가격을 지정받는다.<br>
11. 옵션은 옵션 번호로 식별한다.<br>
12. 카테고리는 카테고리 번호와 카테고리 이름을 지정 받는다.<br>
13. 카테고리는 카테고리 번호로 식별한다.<br>
14. 주문 기록에는 주문 번호, 주문자, 메뉴번호, 옵션번호, 주문날짜시각이 입력된다.<br>
15. 주문자는 회원일 경우 핸드폰 번호를 외래키로 입력 받고, 비회원일 경우 null을 입력 받는다.<br>
16. 주문은 주문번호로 식별한다.<br>
17. 고객(회원, 비회원)은 한 번의 주문에 여러 개의 메뉴를 주문할 수 있다.<br>
18. 온도는 온도번호, 온도이름을 입력받는다.</del><br>
<hr>
<hr>
<h4><del>초기 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/161521731-15e61450-b19a-4882-b201-e6cbbb56dec7.png"></img>
<h4><del>220513 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/169690290-35926efd-b454-484f-bde6-996045f75d35.png"></img>
<h4><del>220610 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/173021686-16839b00-0f11-4fb4-a815-476b52d47c65.jpg"></img>
<h4>220611 수정된 ERD</h4>
<img src="https://user-images.githubusercontent.com/69462861/173185402-9aedd5bb-66b6-4ef5-a257-373e6a0df64f.png"></img>
<hr>
<h4><del>초기 물리적 스키마</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/169866825-d330c4c8-e6e1-4525-a20b-f3eff577bc75.png"></img>
<h4>220611 물리적 스키마</h4>
<del>
