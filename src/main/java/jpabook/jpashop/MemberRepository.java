package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);

        // command와 query를 분리하고자 하는 원칙에 따라 ID 값만을 반환함
        // Member 객체의 모든 데이터를 반환하면 Side effect 발생 가능
        // Id 값만으로 충분히 조회 가능
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
