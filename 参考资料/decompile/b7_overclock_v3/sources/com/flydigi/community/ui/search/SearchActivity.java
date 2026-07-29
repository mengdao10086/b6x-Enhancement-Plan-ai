package com.flydigi.community.ui.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.d0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.o;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import com.flydigi.community.ui.search.a;
import com.flydigi.community.ui.search.history.HistoryFragment;
import com.flydigi.community.ui.search.result.ResultFragment;
import com.flydigi.data.DataConstant;
import g.p0;
import i9.a;
import java.util.ArrayList;
import u9.h;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.b.f31921f)
public class SearchActivity extends p implements a.b, HistoryFragment.c {
    public static final int N7 = 30;
    public EditText E7;
    public ImageView F7;
    public HistoryFragment G7;
    public ResultFragment H7;
    public int I7 = -1;
    public int J7;
    public a.InterfaceC0145a K2;
    public int K7;
    public String L7;
    public ArrayList<DeviceCategoryBean> M7;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 30) {
                o.E(SearchActivity.this.getString(R.string.community_search_keyword_max_limit));
                SearchActivity.this.E7.setText(editable.subSequence(0, 30));
                SearchActivity.this.E7.setSelection(30);
            } else {
                if (SearchActivity.this.E7.getText().length() > 0) {
                    SearchActivity.this.F7.setVisibility(0);
                    return;
                }
                SearchActivity.this.F7.setVisibility(4);
                Fragment fragmentR0 = SearchActivity.this.n3().r0(R.id.container_fragment);
                if (fragmentR0 instanceof ResultFragment) {
                    if (SearchActivity.this.G7 == null) {
                        SearchActivity.this.G7 = HistoryFragment.l6();
                    }
                    d0.T0(SearchActivity.this.G7, fragmentR0);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v4(View view) {
        this.L7 = this.E7.getText().toString();
        s4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w4() {
        this.E7.requestFocus();
        KeyboardUtils.t(this.E7, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x4(View view) {
        this.E7.setText("");
        this.L7 = "";
        if (this.G7 == null) {
            this.G7 = HistoryFragment.l6();
        }
        d0.T0(this.G7, this.H7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y4(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            return false;
        }
        this.L7 = this.E7.getText().toString();
        s4();
        return true;
    }

    @Override // com.flydigi.community.ui.search.history.HistoryFragment.c
    public void R0(String str, String str2) {
        this.E7.setText(str2);
        EditText editText = this.E7;
        editText.setSelection(editText.length());
        h.j(this, ArticleReadLog.f13290h, str2, str);
        this.L7 = str2;
        s4();
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_community_search;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.K2 = new b(this);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: a6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f271a.u4(view);
            }
        });
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() { // from class: a6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f272a.v4(view);
            }
        });
        this.E7 = (EditText) findViewById(R.id.et_search);
        this.F7 = (ImageView) findViewById(R.id.btn_clear);
        this.E7.postDelayed(new Runnable() { // from class: a6.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f274a.w4();
            }
        }, 250L);
        this.E7.addTextChangedListener(new a());
        this.F7.setOnClickListener(new View.OnClickListener() { // from class: a6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f270a.x4(view);
            }
        });
        this.E7.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: a6.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return this.f273a.y4(textView, i10, keyEvent);
            }
        });
        t4();
        if (bundle == null) {
            if (this.G7 == null) {
                this.G7 = HistoryFragment.l6();
                d0.m(n3(), this.G7, R.id.container_fragment, false);
            }
            if (this.H7 == null) {
                this.H7 = ResultFragment.j6(this.I7, this.K7, this.L7, this.M7);
                d0.j(n3(), this.H7, R.id.container_fragment, ResultFragment.class.getSimpleName(), true, false);
            }
            String stringExtra = getIntent().getStringExtra(DataConstant.COMMUNITY_KEY_SEARCH_KEYWORD);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.E7.setText(stringExtra);
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        this.K2.Z();
        super.onDestroy();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        E0();
        super.onStop();
    }

    public final void s4() {
        if (!NetworkUtils.K()) {
            o.E(getString(R.string.net_state_error));
            return;
        }
        if (this.L7.trim().length() == 0) {
            o.E(getString(R.string.community_warning_empty_search_keyword));
            return;
        }
        KeyboardUtils.k(this.E7);
        HistoryFragment historyFragment = this.G7;
        if (historyFragment != null) {
            historyFragment.m6(this.L7);
        }
        ResultFragment resultFragment = this.H7;
        if (resultFragment != null) {
            resultFragment.m6(this.L7, 1);
            d0.T0(this.H7, this.G7);
        }
    }

    public final void t4() {
        this.M7 = new ArrayList<>(4);
        DeviceCategoryBean deviceCategoryBean = new DeviceCategoryBean();
        deviceCategoryBean.g(0);
        deviceCategoryBean.e(getString(R.string.community_device_category_all));
        this.M7.add(deviceCategoryBean);
        DeviceCategoryBean deviceCategoryBean2 = new DeviceCategoryBean();
        deviceCategoryBean2.g(3);
        deviceCategoryBean2.e(getString(R.string.community_device_category_half));
        this.M7.add(deviceCategoryBean2);
        DeviceCategoryBean deviceCategoryBean3 = new DeviceCategoryBean();
        deviceCategoryBean3.g(1);
        deviceCategoryBean3.e(getString(R.string.community_device_category_big));
        this.M7.add(deviceCategoryBean3);
        DeviceCategoryBean deviceCategoryBean4 = new DeviceCategoryBean();
        deviceCategoryBean4.g(2);
        deviceCategoryBean4.e(getString(R.string.community_device_category_keyboard));
        this.M7.add(deviceCategoryBean4);
        int iH = this.K2.H(this.M7);
        this.J7 = iH;
        this.K7 = iH;
    }

    public void z4() {
        this.I7 = -1;
        this.K7 = this.J7;
        this.L7 = "";
        this.E7.setText("");
    }
}
