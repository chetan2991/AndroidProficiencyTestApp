package com.chetan.home.ui

import androidx.databinding.BaseObservable
import com.chetan.home.domain.model.Fact

class HomeListItemViewState(
    val fact: Fact,
    val palette: HomeColorPalette
) : BaseObservable()