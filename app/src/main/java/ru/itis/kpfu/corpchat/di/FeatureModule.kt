package ru.itis.kpfu.corpchat.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.fragment.AuthCompanySignUpIndustryFragment
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.viewmodel.AuthCompanySignUpIndustryModule
import ru.itis.kpfu.corpchat.feature.auth.presentation.photo.fragment.AuthSignUpPhotoFragment
import ru.itis.kpfu.corpchat.feature.auth.presentation.photo.viewmodel.AuthSignUpPhotoModule
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.fragment.AuthCompanySignUpNameFragment
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.viewmodel.AuthCompanySignUpNameModule
import ru.itis.kpfu.corpchat.feature.auth.presentation.signin.fragment.AuthSignInFragment
import ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel.AuthSignInModule
import ru.itis.kpfu.corpchat.feature.auth.presentation.user.fragment.AuthUserSignUpNameFragment
import ru.itis.kpfu.corpchat.feature.auth.presentation.user.viewmodel.AuthUserSignUpNameModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.fragment.ChatChannelListFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.viewmodel.ChatChannelListModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.message.fragment.ChatChannelMessageFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.message.viewmodel.ChatChannelMessageModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.contact.fragment.ChatContactListFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.contact.viewmodel.ChatContactListModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.list.fragment.ChatGroupListFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.list.viewmodel.ChatGroupListModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.message.fragment.ChatGroupMessageFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.message.viewmodel.ChatGroupMessageModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.fragment.ChatPrivateListFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.viewmodel.ChatPrivateListModule
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.fragment.ChatPrivateMessageFragment
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.viewmodel.ChatPrivateMessageModule
import ru.itis.kpfu.corpchat.feature.news.presentation.edit.fragment.NewsEditFragment
import ru.itis.kpfu.corpchat.feature.news.presentation.edit.viewmodel.NewsEditModule
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.fragment.NewsFeedFragment
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel.NewsFeedModule
import ru.itis.kpfu.corpchat.feature.news.presentation.info.fragment.NewsInfoFragment
import ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel.NewsInfoModule

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
