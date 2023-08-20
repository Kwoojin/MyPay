package com.fc.membership.adapter.in.web;


import com.fc.membership.application.port.in.FindMembershipCommand;
import com.fc.membership.application.port.in.FindMembershipUseCase;
import com.fc.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.fc.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class FindMemberShipController {

    @GetMapping(path = "/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }

    private final FindMembershipUseCase findMembershipUseCase;

}
