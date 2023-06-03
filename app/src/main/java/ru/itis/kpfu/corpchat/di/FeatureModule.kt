package ru.itis.kpfu.corpchat.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.AuthCompanySignUpIndustryFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.AuthCompanySignUpIndustryModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.logo.AuthCompanySignUpLogoFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.logo.AuthCompanySignUpLogoModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.AuthCompanySignUpNameFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.AuthCompanySignUpNameModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.enter.AuthEnterFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.enter.AuthEnterModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.signin.AuthSignInFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.signin.AuthSignInModule
import ru.itis.kpfu.corpchat.presentation.screen.auth.user.AuthUserSignUpFragment
import ru.itis.kpfu.corpchat.presentation.screen.auth.user.AuthUserSignUpModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.list.ChatChannelListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.list.ChatChannelListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message.ChatChannelMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message.ChatChannelMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.contact.ChatContactListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.contact.ChatContactListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.list.ChatGroupListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.list.ChatGroupListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.ChatGroupMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.ChatGroupMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.ChatPrivateListFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.ChatPrivateListModule
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.message.ChatPrivateMessageFragment
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.message.ChatPrivateMessageModule
import ru.itis.kpfu.corpchat.presentation.screen.news.edit.NewsEditFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.edit.NewsEditModule
import ru.itis.kpfu.corpchat.presentation.screen.news.feed.NewsFeedFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.feed.NewsFeedModule
import ru.itis.kpfu.corpchat.presentation.screen.news.info.NewsInfoFragment
import ru.itis.kpfu.corpchat.presentation.screen.news.info.NewsInfoModule

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
    @ContributesAndroidInjector(modules = [AuthUserSignUpModule::class])
    fun contributeAuthUserSignUpFragment(): AuthUserSignUpFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthEnterModule::class])
    fun contributeAuthEnterFragment(): AuthEnterFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthSignInModule::class])
    fun contributeAuthSignInFragment(): AuthSignInFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthCompanySignUpNameModule::class])
    fun contributeAuthCompanySignUpNameFragment(): AuthCompanySignUpNameFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthCompanySignUpLogoModule::class])
    fun contributeAuthCompanySignUpLogoFragment(): AuthCompanySignUpLogoFragment

    @FeatureScope
    @ContributesAndroidInjector(modules = [AuthCompanySignUpIndustryModule::class])
    fun contributeAuthCompanySignUpIndustryFragment(): AuthCompanySignUpIndustryFragment



}
