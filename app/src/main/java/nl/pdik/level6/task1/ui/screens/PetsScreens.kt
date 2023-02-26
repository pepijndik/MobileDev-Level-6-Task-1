package nl.pdik.level6.task1.ui.screens

import androidx.annotation.StringRes
import nl.pdik.level6.task1.R

/**
 * Screen metadata for Pets app.
 */

sealed class PetsScreens(val route: String, @StringRes val labelResourceId: Int) {
    object CatsScreen : PetsScreens("cats", R.string.cats)
    object DogsScreen : PetsScreens("dogs", R.string.dogs)
}
