import { Travel } from './interfaces'

export const DEFAULT_BATCH_SIZE: number = 50

export const TEST_TRAVEL: Travel = {
  id: 1,
  description: '',
  documents: true,
  smallParcel: false,
  bigParcel: true,
  cost: 20.0,
  currency: 'EU',
  user: {
    userId: 1,
    name: 'Dmitrii Skroba',
    telegramHandle: '@dmitriSDV239'
  },
  stops: [
    {
      position: 0,
      date: '2024-03-19T23:00:00.000+00:00',
      city: 'Moscow',
      country: 'Russia'
    },
    {
      position: 1,
      date: '2024-03-19T23:00:00.000+00:00',
      city: 'St.Petersburg',
      country: 'Russia'
    },
    {
      position: 1,
      date: '2024-03-19T23:00:00.000+00:00',
      city: 'Belgrad',
      country: 'Serbia'
    }
  ]

}
