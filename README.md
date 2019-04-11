# OOP, Refactoring, TDD 연습하기

![bowling](https://sc-events.s3.amazonaws.com/4250633/main.jpg)

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

---
---

## 볼링 점수판 1차 명세
여기에 작성된 명세는 모든 구현체가 **반드시** 따라야 한다.

팀원들의 합의에 의해 구현 사항이 **추가**되거나 **변경**될 수 있으며, 
명세가 최종 확정된 후에 발생하는 변경사항은 다음 구현 차수에 반영하도록 한다.     


### 명세
![score-example](https://mblogthumb-phinf.pstatic.net/20130630_30/lifesewon_1372584267266CBgk9_JPEG/%BA%BC%B8%B5%C1%A1%BC%F6_%282%29.jpg?type=w2)

[추가 바람 - 최종 명세 확정 후에 1차 구현 진행]
- 볼링 점수판은 위와 같은 점수판을 콘솔에 표현한다.
- 표준 볼링 룰을 따라서 점수판을 구현한다.
- 모든 명령은 콘솔 창을 통해 입력된다.
- UI는 없으며, 점수판은 콘솔 창을 통해 출력된다.
 

### 유스케이스

#### `$ init`
- 게임이 진행중(입력한 점수가 하나라도 있는 경우)인 경우

    `Are you sure? All changes are discarded. (Y/N)` 등의 경고문을 띄우며, 사용자의 입력에 따라 점수판 초기화 결정

- 진행중이 아닌 경우 

    경고문 없이 바로 초기화

초기화 이후 유저 등록 과정이 진행 됨.
```
$ init
----> Are you sure? All changes will be discarded. (Y/N)
Yes
----> Input player names, when you finished, input "@DONE"
JaeEun
Gil-dong
Computer
@DONE
----> Now, Game Start.
----> Frame 1.
$ add Gil-dong 3 8
```

#### `$ init -f` 
게임 진행 유무에 관계없이, 경고문 없이 바로 초기화
 
#### `$ init <other illegal options..>`
예외 발생 


#### `$ show`
현재까지 입력된(진행된) 모든 유저의 점수 기록(점수판)을 보여준다. 

#### `$ show winner`
경기가 종료되었다면, 승자가 누구인지 나타낸다.

- 한 명인 경우
    
    예외 발생 

- 두 명 이상인 경우

    모든 User 이름 및 점수 표시 후 최종 승자에게 강조

- 경기가 종료되지 않은 경우

    예외 발생 

#### `$ show <user>`
해당 user의 점수판을 보여준다.

#### `$ show <user> <frame>`
해당 user의 해당 frame 점수를 보여준다.

#### `$ show <unknown user>`
예외 발생

#### `$ show <unknown command>`
예외 발생  

#### `$ add <user> <first-hit>` 
`<user>`의 현재 Frame에 점수 추가함. 
이 Command로 인해 현재 Frame이 종료가 되면, 자동으로 다음 Frame으로 넘어간다.

- 마지막 Frame 인 경우

    [추가 바람.]

- 마지막 Frame이 아닌 경우
    
    [추가 바람.]

- `<???-hit>`의 값이 `[1-9], -, X`가 아닌 경우 
    
    예외 발생 

#### `$ add <user> <first-hit>`


#### `$ add <user> <first-hit> <second-hit>`

#### `$ add <user> <first-hit> <second-hit>`

#### `$ add <user> <first-hit> <second-hit> <third-hit>`

#### `$ <unknown command>`
예외 발생

----

더 추가할 수 있는 Command
#### `$ edit`
점수 수정

#### `$ reset`
#### `$ help`
사용 가능한 Command 목록 

#### `$ show <user> <from-frame> <to-frame>`
특정 유저의 특정 프레임만 점수판 rendering 

#### `$ sum <user> <from-frame> <to-frame>`
점수 합 



---
---

## 학습 방법
1. 이 repository를 fork 한다. 루트 디렉토리에 자신의 프로젝트를 생성한다.
2. 위에 명시된 볼링 점수판의 기능 명세 및 유스케이스에 부합하는 각자의 볼링 점수판을 구현한다.
3. commit -> push -> pull request 
4. **다른 사람의 코드 리뷰를 받는다.** 
5. 2.로 돌아가 반복한다. 


## 주의사항
1. 한 사람당 하나의 프로젝트를 구현한다.
2. 명세 이외의, 강요하거나 반드시 지켜야 하는 것은 없다. 본인의 필요에 맞게 구현하면 된다.  
3. 명시적으로 정해진 기간 역시 존재하지 않는다. 단, 그래도 열심히 해주면 그만큼 실력이 늘지 않을까...?
4. 일주일에 하루는 정기적으로 미팅을 가진다. (추후 논의)
5. 이 문서는 누구라도 수정이 가능하다.
6. OOP와 TDD, Refactoring을 학습하는 것이지, 기타 Git, Build 도구 등을 학습하는 것이 아니므로 
Git branch 전략등은 본인의 입맛대로 정하면 된다. (master 하나에 다 때려박아도 무방하다) 
물론 프로그램을 구현하며 추가적으로 학습하는 것은 매우 권장된다. 



## 권장사항
0. 정해진 기간은 없으나, 각자 기간을 정해두고 작업을 해보자. 
전체 프로그램 기간을 정하기가 어렵다면, 각 기능별로 데드라인을 정해보는 것도 좋다. 
중요한 것은 **데드라인**이 있는지의 여부이다. 데드라인을 정해놓지 않고 작업을 하다보면, 흐지부지 끝나버릴 확률이 높다.
1. Commit 메시지를 상세히 적자.
2. Commit을 기능 단위, 코드 단위로 자주 하자.
3. 다른 사람의 구현체를 자주, 그리고 많이 읽어보자. 
4. 다른 사람의 구현체에 PR을 날리는 것 역시 권장된다.
5. **꾸준히 하자.** 하루에 한 번 이상 한 줄이라도 코드를 작성해보자.
6. TDD를 실천해보자. (참고서적 2. 참고) 
7. 아래의 객체지향 체조를 실천해보자.
8. [SOLID](https://en.wikipedia.org/wiki/SOLID)를 적용해보자.
9. 디자인 패턴을 적용해보자. 



## [객체지향 체조](https://developerfarm.wordpress.com/2012/02/03/object_calisthenics_summary/)
### [1단계]
규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.

규칙 2: else 예약어를 쓰지 않는다.

(+) 메소드의 라인 수를 10라인을 넘지 않는다.

### [2단계]
규칙 3: 모든 원시값과 문자열을 포장한다.

규칙 6: 모든 엔티티를 작게 유지한다.

규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

규칙 8: 일급 콜렉션을 쓴다.

### [3단계]
규칙 4: 한 줄에 점을 하나만 찍는다.

규칙 5: 줄여쓰지 않는다 (축약 금지).

규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

3단계까지 한 번에 시도해도 좋고, 반복적으로 프로그램을 구현하며 점점 단계를 높여가도 무방하다.  




## 개발환경 
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


## 참고서적 및 페이지
1. [클린 소프트웨어](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791185890852&orderClick=LEA&Kc=)
2. [테스트 주도 개발](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966261024&orderClick=LAH&Kc=)
3. [리팩토링](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788979149715&orderClick=LAH&Kc=)
4. [클린 코드](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966260959&orderClick=LEA&Kc=)
5. [JAVA 언어로 배우는 디자인패턴 입문](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788931436914&orderClick=LAH&Kc=)
6. [이펙티브 자바 3/E](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788966262281&orderClick=LAH&Kc=)
7. [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
8. [성공하는 프로그래밍 공부법](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788997924417&orderClick=LEA&Kc=)
추가 바람.

git 활용 방법, commit message 작성 요령, given-when-then, 3A, 무엇을 테스트할 것인가? Code convention




