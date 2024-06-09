export interface Cliente {
  apellido: string;
  correoElectronico: string;
  estado: number;
  fechaAdiciono: Date | null;
  fechaModifico: Date | null;
  fechaNacimiento: Date | null;
  idCliente: number | null;
  nombre: string;
  numeroIdentificacion: string;
  direccion:string;
  telefono: string;
  usuarioAdiciono: string| null;
  usuarioModifico: string | null;
}

