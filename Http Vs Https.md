# Http와 Https

## Http (HyperText Transfer Protocol)

- 웹 브라우저와 웹 서버간의 커뮤니케이션을 위해 설계된 약속
- 초기에는 HTML과 같은 하이퍼미디어 문서를 주로 전송했지만, 최근에는 Plain text, JSON, XML 등 다양한 형태의 정보도 전송하는 애플리케이션 레이어 프로토콜이다. 
- HTTP는 stateless이며, 이는 서버가 두 요청간에 어떠한 데이터(상태)도 유지하지 않음을 의미합니다.
- TCP나 UDP 프로토콜을 사용하고, 기본 포트는 80 포트이다.

### 동작방식

- 클라이언트 : 서버에 요청을 보내는 리소스 사용자
- 서버: 클라이언트가 보낸 요청에 대한 응답을 제공하는 리소스 관리자

  ![image](https://user-images.githubusercontent.com/103401991/186902619-80d638dd-0598-4a89-aee9-dc45906da173.png)

### 요청 메소드

#### GET
: 리소스를 조회할 떄 사용.
 URI를 통해 리소스 요청을 보냄.
#### POST
: 리소스를 생성할 때 사용.
#### PUT
: 리소스의 전체를 수정할 때 사용.
#### PATCH
: 리소스의 일부분을 수정할 때 사용.
#### DELETE
: 리소스를 삭제할 떄 사용

## Https (HyperText Transfer Protocol Secure)

- 기본적안 부분은 동일하지만 보안 부분이 추가됨
- 서버와 클라이언트 간에 주고받는 데이터가 모두 암호화 된다
- SSL(현재 명칭은 TLS)프로토콜을 사용하여 데이터를 암호화하고, TCP/IP 443 포트를 쓴다

#### 암호화 방식

**공개키 방식**

- A로 암호화를 하면 B로 복호화를 할 수 있고, B로 암호화를 하면 A로 복호화가 가능하다
- 둘 중 하나는 공개키로, 공개키 저장소(CA)에 둔다.
- 비공개키는 서버가 가지고 있는다. 공개키가 노출되어도 비공개키를 모르면 복호화를 할 수 없다

![image](https://user-images.githubusercontent.com/103401991/187340635-42e7f80e-f967-4bdb-9127-5aa31326c988.png)

**대칭키 방식**

- 서로 같은 키를 나누어 가져 암호화, 복호화가 가능
- 키는 매번 새롭게 발급되기 때문에 누출되어도 안전하다
- 공개키 방식보다 빠르다

![image](https://user-images.githubusercontent.com/103401991/187341131-95fec8f4-d1ed-407c-a16b-895e26cacbde.png)
![image](https://user-images.githubusercontent.com/103401991/187341208-9447a475-d2b4-472d-8482-02a898227402.png)

#### 장점

- Https는 웹사이트의 무결성을 보호해준다
- 클라이언트와 서버가 주고 받는 데이터를 암호화로 보호함으로써 보안을 강화한다

#### 단점

- 보안을 강화한 것은 맞지만 인증된 CA기업이 아닌 사설 인증서를 발급한 경우 안전하지 않을 수 있다