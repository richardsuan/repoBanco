import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TarjetaService } from 'src/app/services/tarjeta/tarjeta.service';
@Component({
  selector: 'app-tarjetacontrol',
  templateUrl: './tarjetacontrol.component.html',
  styleUrls: ['./tarjetacontrol.component.css']
})
export class TarjetacontrolComponent implements OnInit {
  // tarjeta
  tarjeta: any;
  tarjetas: any;
  tarjetaForm!: FormGroup;
  idUsers: any;
  numeroEnrol: string;
  estado: string;
  constructor(
    public fb: FormBuilder,
    public tarjetaService: TarjetaService
  ) { }
  // 78
  ngOnInit(): void {
    this.tarjetaForm = this.fb.group({
      nombreTarjeta : ['', [Validators.required, Validators.maxLength(100)]],
      ano : ['', [Validators.required, Validators.minLength(4), Validators.maxLength(4), Validators.pattern('^[0-9]*$')]],
      numeroTarjeta : ['', [ Validators.required, Validators.minLength(16), Validators.maxLength(19), Validators.pattern('^[0-9]*$')]],
      miUsuario : ['', [ Validators.maxLength(4), Validators.pattern('^[0-9]*$')]],
      numeroEnrol : ['', [ Validators.minLength(4)]],
      estado : [''],
      tipoTarjeta : ['']
    });
    this.tarjetaService.getAllTarjetas().subscribe (res => {
      this.tarjetas = res;
      console.log(res);
    },
      error => { console.error(error); }
    );
    this.tarjetaService.getAllUsers().subscribe (res => {
      this.idUsers = res;
      console.log(res);
    },
      error => { console.error(error); }
    );
  }
  guardar(): void {
    console.log('holaaaaaaaaaa', this.tarjetaForm.value);
    if (this.tarjetaForm.valid){
        this.numeroEnrol = (Math.trunc(Math.random() * (100 - 1) + 1)).toString();
        alert('El numero para enrolar es:' + this.numeroEnrol);
        this.tarjetaForm.controls.numeroEnrol.setValue(this.numeroEnrol);
        this.tarjetaForm.controls.estado.setValue('creada');
        this.tarjetaService.saveTarjet(this.tarjetaForm.value).subscribe(res => {
        this.tarjetaForm.reset();
        this.tarjetas.push(res);
      },
        error => { console.error(error); }
      );
    }else{
      console.log('no es valido');
      console.log(this.tarjetaForm.value);
    }
  }
  buscarTarjeta(): void {
    this.tarjetaService.getSimilarTarjet(this.tarjetaForm.get('nombreTarjeta')?.value).subscribe(res => {
    this.tarjeta = res;
    console.log(this.tarjetaForm.get('nombreTarjeta')?.value);
  },
    error => { console.error(error); }
  );
  }
  eliminar(tarjeta: any): void {
    this.tarjetaService.deleteTarjeta(tarjeta).subscribe(res => {
    console.log(res);
    this.buscarTarjeta();
    if (res === true){
      this.tarjetas.pop(tarjeta);
    }
  },
    error => { console.error(error); }
  );
    this.tarjetaService.getAllTarjetas().subscribe (res => {
        this.tarjetas = res;
        console.log(res);
      },
      error => { console.error(error); }
    );
  }

    get nombreTarjeta() {
      return this.tarjetaForm.get('nombreTarjeta');
    }
    get ano() {
      return this.tarjetaForm.get('ano');
    }
    get genero() {
      return this.tarjetaForm.get('genero');
    }
    get numeroTarjeta() {
      return this.tarjetaForm.get('numeroTarjeta');
    }
    get miUsuario() {
      return this.tarjetaForm.get('miUsuario');
    }
}
