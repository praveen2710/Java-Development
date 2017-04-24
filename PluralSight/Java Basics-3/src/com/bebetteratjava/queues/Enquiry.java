package com.bebetteratjava.queues;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Enquiry {

    private final Customer customer;
    private final Category category;

    public Enquiry(Customer customer, Category category) {
        this.customer = customer;
        this.category = category;
    }

    public Customer getCustomer() {return customer;}

    public Category getCategory() {return category;}

    @Override
    public String toString() {
        return "Enquiry{" +
                "customer=" + customer +
                ", category=" + category +
                '}';
    }
}
