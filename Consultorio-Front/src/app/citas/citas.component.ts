import { Component, OnInit } from '@angular/core';
import { Loan } from '../interfaces/loan';
import { RestService } from '../services/rest.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-citas',
  templateUrl: './citas.component.html',
  styleUrls: ['./citas.component.scss']
})
export class CitasComponent implements OnInit {
  public loans: Loan[] = [];
  constructor(private service:RestService, public translate: TranslateService) { }

  ngOnInit() {
    this.getCitas();
  }

  private getCitas(){
    let url = `buscarLibrosPrestados`;
    this.service.queryExternalApi(url).subscribe(
      response => {
        let result = response.json();
        if (result) {
          this.loans = result;
        
        } else {          
          console.log('error');
        }
      },
      err => {
        console.log(err);
      }
    ); 
  }

}
