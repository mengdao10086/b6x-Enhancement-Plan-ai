package com.zhihu.matisse.internal.ui;

import android.database.Cursor;
import android.os.Bundle;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import g.p0;
import java.util.ArrayList;
import vh.b;
import wh.a;
import xh.c;

/* JADX INFO: loaded from: classes5.dex */
public class AlbumPreviewActivity extends a implements b.a {
    public static final String S7 = "extra_album";
    public static final String T7 = "extra_item";
    public b Q7 = new b();
    public boolean R7;

    @Override // vh.b.a
    public void G2(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(Item.s(cursor));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        c cVar = (c) this.f54702v1.getAdapter();
        cVar.d(arrayList);
        cVar.notifyDataSetChanged();
        if (this.R7) {
            return;
        }
        this.R7 = true;
        int iIndexOf = arrayList.indexOf((Item) getIntent().getParcelableExtra(T7));
        this.f54702v1.U(iIndexOf, false);
        this.E7 = iIndexOf;
    }

    @Override // vh.b.a
    public void L1() {
    }

    @Override // wh.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (!th.c.b().f51308q) {
            setResult(0);
            finish();
            return;
        }
        this.Q7.f(this, this);
        this.Q7.d((Album) getIntent().getParcelableExtra("extra_album"));
        Item item = (Item) getIntent().getParcelableExtra(T7);
        if (this.f54701k1.f51297f) {
            this.K1.setCheckedNum(this.K0.e(item));
        } else {
            this.K1.setChecked(this.K0.l(item));
        }
        i4(item);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.Q7.g();
    }
}
