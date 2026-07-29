package ag;

import ag.e;
import android.os.Environment;
import android.os.HandlerThread;
import g.n0;
import g.p0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class c implements f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f652e = System.getProperty("line.separator");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f653f = " <br> ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f654g = ",";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Date f655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SimpleDateFormat f656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final h f657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f658d;

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f659e = 512000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Date f660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SimpleDateFormat f661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f663d;

        @n0
        public c a() {
            if (this.f660a == null) {
                this.f660a = new Date();
            }
            if (this.f661b == null) {
                this.f661b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.f662c == null) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.f662c = new e(new e.a(handlerThread.getLooper(), str, f659e));
            }
            return new c(this);
        }

        @n0
        public b b(@p0 Date date) {
            this.f660a = date;
            return this;
        }

        @n0
        public b c(@p0 SimpleDateFormat simpleDateFormat) {
            this.f661b = simpleDateFormat;
            return this;
        }

        @n0
        public b d(@p0 h hVar) {
            this.f662c = hVar;
            return this;
        }

        @n0
        public b e(@p0 String str) {
            this.f663d = str;
            return this;
        }

        public b() {
            this.f663d = "PRETTY_LOGGER";
        }
    }

    @n0
    public static b c() {
        return new b();
    }

    @Override // ag.f
    public void a(int i10, @p0 String str, @n0 String str2) {
        n.a(str2);
        String strB = b(str);
        this.f655a.setTime(System.currentTimeMillis());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Long.toString(this.f655a.getTime()));
        sb2.append(f654g);
        sb2.append(this.f656b.format(this.f655a));
        sb2.append(f654g);
        sb2.append(n.e(i10));
        sb2.append(f654g);
        sb2.append(strB);
        String str3 = f652e;
        if (str2.contains(str3)) {
            str2 = str2.replaceAll(str3, f653f);
        }
        sb2.append(f654g);
        sb2.append(str2);
        sb2.append(str3);
        this.f657c.a(i10, strB, sb2.toString());
    }

    @p0
    public final String b(@p0 String str) {
        if (n.d(str) || n.b(this.f658d, str)) {
            return this.f658d;
        }
        return this.f658d + "-" + str;
    }

    public c(@n0 b bVar) {
        n.a(bVar);
        this.f655a = bVar.f660a;
        this.f656b = bVar.f661b;
        this.f657c = bVar.f662c;
        this.f658d = bVar.f663d;
    }
}
