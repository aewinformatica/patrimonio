import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  urlItems = 'http://localhost:8080/itens';

  constructor(private http:HttpClient) { }

  listar(){
    let headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa('aewinformatica:password')
    });


   return this.http.get<any[]>(this.urlItems,{
    headers
   })
  }

  adicionar(item: any){ 
    return this.http.post(this.urlItems, item);
  }
}
