package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bi0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f275a;

    public bi0(n92 n92Var, rh0 rh0Var) {
        this.f5707a = n92Var;
        this.f275a = rh0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onFocusChange(android.view.View r1, boolean r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L2b
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L11
            goto L13
        L11:
            java.lang.String r1 = ""
        L13:
            a.n92 r2 = r0.f5707a
            T r2 = r2.f6891a
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = a.f92.a(r1, r2)
            r2 = r2 ^ 1
            if (r2 == 0) goto L2a
            a.n92 r2 = r0.f5707a
            r2.f6891a = r1
            a.rh0 r2 = r0.f275a
            r2.a(r1)
        L2a:
            return
        L2b:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bi0.onFocusChange(android.view.View, boolean):void");
    }
}
