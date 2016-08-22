import { Injectable } from "@angular/core";
import { NotificationsService } from "angular2-notifications/components";
import { TranslateService } from "ng2-translate/ng2-translate";

@Injectable()
export class ServiceNotifications {
    constructor(public translate:TranslateService,
                public notificationsService:NotificationsService) {
    }

    createNotification(type, title, content) {
        this.translate.get(title).subscribe((title) => {
            this.translate.get(content).subscribe((content) => {
                switch(type) {
                    case 'success':
                        this.notificationsService.success(title, content);
                        break;

                    case 'error':
                        this.notificationsService.error(title, content);
                        break;

                    case 'info':
                        this.notificationsService.info(title, content);
                        break;

                    default:
                        break;
                }
            });
        });
    }
}