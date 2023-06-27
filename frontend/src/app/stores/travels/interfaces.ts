export interface TravelsState {
  travels: Travel[]
  batch: number,
  batchSize: number
}

export interface Travel {
  id: number,
  description: string,
  documents: boolean,
  smallParcel: boolean,
  bigParcel: boolean,
  cost: number,
  currency: Currency,
  userId: number,
  stops: TravelStop[]
}

export type Currency = 'EU' | 'RUB' | 'USD'

export interface TravelStop {
  position: number,
  date: string,
  city: string
}
