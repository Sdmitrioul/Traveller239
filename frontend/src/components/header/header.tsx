import { ReactElement } from 'react'
import { Logo } from '../logo'
import { Navigation } from '../navigation'
import { UserLogo } from '../userLogo'
import './header.css'

export const Header = (): ReactElement => {
  return (
    <div className='Header'>
      <Logo />
      <Navigation />
      <UserLogo />
    </div>
  )
}