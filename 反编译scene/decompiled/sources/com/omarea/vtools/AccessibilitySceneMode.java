package com.omarea.vtools;

import a.a42;
import a.aa0;
import a.aq0;
import a.b62;
import a.b92;
import a.bc2;
import a.d42;
import a.d72;
import a.dx1;
import a.e50;
import a.ec2;
import a.f92;
import a.fa0;
import a.fx1;
import a.g92;
import a.h12;
import a.h42;
import a.ha0;
import a.hf2;
import a.hz0;
import a.i52;
import a.iq0;
import a.jq0;
import a.k82;
import a.m42;
import a.mq0;
import a.oq0;
import a.pl0;
import a.qc2;
import a.qe2;
import a.r61;
import a.r62;
import a.si0;
import a.t52;
import a.t62;
import a.ti0;
import a.u61;
import a.ug0;
import a.un0;
import a.v52;
import a.v72;
import a.vg0;
import a.wd2;
import a.wg0;
import a.wu0;
import a.x62;
import a.xd2;
import a.y42;
import a.yb2;
import a.z32;
import a.z42;
import a.z90;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.util.LruCache;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class AccessibilitySceneMode extends AccessibilityService implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8452a = new a(null);
    public static long f = SystemClock.uptimeMillis();
    public static long g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx1 f5051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fx1 f5052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iq0 f5053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public oq0 f5054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<Integer, String> f5056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f5059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<String> f5060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5061a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5062b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<String> f5063b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5064b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f5065c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final ArrayList<Integer> f5066c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f5068d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final ArrayList<Integer> f5069d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f5070d;
    public final int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final long f5071e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f5072e;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f5067c = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String> f5058a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5049a = 1080;
    public int b = 2340;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public final long a() {
            return AccessibilitySceneMode.f;
        }
    }

    public static final class b extends g92 implements v72<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8453a = new b();

        public b() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String i() {
            return new ti0(Scene.f4798a.c()).a();
        }
    }

    @x62(c = "com.omarea.vtools.AccessibilitySceneMode$modernModeEvent$6", f = "AccessibilitySceneMode.kt", l = {707}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8454a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5073a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5075a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, b62 b62Var) {
            super(2, b62Var);
            this.f8454a = j;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = AccessibilitySceneMode.this.new c(this.f8454a, b62Var);
            cVar.f5073a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f5073a;
                pl0 pl0Var = new pl0();
                this.f5075a = wd2Var;
                this.b = 1;
                obj = pl0Var.a(this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            ArrayList arrayList = (ArrayList) obj;
            if ((!arrayList.isEmpty()) && AccessibilitySceneMode.g == this.f8454a && !arrayList.contains(fa0.f867a.j())) {
                AccessibilitySceneMode.this.w((String) i52.A(arrayList));
            }
            return m42.f6769a;
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AccessibilitySceneMode.this.f5072e) {
                return;
            }
            Scene.c cVar = Scene.f4798a;
            String string = AccessibilitySceneMode.this.getString(u61.accessibility_disconnected);
            f92.c(string, "getString(R.string.accessibility_disconnected)");
            Scene.c.p(cVar, string, 0, 2, null);
        }
    }

    @x62(c = "com.omarea.vtools.AccessibilitySceneMode$onServiceConnected$1", f = "AccessibilitySceneMode.kt", l = {}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8456a;
        public int b;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = AccessibilitySceneMode.this.new e(b62Var);
            eVar.f8456a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            AccessibilitySceneMode accessibilitySceneMode = AccessibilitySceneMode.this;
            Context applicationContext = accessibilitySceneMode.getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            accessibilitySceneMode.f5058a = new si0(applicationContext).a();
            AccessibilitySceneMode.this.f5058a.add("com.oplus.pscanvas");
            ArrayList arrayList = AccessibilitySceneMode.this.f5063b;
            Context applicationContext2 = AccessibilitySceneMode.this.getApplicationContext();
            f92.c(applicationContext2, "applicationContext");
            arrayList.addAll(new ti0(applicationContext2).b());
            AccessibilitySceneMode.this.f5063b.addAll(AccessibilitySceneMode.this.f5058a);
            if (e50.f677a.r0()) {
                e50.f677a.u1(true);
                wu0.f3480a.q().e();
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.AccessibilitySceneMode$onUnbind$1", f = "AccessibilitySceneMode.kt", l = {}, m = "invokeSuspend")
    public static final class f extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8457a;
        public int b;

        public f(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            f fVar = new f(b62Var);
            fVar.f8457a = (wd2) obj;
            return fVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((f) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            if (e50.f677a.r0()) {
                e50.f677a.u1(false);
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.AccessibilitySceneMode$windowAnalyse$1", f = "AccessibilitySceneMode.kt", l = {}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8458a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5077a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AccessibilityWindowInfo f5078a;
        public int b;
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AccessibilityWindowInfo accessibilityWindowInfo, int i, long j, b62 b62Var) {
            super(2, b62Var);
            this.f5078a = accessibilityWindowInfo;
            this.c = i;
            this.f8458a = j;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = AccessibilitySceneMode.this.new g(this.f5078a, this.c, this.f8458a, b62Var);
            gVar.f5077a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            CharSequence packageName;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            CharSequence charSequence = null;
            try {
                AccessibilityNodeInfo root = this.f5078a.getRoot();
                if (root != null && (packageName = root.getPackageName()) != null) {
                    AccessibilitySceneMode.this.f5056a.put(t62.e(this.c), packageName.toString());
                    charSequence = packageName;
                }
            } catch (Exception unused) {
            }
            if (AccessibilitySceneMode.g == this.f8458a && charSequence != null) {
                AccessibilitySceneMode.this.w(charSequence.toString());
            }
            return m42.f6769a;
        }
    }

    public AccessibilitySceneMode() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.android.systemui");
        m42 m42Var = m42.f6769a;
        this.f5063b = arrayList;
        this.d = 4194336;
        this.e = 4196384;
        this.f5066c = y42.c(4, 2, 5, 3, -1);
        this.f5069d = y42.c(4, 2, 5, -1);
        this.f5059a = t52.f(new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI00", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI01", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI02", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI03", "com.tencent.mm:appbrand"), new d42("com.tencent.mm.plugin.appbrand.ui.AppBrandUI04", "com.tencent.mm:appbrand"));
        this.f5060a = v52.d("com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI", "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI", "com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI00", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI01", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI02", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI03", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI04", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", "com.tencent.wework.login.controller.LoginScannerActivity", "com.tencent.mobileqq.olympic.activity.ScanTorchActivity", "com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity", "dov.com.qq.im.QIMCameraCaptureActivity", "com.alipay.mobile.scan.as.main.MainCaptureActivity", "com.jd.lib.scan.lib.zxing.client.android.CaptureActivity", "com.jd.lib.scan.lib.zxing.client.android.NewCaptureActivity", "com.etao.feimagesearch.capture.CaptureActivity", "com.bilibili.app.qrcode.QRcodeCaptureActivity", "com.oplus.scanner.ui.main.CameraActivity", "com.xiaomi.scanner.app.ScanActivity", "com.flyme.scanner.CaptureActivity", "kt.com.fcbox.hiveconsumer.app.business.scan.ScanActivity");
        this.f5056a = new LruCache<>(10);
        this.f5055a = a42.a(b.f8453a);
        this.f5068d = 7000L;
        this.f5071e = 3000L;
    }

    public static /* synthetic */ void A(AccessibilitySceneMode accessibilitySceneMode, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        accessibilitySceneMode.z(l);
    }

    public static /* synthetic */ List p(AccessibilitySceneMode accessibilitySceneMode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return accessibilitySceneMode.o(z);
    }

    public static /* synthetic */ void v(AccessibilitySceneMode accessibilitySceneMode, AccessibilityEvent accessibilityEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            accessibilityEvent = null;
        }
        accessibilitySceneMode.u(accessibilityEvent);
    }

    public final void B() {
        synchronized (this) {
            if (this.f5061a != null) {
                Timer timer = this.f5061a;
                if (timer != null) {
                    timer.cancel();
                }
                Timer timer2 = this.f5061a;
                if (timer2 != null) {
                    timer2.purge();
                }
                this.f5061a = null;
                D(false);
            }
            m42 m42Var = m42.f6769a;
        }
    }

    public final void C(AccessibilityEvent accessibilityEvent) {
        oq0 oq0Var;
        if (System.currentTimeMillis() - this.f5050a < 3000) {
            if (this.f5054a == null) {
                this.f5054a = new oq0(this);
            }
            CharSequence packageName = accessibilityEvent.getPackageName();
            if (packageName == null || i52.v(this.f5063b, packageName) || accessibilityEvent.getClassName() == "android.widget.EditText" || (oq0Var = this.f5054a) == null) {
                return;
            }
            oq0Var.f(accessibilityEvent, Scene.f4798a.b(hz0.f1282a.f0(), false), this.f5049a, this.b);
        }
    }

    public final void D(boolean z) {
        int i = (z && l()) ? this.e : this.d;
        if (this.c == i) {
            return;
        }
        this.c = i;
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        serviceInfo.eventTypes = i;
        serviceInfo.notificationTimeout = 0L;
        serviceInfo.feedbackType = 16;
        serviceInfo.notificationTimeout = 0L;
        serviceInfo.packageNames = null;
        serviceInfo.flags = 82;
        setServiceInfo(serviceInfo);
    }

    public final void E(AccessibilityWindowInfo accessibilityWindowInfo, long j) {
        int id = accessibilityWindowInfo.getId();
        String str = this.f5056a.get(Integer.valueOf(id));
        if (str == null) {
            qc2.d(hf2.f6309a, qe2.b(), null, new g(accessibilityWindowInfo, id, j, null), 2, null);
        } else if (!f92.a(t(), str) || (accessibilityWindowInfo.isFocused() && accessibilityWindowInfo.isActive())) {
            w(str);
        }
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        return aa0Var == aa0.SERVICE_DEBUG || aa0Var == aa0.SERVICE_UPDATE || aa0Var == aa0.SCREEN_ON || aa0Var == aa0.STATE_RESUME;
    }

    @Override // a.ha0
    public boolean isAsync() {
        return false;
    }

    public final boolean l() {
        return Scene.f4798a.b(hz0.f1282a.J(), false) || Scene.f4798a.b(hz0.f1282a.e0(), false) || Scene.f4798a.b(hz0.f1282a.I(), false);
    }

    public final void m() {
        z90.f8048a.d(this);
        B();
        iq0 iq0Var = this.f5053a;
        if (iq0Var != null) {
            if (iq0Var != null) {
                z90.f8048a.d(iq0Var);
            }
            this.f5053a = null;
            stopSelf();
        }
    }

    public final void n() {
        Object systemService = getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        if (point.x != this.f5049a || point.y != this.b) {
            this.f5049a = point.x;
            this.b = point.y;
        }
        Resources resources = getResources();
        f92.c(resources, "resources");
        this.f5070d = (resources.getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.view.accessibility.AccessibilityWindowInfo> o(boolean r9) {
        /*
            r8 = this;
            java.util.List r0 = r8.getWindows()
            if (r0 == 0) goto L57
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L57
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L16:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r0.next()
            r4 = r3
            android.view.accessibility.AccessibilityWindowInfo r4 = (android.view.accessibility.AccessibilityWindowInfo) r4
            r5 = 0
            java.lang.String r6 = "it"
            if (r9 == 0) goto L3c
            java.util.ArrayList<java.lang.Integer> r7 = r8.f5069d
            a.f92.c(r4, r6)
            int r4 = r4.getType()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r7.contains(r4)
            if (r4 != 0) goto L50
            goto L4f
        L3c:
            java.util.ArrayList<java.lang.Integer> r7 = r8.f5066c
            a.f92.c(r4, r6)
            int r4 = r4.getType()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r7.contains(r4)
            if (r4 != 0) goto L50
        L4f:
            r5 = r2
        L50:
            if (r5 == 0) goto L16
            r1.add(r3)
            goto L16
        L56:
            return r1
        L57:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.AccessibilitySceneMode.o(boolean):java.util.List");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence className;
        String string;
        String str;
        Object next;
        h12 h12Var;
        Object next2;
        Object next3;
        f92.d(accessibilityEvent, "event");
        if (accessibilityEvent.getEventType() == 4194304 || accessibilityEvent.getEventType() == 32) {
            if (f92.a(accessibilityEvent.getPackageName(), "com.android.systemui") && accessibilityEvent.getEventTime() - f > 50000) {
                f = accessibilityEvent.getEventTime();
                aq0.f101a.g(true);
            }
            D(true);
        }
        CharSequence packageName = accessibilityEvent.getPackageName();
        if (packageName != null) {
            if (f92.a(packageName, "com.omarea.gesture") || f92.a(packageName, "com.omarea.filter")) {
                return;
            }
            if (ec2.C(packageName, "packageinstaller", false, 2, null)) {
                if (f92.a(accessibilityEvent.getClassName(), "com.android.packageinstaller.permission.ui.GrantPermissionsActivity")) {
                    return;
                }
                if (f92.a(e50.f677a.y0(), "root")) {
                    try {
                        new mq0().k(this, accessibilityEvent);
                    } catch (Exception unused) {
                    }
                }
            } else if (f92.a(packageName, "com.android.settings")) {
                CharSequence className2 = accessibilityEvent.getClassName();
                String strI = fa0.f867a.i();
                String strB = wu0.f3480a.q().b();
                if (f92.a(strI, "com.android.packageinstaller")) {
                    strI = strB;
                }
                if ((strI.length() > 0) && (!f92.a(strI, "android")) && (!f92.a(strI, getPackageName())) && Scene.f4798a.b(hz0.f1282a.F(), false) && (!f92.a(e50.f677a.y0(), "basic"))) {
                    if (f92.a(className2, "com.android.settings.Settings$ManageAppExternalSourcesActivity") || f92.a(className2, "com.android.settings.Settings$ManageExternalSourcesActivity")) {
                        Context applicationContext = getApplicationContext();
                        f92.c(applicationContext, "this.applicationContext");
                        List<vg0> listE = new wg0(applicationContext).e(strI);
                        if (listE != null) {
                            Iterator<T> it = listE.iterator();
                            while (true) {
                                str = "android.permission.REQUEST_INSTALL_PACKAGES";
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                } else {
                                    next = it.next();
                                    if (f92.a(((vg0) next).a(), "android.permission.REQUEST_INSTALL_PACKAGES")) {
                                        break;
                                    }
                                }
                            }
                            vg0 vg0Var = (vg0) next;
                            if (vg0Var != null && vg0Var.b() != ug0.ALLOW) {
                                h12Var = new h12(this);
                                h12Var.d(strI, str);
                            }
                        }
                    } else if (f92.a(className2, "com.android.settings.Settings$AppDrawOverlaySettingsActivity") || f92.a(className2, "com.android.settings.Settings$OverlaySettingsActivity")) {
                        Context applicationContext2 = getApplicationContext();
                        f92.c(applicationContext2, "this.applicationContext");
                        List<vg0> listE2 = new wg0(applicationContext2).e(strI);
                        if (listE2 != null) {
                            Iterator<T> it2 = listE2.iterator();
                            while (true) {
                                str = "android.permission.SYSTEM_ALERT_WINDOW";
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                } else {
                                    next2 = it2.next();
                                    if (f92.a(((vg0) next2).a(), "android.permission.SYSTEM_ALERT_WINDOW")) {
                                        break;
                                    }
                                }
                            }
                            vg0 vg0Var2 = (vg0) next2;
                            if (vg0Var2 != null && vg0Var2.b() != ug0.ALLOW) {
                                h12Var = new h12(this);
                                h12Var.d(strI, str);
                            }
                        }
                    } else if (f92.a(className2, "com.android.settings.Settings$AppManageExternalStorageActivity")) {
                        Context applicationContext3 = getApplicationContext();
                        f92.c(applicationContext3, "this.applicationContext");
                        List<vg0> listE3 = new wg0(applicationContext3).e(strI);
                        if (listE3 != null) {
                            Iterator<T> it3 = listE3.iterator();
                            while (true) {
                                str = "android.permission.MANAGE_EXTERNAL_STORAGE";
                                if (!it3.hasNext()) {
                                    next3 = null;
                                    break;
                                } else {
                                    next3 = it3.next();
                                    if (f92.a(((vg0) next3).a(), "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                                        break;
                                    }
                                }
                            }
                            vg0 vg0Var3 = (vg0) next3;
                            if (vg0Var3 != null && vg0Var3.b() != ug0.ALLOW) {
                                h12Var = new h12(this);
                                h12Var.d(strI, str);
                            }
                        }
                    }
                }
            } else if (f92.a(packageName, "com.lbe.security.miui") || f92.a(packageName, "com.miui.securitycenter")) {
                try {
                    new mq0().j(this, accessibilityEvent);
                } catch (Exception unused2) {
                }
                try {
                    new jq0().f(this, accessibilityEvent);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } else if (f92.a(packageName, "com.android.permissioncontroller")) {
                try {
                    new jq0().f(this, accessibilityEvent);
                    return;
                } catch (Exception unused4) {
                    return;
                }
            } else if (Scene.f4798a.b(hz0.f1282a.e0(), false)) {
                C(accessibilityEvent);
            }
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 1) {
            return;
        }
        long eventTime = accessibilityEvent.getEventTime();
        CharSequence packageName2 = accessibilityEvent.getPackageName();
        String string2 = packageName2 != null ? packageName2.toString() : null;
        if ((!f92.a(string2, "com.android.systemui")) && (!f92.a(string2, "com.oplus.pscanvas")) && (!f92.a(string2, Scene.f4798a.f())) && (className = accessibilityEvent.getClassName()) != null && (string = className.toString()) != null && !bc2.x(string, "android.widget", false, 2, null)) {
            this.f5057a = string;
        }
        long j = this.f5062b;
        if (j == eventTime || eventTime <= j) {
            return;
        }
        this.f5062b = eventTime;
        this.f5050a = System.currentTimeMillis();
        u(accessibilityEvent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        f92.d(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        x(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        z90.f8048a.c(this);
        z90.b(z90.f8048a, aa0.ACCESSIBILITY_SERVICE, null, 2, null);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        if (aa0Var == aa0.SERVICE_DEBUG) {
            if (y()) {
                v(this, null, 1, null);
            }
        } else {
            if (aa0Var == aa0.SCREEN_ON) {
                Scene.f4798a.j(new d(), 2000L);
                return;
            }
            if (aa0Var == aa0.STATE_RESUME) {
                u(null);
                return;
            }
            if (aa0Var == aa0.SERVICE_UPDATE) {
                D(false);
                Scene.c cVar = Scene.f4798a;
                String string = getString(u61.accessibility_updated);
                f92.c(string, "getString(R.string.accessibility_updated)");
                cVar.o(string, 0);
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        f = SystemClock.uptimeMillis();
        Resources resources = getResources();
        f92.c(resources, "this.resources");
        Configuration configuration = resources.getConfiguration();
        f92.c(configuration, "this.resources.configuration");
        x(configuration);
        this.f5072e = true;
        boolean z = false;
        D(false);
        b92 b92Var = null;
        if (this.f5053a == null) {
            this.f5053a = new iq0(this, z, 2, b92Var);
        }
        n();
        y();
        if (Scene.f4798a.b(hz0.f1282a.e0(), false) && Scene.f4798a.b(hz0.f1282a.f0(), false)) {
            new un0().a(this, false);
        }
        qc2.d(hf2.f6309a, qe2.b(), null, new e(null), 2, null);
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.f5072e = false;
        m();
        stopSelf();
        fa0.r(fa0.f867a, "", null, 2, null);
        qc2.d(xd2.a(qe2.b()), null, null, new f(null), 3, null);
        return super.onUnbind(intent);
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }

    public final String q(int i) {
        return i != 32 ? i != 2048 ? i != 4194304 ? String.valueOf(i) : "TYPE_WINDOWS_CHANGED" : "TYPE_WINDOW_CONTENT_CHANGED" : "TYPE_WINDOW_STATE_CHANGED";
    }

    public final String[] r() {
        List<AccessibilityWindowInfo> windows = getWindows();
        f92.c(windows, "windows");
        ArrayList arrayList = new ArrayList(z42.m(windows, 10));
        for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
            f92.c(accessibilityWindowInfo, "it");
            AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
            arrayList.add(root != null ? root.getPackageName() : null);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((CharSequence) next) != null && (!f92.a(r5, "com.android.systemui"))) {
                z = true;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(z42.m(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(String.valueOf((CharSequence) it2.next()));
        }
        Object[] array = arrayList3.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean s() {
        return this.f5067c || this.f5064b;
    }

    public final String t() {
        return (String) this.f5055a.getValue();
    }

    public final void u(AccessibilityEvent accessibilityEvent) {
        Object next;
        AccessibilityWindowInfo accessibilityWindowInfo;
        CharSequence packageName;
        int i;
        AccessibilityWindowInfo accessibilityWindowInfo2;
        AccessibilityWindowInfo accessibilityWindowInfo3;
        boolean z;
        String packageName2;
        String packageName3;
        AccessibilitySceneMode accessibilitySceneMode = this;
        List listP = p(accessibilitySceneMode, false, 1, null);
        if (!(!listP.isEmpty())) {
            if (Build.VERSION.SDK_INT >= 28) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                g = jCurrentTimeMillis;
                qc2.d(xd2.a(qe2.b()), null, null, accessibilitySceneMode.new c(jCurrentTimeMillis, null), 3, null);
                return;
            }
            return;
        }
        try {
            int i2 = (!s() || accessibilitySceneMode.f5070d) ? 0 : (accessibilitySceneMode.b * accessibilitySceneMode.f5049a) / 2;
            StringBuilder sb = accessibilitySceneMode.f5052a == null ? null : new StringBuilder();
            if (sb != null) {
                yb2.h(sb, "Scene窗口检测\n", "屏幕: " + accessibilitySceneMode.b + 'x' + accessibilitySceneMode.f5049a);
                sb.append(accessibilitySceneMode.f5064b ? " 横向" : " 竖向");
                if (accessibilitySceneMode.f5070d) {
                    sb.append(" Tablet");
                }
                sb.append("\n");
                if (accessibilityEvent != null) {
                    String strQ = accessibilitySceneMode.q(accessibilityEvent.getEventType());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("事件: ");
                    sb2.append(strQ);
                    sb2.append(' ');
                    AccessibilityNodeInfo source = accessibilityEvent.getSource();
                    sb2.append(source != null ? source.getPackageName() : null);
                    sb2.append('\n');
                    sb.append(sb2.toString());
                    yb2.g(sb, "来源：", accessibilityEvent.getClassName());
                } else {
                    sb.append("事件: 主动轮询 " + (new Date().getTime() / ((long) 1000)) + '\n');
                }
            }
            Iterator it = listP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                AccessibilityWindowInfo accessibilityWindowInfo4 = (AccessibilityWindowInfo) next;
                if (accessibilityWindowInfo4.isActive() || accessibilityWindowInfo4.isFocused()) {
                    break;
                }
            }
            if (next == null) {
                return;
            }
            Iterator it2 = listP.iterator();
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            AccessibilityWindowInfo accessibilityWindowInfo5 = null;
            AccessibilityWindowInfo accessibilityWindowInfo6 = null;
            while (it2.hasNext()) {
                try {
                    AccessibilityWindowInfo accessibilityWindowInfo7 = (AccessibilityWindowInfo) it2.next();
                    Iterator it3 = it2;
                    if (s()) {
                        Rect rect = new Rect();
                        accessibilityWindowInfo7.getBoundsInScreen(rect);
                        i = i2;
                        accessibilityWindowInfo3 = accessibilityWindowInfo6;
                        accessibilityWindowInfo2 = accessibilityWindowInfo5;
                        int i5 = (rect.right - rect.left) * (rect.bottom - rect.top);
                        if (sb != null) {
                            boolean z3 = accessibilityWindowInfo7.isActive() || accessibilityWindowInfo7.isFocused();
                            try {
                                z = z2;
                                try {
                                    packageName3 = accessibilitySceneMode.f5056a.get(Integer.valueOf(accessibilityWindowInfo7.getId()));
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                z = z2;
                            }
                            if (packageName3 == null) {
                                AccessibilityNodeInfo root = accessibilityWindowInfo7.getRoot();
                                packageName3 = root != null ? root.getPackageName() : null;
                            }
                            sb.append("\n层级: " + accessibilityWindowInfo7.getLayer() + ' ' + packageName3 + " Focused：" + z3 + "\n类型: " + accessibilityWindowInfo7.getType() + " Rect[" + rect.left + ',' + rect.top + ',' + rect.right + ',' + rect.bottom + "] $" + accessibilityWindowInfo7.getId() + " size:" + i5);
                        } else {
                            z = z2;
                        }
                        String str = accessibilitySceneMode.f5056a.get(Integer.valueOf(accessibilityWindowInfo7.getId()));
                        if (str == null) {
                            str = "";
                        }
                        if (!f92.a(str, t())) {
                            if (i5 < i3 || !(i5 > i3 || accessibilityWindowInfo7.isActive() || accessibilityWindowInfo7.isFocused())) {
                                accessibilityWindowInfo6 = accessibilityWindowInfo3;
                            } else {
                                i3 = i5;
                                accessibilityWindowInfo6 = accessibilityWindowInfo7;
                            }
                            accessibilityWindowInfo5 = accessibilityWindowInfo2;
                        } else if (i5 >= i4) {
                            i4 = i5;
                            accessibilityWindowInfo5 = accessibilityWindowInfo7;
                            accessibilityWindowInfo6 = accessibilityWindowInfo3;
                        } else {
                            accessibilityWindowInfo6 = accessibilityWindowInfo3;
                            accessibilityWindowInfo5 = accessibilityWindowInfo2;
                            z2 = z;
                        }
                        z2 = z;
                    } else {
                        i = i2;
                        accessibilityWindowInfo2 = accessibilityWindowInfo5;
                        accessibilityWindowInfo3 = accessibilityWindowInfo6;
                        z = z2;
                        boolean z4 = accessibilityWindowInfo7.isActive() || accessibilityWindowInfo7.isFocused();
                        if (sb != null) {
                            Rect rect2 = new Rect();
                            accessibilityWindowInfo7.getBoundsInScreen(rect2);
                            try {
                                packageName2 = accessibilitySceneMode.f5056a.get(Integer.valueOf(accessibilityWindowInfo7.getId()));
                            } catch (Exception unused3) {
                            }
                            if (packageName2 == null) {
                                AccessibilityNodeInfo root2 = accessibilityWindowInfo7.getRoot();
                                packageName2 = root2 != null ? root2.getPackageName() : null;
                            }
                            sb.append("\n层级: " + accessibilityWindowInfo7.getLayer() + ' ' + packageName2 + " Focused：" + z4 + "\n类型: " + accessibilityWindowInfo7.getType() + " Rect[" + rect2.left + ',' + rect2.top + ',' + rect2.right + ',' + rect2.bottom + "] $" + accessibilityWindowInfo7.getId() + " size:" + ((rect2.right - rect2.left) * (rect2.bottom - rect2.top)));
                        }
                        if (!z || z4) {
                            Rect rect3 = new Rect();
                            accessibilityWindowInfo7.getBoundsInScreen(rect3);
                            int i6 = (rect3.right - rect3.left) * (rect3.bottom - rect3.top);
                            if (i6 >= i3 || (z4 && !z)) {
                                i3 = i6;
                                z2 = z4;
                                accessibilityWindowInfo6 = accessibilityWindowInfo7;
                                accessibilityWindowInfo5 = accessibilityWindowInfo2;
                            }
                        }
                        accessibilityWindowInfo6 = accessibilityWindowInfo3;
                        accessibilityWindowInfo5 = accessibilityWindowInfo2;
                        z2 = z;
                    }
                    it2 = it3;
                    i2 = i;
                    accessibilitySceneMode = this;
                } catch (Exception unused4) {
                    return;
                }
            }
            int i7 = i2;
            AccessibilityWindowInfo accessibilityWindowInfo8 = accessibilityWindowInfo5;
            AccessibilityWindowInfo accessibilityWindowInfo9 = accessibilityWindowInfo6;
            if (sb != null) {
                sb.append("\n\n");
                if (accessibilityWindowInfo8 != null) {
                    yb2.g(sb, "结果：$", Integer.valueOf(accessibilityWindowInfo8.getId()), " launcher\n");
                }
                if (accessibilityWindowInfo9 != null) {
                    f92.b(accessibilityWindowInfo9);
                    yb2.g(sb, "结果：$", Integer.valueOf(accessibilityWindowInfo9.getId()), " window\n");
                }
                m42 m42Var = m42.f6769a;
            }
            if (accessibilityWindowInfo9 != null && (accessibilityWindowInfo8 == null || i3 >= (i4 * 7) / 10)) {
                accessibilityWindowInfo = accessibilityWindowInfo9;
            } else {
                i3 = i4;
                accessibilityWindowInfo = accessibilityWindowInfo8;
            }
            try {
                if (accessibilityWindowInfo == null || i3 < i7) {
                    if (sb != null) {
                        sb.append("\n现在: " + fa0.f867a.i());
                    }
                    fx1 fx1Var = this.f5052a;
                    if (fx1Var != null) {
                        fx1Var.c(String.valueOf(sb));
                        m42 m42Var2 = m42.f6769a;
                        return;
                    }
                    return;
                }
                Integer numValueOf = accessibilityEvent != null ? Integer.valueOf(accessibilityEvent.getWindowId()) : null;
                int id = accessibilityWindowInfo.getId();
                if (sb == null) {
                    if (numValueOf != null && numValueOf.intValue() == id) {
                        if (accessibilityEvent.getPackageName() != null) {
                            this.f5056a.put(numValueOf, accessibilityEvent.getPackageName().toString());
                            w(accessibilityEvent.getPackageName().toString());
                            return;
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    g = jCurrentTimeMillis2;
                    E(accessibilityWindowInfo, jCurrentTimeMillis2);
                    if (accessibilityEvent != null) {
                        A(this, null, 1, null);
                        return;
                    }
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == id) {
                    packageName = accessibilityEvent.getPackageName();
                    if (packageName == null) {
                        AccessibilityNodeInfo root3 = accessibilityWindowInfo.getRoot();
                        f92.c(root3, "lastWindow.root");
                        packageName = root3.getPackageName();
                    }
                } else {
                    try {
                        AccessibilityNodeInfo root4 = accessibilityWindowInfo.getRoot();
                        f92.c(root4, "lastWindow.root");
                        packageName = root4.getPackageName();
                    } catch (Exception unused5) {
                        packageName = null;
                    }
                }
                if (packageName != null) {
                    this.f5056a.put(Integer.valueOf(id), packageName.toString());
                    sb.append("\n此前: " + fa0.f867a.i());
                    w(packageName.toString());
                    if (accessibilityEvent != null) {
                        A(this, null, 1, null);
                    }
                }
                sb.append("\n现在: " + fa0.f867a.i());
                fx1 fx1Var2 = this.f5052a;
                if (fx1Var2 != null) {
                    String string = sb.toString();
                    f92.c(string, "logs.toString()");
                    fx1Var2.c(string);
                    m42 m42Var3 = m42.f6769a;
                }
            } catch (Exception unused6) {
            }
        } catch (Exception unused7) {
        }
    }

    public final void w(String str) {
        String strSubstring;
        iq0 iq0Var;
        String strT;
        int iM = ec2.M(str, ':', 0, false, 6, null);
        if (iM <= -1) {
            strSubstring = str;
        } else {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(0, iM);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        if (f92.a(wu0.f3480a.q().b(), "standby") && (iq0Var = this.f5053a) != null && iq0Var.H(strSubstring) && (strT = t()) != null) {
            strSubstring = strT;
        }
        if (s() && this.f5058a.contains(strSubstring)) {
            return;
        }
        if (i52.v(this.f5060a, this.f5057a)) {
            String str2 = this.f5059a.get(this.f5057a);
            fa0 fa0Var = fa0.f867a;
            if (str2 == null) {
                str2 = this.f5057a;
            }
            fa0Var.q(strSubstring, str2);
        } else if (f92.a(strSubstring, "com.tencent.mm") || f92.a(strSubstring, "com.tencent.tim") || f92.a(strSubstring, "com.tencent.mobileqq")) {
            fa0 fa0Var2 = fa0.f867a;
            if (bc2.x(str, "com.tencent.mm:appbrand", false, 2, null)) {
                str = "com.tencent.mm:appbrand";
            } else if (bc2.x(str, "com.tencent.mobileqq:mini", false, 2, null)) {
                str = "com.tencent.mobileqq:mini";
            }
            fa0.r(fa0Var2, str, null, 2, null);
        } else if (f92.a(strSubstring, Scene.f4798a.f())) {
            return;
        } else {
            fa0.r(fa0.f867a, strSubstring, null, 2, null);
        }
        z90.b(z90.f8048a, aa0.APP_SWITCH, null, 2, null);
    }

    public final void x(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 1) {
            this.f5064b = false;
        } else if (i == 2) {
            this.f5064b = true;
        }
        n();
    }

    public final boolean y() {
        fx1 fx1Var;
        if (!Scene.f4798a.b(hz0.f1282a.O(), false)) {
            dx1 dx1Var = this.f5051a;
            if (dx1Var != null) {
                dx1Var.b();
            }
            this.f5051a = null;
        } else if (this.f5051a == null) {
            dx1 dx1Var2 = new dx1(this);
            dx1Var2.c();
            m42 m42Var = m42.f6769a;
            this.f5051a = dx1Var2;
        }
        boolean zB = Scene.f4798a.b(hz0.f1282a.d0(), false);
        if (zB && this.f5052a == null) {
            this.f5052a = new fx1(this);
            return true;
        }
        if (!zB && (fx1Var = this.f5052a) != null) {
            if (fx1Var != null) {
                fx1Var.b();
            }
            this.f5052a = null;
        }
        return false;
    }

    public final void z(Long l) {
        B();
        synchronized (this) {
            this.f5065c = System.currentTimeMillis();
            if (this.f5061a == null) {
                Timer timer = new Timer("ActivityContentAnalyser");
                timer.schedule(new r61(this, l), l != null ? l.longValue() : this.f5071e, this.f5071e);
                m42 m42Var = m42.f6769a;
                this.f5061a = timer;
            }
            m42 m42Var2 = m42.f6769a;
        }
    }
}
