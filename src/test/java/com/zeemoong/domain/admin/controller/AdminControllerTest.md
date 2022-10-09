# SpringBoot Test 에 대해 알아보자

[스프링부트 공식문서 (테스트)]: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing



## @SpringBootTest

- 단위 테스트 보다는 통합 테스트에 적합
- 어플리케이션의 설정과 모든 빈을 로드하기 때문에 시간이 오래 걸림

> JUnit5부터는 @RunWith, @ExtendWith 등을 추가해줄 필요가 없다.

## @AutoConfigureMockMvc

- Mock 테스트 시 필요한 의존성을 제공

  ```java
  @Autowired
  MockMvc mvc;
  ```

- @WebMvcTest 가 아닌 @SpringBootTest 에서도 Mock 테스트를 가능하게 해주는 역할

## @WebMvcTest

- Controller 가 예상대로 동작하는지 테스트하기 위해 사용
- WebApplication 과 관련된 빈들만 스캔하여 등록하기 때문에 @SpringBootTest 보다 빠름





> 개인적인 생각으로는 Controller 테스트를 할 때, @SpringBootTest + @AutoConfigureMockMvc 로 하는게 편한듯

```java
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAdminTest() {
        // given
        String name = "이한슬";
        String email = "sky@naver.com";

        AdminResponse adminResponse = AdminResponse.builder().name(name).email(email).build();
        BDDMockito.given(adminService.getAdmin()).willReturn(adminResponse);

        // when
        ResponseEntity<AdminResponse> responseEntity = adminController.getAdmin();

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getName()).isEqualTo(name);
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getEmail()).isEqualTo(email);
    }

    @Test
    void loggingInterceptor_가_정상_등록되어있다면_response_body_를_콘솔에_출력해준다() throws Exception {
        // given
        String name = "이한슬";
        String email = "sky@naver.com";

        AdminResponse adminResponse = AdminResponse.builder().name(name).email(email).build();
        BDDMockito.given(adminService.getAdmin()).willReturn(adminResponse);

        // when
        ResultActions resultActions = mockMvc.perform(get("/admin")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk()).andDo(print());
    }

}
```

