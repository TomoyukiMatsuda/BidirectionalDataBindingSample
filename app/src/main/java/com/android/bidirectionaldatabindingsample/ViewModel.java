package com.android.bidirectionaldatabindingsample;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ViewModel extends BaseObservable {
    private String formText;
    // クリック時表示テキストの初期値をセット
    private String clickText = "ボタンクリックでここに表示";

    //
    @Bindable public String getFormText() {
        return formText;
    }

    // レイアウトで@={viewModel.formText}としないとフォームの中身に変更があった時にsetFormText()が実行されない
    // 単一方向: @{} 双方向: @={}  「=」の有無に注意
    public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.realTimeText);
        notifyPropertyChanged(BR.buttonEnable);
    }

    // メソッド名とは違う処理も合わせて行っているのがあまりよくなさそう
    @Bindable public String getClickText() {
        return clickText;
    }

    // フォーム下にリアルタイムでテキスト表示する
    @Bindable public String getRealTimeText() {
        // フォーム入力のテキストを代入
        String realTimeText = formText;
        return realTimeText;
    }

    // EditTextに入力があるかどうかでボタン活性・非活性を制御
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
