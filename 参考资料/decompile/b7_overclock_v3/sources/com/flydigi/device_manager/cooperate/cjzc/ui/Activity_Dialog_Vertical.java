package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_Dialog_Vertical extends p {
    public TextView K2 = null;
    public TextView E7 = null;
    public TextView F7 = null;
    public TextView G7 = null;
    public TextView H7 = null;
    public final View.OnClickListener I7 = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id2 = view.getId();
            if (id2 == R.id.tv_confirm) {
                Activity_Dialog_Vertical.this.l4(1);
            } else if (id2 == R.id.tv_cancel) {
                Activity_Dialog_Vertical.this.l4(0);
            } else if (id2 == R.id.tv_ok) {
                Activity_Dialog_Vertical.this.l4(1);
            }
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_dialog_vertical;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public final void j4() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_APP_DESC);
        String stringExtra3 = intent.getStringExtra("confirm");
        String stringExtra4 = intent.getStringExtra(CommonNetImpl.CANCEL);
        if (stringExtra == null || stringExtra.equals("")) {
            this.K2.setVisibility(8);
        } else {
            this.K2.setText(stringExtra);
        }
        if (stringExtra2 == null) {
            this.E7.setVisibility(8);
        } else {
            this.E7.setText(stringExtra2);
        }
        if (stringExtra3 != null && stringExtra4 != null) {
            this.H7.setVisibility(8);
            if (!stringExtra3.equals("")) {
                this.F7.setText(stringExtra3);
            }
            if (stringExtra4.equals("")) {
                return;
            }
            this.G7.setText(stringExtra4);
            return;
        }
        this.F7.setVisibility(8);
        this.H7.setVisibility(0);
        if (stringExtra3 != null && !stringExtra3.equals("")) {
            this.H7.setText(stringExtra3);
        } else {
            if (stringExtra4 == null || stringExtra4.equals("")) {
                return;
            }
            this.H7.setText(stringExtra4);
        }
    }

    public void k4() {
        this.K2 = (TextView) findViewById(R.id.tv_title);
        this.E7 = (TextView) findViewById(R.id.tv_desc);
        this.F7 = (TextView) findViewById(R.id.tv_confirm);
        this.G7 = (TextView) findViewById(R.id.tv_cancel);
        this.H7 = (TextView) findViewById(R.id.tv_ok);
        this.F7.setOnClickListener(this.I7);
        this.G7.setOnClickListener(this.I7);
        this.H7.setOnClickListener(this.I7);
    }

    public void l4(int i10) {
        Intent intent = new Intent();
        intent.putExtra(CommonNetImpl.RESULT, i10);
        setResult(-1, intent);
        finish();
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        k4();
        j4();
    }

    @Override // androidx.appcompat.app.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 || i10 == 82) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
