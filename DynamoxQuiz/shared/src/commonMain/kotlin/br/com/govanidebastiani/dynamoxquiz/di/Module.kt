package br.com.govanidebastiani.dynamoxquiz.di

import br.com.geovanidebastiani.dynamoxquiz.db.DynamoxQuizDatabase
import br.com.govanidebastiani.dynamoxquiz.core.data.DatabaseFactory
import br.com.govanidebastiani.dynamoxquiz.core.data.HttpClientFactory
import br.com.govanidebastiani.dynamoxquiz.player.data.local.PlayerLocalDataSource
import br.com.govanidebastiani.dynamoxquiz.player.data.repository.PlayerRepositoryImpl
import br.com.govanidebastiani.dynamoxquiz.player.domain.repository.PlayerRepository
import br.com.govanidebastiani.dynamoxquiz.player.domain.usecase.CreatePlayerUseCase
import br.com.govanidebastiani.dynamoxquiz.player.presentation.PlayerViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val targetModule: Module

val viewModelModule = module {
    viewModelOf(::PlayerViewModel)
}

val databaseModule = module {
    single { DatabaseFactory(get()).database }

    single { get<DynamoxQuizDatabase>().playerQueries }

    single { PlayerLocalDataSource(get()) }
}

val repositoryModule = module {
    single<PlayerRepository> { PlayerRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory { CreatePlayerUseCase(get()) }
}

val networkModule = module {
    single { HttpClientFactory.create(get()) }
}