package com.example.command.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SeachCommandFactory {

    static Map<String, SearchCustomerImpl> conditions = new HashMap<>();
    static {
        conditions.put("searchByMemberNumber", SearchCustomerImpl.valueOf("SEARCH_BY_MEMBER_NUMBER"));
        conditions.put("searchByEmployeeNumber", SearchCustomerImpl.valueOf("SEARCH_BY_EMPLOYEE_NUMBER"));
        conditions.put("searchByOPId", SearchCustomerImpl.valueOf("SEARCH_BY_OP_ID"));
        conditions.put("searchByCustType", SearchCustomerImpl.valueOf("SEARCH_BY_Cust_TYPE"));

    }

    public static Optional<SearchCustomerImpl> getSearchCommand(String searchByParam) {
        return Optional.ofNullable(conditions.get(searchByParam));
    }
}
