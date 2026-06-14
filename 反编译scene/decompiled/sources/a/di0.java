package a;

import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class di0 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di0(EditText editText, n92 n92Var, rh0 rh0Var) {
        super(0);
        this.f564a = editText;
        this.f5903a = n92Var;
        this.f563a = rh0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            android.widget.EditText r0 = r2.f564a
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto Lf
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto Lf
            goto L11
        Lf:
            java.lang.String r0 = ""
        L11:
            a.n92 r1 = r2.f5903a
            T r1 = r1.f6891a
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = a.f92.a(r0, r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L28
            a.n92 r1 = r2.f5903a
            r1.f6891a = r0
            a.rh0 r1 = r2.f563a
            r1.a(r0)
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.di0.a():void");
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
