import { FC, memo } from 'react'

interface Props {
  description?: string | null
}

export const Description: FC<Props> = memo(({ description }) => {
  const EMPTY_DESCRIPTION = 'No description.'
  return (
    <div className='flex'>
      <div>
        {description === null || !description || description.length === 0 ? EMPTY_DESCRIPTION : description}
      </div>
    </div>
  )
})