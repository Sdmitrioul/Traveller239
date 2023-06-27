import { ReactNode } from 'react'
import { useSelector } from 'react-redux'
import { RootState } from '../../app/store'
import { Travel } from '../../app/stores/travels/interfaces'
import { TravelCard } from '../../components/travelCard'

export const MainPage = (): ReactNode => {
  const travels: Travel[] = useSelector((state: RootState) => state.travels.travels)

  return (
    <div className='pt-2 flex flex-col justify-center max-w-[800px] flex-1'>
      {
        travels.map(travel => (<TravelCard travel={travel} key={travel.id} />))
      }
    </div>
  )
}