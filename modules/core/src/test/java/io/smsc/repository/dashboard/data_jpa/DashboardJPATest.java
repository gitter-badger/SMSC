//package io.smsc.repository.dashboard.data_jpa;
//
//import io.smsc.AbstractTest;
//import io.smsc.model.dashboard.Dashboard;
//import io.smsc.model.dashboard.Height;
//import io.smsc.model.dashboard.Width;
//import org.junit.Test;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.security.test.context.support.WithMockUser;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import static io.smsc.test_data.DashboardBoxTestData.*;
//import static io.smsc.test_data.DashboardBoxTypeTestData.*;
//import static io.smsc.test_data.DashboardTestData.*;
//import static io.smsc.test_data.UserTestData.*;
//
//@WithMockUser(username="Admin",roles = {"ADMIN"})
//public class DashboardJPATest extends AbstractTest {
//
////    @Test
////    public void testDeleteDashboard() throws Exception {
////        dashboardRepository.delete(DASHBOARD_ID_1);
////        DASHBOARD_MODEL_MATCHER.assertCollectionEquals(Collections.emptyList(), dashboardRepository.findAll());
////    }
////
////    @Test
////    public void testSaveDashboard() throws Exception {
////        Dashboard newDashboard = new Dashboard(null, "default_admin", "admin", userRepository.findOne(53L));
////        Dashboard created = dashboardRepository.save(newDashboard);
////        newDashboard.setId(created.getId());
////        DASHBOARD_MODEL_MATCHER.assertEquals(newDashboard, dashboardRepository.getOne(newDashboard.getId()));
////    }
////
////    @Test
////    public void testGetSingleDashboard() throws Exception {
////        Dashboard dashboard = dashboardRepository.findOne(DASHBOARD_ID_1);
////        DASHBOARD_MODEL_MATCHER.assertEquals(DASHBOARD_1, dashboard);
////    }
////
////    @Test
////    public void testGetAllDashboards() throws Exception {
////        Collection<Dashboard> dashboards = dashboardRepository.findAll();
////        DASHBOARD_MODEL_MATCHER.assertCollectionEquals(Collections.singletonList(DASHBOARD_1), dashboards);
////    }
////
////    @Test
////    public void testUpdateDashboard() throws Exception{
////        Dashboard updated = dashboardRepository.findOne(242L);
////        updated.setUser(ADMIN);
////        updated.setIcon("new icon");
////        updated.setName("new name");
////        dashboardRepository.save(updated);
////        DASHBOARD_MODEL_MATCHER.assertEquals(updated, dashboardRepository.getOne(DASHBOARD_ID_1));
////    }
////
////    @Test
////    public void testGetDashboardByName() throws Exception {
////        Dashboard dashboard = dashboardRepository.findByName(DASHBOARD_1.getName());
////        DASHBOARD_MODEL_MATCHER.assertEquals(DASHBOARD_1, dashboard);
////    }
////
////    @Test
////    public void testGetDashboardsByUser() throws Exception {
////        List<Dashboard> dashboards = dashboardRepository.findAllDistinctByUser(dashboardRepository.findOne(242L).getUser());
////        DASHBOARD_MODEL_MATCHER.assertCollectionEquals(Collections.singletonList(DASHBOARD_1), dashboards);
////    }
//}
