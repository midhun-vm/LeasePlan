import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PriceListComponent } from './components/price-list/price-list.component';
import { UpdatePriceListComponent } from './components/update-price-list/update-price-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'priceList', pathMatch: 'full' },
  { path: 'priceList', component: PriceListComponent },
  { path: 'updatePriceList', component: UpdatePriceListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
