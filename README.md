# OOP, Refactoring, TDD 연습하기

이 프로젝트는 아래 글에서 설명하는 것을 중심으로 진행한다.

[효과적으로 TDD, 리팩토링, OOP를 연습하는 방법은? (medium)](https://medium.com/@codesquad_yoda/효과적으로-tdd-리팩토링-oop를-연습하는-방법은-7ecc9ddb5d45)

위 글에서는 
1. 요구사항이 명확하고
2. 의존 관계가 없으며
3. 어느정도 복잡성이 존재하는 프로그램
을 작성할 것을 권장하는데, 이에 부합하는 예시는 아래와 같다.

- 로또 (단, UI는 콘솔)
- 사다리 타기 (단, UI는 콘솔)
- **볼링 게임 점수판** (단, UI는 콘솔)
- 체스 게임 (단, UI는 콘솔)
- 지뢰 찾기 게임 (단, UI는 콘솔)

그 중에서도, 여기서는 **볼링 점수판 만들기**를 구현 해 보도록 한다. 


### 볼링 점수판 명세
아래의 명세는 반드시 구현해야 하는 것들이다.
팀원들의 합의에 의해 구현 사항이 **추가**되거나 **변경**될 수 있으며, 
이는 모든 구현체가 **반드시** 따라야 한다.

[추가 바람]
1. 모든 명령은 콘솔 창을 통해 입력된다.
2. UI는 없으며, 점수판은 콘솔 창을 통해 출력된다.
3. 


### 학습 방법
1. 이 repository를 fork 한다. 루트 디렉토리에 자신의 프로젝트를 생성한다.
2. 위에 명시된 볼링 점수판의 기능 명세 및 유스케이스에 부합하는 각자의 볼링 점수판을 구현한다.
3. commit -> push -> pull request 
4. **다른 사람의 코드 리뷰를 받는다.** 
5. 2.로 돌아가 반복한다. 


### 주의사항
1. 한 사람당 하나의 프로젝트를 구현한다.
2. 명세 이외의, 강요하거나 반드시 지켜야 하는 것은 없다. 본인의 필요에 맞게 구현하면 된다.  
3. 명시적으로 정해진 기간 역시 존재하지 않는다. 단, 그래도 열심히 해주면 그만큼 실력이 늘지 않을까...?
4. 일주일에 하루는 정기적으로 미팅을 가진다. (추후 논의)
5. 이 문서는 누구라도 수정이 가능하다.

### 권장사항
1. Commit 메시지를 상세히 적자.
2. Commit을 기능 단위, 코드 단위로 자주 하자.
3. 다른 사람의 구현체를 자주, 그리고 많이 읽어보자. 
4. 다른 사람의 구현체에 PR을 날리는 것 역시 권장된다.
5. 꾸준히 하자. 하루에 한 번 이상 한 줄이라도 코드를 작성해보자. 


### 개발환경 
반드시 아래의 환경을 지켜야 하는 것은 아니다. 
본인이 가장 자신있거나, 연습하고 싶은 언어/환경에서 연습을 진행해도 무방하다.

단, 다른 사람의 원활한 코드 리뷰를 위해 [JSFuck](https://namu.wiki/w/JSFuck) 같은 난해한 프로그래밍 언어는 자제하도록 하자. 

[JAVA]
Java, Junit 5, Gradle, Lombok(Optional)
Lombok 정도는 애교로 봐주자.

[JavaScript]
Javascript, Typescript(Optional), Jest

[ETC]
추가 바람.


### 참고서적 및 페이지
1. [클린 소프트웨어](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791185890852&orderClick=LEA&Kc=)
2. [테스트 주도 개발](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966261024&orderClick=LAH&Kc=)
3. [리팩토링](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788979149715&orderClick=LAH&Kc=)
4. [클린 코드](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966260959&orderClick=LEA&Kc=)
5. [JAVA 언어로 배우는 디자인패턴 입문](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788931436914&orderClick=LAH&Kc=)
6. [이펙티브 자바 3/E](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966262281&orderClick=LAH&Kc=)
7. [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
추가 바람.





