package a;

import android.text.TextWatcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ci0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f404a;

    public ci0(n92 n92Var, rh0 rh0Var) {
        this.f5796a = n92Var;
        this.f404a = rh0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0009  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void afterTextChanged(android.text.Editable r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L9
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L9
            goto Lb
        L9:
            java.lang.String r2 = ""
        Lb:
            a.n92 r0 = r1.f5796a
            T r0 = r0.f6891a
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = a.f92.a(r2, r0)
            r0 = r0 ^ 1
            if (r0 == 0) goto L22
            a.n92 r0 = r1.f5796a
            r0.f6891a = r2
            a.rh0 r0 = r1.f404a
            r0.a(r2)
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ci0.afterTextChanged(android.text.Editable):void");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
