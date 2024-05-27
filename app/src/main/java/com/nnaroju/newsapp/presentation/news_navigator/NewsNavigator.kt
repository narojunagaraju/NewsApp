package com.nnaroju.newsapp.presentation.news_navigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.presentation.bookmark.BookmarkScreen
import com.nnaroju.newsapp.presentation.bookmark.BookmarkViewModel
import com.nnaroju.newsapp.presentation.details.components.DetailsEvent
import com.nnaroju.newsapp.presentation.details.components.DetailsScreen
import com.nnaroju.newsapp.presentation.details.components.DetailsViewModel
import com.nnaroju.newsapp.presentation.home.HomeScreen
import com.nnaroju.newsapp.presentation.home.HomeViewModel
import com.nnaroju.newsapp.presentation.navgraph.Route
import com.nnaroju.newsapp.presentation.news_navigator.components.BottomNavigationItem
import com.nnaroju.newsapp.presentation.news_navigator.components.NewsBottomNavigation
import com.nnaroju.newsapp.presentation.search.SearchScreen
import com.nnaroju.newsapp.presentation.search.SearchViewModel

@Composable
fun NewsNavigator(modifier: Modifier = Modifier) {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(imageVector = Icons.Default.Home, "Home"),
            BottomNavigationItem(imageVector = Icons.Default.Search, "Search"),
            BottomNavigationItem(imageVector = Icons.Default.Save, "Bookmark")
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.SearchScreen.route ||
                backStackState?.destination?.route == Route.BookmarkScreen.route
    }

    selectedItem = remember(key1 = backStackState) {
        when (backStackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.SearchScreen.route -> 1
            Route.BookmarkScreen.route -> 2
            else -> 0
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTop(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTop(
                                navController = navController,
                                route = Route.SearchScreen.route
                            )

                            2 ->
                                navigateToTop(
                                    navController = navController,
                                    route = Route.BookmarkScreen.route
                                )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    modifier = modifier,
                    articles = articles,
                    navigateToSearch = {
                        navigateToTop(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    },
                    navigateToDetails = { article ->
                        navigateToDetails(navController = navController, article = article)
                    }
                )
            }

            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                    modifier = modifier,
                    state = state,
                    event = viewModel::onEvent,
                    navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController,
                            article = article
                        )
                    }
                )
            }
            composable(route = Route.DetailsScreen.route) {
                val viewModel: DetailsViewModel = hiltViewModel()
                viewModel.sideEffect?.let {
                    Toast.makeText(LocalContext.current, viewModel.sideEffect, Toast.LENGTH_SHORT)
                        .show()
                    viewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen(
                            article = article,
                            event = viewModel::onEvent,
                            navigateUp = {
                                navController.navigateUp()
                            })
                    }
            }

            composable(route = Route.BookmarkScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                val state = viewModel.bookMarkState.value
                BookmarkScreen(
                    modifier = modifier,
                    state = state,
                    navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController,
                            article = article
                        )
                    })
            }
        }
    }
}

fun navigateToTop(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails(
    navController: NavController,
    article: Article
) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(route = Route.DetailsScreen.route)
}