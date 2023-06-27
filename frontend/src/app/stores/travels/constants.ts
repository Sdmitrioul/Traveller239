import { Travel } from './interfaces'

export const DEFAULT_BATCH_SIZE: number = 50

export const TEST_TRAVEL: Travel = {
  id: 1,
  description: 'Nonee',
  documents: true,
  smallParcel: true,
  bigParcel: true,
  cost: 20.0,
  currency: 'EU',
  userId: 1,
  stops: [
    {
      position: 0,
      date: '2024-03-19T23:00:00.000+00:00',
      city: 'Moscow'
    },
    {
      position: 1,
      date: '2024-03-19T23:00:00.000+00:00',
      city: 'Belgrad'
    }
  ]

}
