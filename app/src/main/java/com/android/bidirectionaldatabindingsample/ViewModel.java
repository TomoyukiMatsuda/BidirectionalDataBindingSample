package com.android.bidirectionaldatabindingsample;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ViewModel extends BaseObservable {
    private String formText;

    // ゲット
    @Bindable public String getFormText() {
        return formText;
    }

    // setには @Bindable　不要そう
    public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.realTimeText);
        notifyPropertyChanged(BR.buttonEnable);
    }

    // メソッド名とは違う処理も合わせて行っているのがあまりよくなさそう
    @Bindable public String getClickText() {
        String clickText = formText;
        formText = "";
        notifyPropertyChanged(BR.formText);
        return clickText;
    }

    @Bindable
    public String getRealTimeText() {
        // フォーム入力のテキストを代入
        String realTimeText = formText;
        return realTimeText;
    }

    // EditTextに入力があるかどうかでボタン活性・非活性を制御
    @Bindable public boolean isButtonEnable() {
        return !TextUtils.isEmpty(formText);
    }

    public void onButtonClick() {
        notifyPropertyChanged(BR.clickText);
    }
}
