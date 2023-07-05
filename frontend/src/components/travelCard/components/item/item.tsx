import { FC, memo, useId } from 'react'
import cn, { Argument } from 'classnames'
import { Icon, TIcons } from '../../../ui/icon'
import { Tooltip } from 'react-tooltip'

export enum ItemValue {
  Document = 'Document',
  Parcel = 'Parcel',
  BigParcel = 'BigParcel'
}

export type ItemType = `${ItemValue}`

interface Props {
  type: ItemType,
  value: boolean,
  className?: Argument
}

export const Item: FC<Props> = memo(
  ({
     type,
     value,
     className
   }) => {
    const id = useId()

    let icon: TIcons
    let description: String

    switch (type) {
      case ItemValue.Document:
        icon = 'Document'
        description = "Documents"
        break
      case ItemValue.Parcel:
        icon = 'Box'
        description = "Small Parcel"
        break
      case ItemValue.BigParcel:
        icon = 'Suitcase'
        description = "Something big"
        break
      default:
        icon = 'Document'
        description = ""
    }

    return (
      <div className={cn('flex flex-col justify-between', className)}>
        <div>
          <Icon
            name={icon}
            className='text-black'
            data-tooltip-id={id}
            data-tooltip-place='right'
            data-tooltip-content={description}
          />
          <Tooltip id={id} />
        </div>
        <div>
          <Icon name={value ? 'Check' : 'Cross'} className='text-black' />
        </div>
      </div>
    )
  })
