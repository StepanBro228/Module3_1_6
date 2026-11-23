package com.example.module3_1_6.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module3_1_6.data.cardItems

@Composable
fun AppNavHost(widthSizeClass: WindowWidthSizeClass) {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Home") {
                HomeScreen(widthSizeClass, onDetailsClick = { navController.navigate("Details") })
            }
            composable("Details") {
                DetailsScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(widthSizeClass: WindowWidthSizeClass, onDetailsClick: () -> Unit) {
    when (widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(modifier = Modifier.fillMaxSize()) {
                CounterBlock(onDetailsClick, modifier = Modifier.fillMaxWidth())
                CardList(cardItems)
            }
        }
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
            Row(modifier = Modifier.fillMaxSize()) {
                CardList(cardItems, modifier = Modifier.weight(1f))
                CounterBlock(onDetailsClick, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CounterBlock(
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier,
    counterViewModel: CounterViewModel = viewModel()
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Счётчик: ${counterViewModel.count.intValue}", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { counterViewModel.increment() }) {
            Text("Увеличить")
        }
        Button(onClick = onDetailsClick) {
            Text("Перейти в Details")
        }
    }
}

@Composable
fun DetailsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Details", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Это экран с подробной информацией. Сюда можно попасть с экрана Home.")
    }
}
