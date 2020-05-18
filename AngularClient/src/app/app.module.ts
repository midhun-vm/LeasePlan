import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PriceListComponent } from './components/price-list/price-list.component';
import { UpdatePriceListComponent } from './components/update-price-list/update-price-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PriceListComponent,
    UpdatePriceListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
