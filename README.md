# SimpleOrderManipulator
간단한 주문 처리기

##Repository
전략 패턴으로 실제 IO를 수행하는 Datablock 을 주입받아 쿼리들을 처리합니다

##Service
Repository 를 주입받아 내부 로직을 수행합니다.
Queue 를 주입 받아 주문을 캐싱합니다

##Main.java
커맨드라인을 파싱해서 Service에 넘겨주고 Order 객체로 돌려받아 결과를 출력합니다


