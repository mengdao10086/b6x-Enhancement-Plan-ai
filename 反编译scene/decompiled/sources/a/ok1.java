package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ok1 extends g92 implements g82<fj0, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f7033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i92 f2261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sk1 f2262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RecyclerView f2263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f2264a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok1(fj0 fj0Var, String[] strArr, RecyclerView recyclerView, i92 i92Var, sk1 sk1Var, ArrayList arrayList, View view) {
        super(1);
        this.f7033a = fj0Var;
        this.f2264a = strArr;
        this.f2263a = recyclerView;
        this.f2261a = i92Var;
        this.f2262a = sk1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(a.fj0 r18) {
        /*
            r17 = this;
            r6 = r17
            java.lang.String r0 = "it"
            r1 = r18
            a.f92.d(r1, r0)
            a.fj0 r0 = r6.f7033a
            int r5 = r0.g()
            r0 = 0
            r1 = 2
            r2 = 1
            if (r5 == r2) goto L21
            if (r5 == r1) goto L1e
            r3 = 3
            if (r5 == r3) goto L1b
            r4 = r0
            goto L24
        L1b:
            r3 = 80
            goto L23
        L1e:
            r3 = 50
            goto L23
        L21:
            r3 = 20
        L23:
            r4 = r3
        L24:
            androidx.recyclerview.widget.RecyclerView r3 = r6.f2263a
            androidx.recyclerview.widget.RecyclerView$g r3 = r3.getAdapter()
            if (r3 == 0) goto L8f
            a.r01 r3 = (a.r01) r3
            a.i92 r7 = r6.f2261a
            boolean r7 = r7.b
            if (r7 == 0) goto L8b
            java.util.ArrayList r7 = r3.I(r4)
            boolean r8 = r7.isEmpty()
            r8 = r8 ^ r2
            if (r8 == 0) goto L8e
            a.p80$a r9 = a.p80.f2403a
            a.sk1 r8 = r6.f2262a
            android.app.Activity r10 = a.sk1.D1(r8)
            a.q92 r8 = a.q92.f7191a
            a.sk1 r8 = r6.f2262a
            r11 = 2131887408(0x7f120530, float:1.9409422E38)
            java.lang.String r8 = r8.J(r11)
            java.lang.String r11 = "getString(R.string.power_delete_confirm)"
            a.f92.c(r8, r11)
            java.lang.Object[] r11 = new java.lang.Object[r1]
            java.lang.String[] r12 = r6.f2264a
            r12 = r12[r5]
            r11[r0] = r12
            int r0 = r7.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11[r2] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r11, r1)
            java.lang.String r11 = java.lang.String.format(r8, r0)
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            a.f92.c(r11, r0)
            a.nk1 r13 = new a.nk1
            r0 = r13
            r1 = r3
            r2 = r7
            r3 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r14 = 0
            r15 = 16
            r16 = 0
            java.lang.String r12 = ""
            a.p80.a.n(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L8e
        L8b:
            r3.I(r4)
        L8e:
            return
        L8f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.omarea.ui.AdapterChargeStat"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ok1.a(a.fj0):void");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(fj0 fj0Var) {
        a(fj0Var);
        return m42.f6769a;
    }
}
