package a;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.omarea.Scene;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ez0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Display.Mode> f823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f821a = "REFRESH_RATE.CONF";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<String, az0> f822a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nb2 f6055a = new nb2("[ ]+");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f820a = a42.a(dz0.f5950a);
    public final z32 b = a42.a(new cz0(this));

    public ez0() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        i(j());
        if (this.f822a.size() == 0) {
            o();
        }
    }

    public final boolean b() {
        return new rx0(Scene.f4798a.c(), "features/refresh_rate.conf").b("enable", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r11, a.b62<? super a.az0> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof a.bz0
            if (r0 == 0) goto L13
            r0 = r12
            a.bz0 r0 = (a.bz0) r0
            int r1 = r0.f5744a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5744a = r1
            goto L18
        L13:
            a.bz0 r0 = new a.bz0
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f313a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f5744a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.c
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.b
            a.ez0 r11 = (a.ez0) r11
            a.h42.b(r12)     // Catch: java.lang.Exception -> L84
            goto L4b
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            a.h42.b(r12)
            a.e50 r12 = a.e50.f677a     // Catch: java.lang.Exception -> L84
            r0.b = r10     // Catch: java.lang.Exception -> L84
            r0.c = r11     // Catch: java.lang.Exception -> L84
            r0.f5744a = r3     // Catch: java.lang.Exception -> L84
            java.lang.Object r12 = r12.h0(r11, r0)     // Catch: java.lang.Exception -> L84
            if (r12 != r1) goto L4b
            return r1
        L4b:
            r4 = r12
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch: java.lang.Exception -> L84
            java.lang.String r11 = " "
            java.lang.String[] r5 = new java.lang.String[]{r11}     // Catch: java.lang.Exception -> L84
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.util.List r11 = a.ec2.d0(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L84
            int r12 = r11.size()     // Catch: java.lang.Exception -> L84
            r0 = 3
            if (r12 != r0) goto L84
            a.az0 r12 = new a.az0     // Catch: java.lang.Exception -> L84
            r12.<init>()     // Catch: java.lang.Exception -> L84
            java.lang.Object r0 = r11.get(r3)     // Catch: java.lang.Exception -> L84
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L84
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L84
            r12.d(r0)     // Catch: java.lang.Exception -> L84
            r0 = 2
            java.lang.Object r11 = r11.get(r0)     // Catch: java.lang.Exception -> L84
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> L84
            int r11 = java.lang.Integer.parseInt(r11)     // Catch: java.lang.Exception -> L84
            r12.c(r11)     // Catch: java.lang.Exception -> L84
            return r12
        L84:
            a.az0 r11 = new a.az0
            r11.<init>()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ez0.c(java.lang.String, a.b62):java.lang.Object");
    }

    public final az0 d(String str) {
        f92.d(str, "app");
        if (!this.f822a.containsKey(str)) {
            return null;
        }
        az0 az0Var = this.f822a.get(str);
        f92.b(az0Var);
        return az0Var;
    }

    public final List<Display.Mode> e() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (g()) {
            Class cls = Integer.TYPE;
            Constructor constructor = Display.Mode.class.getConstructor(cls, cls, cls, Float.TYPE);
            return y42.h((Display.Mode) constructor.newInstance(60, 1440, 3200, Float.valueOf(60.0f)), (Display.Mode) constructor.newInstance(90, 1440, 3200, Float.valueOf(90.0f)), (Display.Mode) constructor.newInstance(120, 1440, 3200, Float.valueOf(120.0f)));
        }
        if (this.f823a == null) {
            Object systemService = Scene.f4798a.c().getSystemService("window");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f92.c(defaultDisplay, "display");
            Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
            f92.c(supportedModes, "supported");
            ArrayList arrayList = new ArrayList();
            for (Display.Mode mode : supportedModes) {
                f92.c(mode, "it");
                if (mode.getPhysicalWidth() == point.x) {
                    arrayList.add(mode);
                }
            }
            this.f823a = arrayList;
            f92.b(arrayList);
            if (arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (Display.Mode mode2 : supportedModes) {
                    f92.c(mode2, "it");
                    if (mode2.getPhysicalWidth() != point.x) {
                        arrayList2.add(mode2);
                    }
                }
                this.f823a = arrayList2;
            }
        }
        List<Display.Mode> list = this.f823a;
        f92.b(list);
        return list;
    }

    public final int f() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        float refreshRate = 60.0f;
        for (Display.Mode mode : e()) {
            if (mode.getRefreshRate() > refreshRate) {
                refreshRate = mode.getRefreshRate();
            }
        }
        return u92.b(refreshRate);
    }

    public final boolean g() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final String h() {
        return (String) this.f820a.getValue();
    }

    public final void i(String str) {
        f92.d(str, "content");
        Iterator it = ec2.d0(str, new String[]{"\n"}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            List<String> listH = this.f6055a.h((String) it.next(), 0);
            if (listH.size() == 3) {
                HashMap<String, az0> map = this.f822a;
                String str2 = listH.get(0);
                az0 az0Var = new az0();
                az0Var.d(Integer.parseInt(listH.get(1)));
                az0Var.c(Integer.parseInt(listH.get(2)));
                m42 m42Var = m42.f6769a;
                map.put(str2, az0Var);
            }
        }
    }

    public final String j() {
        return y60.f7952a.i(c60.f5764a.d(Scene.f4798a.c(), this.f821a));
    }

    public final boolean k() {
        Object next;
        if (f() > 60) {
            Iterator<T> it = e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (u92.b(((Display.Mode) next).getRefreshRate()) == 60) {
                    break;
                }
            }
            if (next != null) {
                return true;
            }
        }
        return false;
    }

    public final void l() {
        if (this.f824a) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, az0> entry : this.f822a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(" ");
                sb.append(entry.getValue().b());
                sb.append(" ");
                sb.append(entry.getValue().a());
                sb.append("\n");
            }
            c60 c60Var = c60.f5764a;
            String string = sb.toString();
            f92.c(string, "builder.toString()");
            Charset charsetDefaultCharset = Charset.defaultCharset();
            f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = string.getBytes(charsetDefaultCharset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            c60Var.l(bytes, this.f821a, Scene.f4798a.c());
            this.f824a = false;
        }
    }

    public final void m(String str, Integer num, Integer num2) {
        f92.d(str, "app");
        this.f824a = true;
        if ((num != null && num.intValue() == 0) || ((num2 != null && num2.intValue() == 0) || (num == null && num2 == null))) {
            this.f822a.remove(str);
            return;
        }
        az0 az0VarD = d(str);
        if (num == null) {
            num = az0VarD != null ? Integer.valueOf(az0VarD.b()) : null;
        }
        int iIntValue = num != null ? num.intValue() : 0;
        if (num2 == null) {
            num2 = az0VarD != null ? Integer.valueOf(az0VarD.a()) : null;
        }
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        HashMap<String, az0> map = this.f822a;
        az0 az0Var = new az0();
        az0Var.d(iIntValue);
        az0Var.c(iIntValue2);
        m42 m42Var = m42.f6769a;
        map.put(str, az0Var);
    }

    public final Object n(int i, b62<? super m42> b62Var) {
        Object objB1 = e50.f677a.b1(i, b62Var);
        return objB1 == r62.c() ? objB1 : m42.f6769a;
    }

    public final void o() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        List<String> listD0 = ec2.d0(y50.f7950a.a(Scene.f4798a.c(), "refresh_rate.txt"), new String[]{"\n"}, false, 0, 6, null);
        List<Display.Mode> listE = e();
        ArrayList arrayList = new ArrayList(z42.m(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(u92.b(((Display.Mode) it.next()).getRefreshRate())));
        }
        int iF = f();
        for (String str : listD0) {
            if (!bc2.x(str, "#", false, 2, null)) {
                List<String> listH = this.f6055a.h(str, 0);
                if (listH.size() == 3) {
                    int i = Integer.parseInt(listH.get(1));
                    int i2 = Integer.parseInt(listH.get(2));
                    if (!arrayList.contains(Integer.valueOf(i))) {
                        i = i >= 90 ? iF : 60;
                    }
                    if (!arrayList.contains(Integer.valueOf(i2))) {
                        i2 = i2 >= 90 ? iF : 60;
                    }
                    HashMap<String, az0> map = this.f822a;
                    String str2 = listH.get(0);
                    az0 az0Var = new az0();
                    az0Var.d(i);
                    az0Var.c(i2);
                    m42 m42Var = m42.f6769a;
                    map.put(str2, az0Var);
                }
            }
        }
        this.f824a = true;
        l();
    }
}
