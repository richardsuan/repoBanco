import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsercontrolComponent } from './user/usercontrol/usercontrol.component';
import { InicioComponent } from './inicio/inicio/inicio.component';
import { TarjetacontrolComponent } from './tarjeta/tarjetacontrol/tarjetacontrol.component';



const routes: Routes = [
  { path: '', component: InicioComponent},
  { path: 'user', component: UsercontrolComponent},
  { path: 'tarjeta', component: TarjetacontrolComponent},
  { path: '**', component: InicioComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
