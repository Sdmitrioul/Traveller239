import { createBrowserRouter } from 'react-router-dom'
import { NavigationPaths } from './navigation'
import { MainPage } from '../pages/main'
import { FAQ } from '../pages/faq'
import { UserInfo } from '../pages/userInfo'
import { UserTravels } from '../pages/userTravels'
import { TravelWizard } from '../pages/travelWizard'
import { NotFound } from '../pages/notFound'

export const router = createBrowserRouter([
  {
    path: NavigationPaths.Index,
    element: <MainPage />,
    errorElement: <NotFound />
  },
  {
    path: NavigationPaths.FAQ,
    element: <FAQ />
  },
  {
    path: NavigationPaths.UserInfo,
    element: <UserInfo />
  },
  {
    path: NavigationPaths.UserTravels,
    element: <UserTravels />
  },
  {
    path: NavigationPaths.TravelWizard,
    element: <TravelWizard />
  }
])
