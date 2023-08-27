package com.fc.membership.adapter.in.web;


import com.fc.membership.application.port.in.ModifyMembershipCommand;
import com.fc.membership.application.port.in.ModifyMembershipUseCase;
import com.fc.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import com.fc.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class ModifyMemberShipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PatchMapping(path = "/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(
            @PathVariable String membershipId,
            @RequestBody ModifyMemberShipRequest request
    ) {

        final ModifyMembershipCommand command = request.toCommand(membershipId);

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }

}
