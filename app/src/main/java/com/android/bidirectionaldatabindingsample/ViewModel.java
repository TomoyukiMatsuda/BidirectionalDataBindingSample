package com.android.bidirectionaldatabindingsample;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ViewModel extends BaseObservable {
    private String formText;

    @Bindable public String getFormText() {
        return formText;
    }

    // setには @Bindable　不要そう
    public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.displayText);
        notifyPropertyChanged(BR.buttonEnable);
    }

    @Bindable
    public String getDisplayText() {
        // フォーム入力のテキストを代入
        String displayText = formText;
        return displayText;
    }

    // EditTextに入力があるかどうかでボタン活性・非活性を制御
    @Bindable public boolean isButtonEnable() {
        return !TextUtils.isEmpty(formText);
    }
}
