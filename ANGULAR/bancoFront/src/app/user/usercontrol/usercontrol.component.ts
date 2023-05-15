import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user/user.service';
@Component({
  selector: 'app-usercontrol',
  templateUrl: './usercontrol.component.html',
  styleUrls: ['./usercontrol.component.css']
})
export class UsercontrolComponent implements OnInit {
  private emailPattern: any = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  userForm!: FormGroup;
  persona: any;
  personas: any;
  verSeleccion: any;
  opcionSeleccionado: any;
  busqueda = [
    {name: '', valor : '1'},
    {name: 'ID DB', valor : '2'},
    {name: '# de Documento', valor : '3'},
    {name: 'NOMBRE', valor : '4'},
    {name: 'CORREO', valor : 7},
  ];
  estados: any;
  constructor(
    public fb: FormBuilder,
    public usuarioService: UserService
  ) {

   }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      id : [''],
      d_identidad : ['', [Validators.required, Validators.maxLength(12), Validators.pattern('^[0-9]*$')]],
      nombre : ['', [Validators.required, Validators.minLength(5), Validators.maxLength(400), Validators.pattern('[a-zA-Z ]*')]],
      // ,Validators.maxLength(400),Validators.pattern("[a-zA-Z ]*")
      fecha_nacimiento : ['', Validators.required],
      correo : ['', [Validators.required, Validators.pattern(this.emailPattern), Validators.maxLength(400)]] ,
      tarjetasUsuario : ['' ]
    });
    this.usuarioService.getAllUser().subscribe (res => {
      this.personas = res;
      console.log(res);
    },
      error => { console.error(error); }
    );

  }
  guardar(): void {
    if (this.userForm.valid) {
        this.usuarioService.saveUser(this.userForm.value).subscribe(res => {
        this.userForm.reset();
        this.personas.push(res);
      },
        error => { console.error(error); }
      );
    }else{
        console.log('error');
        console.log(this.userForm.value);
    }
  }
  eliminar(persona: any): void {
    this.usuarioService.deletePersona(persona).subscribe(res => {
    console.log(res);
    if (res === true){
      this.personas.pop(persona);
    }
  },
    error => { console.error(error); }
  );
}
  buscarUser(): void {
    this.usuarioService.getsimilarUser(this.userForm.get('nombre')?.value, this.verSeleccion).subscribe(res => {
    this.persona = res;
    console.log('buscar user', res);
  },
    error => { console.error(error); }
  );
}
capturar() {
  this.verSeleccion = this.opcionSeleccionado.valor;
  console.log(this.opcionSeleccionado.valor);
}
  get nombre() {
    return this.userForm.get('nombre');
  }
  get d_identidad() {
    return this.userForm.get('d_identidad');
  }

  get correo() {
    return this.userForm.get('correo');
  }
}
