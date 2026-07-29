package b8;

import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;

/* JADX INFO: loaded from: classes7.dex */
public class g implements a8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f9135c = {1, 4, 2, 6, 11};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GamepadInfo f9136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CFGPropertyJS f9137b;

    public g(GamepadInfo gamepadInfo, CFGPropertyJS cFGPropertyJS) {
        this.f9136a = gamepadInfo;
        this.f9137b = cFGPropertyJS;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    @Override // a8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a8.b r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int[] r3 = b8.g.f9135c
            int r4 = r3.length
            r5 = 0
        L18:
            if (r5 >= r4) goto L70
            r6 = r3[r5]
            r7 = 1
            if (r6 == r7) goto L5e
            r7 = 2
            if (r6 == r7) goto L56
            r7 = 4
            if (r6 == r7) goto L56
            r7 = 6
            if (r6 == r7) goto L2d
            r7 = 11
            if (r6 == r7) goto L5e
            goto L6d
        L2d:
            com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS r7 = r9.f9137b
            int r7 = r7.key_id
            r8 = 241(0xf1, float:3.38E-43)
            if (r7 == r8) goto L4e
            com.flydigi.sdk.gamepad.GamepadInfo r7 = r9.f9136a
            boolean r7 = r7.isFlashplayMode()
            if (r7 == 0) goto L6d
            com.flydigi.sdk.gamepad.GamepadInfo r7 = r9.f9136a
            java.lang.String r7 = r7.getFirmwareVersion()
            java.util.Objects.requireNonNull(r7)
            java.lang.String r8 = "5.9.3.0"
            boolean r7 = l9.c.b(r8, r7)
            if (r7 != 0) goto L6d
        L4e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
            goto L6d
        L56:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
            goto L6d
        L5e:
            com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS r7 = r9.f9137b
            int r7 = r7.key_id
            r8 = 242(0xf2, float:3.39E-43)
            if (r7 == r8) goto L6d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
        L6d:
            int r5 = r5 + 1
            goto L18
        L70:
            r10.e(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.g.a(a8.b):void");
    }
}
