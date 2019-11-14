import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { PersonasComponent } from "./personas/personas.component";
import { CrearPersonasComponent } from './crear-personas/crear-personas.component';
import { CrearCitasComponent } from './crear-citas/crear-citas.component';
import { CitasComponent } from './citas/citas.component';

const routes: Routes = [  
  { path: "",component: LayoutComponent,
  children: [
    { path: "", component: PersonasComponent }       
  ] },
  
  {
    path: "",
    component: LayoutComponent,
    children: [
      { path: "crear-persona", component: CrearPersonasComponent }   ,
      { path: "crear-cita", component: CrearCitasComponent },
      { path: "citas", component: CitasComponent }          
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
