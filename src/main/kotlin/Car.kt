// properties of classes in the constructor are identified by either 'val' (immutable) or 'var' (mutable)
// this example includes one property, 'yearOfMake' and one parameter 'color'
public class Car(public val yearOfMake: Int, color: String) {
    // the access permission for the getter is the same as that for the property. you may provide a different
    // access permission for the setter if you like.
    // this example defines the setter method for the fuelLevel property as private while the getter method
    // is synthesized as a public method.
    var fuelLevel = if (yearOfMake < 2020) 90 else 100
        private set

    // define a mutable property and initialize value from input parameter
    // define a setter method for the new property
    // setting just a 'set' or 'get' for the property will automatically synthesize a backing field
    // providing both a 'set' and a 'get' will not synthesize a backing field (get or set)
    // the effect in the example below is such that a getter will automatically be synthesized
    var color = color
        set(value) {
            if (value.isBlank()) {
                throw java.lang.RuntimeException("no empty, please")
            }
            field = value
        }

    // a class may have zero or more 'init' blocks. these blocks are executed as part of the primary constructor
    // execution. the order of execution of the 'init' blocks is top-down. within an 'init' block  you may access
    // only properties that are already defined above the block. since the properties and parameters declared in the
    // primary constructor are visible throughout the class, any 'init' block within the class can use them.
    // but to use a property defined within the class, you'll have to write the 'init' block after the said
    // property's definition.
    init {
        if (yearOfMake < 2020) { fuelLevel = 90 }
    }
}
