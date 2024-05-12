import { Component } from '@angular/core';
import { TableModule } from 'primeng/table';

import { ItemService } from '../item.service';


@Component({
  selector: 'app-item-cadastro',
  standalone: true,
  imports: [TableModule],
  providers:[ItemService],
  templateUrl: './item-cadastro.component.html',
  styleUrl: './item-cadastro.component.css'
})
export class ItemCadastroComponent {
  items: any [] = [];

  consultar (){
    this.itemService.listar()
        .subscribe((data)=> this.items = data)
  }

  constructor(private itemService: ItemService){
    this.consultar ();
  }


}
