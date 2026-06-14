package com.omarea.vtools.activities;

import a.a42;
import a.g92;
import a.hz0;
import a.v0;
import a.v72;
import a.z32;
import a.zg0;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityPowerModeTile extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f8840a = a42.a(b.f8842a);
    public final z32 b = a42.a(new a());

    public static final class a extends g92 implements v72<Boolean> {
        public a() {
            super(0);
        }

        public final boolean a() {
            return hz0.f1282a.b0() && (hz0.f1282a.B() || ActivityPowerModeTile.this.k());
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Boolean i() {
            return Boolean.valueOf(a());
        }
    }

    public static final class b extends g92 implements v72<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8842a = new b();

        public b() {
            super(0);
        }

        public final boolean a() {
            return new zg0().a(Scene.f4798a.c());
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Boolean i() {
            return Boolean.valueOf(a());
        }
    }

    public final boolean j() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) this.f8840a.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    @Override // a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            a.wu0 r5 = new a.wu0
            r5.<init>()
            boolean r5 = r5.s()
            r0 = 0
            if (r5 == 0) goto L41
            boolean r5 = r4.j()
            if (r5 == 0) goto L37
            a.fa0 r5 = a.fa0.f867a
            java.lang.String r5 = r5.i()
            int r5 = r5.length()
            if (r5 <= 0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = r0
        L24:
            if (r5 == 0) goto L37
            android.content.Intent r5 = new android.content.Intent
            com.omarea.Scene$c r0 = com.omarea.Scene.f4798a
            android.app.Application r0 = r0.c()
            java.lang.Class<com.omarea.scene_mode.ReceiverSceneMode> r1 = com.omarea.scene_mode.ReceiverSceneMode.class
            r5.<init>(r0, r1)
            r4.sendBroadcast(r5)
            goto L4f
        L37:
            com.omarea.Scene$c r5 = com.omarea.Scene.f4798a
            r1 = 2
            r2 = 0
            java.lang.String r3 = "性能调节未启用"
            com.omarea.Scene.c.p(r5, r3, r0, r1, r2)
            goto L4f
        L41:
            r5 = 2131887259(0x7f12049b, float:1.940912E38)
            java.lang.String r5 = r4.getString(r5)
            android.widget.Toast r5 = android.widget.Toast.makeText(r4, r5, r0)
            r5.show()
        L4f:
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityPowerModeTile.onCreate(android.os.Bundle):void");
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }
}
