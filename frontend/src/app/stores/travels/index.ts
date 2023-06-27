import { TravelsState } from './interfaces'
import { createSlice } from '@reduxjs/toolkit'
import { DEFAULT_BATCH_SIZE, TEST_TRAVEL } from './constants'

const initialState: TravelsState = {
  travels: [TEST_TRAVEL, TEST_TRAVEL, TEST_TRAVEL, TEST_TRAVEL],
  batch: -1,
  batchSize: DEFAULT_BATCH_SIZE
}

export const travelsSlice = createSlice({
  name: 'travels',
  initialState,
  reducers: {}
})

export default travelsSlice.reducer