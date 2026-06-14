package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gk1 extends g92 implements g82<fj0, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f6216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i92 f1026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ kk1 f1027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RecyclerView f1028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f1029a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gk1(fj0 fj0Var, String[] strArr, RecyclerView recyclerView, i92 i92Var, kk1 kk1Var, ArrayList arrayList, View view) {
        super(1);
        this.f6216a = fj0Var;
        this.f1029a = strArr;
        this.f1028a = recyclerView;
        this.f1026a = i92Var;
        this.f1027a = kk1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
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
            a.fj0 r0 = r6.f6216a
            int r5 = r0.g()
            r0 = 0
            r1 = 2
            r2 = 1
            if (r5 == r2) goto L2a
            if (r5 == r1) goto L26
            r3 = 3
            if (r5 == r3) goto L22
            r3 = 4
            if (r5 == r3) goto L1e
            r4 = r0
            goto L2e
        L1e:
            r3 = 36000000(0x2255100, float:1.2145531E-37)
            goto L2d
        L22:
            r3 = 18000000(0x112a880, float:2.6936858E-38)
            goto L2d
        L26:
            r3 = 10800000(0xa4cb80, float:1.5134023E-38)
            goto L2d
        L2a:
            r3 = 3600000(0x36ee80, float:5.044674E-39)
        L2d:
            r4 = r3
        L2e:
            androidx.recyclerview.widget.RecyclerView r3 = r6.f1028a
            androidx.recyclerview.widget.RecyclerView$g r3 = r3.getAdapter()
            if (r3 == 0) goto L98
            a.s11 r3 = (a.s11) r3
            a.i92 r7 = r6.f1026a
            boolean r7 = r7.b
            if (r7 == 0) goto L94
            java.util.ArrayList r7 = r3.G(r4)
            int r8 = r7.size()
            if (r8 <= 0) goto L97
            a.p80$a r9 = a.p80.f2403a
            a.kk1 r8 = r6.f1027a
            android.app.Activity r10 = a.kk1.D1(r8)
            a.q92 r8 = a.q92.f7191a
            a.kk1 r8 = r6.f1027a
            r11 = 2131887408(0x7f120530, float:1.9409422E38)
            java.lang.String r8 = r8.J(r11)
            java.lang.String r11 = "getString(R.string.power_delete_confirm)"
            a.f92.c(r8, r11)
            java.lang.Object[] r11 = new java.lang.Object[r1]
            java.lang.String[] r12 = r6.f1029a
            r12 = r12[r5]
            r11[r0] = r12
            int r0 = r7.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11[r2] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r11, r1)
            java.lang.String r11 = java.lang.String.format(r8, r0)
            java.lang.String r0 = "java.lang.String.format(format, *args)"
            a.f92.c(r11, r0)
            a.fk1 r13 = new a.fk1
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
            goto L97
        L94:
            r3.G(r4)
        L97:
            return
        L98:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.omarea.ui.AdapterPowerStat"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.gk1.a(a.fj0):void");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(fj0 fj0Var) {
        a(fj0Var);
        return m42.f6769a;
    }
}
