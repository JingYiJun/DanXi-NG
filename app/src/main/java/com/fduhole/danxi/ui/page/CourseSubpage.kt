package com.fduhole.danxi.ui.page

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EggAlt
import androidx.compose.runtime.Composable
import com.fduhole.danxi.R
import com.fduhole.danxi.ui.GlobalViewModel

class CourseSubpage(
    globalViewModel: GlobalViewModel,
) : Subpage {
    override val title = R.string.course
    override val icon = Icons.Filled.EggAlt
    override val scrollState = globalViewModel.courseScrollState
    override val body: @Composable BoxScope.() -> Unit = {}
    override val leading: @Composable () -> Unit = {}
    override val trailing: @Composable RowScope.() -> Unit = {}
}