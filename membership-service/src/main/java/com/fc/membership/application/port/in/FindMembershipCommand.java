package com.fc.membership.application.port.in;

import common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class FindMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    String membershipId;

}
