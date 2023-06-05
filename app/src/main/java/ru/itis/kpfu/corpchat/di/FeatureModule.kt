package ru.itis.kpfu.corpchat.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.fragment.AuthCompanySignUpIndustryFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.viewmodel.AuthCompanySignUpIndustryModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.photo.fragment.AuthSignUpPhotoFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.photo.viewmodel.AuthSignUpPhotoModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.fragment.AuthCompanySignUpNameFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.viewmodel.AuthCompanySignUpNameModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.signin.fragment.AuthSignInFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.signin.viewmodel.AuthSignInModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.user.fragment.AuthUserSignUpNameFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.user.viewmodel.AuthUserSignUpNameModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.list.fragment.ChatChannelListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.list.viewmodel.ChatChannelListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message.fragment.ChatChannelMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message.viewmodel.ChatChannelMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.contact.fragment.ChatContactListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.contact.viewmodel.ChatContactListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.list.fragment.ChatGroupListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.list.viewmodel.ChatGroupListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.fragment.ChatGroupMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.viewmodel.ChatGroupMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.fragment.ChatPrivateListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.viewmodel.ChatPrivateListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.message.fragment.ChatPrivateMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.message.viewmodel.ChatPrivateMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.news.edit.fragment.NewsEditFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.edit.viewmodel.NewsEditModule
import ru.itis.kpfu.corpchat.presentation.screen.news.feed.fragment.NewsFeedFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.feed.viewmodel.NewsFeedModule
import ru.itis.kpfu.corpchat.presentation.screen.news.info.fragment.NewsInfoFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.info.viewmodel.NewsInfoModule

@Module
interface FeatureModule {

    @FeatureScope
    @ContributesAndroidInjector(modules = [NewsFeedModule::class])
    fun contributeNewsFeedFragment(): NewsFeedFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [NewsInfoModule::class])
    fun contributeNewsInfoFragment(): NewsInfoFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [NewsEditModule::class])
    fun contributeNewsEditFragment(): NewsEditFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatPrivateListModule::class])
    fun contributeChatPrivateListFragment(): ChatPrivateListFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatPrivateMessageModule::class])
    fun contributeChatPrivateMessageFragment(): ChatPrivateMessageFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatGroupListModule::class])
    fun contributeChatGroupListFragment(): ChatGroupListFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatGroupMessageModule::class])
    fun contributeChatGroupMessageFragment(): ChatGroupMessageFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatChannelListModule::class])
    fun contributeChatChannelListFragment(): ChatChannelListFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatChannelMessageModule::class])
    fun contributeChatChannelMessageFragment(): ChatChannelMessageFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [ChatContactListModule::class])
    fun contributeChatContactListFragment(): ChatContactListFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthUserSignUpNameModule::class])
    fun contributeAuthUserSignUpFragment(): AuthUserSignUpNameFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthSignInModule::class])
    fun contributeAuthSignInFragment(): AuthSignInFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthCompanySignUpNameModule::class])
    fun contributeAuthCompanySignUpNameFragment(): AuthCompanySignUpNameFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthSignUpPhotoModule::class])
    fun contributeAuthCompanySignUpLogoFragment(): AuthSignUpPhotoFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthCompanySignUpIndustryModule::class])
    fun contributeAuthCompanySignUpIndustryFragment(): AuthCompanySignUpIndustryFragment



}
