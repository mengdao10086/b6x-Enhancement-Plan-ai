package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hl1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m92 f1183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1184a;
    public final /* synthetic */ TextView b;

    public hl1(l92 l92Var, TextView textView, m92 m92Var, i92 i92Var, TextView textView2) {
        this.f1182a = l92Var;
        this.f1184a = textView;
        this.f1183a = m92Var;
        this.f6322a = i92Var;
        this.b = textView2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onClick(android.view.View r7) {
        /*
            r6 = this;
            a.l92 r7 = r6.f1182a
            int r0 = r7.f6687a
            r1 = 1
            r2 = -1
            if (r0 != r2) goto Ld
            r0 = -10
        La:
            r7.f6687a = r0
            goto L1f
        Ld:
            if (r0 != r1) goto L12
            r7.f6687a = r2
            goto L1f
        L12:
            if (r0 <= 0) goto L17
            int r0 = r0 / 10
            goto La
        L17:
            r2 = -100000000(0xfffffffffa0a1f00, float:-1.7929143E35)
            if (r0 <= r2) goto L1f
            int r0 = r0 * 10
            goto La
        L1f:
            android.widget.TextView r7 = r6.f1184a
            a.l92 r0 = r6.f1182a
            int r0 = r0.f6687a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r7.setText(r0)
            a.m92 r7 = r6.f1183a
            long r2 = r7.f6785a
            a.l92 r7 = r6.f1182a
            int r7 = r7.f6687a
            long r4 = (long) r7
            long r2 = r2 / r4
            a.i92 r7 = r6.f6322a
            boolean r7 = r7.b
            if (r7 == 0) goto L3d
            r1 = 2
        L3d:
            long r0 = (long) r1
            long r2 = r2 * r0
            android.widget.TextView r7 = r6.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r4 = 0
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 < 0) goto L4f
            java.lang.String r1 = "+"
            goto L51
        L4f:
            java.lang.String r1 = ""
        L51:
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = "mA"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.hl1.onClick(android.view.View):void");
    }
}
