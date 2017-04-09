# 스프링 부트 자가 탐구 프로젝트

*"스프링 부트를 대하는 자세"를 연구하기 위한 연습장 프로젝트*

- Step 0. Legacy Boot
- Step 1. Reference Guide
    - starter freemarker
- Step 2. Release Note
    - jackson default
- Step 3. pom.xml
    - start test
- Step 4. auto configuration
    - datasource
- Step 5. freemarker customize
    - template path
    
# Step 0. Legacy Boot

그럭 저럭 구성한 기본 환경 설정!

테스트 코드는 정상! **그러나!**

# Step 1. Reference Guide

![reference guide](https://github.com/kingbbode/backandfront/blob/master/img/reference.png)

레퍼런스 가이드를 보았다. **boot에서 freemarker starter dependency를 제공한다**

그래서 `build.gradle`에서 freemarker dependency를 starter dependency로 대체했다.

테스트 코드도 역시 성공!