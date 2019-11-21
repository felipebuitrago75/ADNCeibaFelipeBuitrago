import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { HttpModule } from "@angular/http";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import {
  ReactiveFormsModule,
  FormsModule,
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from "@angular/forms";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { PersonasComponent } from "./feature/personas/personas.component";
import { LayoutComponent } from "./feature/layout/layout.component";
import { CrearPersonasComponent } from "./feature/crear-personas/crear-personas.component";
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import es from "@angular/common/locales/es";
import { registerLocaleData } from "@angular/common";
import { LOCALE_ID } from "@angular/core";
import { CrearCitasComponent } from './feature/crear-citas/crear-citas.component';
import { CitasComponent } from './feature/citas/citas.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
  declarations: [
    AppComponent,
    PersonasComponent,
    LayoutComponent,
    CrearPersonasComponent,
    CrearCitasComponent,
    CitasComponent    
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    BrowserAnimationsModule,
   
  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: "es-ES"
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}
