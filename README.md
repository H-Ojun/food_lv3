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
OrderList에 주문이 추가될시 자동으로 결제된다.
 - http POST http://a586855b3d92a4ee1883af449339c6ec-100010375.eu-west-3.elb.amazonaws.com:8080/orderLists foodId="1" address="1" status="order" customerId="1" 실행 상태
 
![자동결제](https://user-images.githubusercontent.com/52265076/218928921-ea595fb8-8eaf-49e7-8199-179ffc15b5e7.PNG)

구현 코드이다.
![pub_sub1](https://user-images.githubusercontent.com/52265076/218935449-140db6e6-797b-453a-809d-2e512a196821.PNG)
![pub_sub2](https://user-images.githubusercontent.com/52265076/218935453-80513604-72ff-40e5-b1d9-d06ee686561b.PNG)
![pub_sub3](https://user-images.githubusercontent.com/52265076/218935454-9ecfcd38-4872-4192-8d92-c7ec0fc61a3c.PNG)


# CQRS
OrderPlace, Paid, OrderAccept, OrderReject, OrderStart, OrderFinish, Pick 와 같이 주문 상태가 변하는지 확인할 수 있다.

![cqrs_1](https://user-images.githubusercontent.com/52265076/218929427-a3703f2d-53f0-4487-a62b-32f37b04268f.PNG)

![cqrs_2](https://user-images.githubusercontent.com/52265076/218929449-20ebaddf-2d9e-47c5-8ccc-89f9f4539957.PNG)

![cqrs_3](https://user-images.githubusercontent.com/52265076/218929475-c552d1c4-9b74-4ac9-95b0-2b2a0dcf54ba.PNG)

구현 코드이다.
![cqrs_image1](https://user-images.githubusercontent.com/52265076/218935423-35741eab-844b-4aae-aac2-105475897a77.PNG)
![cqrs_image2](https://user-images.githubusercontent.com/52265076/218935438-6910416a-d6cc-4112-9319-e8406ae1a530.PNG)
![cqrs_image3](https://user-images.githubusercontent.com/52265076/218935441-cd7d7983-97e0-46d7-af70-3b72bb691db7.PNG)
![cqrs_image4](https://user-images.githubusercontent.com/52265076/218935446-b0a7ea60-bd8e-43b7-b629-9dd9d91f0ac6.PNG)


# Compensation / Correlation
주문 상태이다.
orderId 1의 cancel 값이 false 인 것을 알 수 있다.

![주문1](https://user-images.githubusercontent.com/52265076/218929805-da8c727e-284e-42f2-9bb0-dc126d49cc6d.PNG)

![결제상태_처음](https://user-images.githubusercontent.com/52265076/218929875-631987ae-e715-4409-ac91-fa3777380bad.PNG)

주문을 취소하면 orderId 1의 cancel 값이 true가 되어 주문이 취소된다.

![주문1취소](https://user-images.githubusercontent.com/52265076/218929815-7f7f0376-0523-427e-b25b-769fa61a2c7b.PNG)

![결제상태_취소](https://user-images.githubusercontent.com/52265076/218929883-90200750-43d8-44d0-9fff-bc92a5687233.PNG)


# Deploy to EKS Cluster
AWS에서 user19-eks의 Cluster Nodes 를 가져온다.

![eks_cluster](https://user-images.githubusercontent.com/52265076/218930261-590f00fe-38dd-47d3-8bf9-ea48e0bc664e.PNG)

gitPod에서 kubectl로 확인된 AWS Node이다.

![eks_cluster2](https://user-images.githubusercontent.com/52265076/218930272-34838afa-312c-4506-8207-9bc2928c8f67.PNG)

helm을 사용해 Kafka를 설치한 상태이다.

![eks_cluster3](https://user-images.githubusercontent.com/52265076/218930277-70b36a42-de80-45b1-af13-ffc3beed0f87.PNG)


# Gateway & Service Router 설치
customer, gateway, order, rider, store 서비스를 설치한 상태이다.

![gateway_service_router](https://user-images.githubusercontent.com/52265076/218930756-5102de3e-dbdb-4d8e-97d9-c86473b064ee.PNG)


# Autoscale (HPA)
autoscale 설정한 상태의 모습이다.

![autoscale](https://user-images.githubusercontent.com/52265076/218930977-b9037a5e-3fae-4b76-baeb-f2d101ebb6b0.PNG)

siege -c20 -t40S -v http://order:8080/orderLists 를 활용해
autoscale이 동작하는 모습이다.

![autoscale2](https://user-images.githubusercontent.com/52265076/218930987-520b5747-df75-4db6-924a-324614e48c49.PNG)
