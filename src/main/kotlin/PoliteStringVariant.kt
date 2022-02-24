import kotlin.reflect.KProperty

class PoliteStringVariant(private val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}