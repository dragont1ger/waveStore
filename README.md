# Project Wave

## 📢 프로젝트 개요 (Overview)

**Project Wave**는 사용자들이 안전하고 편리하게 중고 거래를 할 수 있는 웹 플랫폼입니다. 판매자와 구매자는 실시간으로 상품 정보를 확인하고, 원활한 거래를 진행할 수 있습니다. 소셜 로그인 및 안전한 결제 시스템을 통해 신뢰 기반의 거래 환경을 제공합니다.

- **주요 목표**:
  - 안전하고 신뢰성 있는 중고 거래 환경 제공
  - 채팅 및 원활한 상품 검색 기능 제공
  - 사용자 인증을 위한 소셜 로그인 시스템 구현
  - 안전한 결제 시스템 도입

- **주요 기능**:
  - 상품 등록 및 검색
  - 채팅
  - 결제 시스템
  - 회원 관리 (회원 가입, 로그인, 프로필 관리)
  - 소셜 로그인 (Google, Kakao)

### **📆**프로젝트 기간

2025.01.16 ~ 2025.02.20

## 📌 기술 스택 (Tech Stack)

- **프론트엔드**: HTML, CSS, JavaScript, Thymeleaf
- **백엔드**: Java, Spring Boot, JPA
- **데이터베이스**: Oracle
- **보안**: JWT (JSON Web Token), OAuth2 (소셜 로그인), BCrypt 암호화
- **빌드 도구**: Gradle


## 📌 데이터 흐름 (Data Flow)
사용자가 로그인 요청을 보냄 → Controller가 요청을 받음
Service 계층이 비즈니스 로직 처리 → Repository에서 DB 조회
DB에서 데이터 반환 후, 응답 생성 → Controller에서 JSON 형태로 반환

[Client] -> [Controller] -> [DTO] -> [Service] -> [Entity] -> [Repository] -> [Database]
                     ↳ [Config] (Security, Password Encoding, JWT)



## ✅ 기대 효과 (Expected Benefits)
- 안전한 중고 거래 환경 제공 (소셜 로그인, 결제 시스템 도입)
- 사용자 경험(UX) 개선을 위한 채팅 및 검색 기능 제공
- 확장성 고려 (추후 모바일 앱 연동 및 기능 확장 가능)
- MVC(Model-View-Controller) 패턴 기반 설계
- RESTful API를 활용한 백엔드 & 프론트엔드 통신

## 📌 프로젝트 구조 (Project Structure)

```plaintext
project-wave
├── 📂 src/main/java/org/example/store
│     ├── 📂 chat              # 채팅 관련 로직
│     ├── 📂 chatRoom          # 채팅방 관리 기능
│     ├── 📂 follow            # 팔로우 기능
│     ├── 📂 like_product      # 상품 찜하기 기능
│     ├── 📂 member            # 회원 관련 기능 (로그인, 회원가입 등)      
│     ├── 📂 memberReview      # 회원 리뷰 기능
│     ├── 📂 payment           # 결제 기능
│     ├── 📂 shop              # 쇼핑몰 관련 기능
│     ├── 📂 social            # OAuth2 기반 소셜 로그인
│     ├── 📂 utils             # 공통적으로 사용하는 유틸리티 클래스
│
├── 📂 src/main/resources
│     ├── 📂 static            # 정적 리소스 (CSS, JS, 이미지)
│     ├── 📂 templates         # Thymeleaf 템플릿 (HTML 뷰)
│     ├── 📄 application.yml   # 환경 설정 파일
│
├── 📂 test                     # JUnit을 활용한 테스트 코드
├── 📄 build.gradle             # 프로젝트 빌드 설정
├── 📄 README.md                # 프로젝트 문서

```

