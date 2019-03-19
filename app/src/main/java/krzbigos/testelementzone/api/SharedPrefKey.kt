package krzbigos.testelementzone.api

import android.content.Context

private const  val PREFERENCE_NAME:String ="Krzbigos.TestElementZone"
private const val PREFERENCE_KEY:String ="KeyValue"

class SharedPrefKey(context: Context) {
    private val preference=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun setSharedPrefKey(key: String){
        val editor=preference.edit()
        editor.putString(PREFERENCE_KEY,key)
        editor.apply()
    }
    fun getSharedPrefKey(): String {
        return preference.getString(PREFERENCE_KEY,"0")
    }
}