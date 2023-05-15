import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsercontrolComponent } from './usercontrol/usercontrol.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [UsercontrolComponent],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  exports:[UsercontrolComponent]
})
export class UserModule { }
