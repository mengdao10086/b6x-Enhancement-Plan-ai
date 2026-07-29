package com.flydigi.device_manager.ui.mapping_test;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.blankj.utilcode.util.f;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import o5.h;

/* JADX INFO: loaded from: classes7.dex */
public class FullScreenDialogActivity extends p {
    public static final int F7 = 1;
    public static final int G7 = 2;
    public static final int H7 = 3;
    public static final String I7 = "key_result";
    public static final String J7 = "key_type";
    public static final String K7 = "key_title";
    public static final String L7 = "key_content";
    public static final String M7 = "key_confirm";
    public static final String N7 = "key_cancel";
    public static final String O7 = "key_ok";
    public static final String P7 = "key_loading";
    public final View.OnClickListener E7 = new View.OnClickListener() { // from class: o7.a
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f42778a.l4(view);
        }
    };
    public int K2;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l4(View view) {
        int id2 = view.getId();
        if (id2 == R.id.tv_confirm) {
            m4(1);
        } else if (id2 == R.id.tv_cancel) {
            m4(0);
        } else if (id2 == R.id.tv_ok) {
            m4(1);
        }
    }

    public static Intent n4(Context context, int i10, String str) {
        Intent intent = new Intent(context, (Class<?>) FullScreenDialogActivity.class);
        intent.putExtra("key_type", i10);
        intent.putExtra(P7, str);
        return intent;
    }

    public static Intent o4(Context context, int i10, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) FullScreenDialogActivity.class);
        intent.putExtra("key_type", i10);
        intent.putExtra(K7, str);
        intent.putExtra(L7, str2);
        intent.putExtra(O7, str3);
        return intent;
    }

    public static Intent p4(Context context, int i10, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, (Class<?>) FullScreenDialogActivity.class);
        intent.putExtra("key_type", i10);
        intent.putExtra(K7, str);
        intent.putExtra(L7, str2);
        intent.putExtra(M7, str3);
        intent.putExtra(N7, str4);
        return intent;
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        int i10 = this.K2;
        if (i10 == 1) {
            return R.layout.dialog_loading;
        }
        if (i10 == 2) {
            return R.layout.dialog_single_button;
        }
        if (i10 == 3) {
            return R.layout.dialog_two_button;
        }
        finish();
        return R.layout.activity_dialog;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void k4() {
        if (this.K2 == 1) {
            String stringExtra = getIntent().getStringExtra(P7);
            TextView textView = (TextView) findViewById(R.id.tv_title);
            if (TextUtils.isEmpty(stringExtra)) {
                textView.setVisibility(8);
                return;
            } else {
                textView.setText(stringExtra);
                return;
            }
        }
        String stringExtra2 = getIntent().getStringExtra(K7);
        String stringExtra3 = getIntent().getStringExtra(L7);
        TextView textView2 = (TextView) findViewById(R.id.tv_title);
        TextView textView3 = (TextView) findViewById(R.id.tv_content);
        if (TextUtils.isEmpty(stringExtra2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(stringExtra2);
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(stringExtra3);
        }
        int i10 = this.K2;
        if (i10 == 2) {
            String stringExtra4 = getIntent().getStringExtra(O7);
            Button button = (Button) findViewById(R.id.tv_ok);
            if (!TextUtils.isEmpty(stringExtra4)) {
                button.setText(stringExtra4);
            }
            button.setOnClickListener(this.E7);
            return;
        }
        if (i10 == 3) {
            String stringExtra5 = getIntent().getStringExtra(M7);
            String stringExtra6 = getIntent().getStringExtra(N7);
            Button button2 = (Button) findViewById(R.id.tv_confirm);
            Button button3 = (Button) findViewById(R.id.tv_cancel);
            button2.setOnClickListener(this.E7);
            button3.setOnClickListener(this.E7);
            if (!TextUtils.isEmpty(stringExtra5)) {
                button2.setText(stringExtra5);
            }
            if (TextUtils.isEmpty(stringExtra6)) {
                return;
            }
            button3.setText(stringExtra6);
        }
    }

    public void m4(int i10) {
        Intent intent = new Intent();
        intent.putExtra(I7, i10 == 1);
        setResult(-1, intent);
        finish();
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            setRequestedOrientation(-1);
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (i10 >= 28 && !h.h()) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        int intExtra = getIntent().getIntExtra("key_type", 0);
        this.K2 = intExtra;
        if (intExtra == 0) {
            finish();
        }
        super.onCreate(bundle);
        f.A(this, false);
        k4();
    }

    @Override // androidx.appcompat.app.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 || i10 == 82) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
