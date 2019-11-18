import { Persona } from './persona';

export interface Cita {
    id: number;
    fechaCita: Date;  
    costoCita: number;  
    persona: Persona;  
}
