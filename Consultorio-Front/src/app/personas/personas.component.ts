import { Component, OnInit } from '@angular/core';
import { RestService } from '../services/rest.service';
import { Persona } from '../interfaces/persona';
import swal from "sweetalert2";
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.scss']
})
export class PersonasComponent implements OnInit {
  public personas: Persona[] = [];
  public page: number = 1;
  public pageSize: number = 4;
  public collectionSize: number = this.personas.length;
  constructor(private service: RestService, public translate: TranslateService) { }
  ngOnInit() {
    this.getPersonas();
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

  confirmDelete(id) {
    swal({
      title: this.translate.instant("alerts.confirm"),
      text: this.translate.instant("alerts.sure_to_delete"),
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: this.translate.instant("buttons.yes"),
      cancelButtonText: this.translate.instant("buttons.cancel")
    }).then(result => {
      if (result.value) {
        this.deleteBook(id);
      }
    });
  }

  private deleteBook(id) {
    let url = `/consultorio/eliminarPersona/${id}`;
    this.service.queryDeleteRegular(url).subscribe(response => {
      let result = response;
      if (result) {
        this.getPersonas();
        swal({
          title: this.translate.instant("alerts.success"),
          text: this.translate.instant("alerts.persona_eliminada"),
          type: "success",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
        }).then(result => {
          return false;
        });
      }
      else {
        swal({
          title: this.translate.instant("alerts.error"),
          text: this.translate.instant("alerts.book_doesnt_exist"),
          type: "error",
          showCancelButton: false,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: this.translate.instant("buttons.ok"),
        }).then(result => {
          return false;
        });
      }
    }, err => {
      console.log(err);
    });
  }
}
