import kotlin.reflect.KProperty

class PoliteString(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        content.replace("stupid", "s*****")

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, s: String) {
        content = s
    }
}