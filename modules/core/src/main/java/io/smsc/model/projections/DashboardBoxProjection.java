package io.smsc.model.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.smsc.model.dashboard.*;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

/**
 * This interface is describing excerpting projection for {@link DashboardBox}
 * entity and is used for fetching relation properties in JSON response.
 *
 * @author Nazar Lipkovskyy
 * @see Projection
 * @since 0.0.1-SNAPSHOT
 */
@Projection(name = "withDashboardsAndDashboardBoxType", types = {DashboardBox.class})
public interface DashboardBoxProjection {

    Long getId();

    Long getVersion();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Date getLastModifiedDate();

    Width getWidth();

    Height getHeight();

    Integer getOrder();

    String getName();

    String getDescription();

    Dashboard getDashboard();

    DashboardBoxType getDashboardBoxType();
}
