package hello.core.beandefinition.member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemerServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appconfig = new AppConfig();
        memberService = appconfig.memberService();
    }
    @Test
    void join(){
        //given(주어졌을때)
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when(이렇게 했을떄)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then(이렇게 된다)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
