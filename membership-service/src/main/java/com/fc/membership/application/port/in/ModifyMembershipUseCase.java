package com.fc.membership.application.port.in;

import com.fc.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);

}
