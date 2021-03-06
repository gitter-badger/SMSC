package io.smsc.model.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.smsc.model.customer.Customer;
import io.smsc.model.customer.CustomerContact;
import io.smsc.model.customer.Salutation;
import io.smsc.model.customer.Type;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

/**
 * This interface is describing excerpting projection for {@link CustomerContact}
 * entity and is used for fetching relation properties in JSON response.
 *
 * @author Nazar Lipkovskyy
 * @see Projection
 * @since 0.0.1-SNAPSHOT
 */
@Projection(name = "withCustomer", types = {CustomerContact.class})
public interface CustomerContactProjection {

    Long getId();

    Long getVersion();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Date getLastModifiedDate();

    String getFirstname();

    String getSurname();

    String getPhone();

    String getMobilePhone();

    String getFax();

    String getEmailAddress();

    Customer getCustomer();

    Type getType();

    Salutation getSalutation();
}
