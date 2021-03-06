package io.smsc.repository;

import io.smsc.model.CustomerUser;
import io.smsc.model.User;
import io.smsc.model.projections.CustomerUserProjection;
import io.smsc.model.projections.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * This REST repository class is used for providing default {@link JpaRepository}
 * CRUD methods to operate with {@link User} entities and exporting them to
 * appropriate endpoints.
 *
 * @author Nazar Lipkovskyy
 * @since 0.0.1-SNAPSHOT
 */
@RepositoryRestResource(collectionResourceRel = "customer-users", path = "customer-users", excerptProjection = CustomerUserProjection.class)
@Transactional(readOnly = true)
public interface CustomerUserRepository extends JpaRepository<CustomerUser, Long> {

    //All query method resources are exposed under the resource 'search'.

    @Override
    @Transactional
    void delete(Long id);

    @Override
    @Transactional
    CustomerUser save(CustomerUser customerUser);

    @Override
    CustomerUser findOne(Long id);

    User findByUsername(@Param("username") String userName);

    User findByEmail(@Param("email") String email);

    @Override
    Page<CustomerUser> findAll(Pageable pageable);
}
