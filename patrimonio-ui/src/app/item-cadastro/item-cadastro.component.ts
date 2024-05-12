
import { Component } from '@angular/core';
import {  FormsModule, ReactiveFormsModule,FormBuilder} from '@angular/forms';
import { TableModule } from 'primeng/table';
import { InputMaskModule } from 'primeng/inputmask';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';

import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-cadastro',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, TableModule,InputTextModule, InputMaskModule, ButtonModule, CalendarModule],
  providers:[ItemService],
  templateUrl: './item-cadastro.component.html',
  styleUrl: './item-cadastro.component.css'
})
export class ItemCadastroComponent {
  constructor(private itemService: ItemService, private formBuilder: FormBuilder){
    this.consultar ();
  }

  items: any [] = [];

  checkoutForm = this.formBuilder.group({
    etiqueta: '',
    dataAquisicao: null,
    descricao: ''
  });

  consultar (){
    this.itemService.listar()
        .subscribe((data)=> this.items = data)
  }

  criar(){
    this.itemService.adicionar(this.checkoutForm.value)
        .subscribe(()=> {
          this.consultar();
          this.checkoutForm.reset();
        })
  }


}
