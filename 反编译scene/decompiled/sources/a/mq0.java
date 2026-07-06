package a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.omarea.Scene;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mq0 extends lq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f6834a = {"允许", "Allow"};
    public String[] b = {"installation…", "安装准备中", "检测中", "扫描中"};
    public String[] c = {"Update", "继续更新", "更新", "继续安装", "下一步", "下一步", "Next", "Next", "仍然安装"};
    public String[] d = {"允许本次安装", "安装", "Install", "安裝", "Install"};
    public String[] e = {"安装中", "Installing", "扫描中"};
    public String[] f = {"完成", "Done", "OK"};
    public final String[] g = {"你喜欢", "推荐", "广告", "还下载"};
    public final String[] h = {"Don't", "商店", "安全", "删除", "退出", "取消"};

    public static /* synthetic */ void g(mq0 mq0Var, String[] strArr, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService, long j, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            z = false;
        }
        mq0Var.f(strArr, accessibilityNodeInfo, accessibilityService, j2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String[] r15, android.view.accessibility.AccessibilityNodeInfo r16, android.accessibilityservice.AccessibilityService r17, long r18, boolean r20) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            int r3 = r1.length
            r4 = 0
            r5 = r4
        L7:
            if (r5 >= r3) goto L8f
            r6 = r1[r5]
            java.util.List r6 = r2.findAccessibilityNodeInfosByText(r6)
            r7 = 1
            if (r6 == 0) goto L1b
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L19
            goto L1b
        L19:
            r8 = r4
            goto L1c
        L1b:
            r8 = r7
        L1c:
            if (r8 != 0) goto L89
            int r8 = r6.size()
            r9 = r4
        L23:
            if (r9 >= r8) goto L89
            java.lang.Object r10 = r6.get(r9)
            java.lang.String r11 = "nodes[i]"
            a.f92.c(r10, r11)
            android.view.accessibility.AccessibilityNodeInfo r10 = (android.view.accessibility.AccessibilityNodeInfo) r10
            java.lang.CharSequence r10 = r10.getText()
            a.f92.b(r10)
            java.lang.String r10 = r10.toString()
            boolean r10 = r14.i(r10)
            if (r10 == 0) goto L42
            goto L84
        L42:
            java.lang.Object r10 = r6.get(r9)
            a.f92.c(r10, r11)
            android.view.accessibility.AccessibilityNodeInfo r10 = (android.view.accessibility.AccessibilityNodeInfo) r10
            android.view.accessibility.AccessibilityNodeInfo r10 = r14.c(r10)
            if (r10 == 0) goto L84
            boolean r11 = r10.isEnabled()
            if (r11 != 0) goto L5a
            r10.setEnabled(r7)
        L5a:
            if (r20 == 0) goto L6c
            boolean r11 = r14.h(r2)
            if (r11 == 0) goto L6c
            com.omarea.Scene$c r10 = com.omarea.Scene.f4798a
            r11 = 2
            r12 = 0
            java.lang.String r13 = "界面上疑似存在广告，SCENE跳过自动点击[安装]！"
            com.omarea.Scene.c.p(r10, r13, r4, r11, r12)
            goto L78
        L6c:
            boolean r11 = super.b(r10)
            if (r11 != 0) goto L78
            r11 = r17
            super.e(r10, r11)
            goto L7a
        L78:
            r11 = r17
        L7a:
            r12 = 0
            int r10 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r10 <= 0) goto L86
            java.lang.Thread.sleep(r18)     // Catch: java.lang.Exception -> L86
            goto L86
        L84:
            r11 = r17
        L86:
            int r9 = r9 + 1
            goto L23
        L89:
            r11 = r17
            int r5 = r5 + 1
            goto L7
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mq0.f(java.lang.String[], android.view.accessibility.AccessibilityNodeInfo, android.accessibilityservice.AccessibilityService, long, boolean):void");
    }

    public final boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (String str : this.g) {
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
            if (!(listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty())) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(String str) {
        for (String str2 : this.h) {
            if (ec2.C(str, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final void j(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        f92.d(accessibilityService, "service");
        f92.d(accessibilityEvent, "event");
        if (!Scene.f4798a.b(hz0.f1282a.J(), false) || accessibilityEvent.getSource() == null) {
            return;
        }
        try {
            String[] strArr = {"继续安装", "Install"};
            for (int i = 0; i < 2; i++) {
                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityEvent.getSource().findAccessibilityNodeInfosByText(strArr[i]);
                if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
                    int size = listFindAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AccessibilityNodeInfo accessibilityNodeInfo = listFindAccessibilityNodeInfosByText.get(i2);
                        f92.c(accessibilityNodeInfo, "next2Nodes[i]");
                        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
                        String string = accessibilityNodeInfo2.getClassName().toString();
                        Locale locale = Locale.getDefault();
                        f92.c(locale, "Locale.getDefault()");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = string.toLowerCase(locale);
                        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (ec2.C(lowerCase, "button", false, 2, null)) {
                            if (!accessibilityNodeInfo2.isEnabled()) {
                                accessibilityNodeInfo2.setEnabled(true);
                            }
                            if (!super.b(accessibilityNodeInfo2)) {
                                super.e(accessibilityNodeInfo2, accessibilityService);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void k(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        f92.d(accessibilityService, "service");
        f92.d(accessibilityEvent, "event");
        if (!Scene.f4798a.b(hz0.f1282a.J(), false) || accessibilityEvent.getSource() == null) {
            return;
        }
        try {
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            String[] strArr = this.f6834a;
            f92.c(source, "view");
            g(this, strArr, source, accessibilityService, 0L, false, 24, null);
            l(this.b, source);
            g(this, this.c, source, accessibilityService, 200L, false, 16, null);
            f(this.d, source, accessibilityService, 200L, true);
            l(this.e, source);
            g(this, this.f, source, accessibilityService, 0L, false, 24, null);
        } catch (Exception unused) {
        }
    }

    public final void l(String[] strArr, AccessibilityNodeInfo accessibilityNodeInfo) throws InterruptedException {
        for (String str : strArr) {
            while (true) {
                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                if (listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
                    break;
                } else {
                    Thread.sleep(200L);
                }
            }
        }
    }
}
