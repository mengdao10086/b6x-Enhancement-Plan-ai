package a;

import android.content.SharedPreferences;
import android.content.res.Resources;
import com.omarea.Scene;
import com.omarea.vtools.AccessibilitySceneMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iq0 extends wu0 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ij0 f1399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tw0 f1400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f1401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AccessibilitySceneMode f1402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f1403a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public SharedPreferences f1404b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<String> f1405b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1406b;
    public final boolean c;
    public String m;
    public String n;
    public String o;

    public iq0(AccessibilitySceneMode accessibilitySceneMode, boolean z) {
        f92.d(accessibilitySceneMode, "context");
        this.f1402a = accessibilitySceneMode;
        this.c = z;
        this.n = "com.android.systemui";
        this.o = "";
        this.f1401a = Scene.f4798a.c().getSharedPreferences(hz0.f1282a.l0(), 0);
        this.f1404b = Scene.f4798a.c().getSharedPreferences(hz0.f1282a.m0(), 0);
        this.f1405b = new ArrayList<>();
        this.b = 25000L;
        tw0 tw0VarD = tw0.f3070a.d(this.f1402a, new fz0(this.f1402a));
        f92.b(tw0VarD);
        this.f1400a = tw0VarD;
        this.f1399a = new ij0(this.f1402a);
        this.f1399a = new ij0(this.f1402a);
        U(this, false, 1, null);
        qc2.d(hf2.f6309a, qe2.b(), null, new bq0(this, null), 2, null);
        z90.f8048a.c(this);
    }

    public /* synthetic */ iq0(AccessibilitySceneMode accessibilitySceneMode, boolean z, int i, b92 b92Var) {
        this(accessibilitySceneMode, (i & 2) != 0 ? false : z);
    }

    public static /* synthetic */ void U(iq0 iq0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        iq0Var.T(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(java.lang.String r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L8b
            java.lang.String r0 = r6.n
            boolean r0 = a.f92.a(r7, r0)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L8b
            r6.n = r7
            boolean r0 = r6.I()
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L6f
            boolean r0 = r6.r()
            if (r0 == 0) goto L26
            a.hz0 r0 = a.hz0.f1282a
            boolean r0 = r0.a0()
            if (r0 == 0) goto L26
            r0 = r1
            goto L27
        L26:
            r0 = r2
        L27:
            if (r0 == 0) goto L30
            a.su0 r0 = a.wu0.f3480a
            java.lang.String r0 = r0.n()
            goto L4f
        L30:
            android.content.SharedPreferences r0 = r6.f1401a
            java.lang.String r0 = r0.getString(r7, r3)
            if (r0 == 0) goto L39
            goto L4a
        L39:
            android.content.SharedPreferences r0 = r6.f1401a
            a.su0 r4 = a.wu0.f3480a
            java.lang.String r4 = r4.c()
            java.lang.String r5 = "*"
            java.lang.String r0 = r0.getString(r5, r4)
            a.f92.b(r0)
        L4a:
            java.lang.String r4 = "spfPowerCfg.getString(pa…getString(\"*\", BALANCE)!!"
            a.f92.c(r0, r4)
        L4f:
            a.su0 r4 = a.wu0.f3480a
            java.lang.String r4 = r4.j()
            boolean r4 = a.f92.a(r0, r4)
            r4 = r4 ^ r1
            if (r4 == 0) goto L6f
            java.lang.String r4 = r6.o
            boolean r4 = a.f92.a(r4, r0)
            r4 = r4 ^ r1
            if (r4 != 0) goto L6b
            boolean r4 = r6.t()
            if (r4 == 0) goto L6f
        L6b:
            r6.R(r0, r7)
            goto L70
        L6f:
            r1 = r2
        L70:
            if (r1 != 0) goto L8b
            a.hz0 r0 = a.hz0.f1282a
            boolean r0 = r0.B()
            if (r0 != 0) goto L8b
            a.su0 r0 = a.wu0.f3480a
            a.dx0 r0 = r0.q()
            r0.d(r7)
            a.z90 r7 = a.z90.f8048a
            a.aa0 r0 = a.aa0.SCENE_NOTIFY_UPDATE
            r1 = 2
            a.z90.b(r7, r0, r3, r1, r3)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.iq0.G(java.lang.String):void");
    }

    public final boolean H(String str) {
        f92.d(str, "packageName");
        return J(str) || f92.a(this.f1401a.getString(str, ""), wu0.f3480a.j());
    }

    public final boolean I() {
        return hz0.f1282a.b0() && !hz0.f1282a.B();
    }

    public final boolean J(String str) {
        return this.f1405b.contains(str) || this.f1404b.contains(str);
    }

    public final void K() {
        Resources resources = Scene.f4798a.c().getResources();
        yu0 yu0Var = new yu0();
        ArrayList<String> arrayList = this.f1405b;
        arrayList.clear();
        String[] stringArray = resources.getStringArray(s61.config_powercfg_force_igoned);
        f92.c(stringArray, "res.getStringArray(R.arr…ig_powercfg_force_igoned)");
        d52.p(arrayList, stringArray);
        arrayList.addAll(new si0(this.f1402a).a());
        SharedPreferences sharedPreferences = this.f1401a;
        f92.c(sharedPreferences, "spfPowerCfg");
        if (sharedPreferences.getAll().isEmpty()) {
            yu0Var.a();
        }
        if (hz0.f1282a.b0()) {
            if (!s()) {
                hz0.f1282a.K0(false);
            } else {
                bv0.f5735a.a();
                q();
            }
        }
    }

    public final void L(String str) {
        if (!this.f1406b && !this.f1399a.b()) {
            O();
        }
        if (f92.a(this.m, str) || J(str)) {
            return;
        }
        if (this.m == null) {
            this.m = "com.android.systemui";
        }
        G(str);
        tw0.v(this.f1400a, str, false, 2, null);
        this.m = str;
    }

    public final void M() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f6435a;
        long j = 99;
        if (0 <= jCurrentTimeMillis && j >= jCurrentTimeMillis) {
            return;
        }
        this.f1406b = false;
        this.f6435a = System.currentTimeMillis();
        this.f1400a.y();
        Scene.f4798a.j(new eq0(this), this.b + ((long) 1000));
        Scene.f4798a.j(new fq0(this), 1000L);
    }

    public final void N() {
        if (this.f1406b || System.currentTimeMillis() - this.f6435a < this.b) {
            return;
        }
        this.f1400a.z();
        System.gc();
    }

    public final void O() {
        this.f6435a = System.currentTimeMillis();
        this.f1400a.A();
        this.f1400a.m();
        if (!this.f1406b) {
            this.f1406b = true;
            P();
        }
        if (I()) {
            if (this.o.length() > 0) {
                this.m = null;
                this.n = null;
                z90.b(z90.f8048a, aa0.STATE_RESUME, null, 2, null);
            }
        }
    }

    public final void P() {
        if (this.f1403a == null && this.f1406b && !this.f1399a.b()) {
            Timer timer = new Timer("ProcessPolling", true);
            timer.schedule(new hq0(timer, 6, this), 1000L, ((long) 6) * 1000);
            m42 m42Var = m42.f6769a;
            this.f1403a = timer;
        }
    }

    public final void Q() {
        try {
            if (this.f1403a != null) {
                Timer timer = this.f1403a;
                f92.b(timer);
                timer.cancel();
                Timer timer2 = this.f1403a;
                f92.b(timer2);
                timer2.purge();
                this.f1403a = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void R(String str, String str2) {
        this.o = str;
        u(str, str2, "dynamic");
    }

    public final void S() {
        m();
        this.o = "";
        K();
        aq0.f101a.j(true);
        Q();
        P();
    }

    public final void T(boolean z) {
        if (this.f1406b) {
            aq0.f101a.g(z);
        }
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        switch (cq0.b[aa0Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    @Override // a.ha0
    public boolean isAsync() {
        return this.c;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        switch (cq0.f5818a[aa0Var.ordinal()]) {
            case 1:
                L(fa0.f867a.i());
                break;
            case 2:
                O();
                break;
            case 3:
                if (new ij0(this.f1402a).b()) {
                    M();
                }
                break;
            case 4:
            case 5:
                String str = this.n;
                this.n = "com.android.systemui";
                G(str);
                break;
            case 6:
                qc2.d(xd2.a(qe2.b()), null, null, new dq0(this, null), 3, null);
                break;
            case 7:
                if (map != null && map.containsKey("app")) {
                    if (I() && this.f1406b && map.containsKey("mode")) {
                        Object obj = map.get("mode");
                        String string = obj != null ? obj.toString() : null;
                        Object obj2 = map.get("app");
                        String string2 = obj2 != null ? obj2.toString() : null;
                        if (string != null && string2 != null && f92.a(string2, this.n)) {
                            R(string, string2);
                        }
                    }
                    this.f1400a.H();
                    break;
                }
                break;
        }
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
        this.f1400a.o();
        aq0.f101a.f();
        Q();
    }
}
