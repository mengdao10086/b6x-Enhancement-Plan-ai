package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.flydigi.base.common.o;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_Dialog_CreateName extends p {
    public View E7;
    public View K2;
    public EditText F7 = null;
    public TextView G7 = null;
    public TextView H7 = null;
    public TextView I7 = null;
    public TextView J7 = null;
    public final View.OnClickListener K7 = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            int id2 = view.getId();
            if (id2 == R.id.tv_confirm) {
                String strTrim = Activity_Dialog_CreateName.this.F7.getText().toString().trim();
                if (strTrim.length() < 2) {
                    o.E("名称长度不能少于2位");
                    return;
                }
                if (strTrim.length() > 10) {
                    o.E("名称长度不能超过10位");
                    return;
                }
                for (int i10 = 0; i10 < Activity_CJZC.f14395v8.size(); i10++) {
                    if (Activity_CJZC.f14395v8.get(i10).f().equals(strTrim)) {
                        Activity_Dialog_CreateName.this.K2.setVisibility(8);
                        Activity_Dialog_CreateName.this.E7.setVisibility(0);
                        return;
                    }
                }
                intent.putExtra(CommonNetImpl.RESULT, 1);
                intent.putExtra("content", strTrim);
                Activity_Dialog_CreateName.this.setResult(-1, intent);
                Activity_Dialog_CreateName.this.finish();
                return;
            }
            if (id2 == R.id.tv_cancel) {
                intent.putExtra(CommonNetImpl.RESULT, 0);
                Activity_Dialog_CreateName.this.setResult(-1, intent);
                Activity_Dialog_CreateName.this.finish();
                return;
            }
            if (id2 != R.id.tv_confirm_2) {
                if (id2 == R.id.tv_cancel_2) {
                    Activity_Dialog_CreateName.this.K2.setVisibility(0);
                    Activity_Dialog_CreateName.this.E7.setVisibility(8);
                    return;
                }
                return;
            }
            String strTrim2 = Activity_Dialog_CreateName.this.F7.getText().toString().trim();
            for (int i11 = 0; i11 < Activity_CJZC.f14395v8.size(); i11++) {
                if (Activity_CJZC.f14395v8.get(i11).f().equals(strTrim2)) {
                    Activity_CJZC.f14395v8.remove(i11);
                }
            }
            intent.putExtra(CommonNetImpl.RESULT, 2);
            intent.putExtra("content", Activity_Dialog_CreateName.this.F7.getText().toString().trim());
            Activity_Dialog_CreateName.this.setResult(-1, intent);
            Activity_Dialog_CreateName.this.finish();
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_dialog_createname;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public final void m4() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("content");
        String stringExtra2 = intent.getStringExtra("confirm");
        String stringExtra3 = intent.getStringExtra(CommonNetImpl.CANCEL);
        if (stringExtra != null && !stringExtra.equals("")) {
            this.F7.setText(stringExtra);
        }
        if (stringExtra2 != null && !stringExtra2.equals("")) {
            this.G7.setText(stringExtra2);
        }
        if (stringExtra3 == null || stringExtra3.equals("")) {
            return;
        }
        this.H7.setText(stringExtra3);
    }

    public void n4() {
        this.K2 = findViewById(R.id.background_1);
        this.E7 = findViewById(R.id.background_2);
        this.F7 = (EditText) findViewById(R.id.edit_content);
        this.G7 = (TextView) findViewById(R.id.tv_confirm);
        this.H7 = (TextView) findViewById(R.id.tv_cancel);
        this.G7.setOnClickListener(this.K7);
        this.H7.setOnClickListener(this.K7);
        this.I7 = (TextView) findViewById(R.id.tv_confirm_2);
        this.J7 = (TextView) findViewById(R.id.tv_cancel_2);
        this.I7.setOnClickListener(this.K7);
        this.J7.setOnClickListener(this.K7);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        n4();
        m4();
    }

    @Override // androidx.appcompat.app.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 || i10 == 82) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
