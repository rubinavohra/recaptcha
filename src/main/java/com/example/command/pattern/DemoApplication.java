package com.example.command.pattern;


import com.example.command.pattern.domain.Requestdto;

public class DemoApplication {

    public static void main(String[] args) {

        Requestdto requestdto = prepareRequest();
        System.out.println(" Search Param >> "+buildSearchCondition(requestdto));

        SearchCustomer command = SeachCommandFactory.getSearchCommand(buildSearchCondition(requestdto))
                .orElseThrow(() -> new IllegalArgumentException("Wrong condition"));
        command.execute();

        System.out.println(" Ends here ");



        // Demo invalid search parameter
       /* SearchCustomer searchBy2 = SeachCommandFactory.getSearchCommand("xxx")
                .orElseThrow(() -> new IllegalArgumentException("Missing valid search parameter ...."));
        searchBy.execute();*/



    }

    private static Requestdto prepareRequest() {
        //Requestdto requestdto = new Requestdto("Emp101", null,null,null);
        Requestdto requestdto = new Requestdto(null, "Mem101", null,null);
        //Requestdto requestdto = new Requestdto(null, null, "Op101",null);
        //Requestdto requestdto = new Requestdto(null,null,null, "Type1");
        return requestdto;
    }

    private static String buildSearchCondition(Requestdto requestdto ) {
        if(requestdto != null && requestdto.getSearchMemberNumber() != null ) {
            return "searchByMemberNumber";
        } else if (requestdto != null && requestdto.getSearchEmployeeNumber() != null) {
            return "searchByEmployeeNumber";
        } else if(requestdto != null && requestdto.getCustomerType() != null) {
            return "searchByCustType";
        } else if(requestdto != null && requestdto.getSearchOpId() != null) {
            return "searchByOPId";
        }
        else {
            return "XXX";
        }
    }
}
