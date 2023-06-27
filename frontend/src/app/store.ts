import { configureStore } from '@reduxjs/toolkit'
import travelsReducer from './stores/travels'

export const store = configureStore({
  reducer: {
    travels: travelsReducer
  }
})

export type RootState = ReturnType<typeof store.getState>

export type AppDispatch = typeof store.dispatch
