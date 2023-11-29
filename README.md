## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---

## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---

1. 피드백 강의 전까지 미션 진행

> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---

2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---

3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 객체지향 생활 체조 원칙

1. 한 메서드에 오직 한 단계의 들여쓰기만 한다.
2. else 예약어를 쓰지 않는다.
3. 모든 원시 값과 문자열을 포장한다.
4. 한 줄에 점을 하나만 찍는다.
5. 줄여 쓰지 않는다(축약 금지).
6. 모든 엔티티를 작게 유지한다.
7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
8. 일급 컬렉션을 쓴다.
9. getter/setter/프로퍼티를 쓰지 않는다.

----

## 2단계 - 문자열 계산기

- 사용자가 입력한 **문자열** 값에 따라 ***사칙연산을 수행***할 수 있는 **계산기**를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    - 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 `10`을 출력해야 한다.

### 객체 분해

#### 계산기(Calculator)

- 더하기 : 숫자 두 개를 입력받아, 더한 값을 반환한다.
- 빼기 : 숫자 두 개를 입력받아, 뺀 값을 반환한다.
- 곱하기 : 숫자 두 개를 입력받아, 곱한 값을 반환한다.
- 나누기 : 숫자 두 개를 입력받아, 나눈 값을 반환한다.

#### 수식 분해자(Disassembler)

- 수식을 입력받아 숫자와 수식으로 나눈다.
- 분해결과는 숫자의 갯수가 항상 수식의 갯수보다 1개 더 많아야한다.

#### 숫자(Number)

- 정수 타입

##### 숫자들(Numbers)

- Number 리스트

#### 수식(Expression)

- `+`,`-`,`*`,`/` 로만 입력을 받을 수 있다.

##### 수식들(Expressions)

- Expression 리스트

----

## 3단계 - 숫자야구게임 구현

### 기능 요구사항
> 기본적으로 `1` 부터 `9` 까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

#### 기본 룰
- 스트라이크(strike) : 같은 수, 같은 자리
- 볼(ball) : 같은 수, 다른 자리
- 낫싱(nothing) : 다른 수
  - e.g. : 상대방(컴퓨터)의 수가 `425` 일 때,
    - `123`을 제시한 경우 --> 1 스트라이크
    - `456`을 제시한 경우 --> 1 볼 1 스트라이크
    - `789`을 제시한 경우 --> 낫싱

#### 요구사항
- 상대방의 역할은 컴퓨터가 한다. 컴퓨터는 1 ~ 9 의 서로 다른 임의의 수를 3개 선택한다.
- 게임 플레이어는 컴퓨터가 생성한 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 과정을 반복해 컴퓨터가 선택한 3 개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

EX)
```text
숫자를 입력해 주세요 : 123
1볼 1스트라이크
숫자를 입력해 주세요 : 145
1볼
숫자를 입력해 주세요 : 671
2볼
숫자를 입력해 주세요 : 216
1스트라이크
숫자를 입력해 주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해 주세요 : 123
1볼 1스트라이크
…
```

### 객체 분해

#### 공(Ball)
- 위치와, 그 위치에 해당하는 1 ~ 9 의 숫자를 할당받을 수 있는 객체

#### 공들(Balls)
- 공(Ball) 3개를 갖고 있는 객체

#### 리포터(Reporter)
- 사용자 입력값과 상대방의 수를 비교하여 결과를 반환해주는 객체

#### 볼 상태(BallStatus)
- STRIKE, BALL, NOTHING 을 표현하는 enum 객체
