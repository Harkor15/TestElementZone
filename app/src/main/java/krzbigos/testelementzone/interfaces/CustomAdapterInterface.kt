package krzbigos.testelementzone.interfaces

import krzbigos.testelementzone.model.SingleOrder

interface CustomAdapterInterface {
    fun completeListView(listViewData: List<SingleOrder>)
}