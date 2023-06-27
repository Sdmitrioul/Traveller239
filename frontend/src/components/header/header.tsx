import { ReactElement } from 'react'
import { Logo } from '../logo'
import { Navigation } from '../navigation'
import { UserLogo } from '../userLogo'
import './header.css'

export const Header = (): ReactElement => {
  return (
    <div className='Header border-b border-b-grey'>
      <Logo />
      <Navigation />
      <UserLogo />
    </div>
  )
}