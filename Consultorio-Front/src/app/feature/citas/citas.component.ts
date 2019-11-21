import { Component, OnInit } from '@angular/core';
import {  Cita } from '../../shared/interfaces/cita';
import { RestService } from '../../core/services/rest.service';
import { TranslateService } from '@ngx-translate/core';
import swal from "sweetalert2";
@Component({
  selector: 'app-citas',
  templateUrl: './citas.component.html',
  styleUrls: ['./citas.component.scss']
})
export class CitasComponent implements OnInit {
  public citas: Cita[] = [];
  constructor(private service:RestService, public translate: TranslateService) { }

  ngOnInit() {
    this.getCitas();
  }

  private getCitas(){
    let url = `/api/cita/obtenerCitas`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.citas = result;
        
        } else {          
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    ); 
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
        this.deleteCita(id);
      }
    });
  }

  private deleteCita(id) {
    let url = `/api//cita/eliminarCita/${id}`;
    this.service.queryDeleteRegular(url).subscribe(response => {
      let result = response;
      if (result) {
        this.getCitas();
        swal({
          title: this.translate.instant("alerts.success"),
          text: this.translate.instant("alerts.cita_eliminada"),
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
