package nl.codingwithlinda.testversionscatalog

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    count: Int,
    startCounter: () -> Unit,
    stopCounter: () -> Unit
) {
    Box(modifier = modifier) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Center
        ) {
            Text(text = "Count: $count")

            Button(onClick = { startCounter() }) {
                Text("Start Counter")
            }

            OutlinedButton (onClick = { stopCounter() }) {
                Text("Stop Counter")
            }

        }

    }
}