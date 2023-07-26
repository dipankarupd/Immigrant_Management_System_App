package com.example.immigrantmanagementsystem.view.admin.page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.immigrantmanagementsystem.view.admin.util.TabItem
import kotlinx.coroutines.launch
import com.example.immigrantmanagementsystem.R
import com.example.immigrantmanagementsystem.utils.navigation.Screen
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(navHostController: NavHostController,) {
    val tabs= listOf(
        TabItem.All,
        TabItem.Accepted,
        TabItem.Rejected,
        TabItem.Pending
    )

    val pagerState = rememberPagerState(pageCount = tabs.size)

    Scaffold(
        topBar = { TopBar(navHostController) }
    ) {
        Column() {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    TopAppBar(
        title = {Text(text = "Tabs", fontSize = 18.sp)},
        backgroundColor = Color.Cyan,
        contentColor = Color.Black,
        actions = {
            LogoutAction(navController)
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs: List<TabItem>,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Cyan,
        contentColor = Color.Black,
        indicator = {   tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed {idx, tab ->
            LeadingIconTab(
                icon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_find_in_page_24), contentDescription = "Find")},
                selected = pagerState.currentPage == idx,
                onClick = {
                          scope.launch {
                              pagerState.animateScrollToPage(idx)
                          }
                },
                text = { Text(text = tab.title, fontSize = 7.sp) }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screens()
    }
}

// provide the logout action in tob bar
@Composable
fun LogoutAction(navController: NavHostController) {
    val context = LocalContext.current
    
    IconButton(
        onClick = {
            navController.navigate(route = Screen.UserHome.route)
            Toast.makeText(context, "Logout Successful", Toast.LENGTH_SHORT).show()
        }
    ) {
       Icon(imageVector = Icons.Filled.ExitToApp, contentDescription ="logout" )
    }
}