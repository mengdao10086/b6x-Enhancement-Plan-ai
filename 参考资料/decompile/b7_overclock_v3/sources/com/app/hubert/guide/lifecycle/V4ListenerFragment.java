package com.app.hubert.guide.lifecycle;

import androidx.fragment.app.Fragment;
import q3.a;

/* JADX INFO: loaded from: classes2.dex */
public class V4ListenerFragment extends Fragment {

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public a f11409c8;

    public void E5(a aVar) {
        this.f11409c8 = aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        t3.a.a("onDestroy: ");
        a aVar = this.f11409c8;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        a aVar = this.f11409c8;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        t3.a.a("onStart: ");
        a aVar = this.f11409c8;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        a aVar = this.f11409c8;
        if (aVar != null) {
            aVar.c();
        }
    }
}
