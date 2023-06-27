import { FC, memo } from 'react'
import { TravelStop } from '../../../../app/stores/travels/interfaces'

interface Props {
  stops: TravelStop[]
}

export const TravelStops: FC<Props> = memo(({ stops }) => {
  return(
    <div>
      stops
    </div>
  )
})
