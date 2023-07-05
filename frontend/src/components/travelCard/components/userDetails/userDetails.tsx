import { FC, memo, useState } from 'react'
import { UserDetails as UD } from '../../../../app/stores/travels/interfaces'
import cn from 'classnames'

interface Prop {
  user: UD
}

export const UserDetails: FC<Prop> = memo(({ user }) => {
  const [hidden, setHidden] = useState<boolean>(true)

  const showHandle = () => {
    setHidden(false)
  }

  return (
    <div className='flex-1 flex bg-grey mt-2 p-2 rounded-lg justify-between shadow-md'>
      <div className='self-end font-medium'>
        {user.name}
      </div>
      {

      }
      <div className={cn('self-end text-black', {
        'font-semibold': !hidden,
        'hover:font-semibold': hidden
      })} onClick={showHandle}>
        {hidden ? 'Show telegram' : user.telegramHandle}
      </div>
    </div>
  )
})