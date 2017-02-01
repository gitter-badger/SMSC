import { NgModule } from "@angular/core";
import { CustomersContactsComponent } from "./customers-contacts";
import { CommonModule } from "@angular/common";
import { RouterModule, Router } from "@angular/router";
import { ContactsCreateComponent } from "./contacts-create/contacts-create";
import { CustomersContactsRoutingModule } from "./customers-contacts-routing.module";
import { CustomersContactsService } from "./customers-contacts.service";
import { CheckboxModule } from "primeng/components/checkbox/checkbox";
import { FormsModule } from "@angular/forms";
import { MultipleSelectModule } from "../common/dynamic-form/contacts-select/contacts-select.component";
import { TranslateModule } from "ng2-translate";
import { PanelModule } from "primeng/components/panel/panel";
import { InputTextModule } from "primeng/components/inputtext/inputtext";
import { ButtonModule } from "primeng/components/button/button";
import { DropdownModule } from "primeng/components/dropdown/dropdown";
import { ControlErrorsModule } from "../../common/control-errors/control-errors";
import { CustomersService } from "../customers.service";
import { RequestOptions, XHRBackend, Http } from "@angular/http";
import { HttpInterceptor } from "../../common/http-interceptor";

const CUSTOMERS_CONTACTS_MODULES = [
    CommonModule,
    CheckboxModule,
    FormsModule,
    MultipleSelectModule,
    TranslateModule,
    PanelModule,
    InputTextModule,
    ButtonModule,
    DropdownModule,
    ControlErrorsModule,
    RouterModule
];

@NgModule({
    imports: [CUSTOMERS_CONTACTS_MODULES],
    exports: [CustomersContactsRoutingModule],
    declarations: [CustomersContactsComponent, ContactsCreateComponent],
    providers: [
        CustomersContactsService,
        CustomersService,
        {
            provide: Http,
            useFactory: (xhrBackend: XHRBackend, requestOptions: RequestOptions, router: Router) =>
                new HttpInterceptor(xhrBackend, requestOptions, router),
            deps: [XHRBackend, RequestOptions, Router]
        }
    ],
})
export class CustomersContactsModule {
}