# Project Wave

## 📢 프로젝트 개요 (Overview)

**Project Wave**는 사용자들이 안전하고 편리하게 중고 거래를 할 수 있는 웹 플랫폼입니다. 판매자와 구매자는 실시간으로 상품 정보를 확인하고, 원활한 거래를 진행할 수 있습니다. 소셜 로그인 및 안전한 결제 시스템을 통해 신뢰 기반의 거래 환경을 제공합니다.

- **주요 목표**:
  - 안전하고 신뢰성 있는 중고 거래 환경 제공
  - 실시간 채팅 및 원활한 상품 검색 기능 제공
  - 사용자 인증을 위한 소셜 로그인 시스템 구현
  - 안전한 결제 시스템 도입

- **주요 기능**:
  - 상품 등록 및 검색
  - 실시간 채팅
  - 결제 시스템
  - 회원 관리 (회원 가입, 로그인, 프로필 관리)
  - 소셜 로그인 (Google, Facebook 등)

## 📌 기술 스택 (Tech Stack)

- **프론트엔드**: HTML, CSS, JavaScript, Thymeleaf
- **백엔드**: Java, Spring Boot, JPA
- **데이터베이스**: MySQL / Oracle
- **보안**: JWT (JSON Web Token), OAuth2 (소셜 로그인)
- **빌드 도구**: Gradle
- **테스트**: JUnit, Mockito

## 📌 프로젝트 구조 (Project Structure)

```plaintext
project-wave
├── 📂 src/main/java/org/example/store
│     ├── 📂 chat              # 실시간 채팅 관련 로직
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
