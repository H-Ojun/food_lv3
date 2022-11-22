![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

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
10. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다.
11. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다.

<img width="1129" alt="Screen Shot 2022-11-22 at 2 53 15 PM" src="https://user-images.githubusercontent.com/52265076/203235727-88efd323-3117-418d-b775-7b7c88efc6a0.png">


# 체크포인트
1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
4. Request / Response
5. Circuit Breaker
6. Gateway / Ingress

# Saga (Pub / Sub)
<img width="362" alt="Screen Shot 2022-11-22 at 3 04 54 PM" src="https://user-images.githubusercontent.com/52265076/203237333-39124826-bb4c-43f9-aac1-f0257a7138b5.png">
<img width="624" alt="Screen Shot 2022-11-22 at 3 02 32 PM" src="https://user-images.githubusercontent.com/52265076/203237083-25d0e227-a26c-45bd-a377-f5bc6e400ed5.png">
<img width="522" alt="Screen Shot 2022-11-22 at 3 01 55 PM" src="https://user-images.githubusercontent.com/52265076/203237051-3db65cde-40ad-4707-ad86-b71b45d1d46f.png">
<img width="404" alt="Screen Shot 2022-11-22 at 3 06 39 PM" src="https://user-images.githubusercontent.com/52265076/203237624-9c98a92b-890a-4977-90d7-597bedf2e373.png">
<img width="650" alt="Screen Shot 2022-11-22 at 3 02 51 PM" src="https://user-images.githubusercontent.com/52265076/203237094-c0892d20-62b6-4cbd-af74-af178afa47d1.png">
<img width="457" alt="Screen Shot 2022-11-22 at 3 02 10 PM" src="https://user-images.githubusercontent.com/52265076/203237072-f8704fb0-0b6a-474c-9196-e6b90ec4cd99.png">

# CQRS
<img width="706" alt="Screen Shot 2022-11-22 at 3 07 19 PM" src="https://user-images.githubusercontent.com/52265076/203237707-f3c54fc3-9827-4fb3-adf9-c3a84fcf5629.png">


# Compensation / Correlation
<img width="519" alt="Screen Shot 2022-11-22 at 3 14 07 PM" src="https://user-images.githubusercontent.com/52265076/203238776-4b7acafa-2065-41fa-aee0-562f6d68515a.png">
<img width="801" alt="Screen Shot 2022-11-22 at 3 12 02 PM" src="https://user-images.githubusercontent.com/52265076/203238574-004acbd7-4f2a-4ba7-a0d5-a248ebe35ad2.png">
<img width="663" alt="Screen Shot 2022-11-22 at 3 12 27 PM" src="https://user-images.githubusercontent.com/52265076/203238585-6eaf9161-010a-4805-b2cd-870150a83439.png">
<img width="465" alt="Screen Shot 2022-11-22 at 3 12 55 PM" src="https://user-images.githubusercontent.com/52265076/203238596-208bce6b-e9f9-450b-a1d1-500bcd061785.png">
<img width="665" alt="Screen Shot 2022-11-22 at 3 13 04 PM" src="https://user-images.githubusercontent.com/52265076/203238600-90287492-8d6c-48e6-a40f-c1398fc5fb3e.png">


# Request / Response
<img width="787" alt="Screen Shot 2022-11-22 at 3 15 11 PM" src="https://user-images.githubusercontent.com/52265076/203239190-f29b70b2-1904-4dbc-84d9-7d794f4a4d1d.png">
<img width="1061" alt="Screen Shot 2022-11-22 at 3 16 48 PM" src="https://user-images.githubusercontent.com/52265076/203239202-e2d2b1b7-603c-43f2-9a59-68e5a7fc44fe.png">


# Circuit Breaker
<img width="500" alt="Screen Shot 2022-11-22 at 3 21 19 PM" src="https://user-images.githubusercontent.com/52265076/203239888-4964c1d3-fcb9-4404-97ad-78767855ad54.png">
<img width="455" alt="Screen Shot 2022-11-22 at 3 21 47 PM" src="https://user-images.githubusercontent.com/52265076/203239900-1a3c5f6b-c9c4-4e51-a5e2-979f41187537.png">


# Gateway / Ingress
<img width="494" alt="Screen Shot 2022-11-22 at 3 23 14 PM" src="https://user-images.githubusercontent.com/52265076/203240111-d94f068a-80b5-46fa-8713-1edd760ab1e2.png">


# 추가사항 1 (결제 내역과 상태를 확인할 수 있다)
<img width="464" alt="Screen Shot 2022-11-22 at 3 09 55 PM" src="https://user-images.githubusercontent.com/52265076/203238160-62371fec-3787-4f70-b1c0-54d58fa869e9.png">

<img width="691" alt="Screen Shot 2022-11-22 at 3 07 37 PM" src="https://user-images.githubusercontent.com/52265076/203237781-6509723e-684a-4ea8-84bc-67dc7e56f1cb.png">


# 추가사항 2 (pick이 있는지 여부와 deliveryconfirm이 되었는지 확인할 수 있다)
<img width="467" alt="Screen Shot 2022-11-22 at 3 10 32 PM" src="https://user-images.githubusercontent.com/52265076/203238234-5c5d9052-5591-4b0e-a179-f44c269b1517.png">

<img width="736" alt="Screen Shot 2022-11-22 at 3 07 46 PM" src="https://user-images.githubusercontent.com/52265076/203237800-906b6c94-ac1b-4ec5-917c-05ab6b385543.png">

