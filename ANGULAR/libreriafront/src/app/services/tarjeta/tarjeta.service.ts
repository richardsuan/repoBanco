import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class TarjetaService {
  constructor(private httpClient: HttpClient) { }
  private API_SERVER = 'http://localhost:8181/';
  public getAllTarjetas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER + 'tarjetas/');
  }
  public saveTarjet(tarjeta: any): Observable<any>{
    console.log(tarjeta);
    return this.httpClient.post(this.API_SERVER + 'tarjeta/agregar/', tarjeta);
  }
  public getSimilarTarjet(tarjeta: any): Observable<any>{
    console.log(tarjeta);
    const params = new HttpParams().set('titulo', tarjeta);
    console.log(this.API_SERVER + 'user/buscar', { params });
    return this.httpClient.get<any>(this.API_SERVER + 'tarjeta/buscar', { params });
  }
  public deleteTarjeta(tarjeta: any): Observable<any>{// borra un user
    console.log(tarjeta.id);
    return this.httpClient.delete(this.API_SERVER + 'tarjeta/eliminar/' + tarjeta.id);
  }
  public getAllUsers(): Observable<any>{
    return this.httpClient.get(this.API_SERVER + 'users/');
  }
}
