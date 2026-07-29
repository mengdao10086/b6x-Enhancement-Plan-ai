package com.zhihu.matisse.internal.ui;

import android.os.Bundle;
import com.zhihu.matisse.internal.entity.Item;
import g.p0;
import java.util.ArrayList;
import th.c;
import wh.a;

/* JADX INFO: loaded from: classes5.dex */
public class SelectedPreviewActivity extends a {
    @Override // wh.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (!c.b().f51308q) {
            setResult(0);
            finish();
            return;
        }
        ArrayList parcelableArrayList = getIntent().getBundleExtra(a.L7).getParcelableArrayList(vh.c.f53174d);
        this.C1.d(parcelableArrayList);
        this.C1.notifyDataSetChanged();
        if (this.f54701k1.f51297f) {
            this.K1.setCheckedNum(1);
        } else {
            this.K1.setChecked(true);
        }
        this.E7 = 0;
        i4((Item) parcelableArrayList.get(0));
    }
}
