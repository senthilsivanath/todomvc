import { IB } from 'app/shared/model/b.model';

export interface IA {
  id?: number;
  name?: string;
  age?: number | null;
  bs?: IB[] | null;
}

export const defaultValue: Readonly<IA> = {};
