package `tests`.`coroutines`.`flow`.`configuration`.`annotations`.`enabled`

import co.touchlab.skie.configuration.annotations.FlowInterop
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import `tests`.`coroutines`.`flow`.sum

@FlowInterop.Enabled
fun foo(): Flow<Int> = flowOf(1, 2, 3)

class Bar @FlowInterop.Enabled constructor(
    val baz: Flow<Int>,
) {
    suspend fun sum(): Int {
        return sum(baz)
    }
}
