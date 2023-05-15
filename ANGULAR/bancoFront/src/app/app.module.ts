import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { TarjetaModule } from './tarjeta/tarjeta.module';
import { UserModule } from './user/user.module';
import { InicioModule } from './inicio/inicio.module';

//import { EditorialcontrolComponent } from './editorial/editorialcontrol/editorialcontrol.component';   EditorialcontrolComponent

@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TarjetaModule ,
    UserModule,
    InicioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
