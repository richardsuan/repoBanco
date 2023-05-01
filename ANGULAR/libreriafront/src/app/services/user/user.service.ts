import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {



  constructor(private httpClient: HttpClient) { }

  private API_SERVER = 'http://localhost:8181/';
  public getAllUser(): Observable<any>{
    return this.httpClient.get(this.API_SERVER + 'users/');
  }

  public saveUser(user: any): Observable<any>{
    console.log(user);
    return this.httpClient.post(this.API_SERVER + 'user/agregar/', user);
  }
  public getsimilarUser(user: string, busqueda: string): Observable<any>{// guarda un user
    console.log(user, '  user');
    console.log(busqueda + '  tipo');
    // console.log(user..get('nombre').value);
    const params = new HttpParams().set('valor', user).set('tipo', busqueda);
    // params.append
    console.log(this.API_SERVER + 'user/buscar', { params });
    // var headers = JSON.stringify(user)
    return this.httpClient.get<any>(this.API_SERVER + 'user/buscar', { params });
  }



  public deletePersona(persona: any): Observable<any>{// borra un user
    console.log(persona.id);
    return this.httpClient.delete(this.API_SERVER + 'user/eliminar/' + persona.id);
  }
}
