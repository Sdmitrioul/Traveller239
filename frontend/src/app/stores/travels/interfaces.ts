export interface TravelsState {
  travels: Travel[]
  batch: number,
  batchSize: number
}

export interface UserDetails {
  userId: number,
  name: string,
  telegramHandle: string
}

export interface Travel {
  id: number,
  description?: string | null,
  documents: boolean,
  smallParcel: boolean,
  bigParcel: boolean,
  cost: number,
  currency: Currency,
  user: UserDetails,
  stops: TravelStop[]
}

export enum CurrencyValue {
  EU = 'EU',
  RUB = 'RUB',
  USD = 'USD'
}

export type Currency = `${CurrencyValue}`

export interface TravelStop {
  position: number,
  date: string,
  city: string,
  country: string
}
