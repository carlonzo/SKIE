# SwiftCompilationError(error: argument type 'SkieSwiftFlow<KotlinInt>' does not conform to expected type 'Kotlinx_coroutines_coreFlow')

func sum() -> SkieSwiftFlow<KotlinInt> {
    fatalError("Should not be called")
}

let _ = Bar(baz: sum())

exit(128)
