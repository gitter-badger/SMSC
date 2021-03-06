//package io.smsc.test_data;
//
//import io.smsc.matcher.ModelMatcher;
//import io.smsc.model.customer.CustomerContact;
//import io.smsc.model.customer.Salutation;
//import io.smsc.model.customer.Type;
//
//import static io.smsc.test_data.CustomerTestData.*;
//
//import java.util.Objects;
//
//public class CustomerContactTestData {
//
//    public static final long CUSTOMER_CONTACT_ID_1 = 241;
//
//    public static final CustomerContact CUSTOMER_CONTACT_1 = new CustomerContact(CUSTOMER_CONTACT_ID_1, "SMSC", "SMSC", "0674329568", "0504569753", "fake_fax", "smsc@bulk.io", Type.CEO, Salutation.MR);
//
//    static
//    {
//        CUSTOMER_CONTACT_1.setCustomer(CUSTOMER_1);
//    }
//
//    public static final ModelMatcher<CustomerContact> CUSTOMER_CONTACT_MODEL_MATCHER = new ModelMatcher<>(CustomerContact.class,
//            (expected, actual) -> expected == actual ||
//                    (Objects.equals(expected.getId(), actual.getId())
//                            && Objects.equals(expected.getFirstname(), actual.getFirstname())
//                            && Objects.equals(expected.getSurname(), actual.getSurname())
//                            && Objects.equals(expected.getPhone(), actual.getPhone())
//                            && Objects.equals(expected.getMobilePhone(), actual.getMobilePhone())
//                            && Objects.equals(expected.getFax(), actual.getFax())
//                            && Objects.equals(expected.getEmailAddress(), actual.getEmailAddress())
//                            && Objects.equals(expected.getType(), actual.getType())
//                            && Objects.equals(expected.getSalutation(), actual.getSalutation())
//                    )
//    );
//}
