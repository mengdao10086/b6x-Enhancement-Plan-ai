package a;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController f6153a;

    public g0(AlertController alertController) {
        this.f6153a = alertController;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000a A[PHI: r0
  0x000a: PHI (r0v5 android.os.Message) = (r0v3 android.os.Message), (r0v6 android.os.Message) binds: [B:10:0x0017, B:5:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            androidx.appcompat.app.AlertController r0 = r2.f6153a
            android.widget.Button r1 = r0.f3967a
            if (r3 != r1) goto Lf
            android.os.Message r0 = r0.f3963a
            if (r0 == 0) goto Lf
        La:
            android.os.Message r3 = android.os.Message.obtain(r0)
            goto L2a
        Lf:
            androidx.appcompat.app.AlertController r0 = r2.f6153a
            android.widget.Button r1 = r0.f3978b
            if (r3 != r1) goto L1a
            android.os.Message r0 = r0.f3976b
            if (r0 == 0) goto L1a
            goto La
        L1a:
            androidx.appcompat.app.AlertController r0 = r2.f6153a
            android.widget.Button r1 = r0.f3984c
            if (r3 != r1) goto L29
            android.os.Message r3 = r0.f3983c
            if (r3 == 0) goto L29
            android.os.Message r3 = android.os.Message.obtain(r3)
            goto L2a
        L29:
            r3 = 0
        L2a:
            if (r3 == 0) goto L2f
            r3.sendToTarget()
        L2f:
            androidx.appcompat.app.AlertController r3 = r2.f6153a
            android.os.Handler r0 = r3.f3962a
            r1 = 1
            a.y1 r3 = r3.f3959a
            android.os.Message r3 = r0.obtainMessage(r1, r3)
            r3.sendToTarget()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g0.onClick(android.view.View):void");
    }
}
