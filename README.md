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
    - freemarker
- Step 5. properties setting
    - datasource
    
# Step 0. Legacy Boot

그럭 저럭 구성한 기본 환경 설정!

테스트 코드는 정상! **그러나!**

# Step 1. Reference Guide

![reference guide](https://raw.githubusercontent.com/kingbbode/spring-boot-attitude/master/img/reference.png)

레퍼런스 가이드를 보았다. **boot에서 freemarker starter dependency를 제공한다**

그래서 `build.gradle`에서 freemarker dependency를 starter dependency로 대체했다.

테스트 코드도 역시 성공!

# Step 2. Release Note

![reference guide](https://raw.githubusercontent.com/kingbbode/spring-boot-attitude/master/img/release.png)

릴리즈 노트를 보았다 **그동안 귀찮게 ObjectMapper에 등록하던 Jackson을 Default로 지원한다는 내용이다!**

그래서 Jackson 관련 설정들을 모두 지워보았다.

테스트 코드가 성공했다!

# Step 3. pom.xml

나는 starter test dependency와 내가 자주쓰던 test 관련 dependency들을 설정해놓았다.

그런데 starter dependency에서 어떤 dependency를 설정해주는지 궁금했다. 그래서 pom.xml을 들여다보았다.

```xml
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
    </dependency>
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-library</artifactId>
    </dependency>
```

헉! 내가 직접 dependency로 설정해주었던 dependency도 모두 starter dependency가 제공해주고 있다!

그래서 직접 설정했던 부분은 지워보았다.

테스트가 정상 동작한다!

# Step 4. auto configuration

spring boot auto configure dependency를 들여다 보았다.

이곳에서 freemarker 패키지가 보인다! 

들여다보니 내가 직접 설정했던 viewResolver를 자동으로 설정해주고 있다.

```java
@Bean
@ConditionalOnMissingBean(name = "freeMarkerViewResolver")
@ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
public FreeMarkerViewResolver freeMarkerViewResolver() {
    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
    this.properties.applyToViewResolver(resolver);
    return resolver;
}
```

거기에 properties class를 들여다보니 내가 해주고 있는 설정이 자동 설정의 기본 값과 같다!

```java
public static final String DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates/";

public static final String DEFAULT_PREFIX = "";

public static final String DEFAULT_SUFFIX = ".ftl";
```

그래서 freemarker 관련 설정을 하고 있는 class 자체를 지워보았다.

테스트 코드 성공!!

# Step 5. properties setting

boot의 spring.factories를 보고 Datasource의 autoconfiguration이 있다는 것을 알았다.

properties class가 있는 것을 보아 properties를 통해 값을 주입받고 있다는 것을 알 수 있다

이번에는 직접 들여다보지 않고 [docs](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)를 들여다보았다.

```
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.continue-on-error=false # Do not stop if an error occurs while initializing the database.
spring.datasource.data= # Data (DML) script resource references.
spring.datasource.data-username= # User of the database to execute DML scripts (if different).
spring.datasource.data-password= # Password of the database to execute DML scripts (if different).
spring.datasource.dbcp2.*= # Commons DBCP2 specific settings
spring.datasource.driver-class-name= # Fully qualified name of the JDBC driver. Auto-detected based on the URL by default.

등등

```

저쪽만 내가 설정해주면 Bean을 직접 생성해주지 않아도 되는것이구나! 바로 기존 설정 클래스를 삭제하고 properties로 설정해보았다.

테스트 코드 성공!