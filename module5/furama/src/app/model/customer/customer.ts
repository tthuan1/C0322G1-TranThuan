import {CustomerType} from './customer-type';

export interface Customer {
  readonly id?: number;
  name?: string;
  birthday?: string;
  gender?: number;
  idCard?: number;
  phone?: string;
  email?: string;
  address?: string;
  customerType?: CustomerType;
}
