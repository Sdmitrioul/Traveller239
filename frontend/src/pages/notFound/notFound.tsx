import { ReactElement } from 'react'
import { isRouteErrorResponse, useRouteError } from 'react-router-dom'

export const NotFound = (): ReactElement => {
  const error = useRouteError()

  console.log(error)

  const errorMessage: string = isRouteErrorResponse(error) ? error.statusText : 'Unkown'

  return (
    <>
      Ooops....
      {errorMessage}
    </>
  )
}