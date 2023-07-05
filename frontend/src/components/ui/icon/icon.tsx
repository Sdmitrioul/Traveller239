import { forwardRef, ReactElement, ReactNode } from 'react'
import cn, { Argument } from 'classnames'
import { icons, TIcons } from './icons'

interface IconItem {
  size: number
  viewBox: { w: number; h: number }
  stroke?: boolean
  fill?: boolean
  content: ReactElement | ReactNode
}

interface Props {
  id?: string
  name: TIcons
  size?: number
  stroke?: boolean
  fill?: boolean
  className?: Argument
  onClick?: (event: any) => void
  onMouseUp?: (event: any) => void
  onMouseDown?: (event: any) => void
}

export const Icon = forwardRef<SVGSVGElement, Props>(
  ({
     id,
     name,
     size,
     stroke,
     fill,
     className,
     onClick,
     onMouseDown,
     onMouseUp,
    ...other
   },
   ref): ReactElement => {
    const icon: IconItem = icons[name]

    // Square icon
    let width = size || icon.size
    let height = size || icon.size

    if (icon.viewBox.w !== icon.viewBox.h) {
      width = icon.viewBox.w
      height = icon.viewBox.h

      if (size) {
        width =
          icon.viewBox.w > icon.viewBox.h
            ? size
            : size * (icon.viewBox.w / icon.viewBox.h)

        height =
          icon.viewBox.h > icon.viewBox.w
            ? size
            : size * (icon.viewBox.h / icon.viewBox.w)
      }
    }

    return (
      <svg
        ref={ref}
        id={id}
        width={width}
        height={height}
        viewBox={`0 0 ${icon.viewBox.w} ${icon.viewBox.h}`}
        fill='none'
        xmlns='http://www.w3.org/2000/svg'
        className={cn(
          {
            'stroke-current':
              typeof stroke === 'boolean' ? stroke : icon.stroke,
            'fill-current': typeof fill === 'boolean' ? fill : icon.fill
          },
          className
        )}
        onMouseDown={onMouseDown}
        onMouseUp={onMouseUp}
        onClick={onClick}
        {...other}
      >
        {icon.content}
      </svg>
    )
  })