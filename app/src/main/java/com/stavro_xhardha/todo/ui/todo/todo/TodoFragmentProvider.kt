package com.stavro_xhardha.todo.ui.todo.todo

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TodoFragmentProvider {
    @ContributesAndroidInjector(modules = [TodoFragmentModule::class])
    internal abstract fun provideTodoFragmentFactory(): TodoFragment
}