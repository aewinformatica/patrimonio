import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ItemCadastroComponent } from './item-cadastro/item-cadastro.component';

export const routes: Routes = [
    {path: "", component: ItemCadastroComponent},
    {path: '**', component: PageNotFoundComponent}
];
