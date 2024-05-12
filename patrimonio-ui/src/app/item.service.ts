import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  urlItems = 'http://localhost:8080/itens';

  constructor(private http:HttpClient) { }

  listar(){
   return this.http.get<any[]>(this.urlItems)
  }

  adicionar(item: any){ 
    return this.http.post(this.urlItems, item);
  }
}
