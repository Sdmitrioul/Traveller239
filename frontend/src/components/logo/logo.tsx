import { ReactElement } from 'react'

export const Logo = (): ReactElement => {
  return (
    <div className='flex flex-col py-2 text-black'>
      <div className='font-semibold text-3xl !leading-6'>
        Traveler
      </div>
      <div className='w-full grid'>
        <div className='justify-self-start font-extrabold text-3xl !leading-6'>
          239
        </div>
      </div>
    </div>
  )
}