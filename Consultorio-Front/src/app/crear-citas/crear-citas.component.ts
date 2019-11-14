import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RestService } from '../services/rest.service';
import { TranslateService } from '@ngx-translate/core';
import swal from "sweetalert2";
import { Router } from '@angular/router';
import { Persona } from '../interfaces/persona';

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

    const loanData = {      
    };

    let url = `citas/crear/${controls["fecha_cita"].value}/${controls["persona"].value}`;
    this.service.queryPostRegular(url,loanData).subscribe(
      response => {
        let result = response;
        if (result) {          
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant("alerts.stored_loan"),
            type: "success",
            showCancelButton: false,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: this.translate.instant("buttons.ok"),            
          }).then(result => {
            
          this.router.navigate(["/citas"]); 
          });        
        } else {          
         
        }
      },
      err => {
        swal({
          title: this.translate.instant("alerts.error"),
          text: err.json().message,
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),            
        }).then(result => {
          return false;
        });
      }
    );
  }

  /**
   * Validates whether a field follows the validation rules
   *
   * @param controlName name of the control being evaluated
   * @param validationType type of the validation to be evaluated
   */
  public controlHasError(controlName: string, validationType: string): boolean {
    const control = this.myForm.controls[controlName];
    if (!control) {
      return false;
    }

    const result = control.hasError(validationType) && (control.dirty || control.touched);

    return result;
  }

  private getPersonas() {
    let url = `consultorio/obtenerPersonas`;
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
