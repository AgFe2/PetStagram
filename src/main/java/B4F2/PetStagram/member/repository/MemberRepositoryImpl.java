package B4F2.PetStagram.member.repository;

import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.entity.QMember;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Member> searchByEmail(String keyword) {
        String search = "%" + keyword + "%";

        QMember member = QMember.member;
        return queryFactory.selectFrom(member)
                .where(member.email.like(search))
                .fetch();
    }

}
