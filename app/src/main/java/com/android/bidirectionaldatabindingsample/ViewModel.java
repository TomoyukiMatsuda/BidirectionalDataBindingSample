package com.android.bidirectionaldatabindingsample;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ViewModel extends BaseObservable {
    // 変数の初期値をセット
    private String formText = "";
    private String clickText = "ボタンクリックでここに表示";

    // フォーム（EditText）の入力値の getter
    @Bindable public String getFormText() {
        return formText;
    }

    // フォーム（EditText）の入力値の setter
    // レイアウトで@={viewModel.formText}としないとフォームの中身に変更があった時にsetFormText()が実行されない
    // 単一方向: @{} 双方向: @={}  「=」の有無に注意
    public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.realTimeText);
        notifyPropertyChanged(BR.buttonEnable);
    }

    // ボタンクリック時に表示するテキスト（TextView）の getter
    @Bindable public String getClickText() {
        return clickText;
    }

    // フォーム下にリアルタイムで表示するテキスト（TextView）の getter
    @Bindable public String getRealTimeText() {
        // フォーム入力されているテキストを代入
        String realTimeText = formText;
        return realTimeText;
    }

    // フォーム（EditText）にテキスト入力があるかどうかでボタン活性・非活性を制御するフラグの getter
    @Bindable public boolean isButtonEnable() {
        return !TextUtils.isEmpty(formText);
    }

    // ボタンクリックイベント
    public void onButtonClick() {
        clickText = formText;
        formText = "";
        notifyPropertyChanged(BR.clickText);
        notifyPropertyChanged(BR.formText);
    }
}
