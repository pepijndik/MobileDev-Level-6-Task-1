package nl.pdik.level6.task1.ui.screens.cats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.pdik.level6.task1.R
import nl.pdik.level6.task1.data.api.Api
import nl.pdik.level6.task1.data.api.util.Resource
import nl.pdik.level6.task1.data.model.Cat

@Composable
fun CatsScreen(
    viewModel: CatsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val catResource: Resource<Cat>? by viewModel.catResource.observeAsState()
    val imageUrl = Api.CATS_BASE_URL +  catResource?.data?.urlExtension
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This will become the catsscreen",
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .heightIn(min = 16.dp)
        )
        ExtendedFloatingActionButton(
            text = { Text(text = stringResource(R.string.get_cat)) },
            onClick = { viewModel.getCat() },
            icon = { Icon(Icons.Filled.Refresh, "") },
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
        )

    }
}
