import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RestService } from '../../core/services/rest.service';
import { TranslateService } from '@ngx-translate/core';
import swal from "sweetalert2";
import { Router } from '@angular/router';
import { Persona } from '../../shared/interfaces/persona';

@Component({
  selector: 'app-crear-citas',
  templateUrl: './crear-citas.component.html',
  styleUrls: ['./crear-citas.component.scss']
})
export class CrearCitasComponent implements OnInit {
  public myForm: FormGroup; 
  public personas: Persona[] = [];
  constructor(private service:RestService,public translate:TranslateService,private router:Router) { }

  ngOnInit() { 
    this.getPersonas();
    this.myForm = new FormGroup({
      fecha_cita: new FormControl("fecha_cita", [Validators.required]),      
      persona: new FormControl("persona", [Validators.required])
    });
  }

  store() {
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const citaData = {
      fechaCita: controls["fecha_cita"].value,
      persona: controls["persona"].value
    };
let data ={
  "fechaCita":citaData.fechaCita,
   "persona": JSON.parse(citaData.persona)
  
}
    let url = `/api/cita/agregarCita`;
    let body =JSON.stringify(data);
    this.service.queryPost(url, body).subscribe(
      response => {
        let result = response;
        if (result) {          
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant("alerts.cita_guardada"),
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),            
          }).then(result => {
            
          this.router.navigate([""]); 
          });        
        } else {          
          swal({
            title: this.translate.instant("alerts.error"),
            text: this.translate.instant("alerts.cannot_delete_book"),
            type: "error",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),            
          }).then(result => {
            return false;
          });
        }
      },
      err => {
        console.log(err);
      }
    );
  }


  

  public controlHasError(controlName: string, validationType: string): boolean {
    const control = this.myForm.controls[controlName];
    if (!control) {
      return false;
    }

    const result = control.hasError(validationType) && (control.dirty || control.touched);

    return result;
  }

  private getPersonas() {
    let url = `/api/consultorio/obtenerPersonas`;
    this.service.queryExternalApi(url).subscribe(response => {
      let result = response.json();
      if (result) {
        this.personas = result;
      }
      else {
        console.log('error');
      }
    }, err => {
      console.log(err);
    });
  }

}
