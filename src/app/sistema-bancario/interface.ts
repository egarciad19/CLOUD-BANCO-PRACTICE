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

export interface Solicitud {
  cantidadMeses: number;
  estado: number;
  fechaAdiciono: Date | null;
  fechaModifico: Date | null;
  idCliente: Number;
  numeroIdentificacion:string | null;
  montoPrestamo: number;
  noSolicitud: number;
  tasaInteres: string;
  usuarioAdiciono: string | null;
  usuarioModifico: string | null;
}

export interface Prestamo {
  idPrestamo: number;
  montoAprobado: number;
  fechaAprobacion: string;
  cantidadMesesPlazo: number;
  saldoPendiente: number;
  estado: number;
  idCliente: {
    idCliente: number;
  };
}
