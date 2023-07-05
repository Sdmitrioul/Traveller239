import { FC, memo } from 'react'
import { Travel } from '../../../../app/stores/travels/interfaces'
import { TravelCost } from '../travelCost'
import { Parcels } from '../parcels'
import { Description } from '../description'
import { UserDetails } from '../userDetails'

interface Props {
  travel: Travel
}

export const TravelInfo: FC<Props> = memo(({ travel }) => {
  return (
    <div className='pt-4 pr-4 pl-9 box-border flex  flex-col'>
      <TravelCost cost={travel.cost} currency={travel.currency} />
      <Parcels {...travel} />
      <Description description={travel.description} />
      <UserDetails user={travel.user} />
    </div>
  )
})
