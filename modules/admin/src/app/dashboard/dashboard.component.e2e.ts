// import { Dashboard } from './dashboard.page';
//
// describe('DashboardComponent', () => {
//     let prot = protractor.wrapDriver(browser.driver);
//
//     prot.manage().window().setSize(1024, 1020);
//     browser.get(browser.baseUrl + '/');
//
//     beforeEach(() => {
//         this.dashboard = new Dashboard();
//         prot = protractor.wrapDriver(browser.driver);
//         this.dashboard.prot = prot;
//     });
//
//     //  Sign in
//     it('Try to login login', () => {
//         this.dashboard.login.login();
//     });
//
//     //  Check page title
//     it('Test title', () => {
//         let result = 'SMSC Admin';
//
//         this.dashboard.getTitle().then((res) => {
//             expect(this.dashboard.getTitle()).toBe(result);
//         });
//     });
//
//     //  Check by existing dashboard
//     it('Check by existing dashboard', () => {
//         this.dashboard.clickOnItemNavDashboard(prot).then(() => {
//             expect(this.dashboard.getDashboard()).toBeTruthy();
//         });
//     });
//
//     //  Switch to fullscreen mode
//     it('Click on fullscreen icon', () => {
//         this.dashboard.clickOnFullscreenIcon();
//     });
//
//     //  Open/Close crud box tool
//     it('Open/Close crud box tool', () => {
//         this.dashboard.toggleCloseIcon();
//     });
//
//     //  Change size mode
//     it('Switch height box mode', () => {
//         this.dashboard.clickOnSizeButtons();
//     });
//
//     //  Create box
//     it('Create box', () => {
//         this.dashboard.createBox();
//     });
//
//     it('Edit box', () => {
//         this.dashboard.editBox();
//     });
//
//     it('Remove box', () => {
//         this.dashboard.removeBox();
//     });
//
//     it('should logout', () => {
//         this.dashboard.login.logout();
//     });
// });
