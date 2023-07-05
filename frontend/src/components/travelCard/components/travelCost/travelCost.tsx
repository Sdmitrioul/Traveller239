import { FC, memo } from 'react'
import { Currency } from '../../../../app/stores/travels/interfaces'
import { convertCurrency } from '../../../../utils/base'

interface Props {
  cost: number
  currency: Currency
}

export const TravelCost: FC<Props> = memo(({ cost, currency }) => {
  return (
    <div className='flex my-3'>
      <div className='mr-3 text-black text-lg font-semibold'>Cost from:</div>
      <div className='flex text-xl font-bold'>
        <div>{cost}</div>
        <div className='font-extrabold' dangerouslySetInnerHTML={{ __html: convertCurrency(currency) }} />
      </div>
    </div>
  )
})