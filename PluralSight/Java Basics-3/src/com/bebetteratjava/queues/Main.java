package com.bebetteratjava.queues;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Main {
    public static void main(String args[]){
//        helpDeskApplication();
        calculatorApp();
    }

    /**
     * This is calculated from left to right
     */
    private static void calculatorApp() {
        Calculator c1 = new Calculator();
//        System.out.println(c1.evaluateStack("2"));
//        System.out.println(c1.evaluateStack("2 + 3"));
//        System.out.println(c1.evaluateStack("1 - 2"));
        System.out.println(c1.evaluateStack("2 * 3 + 2 / 4"));
        System.out.println(c1.evaluateQueue("2 * 3 + 2 / 4"));
    }

    private static void helpDeskApplication() {
        HelpDesk helpDesk = new HelpDesk();
        helpDesk.enquire(Customer.JACK,Category.PHONE);
        helpDesk.enquire(Customer.JILL,Category.PRINTER);
        helpDesk.enquire(Customer.MARY,Category.COMPUTER);
//        processAllEnquires(helpDesk);
//        processSpecificEnquires(helpDesk);
    }

    private static void processSpecificEnquires(HelpDesk helpDesk) {
        helpDesk.processPrinterEnquiry();
        helpDesk.processPrinterEnquiry();
        helpDesk.processPrinterEnquiry();

        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
    }

    private static void processAllEnquires(HelpDesk helpDesk) {
        helpDesk.processAllEnquires();
    }
}
