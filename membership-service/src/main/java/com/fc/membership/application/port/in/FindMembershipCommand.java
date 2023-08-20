package com.fc.membership.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.fc.common.SelfValidating;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class FindMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    String membershipId;

}
