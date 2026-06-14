package a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kh implements mh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lh f6605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1632a;

    public kh(lh lhVar) {
        this.f6605a = lhVar;
    }

    @Override // a.mh
    @SuppressLint({"WrongConstant"})
    public void a(View view) {
        int i = this.f6605a.f6706a;
        if (i > -1) {
            view.setLayerType(i, null);
            this.f6605a.f6706a = -1;
        }
        if (Build.VERSION.SDK_INT >= 16 || !this.f1632a) {
            lh lhVar = this.f6605a;
            Runnable runnable = lhVar.b;
            if (runnable != null) {
                lhVar.b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            mh mhVar = tag instanceof mh ? (mh) tag : null;
            if (mhVar != null) {
                mhVar.a(view);
            }
            this.f1632a = true;
        }
    }

    @Override // a.mh
    public void b(View view) {
        Object tag = view.getTag(2113929216);
        mh mhVar = tag instanceof mh ? (mh) tag : null;
        if (mhVar != null) {
            mhVar.b(view);
        }
    }

    @Override // a.mh
    public void c(View view) {
        this.f1632a = false;
        if (this.f6605a.f6706a > -1) {
            view.setLayerType(2, null);
        }
        lh lhVar = this.f6605a;
        Runnable runnable = lhVar.f1800a;
        if (runnable != null) {
            lhVar.f1800a = null;
            runnable.run();
        }
        Object tag = view.getTag(2113929216);
        mh mhVar = tag instanceof mh ? (mh) tag : null;
        if (mhVar != null) {
            mhVar.c(view);
        }
    }
}