## 🎯 구현 결과
메인 페이지
![메인](https://github.com/user-attachments/assets/5784f8bc-0be5-450b-83f5-1834d7a2aacf)
1. **카테고리 및 검색 기능**
    - 사용자가 원하는 상품을 찾을 수 있도록 **카테고리 필터**와 **검색창**이 제공됨.
2. **핵심 기능 버튼**
    - **채팅 버튼** : 판매자와 구매자가 소통할 수 있도록 지원.
    - **판매 버튼** : 사용자가 직접 상품을 등록하여 판매할 수 있도록 하는 기능.
3. **추천 상품 목록**
    - **최근 등록된 판매 상품**들이 이미지와 함께 표시됨.
    - 사용자에게 인기 있거나 관심 가질 만한 상품을 추천하는 역할
  
      
로그인 페이지
![로그인](https://github.com/user-attachments/assets/c6d4bf84-0f69-4904-84cd-5da6565a37c5)
1. **로그인 필수 조건**
    - 로그인을 하지 않으면 **판매 및 구매 기능을 이용할 수 없음.**
    - 즉, 사용자 계정이 있어야만 거래가 가능하도록 제한됨.
2. **회원가입 기능**
    - **회원이 아닐 경우** 회원가입 버튼을 눌러 **가입 페이지로 이동** 가능.
    - 신규 사용자가 쉽게 가입할 수 있도록 유도.
3. **소셜 로그인 지원**
    - 일반적인 **아이디/비밀번호 로그인** 외에도 **소셜 로그인 기능** 제공.
    - 사용자는 **구글, 카카오 외부 계정을 연동하여 간편 로그인** 가능.

상품 등록 페이지
![상품등록](https://github.com/user-attachments/assets/96e533c6-5d70-4ea7-becf-b4dcb2a1c4b5)
1. **상품 이미지 업로드**
    - **최대 7장**까지 상품 이미지를 업로드할 수 있음..
2. **상품 정보 설정**
    - **상품명** : 상품의 이름을 설정할 수 있음.
    - **가격** : 상품의 가격을 설정할 수 있음.
    - **카테고리** : 상품의 카테고리를 선택할 수 있음.
    - **상품 상태** : 새 상품인지, 중고 상품인지를  설정할 수 있음.
    - **직거래 장소** : 상품을 직거래할 장소를 설정할 수 있음.

상품 상세 페이지
![KakaoTalk_20250217_120950124 (1)](https://github.com/user-attachments/assets/b2030ab7-bbb6-4660-97c1-5aee9cfde7ed)
1. **상품 등록 시간 표시**
    - 등록일 기준으로 **몇 분 전**에 상품이 올라왔는지 표시됨.
2. **판매자 상점 정보**
    - 판매자의 **팔로워 수**와 **이전 판매 목록**을 조회할 수 있는 기능 제공.
    - 판매자의 활동을 확인하고 신뢰도를 높일 수 있음.
3. **찜 기능**
    - 사용자가 관심 있는 상품을 **찜**할 수 있는 기능 제공.
4. **채팅 걸기**
    - **채팅 버튼**을 통해 판매자와 구매자가 직접 소통할 수 있음.
5. **바로 구매 버튼**
    - 구매자가 **바로 구매**할 수 있는 기능 제공, 간편한 구매를 돕는 역할.

결제 페이지
![KakaoTalk_20250217_121015842](https://github.com/user-attachments/assets/291e05ac-564b-4e86-97a3-8c4c3283f44b)
1. **결제 금액 표시**
    - 총 결제 금액이 페이지 상단에 표시됨, 사용자가 결제할 금액을 확인할 수 있음.
2. **결제 방법 선택**
    - **카드 결제, 계좌이체, 토스페이, 페이코, 카카오페이, 네이버페이, 휴대폰 결제**와 같은 다양한 결제 방법을 선택할 수 있음.
3. **이용 약관 및 개인정보 처리 동의**
    - **결제 서비스 이용 약관**과 **개인정보 처리 동의**에 대한 필수 체크박스가 제공됨.
    - 사용자가 해당 항목을 동의해야만 결제를 진행할 수 있음.
  

## 📌 향후 개선 사항 (Future Improvements)
1. 회원 등급 시스템 도입 및 포인트 적립 기능
    - 회원 활동에 따라 등급을 나누고, 활동에 따른 포인트를 적립하여 혜택을 제공하는 시스템.
    
2. 모바일 앱 개발
    - 웹 플랫폼에 대한 접근성을 높이고, 모바일 환경에서도 원활히 이용할 수 있도록 앱 개발.
    
3. 탈퇴 회원 데이터 자동 백업 및 복구 기능 추가 또는 일정 기간 후 완전 삭제
    - 탈퇴한 회원의 데이터를 일정 기간 동안 자동 백업하고, 그 기간 이후에는 데이터 삭제.
    - 데이터 보안과 개인정보 보호를 고려한 방안이 필요하며, 복구 시스템이 필요할 수 있음.

  
## 📌 개발 환경 설정 (Setup Instructions)
프로젝트 클론 (Clone the repository)
```plaintext
git clone https://github.com/dragont1ger/waveStore.git
```

빌드 도구 설정
build.gradle 파일에 설정된 Gradle을 사용하여 의존성 패키지를 설치합니다.
```plaintext
./gradlew build
```

데이터베이스 설정
Oracle 데이터베이스 설정을 application.yml 파일에서 확인하고, 필요한 테이블을 생성합니다.
애플리케이션 실행 (Run the application)
Spring Boot 애플리케이션을 실행합니다.
```plaintext
./gradlew bootRun
```
웹 브라우저에서 접속
애플리케이션이 성공적으로 실행되면 웹 브라우저에서 http://localhost:8080을 통해 접속할 수 있습니다.

## 📌 웹 링크
http://ec2-52-79-61-147.ap-northeast-2.compute.amazonaws.com/
