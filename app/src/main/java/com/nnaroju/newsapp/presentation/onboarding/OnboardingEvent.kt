package com.nnaroju.newsapp.presentation.onboarding

sealed class OnboardingEvent {
    object SaveAppEntry : OnboardingEvent()
}