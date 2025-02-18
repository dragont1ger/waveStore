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


## 📌 기술 스택 (Tech Stack)

- **프론트엔드**: HTML, CSS, JavaScript, Thymeleaf
- **백엔드**: Java, Spring Boot, JPA
- **데이터베이스**: MySQL / Oracle
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

## 구현 결과
![메인](https://github.com/user-attachments/assets/5784f8bc-0be5-450b-83f5-1834d7a2aacf)


## 📌 향후 개선 사항 (Future Improvements)
- 회원 등급 시스템 도입 및 포인트 적립 기능
- 모바일 앱 개발
- 탈퇴 회원 데이터 자동 백업 및 복구 기능 추가 또는 일정 기간 후 완전 삭제
