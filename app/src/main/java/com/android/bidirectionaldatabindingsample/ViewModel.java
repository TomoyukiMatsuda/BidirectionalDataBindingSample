package com.android.bidirectionaldatabindingsample;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ViewModel extends BaseObservable {
    private String formText;
    private String displayText;

    @Bindable public String getFormText() {
        return this.formText;
    }

    @Bindable public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.buttonEnable);
    }

    // EditTextに入力があるかどうかでボタン活性・非活性を制御
    @Bindable public boolean isButtonEnable() {
        return !TextUtils.isEmpty(this.formText);
    }
}
