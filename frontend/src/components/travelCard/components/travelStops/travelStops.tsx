import { FC, memo } from 'react'
import { TravelStop as TS } from '../../../../app/stores/travels/interfaces'
import { TravelStop } from '../travelStop'
import { Dots } from '../../../dots'

interface Props {
  stops: TS[]
}

export const TravelStops: FC<Props> = memo(({ stops }) => {
  return (
    <div className='self-center'>
      {stops.map((stop, index) =>
        <>
          <TravelStop key={stop.position} stop={stop} />
          {index < stops.length - 1 && (
            <div className='flex justify-center mb-2'>
              <Dots count={2} />
            </div>)}
        </>)}
    </div>
  )
})
