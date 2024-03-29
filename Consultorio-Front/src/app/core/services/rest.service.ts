import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions } from "@angular/http";
import { environment } from "../../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class RestService {
  //public apiUrl: string = environment.api_url;
  constructor(private http: Http) {}

  /**
   *
   **/
  queryPostRegular(route: string, body) {
    let repos = this.http.post((route), body);
    return repos;
  }

  queryDeleteRegular(route: string) {
    let repos = this.http.delete((route));
    return repos;
  }

  queryGet(route: string) {
    let token = localStorage.getItem("token");
    let headers = new Headers({ Authorization: token });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.get((route), options);
    return repos;
  }

  queryPost(route: string, body) {
    let token = localStorage.getItem("token");
    let headers = new Headers({
      'Content-Type': 'application/json'
    });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.post((route), body, options);
    return repos;
  }

  queryDelete(route: string) {
    let token = localStorage.getItem("token");
    let headers = new Headers({ Authorization: token });
    let options = new RequestOptions({ headers: headers });
    let repos = this.http.delete((route), options);
    return repos;
  }

  queryExternalApi(route) {
    let repos = this.http.get((route));
    return repos;
  }
}
