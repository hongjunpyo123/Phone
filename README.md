# Phone — 콘솔 기반 스마트폰 시뮬레이터

Java로 만든 텍스트(콘솔) 기반 스마트폰 시뮬레이션 프로그램입니다. 실행하면 박스 드로잉 문자로 그린 화면 위에서 인터넷, 메시지, 호텔 예약(야놀자 스타일), 은행, 미니게임, 설정 앱을 메뉴 형태로 이용할 수 있습니다. 사용자 데이터(계좌, 메시지, 예약 내역 등)는 전부 MySQL DB에 저장됩니다.

## 실행 흐름

1. 프로그램을 실행하면 모델명 / 사용자 이름 / 전화번호(11자리)를 입력받습니다.
2. 입력이 끝나면 메인 홈 화면(`Phone.mainPhone()`)이 뜨고, 아래 앱들을 번호/이름으로 선택해 들어갈 수 있습니다.

| 메뉴 | 설명 |
|---|---|
| `internet` | URL을 입력하면 시스템 기본 브라우저로 엽니다 (`Desktop.browse`) |
| `message` | 전화번호로 쪽지를 주고받는 채팅. 백그라운드 스레드가 1초 간격으로 새 메시지를 폴링합니다 |
| `yanolja` | 호텔(스터디룸/미팅룸/게스트룸) 예약 및 예약 조회 |
| `setting` | 현재 DB 접속 설정(url/username/password) 확인 및 `data/setting.txt` 편집 |
| `bank` | 계좌 개설, 송금, 거래내역 조회 |
| `game` | 코인샵 + 숫자야구 / 업다운 / 야바위 미니게임 (게임 코인은 은행 잔액으로 충전/환전) |
| `[1]` | DB 재연결 시도 |
| `[0]` | 휴대폰 재시작 (초기 등록 화면으로) |

화면 상단의 `signal: (○/X)`가 현재 DB 연결 상태를 나타내며, `ConnectingThread`가 백그라운드에서 1초마다 재연결을 시도합니다.

## 요구 사항

- JDK 17
- Gradle (wrapper 포함, `./gradlew`로 바로 실행 가능)
- MySQL 서버 (로컬 `localhost:3306` 기준)

## DB 설정

1. MySQL에 `phone` 데이터베이스를 만들고, `최종결과물/phoneDBdump.sql`을 임포트합니다.
   ```
   mysql -u root -p phone < 최종결과물/phoneDBdump.sql
   ```
   테이블 구성: `bank`(계좌/잔액), `hotel`(예약), `msg`(메시지), `transfer`(송금 내역).

2. 접속 정보는 프로젝트 루트의 `data/setting.txt`에서 관리됩니다 (앱 최초 실행 시 자동 생성).
   ```
   ------------DB setting---------------
   url:jdbc:mysql://localhost:3306/phone
   username:root
   password:
   -------------------------------------
   ```
   필요 시 이 파일을 직접 수정하거나, 앱 내 `setting` 메뉴에서 `[0] Edit File`로 열 수 있습니다(단, `Tools.runFile`이 `cmd /c start`를 사용하므로 **Windows 전용**이며 macOS/Linux에서는 동작하지 않습니다 — 텍스트 에디터로 직접 열어서 수정하면 됩니다).

   > 참고: `FileIO.createFile()`은 `data/` 폴더가 이미 존재하면 파일 쓰기 로직 자체를 건너뛰는 버그가 있습니다. 폴더는 있는데 `setting.txt`만 지워진 경우 자동으로 재생성되지 않으니, 그럴 땐 위 내용을 수동으로 다시 만들어주세요.

## 빌드 & 실행

```bash
# 컴파일만
./gradlew compileJava

# 테스트 제외 빌드
./gradlew build -x test

# 실행 (Gradle이 의존성 클래스패스를 자동으로 구성)
./gradlew run
```

### 배포용 단일 jar (Shadow)

일반 `./gradlew jar`로 만든 jar는 MySQL 드라이버 등 의존성이 포함되지 않아 `java -jar`로 단독 실행하면 DB 연결이 실패합니다. 의존성까지 합쳐진 실행 가능한 jar가 필요하면:

```bash
./gradlew shadowJar
java -jar build/libs/java-project-1.0-all.jar
```

## 프로젝트 구조

```
src/com/project/phone/
├── main/       Phone.java — 진입점, 메인 메뉴 루프
├── database/   Connecting(JDBC 커넥션/쿼리 헬퍼), DBsetting(접속 정보 홀더)
├── file/       FileIO — data/setting.txt 생성·읽기
├── internet/   Internet — URL을 브라우저로 여는 기능
├── message/    Message — 쪽지 전송, ChatThread와 연동
├── bank/       Bank, CreateAccount, Money, SendMoney, TransferHistory
├── hotel/      Hotel, Room(추상 클래스), StudyRoom/MeetingRoom/GuestRoom, Reservation, Inquiry
├── game/       Game, Coin(코인샵), Baseball(숫자야구), Updown, Yabawi(야바위)
├── setting/    Setting — DB 설정 화면
├── thred/      ChatThread(메시지 폴링), ConnectingThread(DB 재연결 폴링)
└── util/       Tools — 화면 클리어, 입력버퍼 flush, 대기, 랜덤 유틸 등 공용 함수
```

`최종결과물/`에는 과제 제출용 구현 보고서(PDF), DB 덤프(`phoneDBdump.sql`), 미리 빌드된 jar가 들어있습니다.

## 기술 스택

- Java 17
- Gradle (`application` + `com.gradleup.shadow` 플러그인)
- MySQL / JDBC (`com.mysql:mysql-connector-j`)
- 순수 `java.util.Scanner` 기반 콘솔 UI
