<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MS Project - 고객 분석</title>
    <h1>MS Project - 고객 분석</h1>
    <h5>제작 : 201921288 정륜수</h5>
</head>
<body>
<form action="./result" method="post">
<div align="center">
    <h3>조건에 맞춰서 고객의 정보를 입력하세요.</h3>
    <hr>
    <br/>
    <h5>태어난 년도(ex. 2000)</h5>
    <input type="number" step="0.01" name="birth_year">
    <h5>최종 학력({Undergraduate, Postgraduate})</h5>
    <input type="text" name="education">
    <h5>결혼 여부({In couple( = Single,Divorced...), Alone (=Together,Married...)})</h5>
    <input type="text" name="marital_status">
    <h5>1년간 수입</h5>
    <input type="number" step="0.01" name="income">
    <h5>자녀 유무 ({No child, Has child})</h5>
    <input type="text" name="has_child">
    <h5>고객이 서비스를 위해 계정을 등록한 날(YYYY-MM-DD, ex. 2021년 11월 30일 -> 2021-11-30)</h5>
    <input type="text" name="dt_customer">
    <h5>고객의 마지막 구매 후 일 수</h5>
    <input type="number" step="0.01" name="recency">
    <h5>지난 2년간 고객이 불만을 제기한 여부(NO: 불만이 없다. YES: 불만이 있다.)</h5>
    <input type="text" name="complain">
    <hr>
    <h5>지난 2년 간 와인 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_wines">
    <h5>지난 2년 간 과일 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_fruits">
    <h5>지난 2년 간 고기류 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_meatProducts">
    <h5>지난 2년 간 생선류 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_fishProducts">
    <h5>지난 2년 간 간식 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_sweetProducts">
    <h5>지난 2년 간 사치품 구매량(금액)</h5>
    <input type="number" step="0.01" name="mnt_goldProduct">
    <h5>할인된 상품 구매한 수</h5>
    <input type="number" step="0.01" name="numDealsProduct">
    <hr>
    <h5>웹사이트를 통한 구매량(금액)</h5>
    <input type="number" step="0.01" name="numWebPurchases">
    <h5>카탈로그 통신 판매를 통한 구매량(금액)</h5>
    <input type="number" step="0.01" name="numCatalogePurchases">
    <h5>가게 방문을 통한 구매량(금액)</h5>
    <input type="number" step="0.01" name="numStorePurchases">
    <h5>웹사이트 방문량</h5>
    <input type="number" step="0.01" name="numWebVisitsMonth">
    <hr>
    <h5>지난 캠페인을 수락한 여부(NO: 수락하지 않았다, YES: 수락했다)</h5>
    <input type="text" name="response">
    <br/>
    <p></p>
    <input type="submit" value="고객 유형 출력하기">
    <p></p>
    <p></p>
</div>
</form>
</body>
<footer>
    <p>가톨릭대학교 데이터마이닝 수업 프로젝트 과제물</p>
    <p>담당 교수님 : 노상욱 교수님</p>
    <p>담당 조교님 : 박헌우 조교님</p>
</footer>
</html>