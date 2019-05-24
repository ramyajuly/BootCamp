package com.company;

/**
 * Program on Composition Design
 */
public class CustomerComposition {
    public static void main(String[] args) {

        Customer customer = new Customer("Ramya","Basavaraj",
                "ramya@email","123456",
                new Address("Shipping Street 1","Shipping Street 2","City","State","zip235"),
                new Address("Billing Street 1","Billing Street 2","City","State","zip456"),
                true);

        System.out.println(customer.getFirstName() + " " + customer.getLastName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getPhoneNumber());
        System.out.println(customer.getShippingAddress().getStreet1() +  " " +customer.getShippingAddress().getStreet2()
                + " " + customer.getShippingAddress().getCity() + " " +
                customer.getShippingAddress().getState() + " "+
                customer.getShippingAddress().getZip());
        System.out.println(customer.getBillingAddress().getStreet1() +  " " +customer.getBillingAddress().getStreet2()
                + " " + customer.getBillingAddress().getCity() + " " +
                customer.getBillingAddress().getState() + " "+
                customer.getBillingAddress().getZip());
        System.out.println("Rewarded: " + customer.isRewardsMember());

    }
}
