package com.example.command.pattern;


import com.example.command.pattern.domain.ResponseDto;

public enum SearchCustomerImpl implements SearchCustomer {
        SEARCH_BY_MEMBER_NUMBER {
        @Override
        public ResponseDto execute() {
            System.out.println("Add logic here to fetch customers by member number");
            return null;
        }
    },

    SEARCH_BY_EMPLOYEE_NUMBER {
        @Override
        public ResponseDto execute() {
            System.out.println("Add logic here to fetch customers by Employee number");
            return null;
        }
    },
    SEARCH_BY_OP_ID {
        @Override
        public ResponseDto execute() {
            System.out.println("Add logic here to fetch customers by OP Id");
            return null;
        }
    },
    SEARCH_BY_Cust_TYPE {
        @Override
        public ResponseDto execute() {
            System.out.println("Add logic here to fetch customers by Type");
            return null;
        }
    };



}
