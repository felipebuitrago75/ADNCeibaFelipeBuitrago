import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './feature/layout/layout.component';
import { PersonasComponent } from "./feature/personas/personas.component";
import { CrearPersonasComponent } from './feature/crear-personas/crear-personas.component';
import { CrearCitasComponent } from './feature/crear-citas/crear-citas.component';
import { CitasComponent } from './feature/citas/citas.component';

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
