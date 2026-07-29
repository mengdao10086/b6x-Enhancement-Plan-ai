package com.umeng.socialize.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.utils.ContextUtil;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24534a = "Prefs";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f24535c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24536b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f24537d = new a("AZX");

    public class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24539b;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f24539b = str;
        }

        private String b(String str) {
            return this.f24539b + str;
        }

        private String c(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    return b.a().b(str, str2);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return str2;
        }

        private void d(String str, String str2) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str, str2);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public void a(String str, int i10) {
            d(b(str), String.valueOf(i10));
        }

        public void a(String str, long j10) {
            d(b(str), String.valueOf(j10));
        }

        public int b(String str, int i10) {
            try {
                return Integer.parseInt(c(b(str), String.valueOf(i10)));
            } catch (Exception unused) {
                return i10;
            }
        }

        public void a(String str, float f10) {
            d(b(str), String.valueOf(f10));
        }

        public void a(String str, String str2) {
            d(b(str), String.valueOf(str2));
        }

        public long b(String str, long j10) {
            try {
                return Long.parseLong(c(b(str), String.valueOf(j10)));
            } catch (Exception unused) {
                return j10;
            }
        }

        public void a(String str, boolean z10) {
            d(b(str), String.valueOf(z10));
        }

        private void c(String str) {
            try {
                if (c.a(ContextUtil.getContext())) {
                    b.a().a(str);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public void a(String str) {
            c(b(str));
        }

        public float b(String str, float f10) {
            try {
                return Float.parseFloat(c(b(str), String.valueOf(f10)));
            } catch (Exception unused) {
                return f10;
            }
        }

        public boolean b(String str, boolean z10) {
            try {
                return Boolean.parseBoolean(c(b(str), String.valueOf(z10)));
            } catch (Exception unused) {
                return z10;
            }
        }

        public String b(String str, String str2) {
            return c(b(str), str2);
        }
    }

    private e(Context context) {
        this.f24536b = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f24535c == null) {
            synchronized (e.class) {
                if (f24535c == null) {
                    f24535c = new e(context);
                }
            }
        }
        return f24535c;
    }

    public boolean b() {
        return a(com.umeng.socialize.a.a.f24527e);
    }

    public int c() {
        return this.f24537d.b(com.umeng.socialize.a.a.f24528f, 0);
    }

    public long d() {
        return this.f24537d.b(com.umeng.socialize.a.a.f24526d, 0L);
    }

    public void e() {
        if (c.a(this.f24536b)) {
            this.f24537d.a(com.umeng.socialize.a.a.f24526d, d() + 1);
        }
    }

    private void b(String str) {
        this.f24537d.a(str + an.aU);
        this.f24537d.a(str + "ts");
    }

    public void a(long j10) {
        a(com.umeng.socialize.a.a.f24527e, j10);
    }

    public long a() {
        return this.f24537d.b("smart_ts", 0L);
    }

    public void a(int i10) {
        this.f24537d.a(com.umeng.socialize.a.a.f24528f, i10);
    }

    private void a(String str, long j10) {
        this.f24537d.a(str + an.aU, j10);
        this.f24537d.a(str + "ts", System.currentTimeMillis());
    }

    private boolean a(String str) {
        long jB = this.f24537d.b(str + an.aU, 0L);
        if (jB <= 0) {
            return true;
        }
        a aVar = this.f24537d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("ts");
        return Math.abs(System.currentTimeMillis() - aVar.b(sb2.toString(), 0L)) / 1000 >= jB;
    }
}
