package com.fc.money.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.common.CommonHttpClient;
import com.fc.money.application.port.out.GetMembershipPort;
import com.fc.money.application.port.out.MembershipStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter implements GetMembershipPort {

    private final CommonHttpClient commonHttpClient;

    private final String membershipServiceUrl;

    private final ObjectMapper objectMapper;

    public MembershipServiceAdapter(
            @Value("${service.membership.url}") String membershipServiceUrl,
            CommonHttpClient commonHttpClient,
            ObjectMapper objectMapper
    ) {
        this.membershipServiceUrl = membershipServiceUrl;
        this.commonHttpClient = commonHttpClient;
        this.objectMapper = objectMapper;

    }

    @Override
    public MembershipStatus getMembership(String membershipId) {
        String url = String.join("/", membershipServiceUrl, "membership", membershipId);
        try {
            String jsonResponse = commonHttpClient.sendGetRequest(url).body();

            Membership membership = objectMapper.readValue(jsonResponse, Membership.class);
            return new MembershipStatus(membership.getMembershipId(), membership.getIsValid());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
