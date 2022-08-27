import {Patient} from './patient';

export interface MedicalRecord {
  id?: number;
  patient?: Patient;
  hospitalizedDay?: string;
  hospitalDischargeDate?: string;
  reason?: string;
  treatments?: string;
  doctor?: string;
}
