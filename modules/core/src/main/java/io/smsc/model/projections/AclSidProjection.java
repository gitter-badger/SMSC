package io.smsc.model.projections;

import io.smsc.model.acl.AclEntry;
import io.smsc.model.acl.AclObjectIdentity;
import io.smsc.model.acl.AclSid;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

/**
 * This interface is describing excerpting projection for {@link AclSid}
 * entity and is used for fetching relation properties in JSON response.
 *
 * @author  Nazar Lipkovskyy
 * @see     Projection
 * @since   0.0.1-SNAPSHOT
 */
@Projection(name = "withEntriesAndObjectIdentities", types = {AclSid.class})
public interface AclSidProjection {

    Long getId();

    Boolean getPrincipal();

    String getSid();

    Set<AclEntry> getAclEntries();

    Set<AclObjectIdentity> getAclObjectIdentities();
}
