package com.fc.membership.adapter.in.web;


import com.fc.membership.application.port.in.FindMembershipCommand;
import com.fc.membership.application.port.in.FindMembershipUseCase;
import com.fc.membership.application.port.in.ModifyMembershipCommand;
import com.fc.membership.application.port.in.ModifyMembershipUseCase;
import com.fc.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
