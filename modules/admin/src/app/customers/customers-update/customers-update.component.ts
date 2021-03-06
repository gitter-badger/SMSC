import { Component } from "@angular/core";
import { TranslateService } from "ng2-translate/ng2-translate";
import { ActivatedRoute } from "@angular/router";
import { Location } from "@angular/common";
import { NotificationService } from "../../services/notification-service";
import { CustomersService } from "../customers.service";
import * as clone from "js.clone";

@Component({
    selector: 'customers-update',
    template: `
        <dynamic-form [submitButtonName]="submitButtonName" [model]="model"
                    (onSubmit)="onSubmit($event)"></dynamic-form>
    `,
    styleUrls: [],
    providers: [Location]
})

export class CustomersUpdateComponent {
    public id: number;
    public submitButtonName: string = 'customers.update';
    public model = {};

    constructor(public translate: TranslateService,
                public customersService: CustomersService,
                public route: ActivatedRoute,
                public location: Location,
                public notifications: NotificationService) {
    }

    ngOnInit() {
        // get id parameter
        this.route.params.subscribe((params) => {
            this.id = +params['id'];
        });

        this.model = this.getModel();
    }

    getModel() {
        return this.route.snapshot.data['edit'];
    }

    onSubmit(data) {
        let _data = clone(data);

        // delete all properties of URI
        delete _data['customerUsers'];
        delete _data['contacts'];
        delete _data['parent'];

        this.customersService.updateResource(this.id, _data)
            .subscribe(() => {
                this.notifications.createNotification('success', 'SUCCESS', 'customers.successUpdateCustomer');
            }, err => {
                console.error(err);
                this.notifications.createNotification('error', 'ERROR', 'customers.errorUpdateCustomer');
            })
    }

}
