package a;

import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ai0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qi0 f68a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f69a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f70a;

    public ai0(qi0 qi0Var, n92 n92Var, rh0 rh0Var, EditText editText) {
        this.f68a = qi0Var;
        this.f5609a = n92Var;
        this.f69a = rh0Var;
        this.f70a = editText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001b  */
    @Override // android.widget.TextView.OnEditorActionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onEditorAction(android.widget.TextView r2, int r3, android.view.KeyEvent r4) {
        /*
            r1 = this;
            r4 = 3
            if (r3 == r4) goto Lc
            r0 = 6
            if (r3 == r0) goto Lc
            r0 = 5
            if (r3 != r0) goto La
            goto Lc
        La:
            r2 = 0
            goto L30
        Lc:
            if (r2 == 0) goto L1b
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L1b
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L1b
            goto L1d
        L1b:
            java.lang.String r2 = ""
        L1d:
            a.n92 r0 = r1.f5609a
            r0.f6891a = r2
            a.rh0 r0 = r1.f69a
            r0.a(r2)
            if (r3 == r4) goto L2f
            a.qi0 r2 = r1.f68a
            android.widget.EditText r3 = r1.f70a
            a.qi0.b(r2, r3)
        L2f:
            r2 = 1
        L30:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ai0.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
    }
}
