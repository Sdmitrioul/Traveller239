import { FC, memo } from 'react'
import { Travel } from '../../../../app/stores/travels/interfaces'

interface Props {
  travel: Travel
}

export const TravelInfo: FC<Props> = memo(({travel}) => {
  return(
    <div>
      Travel
    </div>
  )
})