import { FC, memo } from 'react'
import { Item, ItemValue } from '../item/item'

interface Props {
  documents: boolean,
  smallParcel: boolean,
  bigParcel: boolean,
}

export const Parcels: FC<Props> = memo(({ documents, bigParcel, smallParcel }) => {
  return (
    <div className='px-4 py-3 flex justify-around bg-grey rounded-lg shadow-md'>
      <Item type={ItemValue.Document} value={documents} />
      <Item type={ItemValue.Parcel} value={smallParcel} />
      <Item type={ItemValue.BigParcel} value={bigParcel} />
    </div>
  )
})