package com.fc.money.adapter.out.persistence;

import com.fc.money.application.port.out.IncreaseMoneyPort;
import com.fc.money.domain.MemberMoney;
import com.fc.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import com.fc.common.PersistenceAdapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequest createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
            MoneyChangingRequest.Uuid uuid
    ) {
        MoneyChangingRequestJpaEntity entity = moneyChangingRequestRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.getTargetMembershipId(),
                        moneyChangingType.getMoneyChangingType(),
                        changingMoneyAmount.getChangingMoneyAmount(),
                        LocalDateTime.now(),
                        moneyChangingStatus.getChangingMoneyStatus(),
                        UUID.randomUUID()
                )
        );

        return MoneyChangingRequestMapper.INSTANCE.entityToDomain(entity);
    }

    @Override
    public MemberMoney increaseMoney(
            MemberMoney.MembershipId memberId,
            int increaseMoneyAmount
    ) {
        MemberMoneyJpaEntity entity;
        try {
            List<MemberMoneyJpaEntity> entityList =  memberMoneyRepository.findByMembershipId(Long.parseLong(memberId.getMembershipId()));
            entity = entityList.get(0);

            entity.setBalance(entity.getBalance() + increaseMoneyAmount);
            entity = memberMoneyRepository.save(entity);
        } catch (Exception e){
            entity = new MemberMoneyJpaEntity(
                    Long.parseLong(memberId.getMembershipId()),
                    increaseMoneyAmount
            );
            entity = memberMoneyRepository.save(entity);
        }

        return MemberMoney.generateMemberMoney(
                new MemberMoney.MemberMoneyId(entity.getMemberMoneyId()+""),
                new MemberMoney.MembershipId(entity.getMembershipId()+""),
                new MemberMoney.MoneyBalance(entity.getBalance())
        );
    }

}
