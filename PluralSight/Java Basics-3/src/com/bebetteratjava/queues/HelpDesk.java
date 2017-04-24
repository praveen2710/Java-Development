package com.bebetteratjava.queues;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.bebetteratjava.queues.Category.PRINTER;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class HelpDesk {
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

//    private final PriorityQueue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);
    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(Customer customer, final Category category){
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquires(){
        Enquiry enquiry;
        while ((enquiry = enquiries.poll())!=null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again");
        }
    }

    public  void processPrinterEnquiry(){
        final Enquiry enquiry = enquiries.peek();
        if(enquiry !=null && enquiry.getCategory() == PRINTER){
            enquiries.poll();
            enquiry.getCustomer().reply("Is it out of paper");
        }else
            System.out.println("No Print Work , lets have coffee");
    }

    public void processGeneralEnquiry(){
        final Enquiry enquiry = enquiries.peek();
        if(enquiry !=null && enquiry.getCategory() != PRINTER){
            enquiries.poll();
            enquiry.getCustomer().reply("Have you tried turning it off and on again");
        }else
            System.out.println("No Work , lets have coffee");
    }

    //TODO Java 8 feature

}
