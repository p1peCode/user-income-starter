package com.starter.userincomestarter;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class IncomeClient {

    @Autowired
    private IncomeProperties incomeProperties;
    private final String ID = "id";
    private final String INCOME = "income";
    public int getUserIncome(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode[] users = restTemplate.getForObject(incomeProperties.getApiUrl(), JsonNode[].class);

        if (users != null) {
            for (JsonNode user : users) {
                if (user.has(ID) && user.get(ID).asInt() == userId && user.has(INCOME)) {
                    return user.get(INCOME).asInt();
                }
            }
        }
        return 0;
    }
}