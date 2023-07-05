import cn, { Argument } from 'classnames'
import { FC, memo } from 'react'

interface DotProps {
  className?: Argument
}

export const Dot: FC<DotProps> = ({ className }) => (
  <div className={cn('w-2 h-2 rounded bg-black shadow', className)}></div>
)

interface DotsProps {
  count: number,
  className?: Argument
}
export const Dots: FC<DotsProps> = memo(({count, className}) => (
  <div className={cn('flex flex-col',className)}>
    {
      Array.from(Array(count).keys()).map(i => <Dot key={i} className='mb-3 last:mb-0' />)
    }
  </div>
))
