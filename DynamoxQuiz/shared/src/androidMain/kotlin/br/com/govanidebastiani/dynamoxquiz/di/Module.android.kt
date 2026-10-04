package br.com.govanidebastiani.dynamoxquiz.di

import br.com.govanidebastiani.dynamoxquiz.core.data.DatabaseDriverFactory
import br.com.govanidebastiani.dynamoxquiz.data.AndroidDatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val targetModule: Module
    get() = module {
        single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
    }
