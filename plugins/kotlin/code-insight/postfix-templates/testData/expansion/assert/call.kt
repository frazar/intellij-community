fun test() {
    Processor.shouldProcess()<caret>
}

object Processor {
    fun shouldProcess(): Boolean = true
}

// IGNORE_FIR