package com.android.modul5.di

import com.android.modul5.data.local.MovieDatabase
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.data.repository.MovieRepositoryImpl
import com.android.modul5.domain.repository.MovieRepository
import com.android.modul5.domain.usecase.AddFavMovieUseCase
import com.android.modul5.domain.usecase.CheckFavMovieUseCase
import com.android.modul5.domain.usecase.GetAnimeMoviesUseCase
import com.android.modul5.domain.usecase.GetFavoriteMoviesUseCase
import com.android.modul5.domain.usecase.GetIndonesiaMovieUseCase
import com.android.modul5.domain.usecase.GetMovieDetailUseCase
import com.android.modul5.domain.usecase.GetPopularMoviesUseCase
import com.android.modul5.domain.usecase.RemoveFavMovieUseCase
import com.android.modul5.domain.usecase.SearchMoviesUseCase
import com.android.modul5.presentation.viewmodel.FavoriteMovieViewModel
import com.android.modul5.presentation.viewmodel.MovieDetailViewModel
import com.android.modul5.presentation.viewmodel.MovieSearchViewModel
import com.android.modul5.presentation.viewmodel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MovieDatabase.getDatabase(androidContext()) }
    single { get<MovieDatabase>().favoriteMovieDAO() }
    single { RetrofitClient.tmdbAPI }
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }

    factory { GetPopularMoviesUseCase(get ()) }
    factory { GetAnimeMoviesUseCase(get()) }
    factory { GetIndonesiaMovieUseCase(get()) }
    factory { GetMovieDetailUseCase(get ()) }
    factory { GetFavoriteMoviesUseCase(get ()) }
    factory { SearchMoviesUseCase(get ()) }
    factory { AddFavMovieUseCase(get ()) }
    factory { RemoveFavMovieUseCase(get ()) }
    factory { CheckFavMovieUseCase(get ()) }

    viewModel { MovieViewModel(
        getPopularMoviesUseCase = get (),
        getAnimeMoviesUseCase = get(),
        getIndonesiaMovieUseCase = get()
    ) }
    viewModel { FavoriteMovieViewModel(
        getFavoriteMoviesUseCase = get (),
        removeFavMovieUseCase = get()
    ) }
    viewModel { MovieSearchViewModel(searchMoviesUseCase = get ()) }
    viewModel { MovieDetailViewModel(
            addFavMovieUseCase = get(),
            removeFavMovieUseCase = get(),
            checkFavMovieUseCase = get(),
            getMovieDetailUseCase = get(),
    ) }
}