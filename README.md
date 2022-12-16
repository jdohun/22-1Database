양식 수정 : 220522<br>
요구사항 명세서 -> ERD, 릴레이션 스키마 -> 물리적 스키마 문서 - > DB 생성 스크립트 작성 -> 테이블 정규화 수행
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
<h3>요구사항 명세서</h3>
<details>
<summary>수정 이력</summary>

><details>
<summary>220513, 220522</summary>
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
18. 온도는 온도번호, 온도이름을 입력받는다.<br>
</details>

<details>
<summary>220610</summary>

</details>

<details>
<summary>220612-1</summary>

</details>

<details>
<summary>220612-2</summary>

</details>
</details>

<h4>최종 : 220620</h4>
1. 커피 메뉴는 카테고리 번호, 메뉴 번호, 메뉴 이름, 메뉴 가격을 입력받는다.<br>
2. 커피 메뉴는 메뉴 번호로 식별한다.<br>
3. 커피 메뉴는 주문 전에 장바구니에 먼저 담기.<br>
4. 커피 메뉴를 장바구니에 담기 전에 옵션을 선택해야한다.<br>
5. 옵션은 필수 옵션과 선택 옵션으로 나뉘어진다.<br>
6. 옵션은 옵션 번호, 옵션 이름, 옵션 가격, 필수 여부를 입력 받는다.<br>
7. 옵션은 커피메뉴에 의존적이다.
8. 장바구니는 메뉴 번호, 선택된 옵션 정보, 주문 수량, 메뉴별 가격을 입력받는다.<br>
9. 주문을 하지 않은 장바구니는 초기화된다.<br>
10. 장바구니에 있는 메뉴를 주문하면 주문 상세에 기록된다.<br>
11. 주문 상세는 장바구니와 내용이 동일하며 추가로 주문 번호를 입력 받는다.<br>
12. 주문 상세는 주문 번호, 메뉴 번호, 선택된 옵션 정보로 식별한다<br>
13. 주문 내역은 주문 번호, 구매자, 주문 날짜, 총 가격을 입력받는다.<br>
14. 주문 내역은 주문 번호로 식별한다.<br>
15. 주문자는 회원과 비회원으로 나뉘어진다.<br>
16. 로그인하지 않고 주문을 하면 주문자 번호는 비회원으로 처리된다.<br>
17. 회원은 핸드폰 번호, 이름, 생년월일, 나이, 적립금을 입력받는다.<br>
18. 초기회원의 적립금은 0으로 초기화한다.<br>
19. 회원은 핸드폰 번호로 식별한다.(회원 로그인에 사용)<br>
20. 회원과 장바구니는 1:1 관계로 서로를 소유한다.<br>

<hr>
<h4><del>초기 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/161521731-15e61450-b19a-4882-b201-e6cbbb56dec7.png"></img>
<h4><del>220513 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/169690290-35926efd-b454-484f-bde6-996045f75d35.png"></img>
<h4><del>220610 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/173021686-16839b00-0f11-4fb4-a815-476b52d47c65.jpg"></img>
<h4><del>220611 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/173185402-9aedd5bb-66b6-4ef5-a257-373e6a0df64f.png"></img>
<h4><del>220612-1 수정된 ERD</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/173213772-74bb07b8-244c-42ad-ac28-89ef4a1785a4.png"></img>
<del><h4>220612-2 수정된 ERD</h4></del>
<img src="https://user-images.githubusercontent.com/69462861/173291410-20906ecd-e5cf-494b-b7b3-bbfae562cef4.png"></img>
<h4>220620 수정된 ERD</h4>
<img src="https://user-images.githubusercontent.com/69462861/174522304-9b889eb4-5d54-46de-a4e3-0c4ddb027ecb.png"></img>
<hr>
<h4>릴레이션 스키마<h4>
<img src="https://user-images.githubusercontent.com/69462861/173305364-5c2b8bb5-1771-4110-801a-5d7f425fbbc0.png"></img>
<hr>
<h4><del>초기 물리적 스키마</del></h4>
<img src="https://user-images.githubusercontent.com/69462861/169866825-d330c4c8-e6e1-4525-a20b-f3eff577bc75.png"></img>
<del><h4>220612-1 물리적 스키마</h4></del>
<img src="https://user-images.githubusercontent.com/69462861/173213832-a246a6bd-e9a5-4d78-ac69-eca4aa0e6e8f.png"></img>
<del><h4>220612-2 물리적 스키마</h4></del>
<img src="https://user-images.githubusercontent.com/69462861/173291335-51e33a26-9cb5-4cce-aa3b-91825fbc0cbd.png"></img>
<h4>220620 물리적 스키마</h4>
<img src="https://user-images.githubusercontent.com/69462861/174523299-4a4e4401-5547-4059-ac05-6e722299e9f9.png"></img>
<hr>
<h4>테이블 정규화</h4>
<img src="https://user-images.githubusercontent.com/69462861/173292905-4d0c4ed7-f178-469f-8ef0-f0401201584a.png"></img>
