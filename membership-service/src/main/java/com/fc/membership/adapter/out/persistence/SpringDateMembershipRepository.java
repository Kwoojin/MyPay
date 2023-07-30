package com.fc.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDateMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
