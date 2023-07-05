import { FC, memo, useId, useMemo } from 'react'
import { TravelStop as TS } from '../../../../app/stores/travels/interfaces'
import { Tooltip } from 'react-tooltip'

interface Props {
  stop: TS
}

export const TravelStop: FC<Props> = memo(({ stop }) => {
  const date = useMemo(() => new Date(stop.date), [stop.date])
  const id = useId()

  return (
    <div className='rounded-lg border border-grey mb-2 last:mb-0 hover:bg-grey shadow-md'>
      <div className='flex justify-center'>
        <div className='flex'>
          <div
            data-tooltip-id={id}
            data-tooltip-place='top'
            data-tooltip-content={stop.country}
            className='text-lg font-semibold'
          >
            {stop.city}
          </div>
          <Tooltip id={id} />
        </div>
      </div>
      <div className='text-xs italic'>
        {date.toLocaleDateString()}
      </div>
    </div>
  )
})