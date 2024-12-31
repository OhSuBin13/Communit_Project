package community.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import community.board.repository.MemberRepository;
import community.board.domain.Member;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Long join(Member member) {
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByUsername(member.getUsername())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }
  
  public boolean login(String username, String password) {
    Member member = findOne(username).orElseThrow(() -> new IllegalStateException("회원이 존재하지 않습니다."));
    if (!member.getPassword().equals(password)) {
      throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
    }
    return true;
  }

  public void withdrawalMember(String username) {
    Member member = findOne(username).orElseThrow(() -> new IllegalStateException("회원이 존재하지 않습니다."));
    memberRepository.delete(member);
  }

  public Optional<Member> findOne(String username) {
    return memberRepository.findByUsername(username);
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }
}
