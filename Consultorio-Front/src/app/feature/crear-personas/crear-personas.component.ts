import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { Router, ActivatedRoute } from "@angular/router";
import { RestService } from "../../core/services/rest.service";
import swal from "sweetalert2";
import { FormGroup, FormControl, Validators } from "@angular/forms";

@Component({
  selector: "app-crear-personas",
  templateUrl: "./crear-personas.component.html",
  styleUrls: ["./crear-personas.component.scss"]
})
export class CrearPersonasComponent implements OnInit {
  public editing: boolean = false;
  private identificacion: number = null;
  private nombre: string = null;
  private edad: number = null;
  public myForm: FormGroup;
  constructor(
    private translate: TranslateService,
    private router: Router,
    private service: RestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.identificacion = this.route.snapshot.queryParams["identificacion"];
    this.nombre = this.route.snapshot.queryParams["nombre"];
    this.edad = this.route.snapshot.queryParams["edad"];

    this.myForm = new FormGroup({
      identificacion: new FormControl("identificacion", [Validators.required]),
      nombre: new FormControl("nombre", [Validators.required]),
      edad: new FormControl("edad", [Validators.required]),
    });

    if (null !== this.identificacion && undefined !== this.identificacion) {
      this.myForm.controls["identificacion"].setValue(this.identificacion);
      this.editing = true;
    }

   
      this.myForm.controls["nombre"].setValue("");
    

    if (null !== this.edad && undefined !== this.edad) {
      this.myForm.controls["edad"].setValue(this.edad);
    }

  }


  store() {
    let controls = this.myForm.controls;
    if (this.myForm.invalid) {
      Object.keys(controls).forEach(controlName =>
        controls[controlName].markAsTouched()
      );
      return;
    }

    const personaData = {
      identificacion: controls["identificacion"].value,
      nombre: controls["nombre"].value,
      edad: controls["edad"].value
    };
let data ={
  "nombre":personaData.nombre,
  "edad":personaData.edad,
  "numeroIdentificacion":personaData.identificacion
}
    let url = `/api/consultorio/agregarPersona`;
    let body =JSON.stringify(data);
    this.service.queryPost(url, body).subscribe(
      response => {
        let result = response;
        if (result) {          
          swal({
            title: this.translate.instant("alerts.success"),
            text: this.translate.instant("alerts.persona_guardada"),
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

    const result =
      control.hasError(validationType) && (control.dirty || control.touched);

    return result;
  }
}
