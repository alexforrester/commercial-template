package foo.bar.clean.ui.actionhandlers.screens

import co.early.fore.kt.core.delegate.Fore
import foo.bar.clean.domain.features.favourites.FavouritesModel
import foo.bar.clean.ui.actionhandlers.Act
import foo.bar.clean.ui.actionhandlers.GlobalActionHandler
import foo.bar.clean.ui.actionhandlers.koinInject

class ActionHandlerFavouritesScreen(
    private val favouritesModel: FavouritesModel = koinInject(),
) : GlobalActionHandler<Act.ScreenFavourites>() {

    override fun __handle(act: Act.ScreenFavourites) {

        Fore.i("_handle ScreenFavourites Action: $act")

        when (act) {
            Act.ScreenFavourites.ClearAllFavourites -> favouritesModel.clearAllFavourites()
            is Act.ScreenFavourites.ClearFavourite -> favouritesModel.toggleFavourite(act.feature)
        }
    }
}
