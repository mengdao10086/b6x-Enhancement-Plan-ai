package d8;

import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class g implements a8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f26110a = {R.string.floatview_property_type_click, R.string.floatview_property_type_fps, R.string.floatview_property_type_moba, R.string.floatview_property_type_slide, R.string.floatview_property_cursor_control, R.string.floatview_property_type_macro};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[][] f26111b = {new int[]{100, 101, 102, 104}, new int[]{a.c.f52774j, 300, a.c.f52772h, a.c.f52773i}, new int[]{310}, new int[]{400, 401, 402, 403, a.c.C, a.c.D, 406, a.c.F}, new int[]{500}, new int[]{601, 602, 603}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GamepadInfo f26112c;

    public g(GamepadInfo gamepadInfo) {
        this.f26112c = gamepadInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @Override // a8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a8.b r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int[] r2 = r11.f26110a
            int r3 = r2.length
            r4 = 0
            r5 = 0
        L14:
            if (r5 >= r3) goto L38
            r6 = r2[r5]
            int r7 = com.flydigi.float_view.R.string.floatview_property_type_moba
            if (r6 != r7) goto L2e
            com.flydigi.sdk.gamepad.GamepadInfo r7 = r11.f26112c
            java.lang.String r7 = r7.getFirmwareVersion()
            java.util.Objects.requireNonNull(r7)
            java.lang.String r8 = "5.9.4.2"
            boolean r7 = l9.c.b(r8, r7)
            if (r7 != 0) goto L2e
            goto L35
        L2e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
        L35:
            int r5 = r5 + 1
            goto L14
        L38:
            r2 = 0
        L39:
            int[][] r3 = r11.f26111b
            int r3 = r3.length
            if (r2 >= r3) goto L90
            r3 = 2
            if (r2 != r3) goto L53
            com.flydigi.sdk.gamepad.GamepadInfo r3 = r11.f26112c
            java.lang.String r3 = r3.getFirmwareVersion()
            java.util.Objects.requireNonNull(r3)
            java.lang.String r5 = "6.0.4.4"
            boolean r3 = l9.c.b(r5, r3)
            if (r3 != 0) goto L53
            goto L8d
        L53:
            int[][] r3 = r11.f26111b
            r3 = r3[r2]
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r3.length
            r7 = 0
        L5e:
            if (r7 >= r6) goto L8a
            r8 = r3[r7]
            r9 = 104(0x68, float:1.46E-43)
            if (r8 != r9) goto L71
            com.flydigi.sdk.gamepad.GamepadInfo r9 = r11.f26112c
            java.lang.String r10 = "5.8.3.1"
            boolean r9 = o9.e.a(r9, r10)
            if (r9 != 0) goto L71
            goto L87
        L71:
            r9 = 300(0x12c, float:4.2E-43)
            if (r8 != r9) goto L80
            com.flydigi.sdk.gamepad.GamepadInfo r9 = r11.f26112c
            java.lang.String r10 = "5.9.0.3"
            boolean r9 = o9.e.a(r9, r10)
            if (r9 != 0) goto L80
            goto L87
        L80:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5.add(r8)
        L87:
            int r7 = r7 + 1
            goto L5e
        L8a:
            r1.add(r5)
        L8d:
            int r2 = r2 + 1
            goto L39
        L90:
            java.util.ArrayList r2 = new java.util.ArrayList
            java.lang.Object r3 = r1.get(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            r2.<init>(r3)
            r12.e(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.g.a(a8.b):void");
    }
}
