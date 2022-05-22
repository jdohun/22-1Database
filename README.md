양식 수정 : 220522
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
1.카페 멤버십 회원으로 가입하기 위해서는 이름, 핸드폰 번호, 나이, 직업 입력해야한다.<br>
2.멤버십 회원은 핸드폰 번호로 식별한다.<br>
3.멤버십 회원에게는 적립금이 부여된다.<br>
4.메뉴는 이름, 가격, 온도(only iced, only hot, both)를 입력받는다.<br>
5.메뉴는 카테고리 별로 관리되며 카테고리 번호를 지정받는다.<br>
6.메뉴는 메뉴번호를 받고 메뉴번호로 식별한다.<br>
7.메뉴에는 옵션을 부여할 수 있으며 옵션은 따로 관리된다.<br>
8.옵션은 옵션번호로 식별한다.<br>
9.옵션에는 옵션이름과 추가 가격을 입력해야한다.<br>
10.주문에는 주문자, 메뉴번호, 옵션번호, 주문날짜시각이 입력된다.<br>
11.주문자 정보는 회원일 경우 핸드폰번호를 외래키로 입력받는다.<br>
12.주문은 주문번호로 식별한다.<br>
13.한 번의 주문에 여러 개의 메뉴를 주문할 수 있다.<br>
<hr>
<img src="https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=cafe.drawio#R5V1bc5s6EP41PMZjENdH40v7cNJJm5me9pFjE5sWmxSTxjm%2F%2FkgggVnJNcZYiJxMZwoLlmH17afV7krW0HR7%2BJAGz5v7ZBXGmjFeHTQ00wz85xj4PyJ5KyS6a1PJOo1WVFYJHqN%2FQyocU%2BlLtAr3tRuzJImz6LkuXCa7XbjMarIgTZPX%2Bm1PSVz%2F1udgHXKCx2UQ89K%2Fo1W2KaSuNa7kH8NovWHfrI%2FplW3AbqaC%2FSZYJa81UXjIFskuo4%2F4EKbbYBfuMnzlPkh%2FhqlmzTdZRt50ohkL%2FO%2BJ3D1aJ8k6DoPnaD9aJlssXu7xLYunYBvFRM9HDfm0Ifx1aK6haZokWXG0PUzDmHQW64bimRYnrpZ6SEm7DT7w9dPs7ce3x%2FSL%2B8kxfs0e%2F7r%2FFd85RSu%2Fg%2FiF6lebTzXf1yamNp9pnqn5U3w9F3qanwtdS3On2nyi%2BUib4Ev4ZlubTKlSszfWU2nysluF5Nt1DfmvmygLH5%2BDJbn6isGJZZtsG9PL6zRYRfhNpkmcpFi2S3b4Rn8VpRhEUbLDojDY4xf10yQLqGSMT5%2Fi6PkrbYQcf6THvHqoxn6HaRYejkRUXR%2FCZBtm6Ru%2BhV51KSqoqSB6%2BlrBTmfA2RxBzqaygMJoXTZc9Q4%2BoB10QWd5fGdBnYe71YQYWaXBIx1XHUIUFx6i7Bs5Hln07PvRldnh%2BOSNnezwexQfMix2%2Fp02n59Un8vP2AdP9sY%2BeUmX4R9emvFOFqTrMDsP5XBV4w%2B%2Bc4%2B6zxL0HpOlYYxh9rvOOqIupd%2FwkEQ5URzqIGA0C0FRvDf90LHVgnZ00JAD2inUwrWT46t86faQY9qvYc6OiR2%2B4IM1OWhGDvmxb2iumxOLq%2Fkuawk%2FWdUYh%2BgYG%2FU%2BPM8gdXR3YP4G6EJDYP9jAYLMW9m%2FbojZuonup5o3y2%2FLha6pkJ4hxBVQNFKJaR1ZTGsMkmkRqsOnHLYvpVoExvtywJfFtWZTZwxLPHKKD9zc%2BK9yvTowYeQp5irplkoWLM1XshtaMIOaKibsdeQtmWa9IU%2ByBdvtB2jeOVJmgEYNPCFP6vgsmLbyXinHkkNzQNGpSUR%2FjpGrEq3KYlVnmKxq2x05Rn2zqiDuIXCB1J7kQB32zqHlK3RkyifMcnzGLCsKsI85QP8zB%2BCThzCNsCbC9Hr7Npvat6eUfZvQaxq3tO%2B%2BJz4MecpA0WkORQmwQ2rNt02AlrajigW9G0sy6gRBHjyCuHbuoxcHMw6H6SbZ%2FvOy7yMcCfRlGiOLG0JcQb8j61ZDiCBg0YE3qB8ZX%2BUZnvMGa5ZeGX7n3mBTZ5DBSxGrhdFsmEcYzFhxm8CO2phjWBraDKQsGrgSdOUH%2B0mCGaIseT4BmZRBBTMfMrBwls9EZpo3oeOI52vMUesxQmtadbPV%2BemH3AitoVQoQVaE1vCaDh%2BKOX11%2BCA4LW1qyR6AoWxLFpVQcIFDzniHFjgsR8kyHdNzsIE5CcDXVjZaA8YtZAnYUmrgFXUcrRlE4JWhZmhkifS6%2BZlt01k9syUSxGWw1U7GubuDqZBFYJXNXLmq8aA45kA0qlMe9Gd5gtAlGlVHkbp9wgHoTZMdxx6GG742mkYkmDkrwpI6nJK0rtsBbKtLZsmOIxLDiF43R51acTAdoIWb4DaOSYCEHpINO3HpPh6BJ26eFV2o5VJboExPF%2FjUckcQfi6oc%2FrCL5fVFbPP0uRnCJYpPEVxDERBHK3JGoUlVhlheZ%2BoKloG8YRe2EarVXyqJ25QzHy2Qs8WaB9GdzvTPuvWI%2B1v36%2F2EYKOaM%2FaP%2BGHIlJhSvzQae7Hj6kr6he1ajqZsMM%2Bkl5qqnsjxn1Mm6KCcanBTPM2mTDFg5nMgTvrA5hq%2BQACCJkw%2BdzY%2BbR5OEJH9saegClyQAVrdIB1Dy2oaZh8rwmyGFJ9CFNU8CssTVM4SGK4JqfY3itNTVGJb2%2BMKotQm9bvK0aolsuZptW6wEABQhWkJouplW%2FlaV6LHCtu1chSkC5Flbyigck18vUR%2BJKjefzK8j7LePWRe8J16EurFj%2BVuooqhxsKNZvWyTALV4Q%2FTcGcBhbZN%2BbPMc%2FFhlz%2BtFQrLZcSEW0OPsXKyHnAoLaDt6XzrqRk8NkCNhSENmAUo7eyXgTiyPiv77petiNQa%2FuVWVW5x3jKwKO0N%2BLGaQ0GM0WMuKT4KystbfPP7dzaeK%2FNpV2FPP0y5JGuf6TPlaTZJlknuyCeV9KOsdl4wYhi2NQdkHJrG2uDKTeuoRPoxD0QvB3d9kxu2J9%2BYBssrKL6PGkz4Hb2mJVtFA%2FQraXwkacdZyrvJn9ind%2BKS2r%2BxOYnsu9Y%2B4J4eTkw9NUDjtjNE%2B5cBwM30PeTnMFykZBe%2BsteOUoVl8rKXrGdMM9vd6TWcArho7eNFLiAVHXJMzXWAefyVo3irkqnrpxTS137Chk64vy%2FQNMKF%2Bk7sDxaUN0rN2nlKFUGIItHm8a9FOPRamfgUxV8gyFSwaxZbM0TUsrjFgcGSVOrY82uoxpHdpyBHm5ahfXMeQu3lLJwD3pKcDbS2MBBdI1zxW9t4KK8qcK2bFn1kVnve90NI%2BjObfnCiKEgOtn79jIMXIoYbWe7GllwQJFstK64Nsy3c6PFw7Mj3DS%2Ft0SUDdbj3AmqRaSmodxrB%2BDr%2FOeukwESTJlBThFT7iopZcIdniXvFOVeu1XFVUDsPCvVHoiNHUHFgGjCrbPaZkehX%2BOMAPndGon%2Fq7wDXDJ2J1jnITXp4PFu5DtetOSAvG3%2F6hfkKYhH5bH9CNTaculOB9uINA1p3O4HhAyBAickSjQpaqOcPHuGFTgXKbDHslt3PGJVSSWH9zyn9K79kRCZXkH7MZ9hZmhrEmydg4zRNsBr21xbsmeTXleVUTKSCbW6p2Uc7PfRkokXUXyWY7urtVWsFKrcSOoNnF88JeKWc98MjuMHdL%2F48fJl%2Btl6PDgPd5%2FvEHYFODS%2B57XzYBwXbZ54K0dIqH1%2BPvqO3VATpnn71r5oD8E2THxRjaqE8JIiHGkBa2u7Qcu5di4uFu2aQwW%2FrfiOSRRm28sdxfoy4xv9lk27NQ%2BX5YTb2zqbQg%2FNcTobAm7sOMH9yztznPBp9WPOxe3VT3Cj%2BX8%3D"></img>
