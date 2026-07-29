package com.flydigi.device_manager.ui.diagnose;

import android.os.Bundle;
import android.view.View;
import c7.d;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.diagnose.DiagnoseActivity;
import i9.a;
import i9.b;
import kotlin.jvm.internal.f0;
import u9.c;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31961q)
public final class DiagnoseActivity extends p {
    public d K2;

    public static final void k4(DiagnoseActivity this$0, View view) {
        f0.p(this$0, "this$0");
        b.d(this$0, DataConstant.ACTION_DIAGNOSE_PHONE_STATE);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_diagnose;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        d dVar = this.K2;
        d dVar2 = null;
        if (dVar == null) {
            f0.S("binding");
            dVar = null;
        }
        Q3(dVar.f9901e);
        b.d(this, DataConstant.REMOTE_ACTION_START_TEST_KEYMAPPING_UI);
        d dVar3 = this.K2;
        if (dVar3 == null) {
            f0.S("binding");
            dVar3 = null;
        }
        dVar3.f9899c.setOnClickListener(new View.OnClickListener() { // from class: k7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiagnoseActivity.k4(this.f37068a, view);
            }
        });
        d dVar4 = this.K2;
        if (dVar4 == null) {
            f0.S("binding");
        } else {
            dVar2 = dVar4;
        }
        dVar2.f9902f.setText(c.a(this));
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.d(this, DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        d dVarC = d.c(getLayoutInflater());
        f0.o(dVarC, "inflate(layoutInflater)");
        this.K2 = dVarC;
        if (dVarC == null) {
            f0.S("binding");
            dVarC = null;
        }
        setContentView(dVarC.getRoot());
    }
}
