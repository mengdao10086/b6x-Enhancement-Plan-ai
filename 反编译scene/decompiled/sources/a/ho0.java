package a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.omarea.Scene;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ho0 extends r50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1199a;
    public final int c;
    public final int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ho0(Context context) {
        super(null, 1, null);
        f92.d(context, "context");
        this.f1198a = context;
        this.c = 8000;
        this.d = 15000;
        this.f1199a = "http://download.omarea.com/toolkit/";
    }

    public final ar0 B(String str) throws PackageManager.NameNotFoundException {
        f92.d(str, "type");
        ar0 ar0Var = new ar0();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PackageInfo packageInfo = this.f1198a.getPackageManager().getPackageInfo(this.f1198a.getPackageName(), 0);
        try {
            g30 g30Var = new g30(k(l(no0.f6937a.a() + "/cloud-scheduler2", new l30(new do0(this, str, e50.f677a.l0(), packageInfo)))));
            ar0Var.r(0L);
            if (g30Var.j("files") && (!f92.a(g30Var.b("files"), g30.f959a))) {
                g30 g30VarG = g30Var.g("files");
                uj0 uj0Var = new uj0();
                Iterator<String> itK = g30VarG.k();
                f92.c(itK, "files.keys()");
                while (itK.hasNext()) {
                    String next = itK.next();
                    String strI = g30VarG.i(next);
                    f92.c(strI, "files.getString(key)");
                    String strA = uj0Var.a(strI);
                    f92.c(next, "key");
                    linkedHashMap.put(next, strA);
                }
            }
        } catch (Exception unused) {
        }
        if (linkedHashMap.containsKey("powercfg.sh") && linkedHashMap.containsKey("manifest.json")) {
            new bv0().e();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (f92.a((String) entry.getKey(), "manifest.json")) {
                    try {
                        ar0Var.q(new g30((String) entry.getValue()));
                        wu0.f3480a.a();
                        e50.f677a.P0("version-update");
                    } catch (Exception unused2) {
                    }
                }
                c60 c60Var = c60.f5764a;
                String str2 = (String) entry.getValue();
                Charset charset = bb2.f5692a;
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = str2.getBytes(charset);
                f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
                if (!c60Var.l(bytes, (String) entry.getKey(), this.f1198a)) {
                    Scene.c.p(Scene.f4798a, "Unable to save the profile: " + ((String) entry.getKey()), 0, 2, null);
                }
            }
        }
        return ar0Var;
    }

    public final long C(String str) throws PackageManager.NameNotFoundException {
        f92.d(str, "type");
        PackageInfo packageInfo = this.f1198a.getPackageManager().getPackageInfo(this.f1198a.getPackageName(), 0);
        try {
            g30 g30Var = new g30(k(l(no0.f6937a.a() + "/cloud-scheduler-v2", new l30(new fo0(this, str, e50.f677a.l0(), packageInfo)))));
            ar0 ar0Var = new ar0();
            ar0Var.q(g30Var);
            if (ar0Var.d().length() > 0) {
                qc2.d(xd2.a(qe2.b()), null, null, new eo0(this, ar0Var, null), 3, null);
            }
            return ar0Var.p();
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final void D(String str, String str2) {
        try {
            if (!(str2.length() > 0)) {
                Scene.f4798a.m(hz0.f1282a.C(), null);
                Scene.f4798a.m(hz0.f1282a.z(), null);
                return;
            }
            byte[] bArrG = g(this.f1199a + URLEncoder.encode(str, "UTF-8"));
            if (c60.f5764a.l(bArrG, "scene-daemon-bak", this.f1198a)) {
                Scene.f4798a.m(hz0.f1282a.C(), w20.f3357a.a().c());
                Scene.f4798a.m(hz0.f1282a.z(), str2);
            }
            c60.f5764a.l(bArrG, "scene-daemon", this.f1198a);
        } catch (Exception unused) {
        }
    }

    public final String E() {
        return "scene9/9.0";
    }

    public final Locale F() {
        if (Build.VERSION.SDK_INT < 24) {
            Resources resources = Scene.f4798a.c().getResources();
            f92.c(resources, "Scene.context.resources");
            return resources.getConfiguration().locale;
        }
        Resources resources2 = Scene.f4798a.c().getResources();
        f92.c(resources2, "Scene.context.resources");
        Configuration configuration = resources2.getConfiguration();
        f92.c(configuration, "Scene.context.resources.configuration");
        return configuration.getLocales().get(0);
    }

    public final String G() {
        im0 im0Var = jm0.f6525a;
        String strB = im0Var.b();
        String strA = im0Var.a();
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strA.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return u42.k(new String[]{"waipio", "waipiop", "cape", "capep", "ukee"}, lowerCase) ? lowerCase : strB;
    }

    public final String H() {
        StringBuilder sb;
        String str;
        kl0 kl0Var = new kl0();
        String strV = kl0Var.v("");
        if (kl0Var.B()) {
            str = "dimensity-";
            if (kl0Var.a()) {
                sb = new StringBuilder();
                sb.append("dimensity-");
                sb.append(strV);
                strV = "-ppm";
                sb.append(strV);
                return sb.toString();
            }
            sb = new StringBuilder();
        } else if (new kl0().A()) {
            sb = new StringBuilder();
            str = "snapdragon-";
        } else {
            sb = new StringBuilder();
            str = "unknown-";
        }
        sb.append(str);
        sb.append(strV);
        return sb.toString();
    }

    public final String I() {
        try {
            String strL = l(no0.f6937a.a() + "/cloud-scheduler-threads", new l30(new go0(this, this.f1198a.getPackageManager().getPackageInfo(this.f1198a.getPackageName(), 0))));
            new d30(strL);
            return strL;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ho0.J():void");
    }

    @Override // a.r50
    public int h() {
        return this.c;
    }

    @Override // a.r50
    public int i() {
        return this.d;
    }
}
