func intFlow() -> SkieSwiftFlow<KotlinInt> {
    return AKt.foo()
}

let bar = Bar(baz: intFlow())

let result = try! await bar.sum().int32Value

exit(result - 6)
