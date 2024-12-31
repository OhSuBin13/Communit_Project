package community.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import community.board.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTest {

  @Autowired
  private MemberRepository memberRepository;
  
  @Test
  void testFindMembers() {
    
  }

  @Test
  void testFindOne() {

  }

  @Test
  void testJoin() {

  }

  @Test
  void testLogin() {

  }

  @Test
  void testWithdrawalMember() {

  }
}
