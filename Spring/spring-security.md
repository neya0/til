# Spring Security란?

> Spring Security는 Spring 기반의 애플리케이션의 <span style="color: tomato">보안(인증과 권한, 인가 등)</span>을 담당하는 스프링 하위 프레임워크이다. 

+ spring Security는 <span style="color: tomato">인증과 권한</span>에 대한 부분을 Filter의 흐름에 따라 처리한다.
+ 보안과 관련해서 체계적으로 많은 옵션을 제공해주기 때문에 개발자가 일일이 보안관련 로직을 작성하지 않아도 된다.

<hr/>

## **인증과 인가**

<br/>

**인증(Authentication)**
+ 해당 사용자가 본인이 맞는지 확인하는 절차

**인가(Authorization)**
+ 인증된 사용자가 요청한 자원에 접근 가증한지를 결정하는 절차

<br />

![image](https://user-images.githubusercontent.com/103401991/181863306-dda8359a-7d61-4bb3-acd0-f702711a4fc8.png)

+ 인증 절차를 거친 후에 인가 절차를 진행, 인가 과정에서 해당 리소스에 대한 접근 권한이 있는지를 확인하게 된다.
+ 이러한 인증과 인가를 위해 principal을 아이디로, credential을 비밀번호로 사용하는 credential 기반의 인증 방식을 사용한다.

[principal] 보호 받는 리소스에 접근하는 대상\
[credential] 리소스에 접근하는 대상의 비밀번호

<hr />

## **Spring Security 주요 모듈**

**Security Context Holder**
+ SecurityContextHolder는 보안 주체의 세부 정보를 포함하여 응용 프로그램의 현재 보안 컨텍스트에 대한 세부 정보가 저장된다.

**Security Context**
+ SecurityContext는 Authencation을 보관하는 역할을 하며, SecurityContext를 통해 Authentication객체를 꺼내올 수 있다.

**Authentication**
+ Authentication은 현재 접근하는 주체의 정보와 권한을 담는 인터페이스입니다.
+ SecurityContext에 저장되며, SecurityContextHolder를 통해 SecurityContxt에 접근하고, SecurityContext를 통해 Authentication 객체를 꺼내올 수 있다.

```

public interface Authentication extends Principal, Serializable {
	//현재 사용자의 권한 목록을 가져옴
	Collection<? extends GrantedAuthority> getAuthorities();
	//credentials(주로 비밀번호)를 가져옴 
	Object getCredentials();
	
	Object getDetails();
	//Principal 객체를 가져옴
	Object getPrincipal();
	//인증 여부를 가져옴
	boolean isAuthenticated();
	//인증 여부를 설정함
	void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}

```

**UsernamePasswordAuthenticationToken**

+ Authentication을 구현한 AbstractAuthenticationToken의 하위 클래스로 username이 Principal의 역할을 하고, password가 Credential의 역할을 한다.
+ 첫번째 생성자는 인증 전의 객체를 생성하고, 두 번쨰 생성자는 인증이 완료된 객체를 생성해준다.

```
public class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	//주로 사용자 ID에 해당함
	private final Object principal;
	//주로 사용자 PW에 해당함
	private Object credentials;
	//인증 완료 전의 객체 생성
	public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		setAuthenticated(false);
	}
	//인증 완료 후의 객체 생성
	public UsernamePasswordAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true); // must use super, as we override
	}
}



public abstract class AbstractAuthenticationToken implements Authentication, CredentialsContainer { }

```

<hr />

## **처리과정**

<br />

![image](https://user-images.githubusercontent.com/103401991/181709337-cd9b4d3c-88ec-4d66-869e-7b9cce9e56c7.png)

1. 로그인 요청
2. UsernamePasswordAuthenticationToken 발행
    - 로그인 요청이 오면 먼저 AuthenticationFilter로 오고, 아이디와 비밀번호를 기반으로 Token을 발급해준다. 프론트에서 유효성 검사를 먼저 하겠지만 이때 유효성 검사를 한 번 더 진행해 주는 것이 좋다.
3. 토큰은 검증을 위해 AuthenticationManager의 인스턴스로 전달
4. AuthenticationManager는 인증에 성공하면 Authentication 인스턴스를 리턴
5. 인스턴스는 SecurityContextHolder에 저장

### Authentication Provider

+ 실제 인증에 대한 부분을 처리하는데, 인증 전의 Authentication 객체를 받아서 인증이 완료된 객체ㅔ를 반환하는 역할을 한다.

### AuthenticationManager

+ 인증에 대한 부분은 AuthenticationManager를 통해서 처리하게 되는데, 실질적으로는 AuthenticationManager에 등록된 AuthenticationProvider에 의해 처리된다.
+ 인증이 성공하면 isAuthentication = true인 객체를 생성하여 SecurityContext에 저장한다.
+ 인증 상태를 유지하기 위해 세션에 보관하며, 실패할 경우에는 AuthenticationException을 발생시킨다.

### UserDetails

+ 인증에 성공하여 생성된 UserDetails 객체는 UsernamePasswordAuthenticationToken을 생성하기 위해 사용된다.
+ UserDetails 인터페이스의 경우 직접 개발한 User 엔티티나 UserDto에 UserDetails를 구현하여 처리할 수 있다.

### UserDetailsService

+ UserDetailsService 인터페이스는 UserDetails 객체를 반환하는 단 하나의 메소드를 가지고 있는데, 일반적으로 이를 구현한 클래스의 내부에 UserRepository를 주입받아 DB에 연결하여 처리합니다.

### PasswordEncoder

+ PasswordEncoder는 말 그대로 패스워드를 인코딩하는 것인데 패스워드 암호화에 사용될 PasswordEncoder 구현체를 지정할 수 있다.
+ 스프링 부트 2.0부터는 인증을 위해 반드시 PasswordEncoder를 지정해야만 한다.
+ BCryptPasswordEncoder: 'bcrypt'라는 해시 함수를 이용해서 패스워드를 암호화하는 목적으로 설계된 클래스이며, 많이 사용됩니다.

### GrantedAuthority

+ 현재 사용자(Principal)가 가지고 있는 권한들이다.
+ 보통 ROLE_USER, ROLE_ADMIN과 같이 ROLE_의 형태로 사용된다.

출처: [Spring Security란 - 짱구의 못말리는 개발일기](https://velog.io/@sc_shin/Spring-Security%EB%9E%80)

