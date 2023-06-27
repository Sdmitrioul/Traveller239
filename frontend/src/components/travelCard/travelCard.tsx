import React, { FC, memo } from 'react'
import { Travel } from '../../app/stores/travels/interfaces'
import './TravelCard.css'
import { TravelInfo } from './components/travelInfo/travelInfo'
import { TravelStops } from './components/travelStops'

interface Props {
  travel: Travel
}

export const TravelCard: FC<Props> = memo(({ travel }) => {
  return (
    <div className='TravelCard'>
      <TravelStops stops={travel.stops} />
      <TravelInfo travel={travel} />
    </div>
  )
})