![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# LV3 통합실습 및 결과 제출
# 주제
배달의 민족 마이크로서비스 분석/설계, 구현, 배포/운영

# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
2. 고객이 선택한 메뉴에 대해 결제한다.
3. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
4. 상점주는 주문을 수락하거나 거절할 수 있다.
5. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.
6. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.
7. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.
8. 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
9. 고객이 주문상태를 중간중간 조회한다.
10. 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.

<img width="1129" alt="Screen Shot 2022-11-22 at 2 53 15 PM" src="https://user-images.githubusercontent.com/52265076/203235727-88efd323-3117-418d-b775-7b7c88efc6a0.png">


# L3 평가를 위한 체크포인트
# Microservice Implementation
1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
# Microservice Orchestration
1. Deploy to EKS Cluster
2. Gateway & Service Router 설치
3. Autoscale (HPA)

# Saga (Pub / Sub)
상황1 : 주문 상태가 변하면 OrderList에 Sync해준다.

<img width="362" alt="Screen Shot 2022-11-22 at 3 04 54 PM" src="https://user-images.githubusercontent.com/52265076/203237333-39124826-bb4c-43f9-aac1-f0257a7138b5.png">
<img width="624" alt="Screen Shot 2022-11-22 at 3 02 32 PM" src="https://user-images.githubusercontent.com/52265076/203237083-25d0e227-a26c-45bd-a377-f5bc6e400ed5.png">
<img width="522" alt="Screen Shot 2022-11-22 at 3 01 55 PM" src="https://user-images.githubusercontent.com/52265076/203237051-3db65cde-40ad-4707-ad86-b71b45d1d46f.png">

상황2 : OrderList에 주문이 추가될시 자동으로 결제된다.

<img width="404" alt="Screen Shot 2022-11-22 at 3 06 39 PM" src="https://user-images.githubusercontent.com/52265076/203237624-9c98a92b-890a-4977-90d7-597bedf2e373.png">
<img width="650" alt="Screen Shot 2022-11-22 at 3 02 51 PM" src="https://user-images.githubusercontent.com/52265076/203237094-c0892d20-62b6-4cbd-af74-af178afa47d1.png">
<img width="457" alt="Screen Shot 2022-11-22 at 3 02 10 PM" src="https://user-images.githubusercontent.com/52265076/203237072-f8704fb0-0b6a-474c-9196-e6b90ec4cd99.png">

# CQRS
OrderPlace, Paid, OrderAccept, OrderReject, OrderStart, OrderFinish, Pick 와 같이 주문 상태가 변하는지 확인할 수 있다.

<img width="291" alt="Screen Shot 2022-11-22 at 3 40 10 PM" src="https://user-images.githubusercontent.com/52265076/203242856-cdbb9d60-c6b7-40d4-876e-8d6cb049aeb8.png">

<img width="706" alt="Screen Shot 2022-11-22 at 3 07 19 PM" src="https://user-images.githubusercontent.com/52265076/203237707-f3c54fc3-9827-4fb3-adf9-c3a84fcf5629.png">


# Compensation / Correlation
주문하면 아래와 같이 payment에 저장된다. (추가사항 기능으로 payInfo로 확인하였다)

<img width="801" alt="Screen Shot 2022-11-22 at 3 12 02 PM" src="https://user-images.githubusercontent.com/52265076/203238574-004acbd7-4f2a-4ba7-a0d5-a248ebe35ad2.png">
<img width="663" alt="Screen Shot 2022-11-22 at 3 12 27 PM" src="https://user-images.githubusercontent.com/52265076/203238585-6eaf9161-010a-4805-b2cd-870150a83439.png">

주문을 취소하면 payment의 cancel 값이 true가 되어 주문이 취소된다.

<img width="465" alt="Screen Shot 2022-11-22 at 3 12 55 PM" src="https://user-images.githubusercontent.com/52265076/203238596-208bce6b-e9f9-450b-a1d1-500bcd061785.png">
<img width="665" alt="Screen Shot 2022-11-22 at 3 13 04 PM" src="https://user-images.githubusercontent.com/52265076/203238600-90287492-8d6c-48e6-a40f-c1398fc5fb3e.png">

실제 코드 내역이다.

<img width="519" alt="Screen Shot 2022-11-22 at 3 14 07 PM" src="https://user-images.githubusercontent.com/52265076/203238776-4b7acafa-2065-41fa-aee0-562f6d68515a.png">


# Deploy to EKS Cluster



# Gateway & Service Router 설치



# Autoscale (HPA)


