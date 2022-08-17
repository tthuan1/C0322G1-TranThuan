import {Facility} from './facility';
import {Customer} from '../customer/customer';

export interface Contract {
  id?: number;
  facility?: Facility;
  customer?: Customer;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  total?: number;
  attachFacility?: string;
}
