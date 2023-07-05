import { Currency, CurrencyValue } from '../app/stores/travels/interfaces'

export const convertCurrency = (currency?: Currency | null): string => {
  switch (currency) {
    case CurrencyValue.EU:
      return '&#8364;'
    case CurrencyValue.RUB:
      return '&#8381;'
    case CurrencyValue.USD:
      return '&#36;'
    default:
      return 'Unknown'
  }
}