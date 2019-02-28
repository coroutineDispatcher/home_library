package com.stavro_xhardha.home_library.ui.book.todo

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BookFragmentProvider {
    @ContributesAndroidInjector(modules = [BookFragmentModule::class])
    internal abstract fun provideTodoFragmentFactory(): BooksFragment
}