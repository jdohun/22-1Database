양식 수정 : 220522
<style>
        .individual {
            border: blue 1px solid;
            color: #0000FF;
        }

        .attribute {
            color: #0000FF;
            text-decoration: underline;
            text-decoration-color: #0000FF;
        }
    </style>
<hr>
# 22-1Database
22년 1학기 데이터베이스 프로젝트

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
<br>
<hr>
<hr>
<img src="https://user-images.githubusercontent.com/69462861/161521731-15e61450-b19a-4882-b201-e6cbbb56dec7.png"></img>
<hr>
<hr>
<h4>220513, 수정 1차 : 220522</h4>
    
    <p>1.카페 멤버십 <span class="individual">회원</span>으로 가입하기 위해서는 <span class="attribute">이름</span>, 핸드폰 번호,나이, 직업 입력해야한다.</p>
    <p>2.멤버십 회원은 핸드폰 번호로 식별한다.</p>
    <p>3.멤버십 회원에게는 적립금이 부여된다.</p>
    <p>4.메뉴는 이름, 가격, 온도(only iced, only hot, both)를 입력받는다.</p>
    <p>5.메뉴는 카테고리 별로 관리되며 카테고리 번호를 지정받는다.</p>
    <p>6.메뉴는 메뉴번호를 받고 메뉴번호로 식별한다.</p>
    <p>7.메뉴에는 옵션을 부여할 수 있으며 옵션은 따로 관리된다.</p>
    <p>8.옵션은 옵션번호로 식별한다.</p>
    <p>9.옵션에는 옵션이름과 추가 가격을 입력해야한다.</p>
    <p>10.주문에는 주문자, 메뉴번호, 옵션번호, 주문날짜시각이 입력된다.</p>
    <p>11.주문자 정보는 회원일 경우 핸드폰번호를 외래키로 입력받는다.</p>
    <p>12.주문은 주문번호로 식별한다.</p>
    <p>13.한 번의 주문에 여러 개의 메뉴를 주문할 수 있다.</p>
