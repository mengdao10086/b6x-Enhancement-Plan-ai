package fh;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import com.upyun.library.exception.RespException;
import com.upyun.library.exception.UpYunException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.s;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {
    public static final String A = "Content-Secret";
    public static final String B = "X-Upyun-Meta-X";
    public static final String C = "X-Upyun-Multi-Disorder";
    public static final String D = "X-Upyun-Multi-Stage";
    public static final String E = "X-Upyun-Multi-Type";
    public static final String F = "X-Upyun-Multi-Length";
    public static final String G = "X-Upyun-Multi-UUID";
    public static final String H = "X-Upyun-Part-ID";
    public static final String I = "X-Upyun-Next-Part-ID";
    public static final String J = "https://v0.api.upyun.com";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f28349v = "Authorization";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f28350w = "/";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f28351x = 1048576;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f28352y = "Content-MD5";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f28353z = "Content-Type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28354a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f28357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f28358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f28359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f28360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f28361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a0 f28362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f28363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RandomAccessFile f28364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f28365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f28366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f28367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f28368o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f28370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public gh.c f28371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f28372s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f28355b = HttpHeaders.DATE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExecutorService f28356c = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f28369p = 20;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f28373t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f28374u = null;

    /* JADX INFO: renamed from: fh.a$a, reason: collision with other inner class name */
    public class C0331a implements gh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28375a;

        /* JADX INFO: renamed from: fh.a$a$a, reason: collision with other inner class name */
        public class RunnableC0332a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f28377a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f28378b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f28379c;

            public RunnableC0332a(boolean z10, d0 d0Var, Exception exc) {
                this.f28377a = z10;
                this.f28378b = d0Var;
                this.f28379c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                gh.b bVar = C0331a.this.f28375a;
                if (bVar != null) {
                    bVar.a(this.f28377a, this.f28378b, this.f28379c);
                }
            }
        }

        public C0331a(gh.b bVar) {
            this.f28375a = bVar;
        }

        @Override // gh.b
        public void a(boolean z10, d0 d0Var, Exception exc) {
            hh.a.a(new RunnableC0332a(z10, d0Var, exc));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f28381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f28382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f28383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f28384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ gh.b f28385e;

        public b(File file, String str, Map map, Map map2, gh.b bVar) {
            this.f28381a = file;
            this.f28382b = str;
            this.f28383c = map;
            this.f28384d = map2;
            this.f28385e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.r(this.f28381a, this.f28382b, this.f28383c);
                String strD = a.this.d();
                a aVar = a.this;
                String strK = hh.c.k(Constants.HTTP_POST, strD, "/pretreatment/", aVar.f28367n, aVar.f28368o, null);
                Map map = this.f28384d;
                map.put(g.f28414e, hh.b.k(map.get(g.f28414e).toString()));
                s.a aVar2 = new s.a();
                for (Map.Entry entry : this.f28384d.entrySet()) {
                    aVar2.b((String) entry.getKey(), entry.getValue().toString());
                }
                d0 d0VarX = a.this.f28362i.a(new b0.a().B("https://p0.api.upyun.com/pretreatment/").r(aVar2.c()).n(HttpHeaders.DATE, strD).n("Authorization", strK).n("User-Agent", hh.c.f31296b).b()).X();
                if (d0VarX.k1()) {
                    this.f28385e.a(true, d0VarX, null);
                } else {
                    this.f28385e.a(false, null, new RespException(d0VarX.W(), d0VarX.L().string()));
                }
            } catch (UpYunException e10) {
                e10.printStackTrace();
                this.f28385e.a(false, null, e10);
            } catch (IOException e11) {
                e11.printStackTrace();
                this.f28385e.a(false, null, e11);
            }
        }
    }

    public class c implements gh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28387a;

        /* JADX INFO: renamed from: fh.a$c$a, reason: collision with other inner class name */
        public class RunnableC0333a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f28389a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f28390b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f28391c;

            public RunnableC0333a(boolean z10, d0 d0Var, Exception exc) {
                this.f28389a = z10;
                this.f28390b = d0Var;
                this.f28391c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                gh.b bVar = c.this.f28387a;
                if (bVar != null) {
                    bVar.a(this.f28389a, this.f28390b, this.f28391c);
                }
            }
        }

        public c(gh.b bVar) {
            this.f28387a = bVar;
        }

        @Override // gh.b
        public void a(boolean z10, d0 d0Var, Exception exc) {
            hh.a.a(new RunnableC0333a(z10, d0Var, exc));
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f28394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f28395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f28396d;

        public d(gh.b bVar, File file, String str, Map map) {
            this.f28393a = bVar;
            this.f28394b = file;
            this.f28395c = str;
            this.f28396d = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f28393a.a(true, a.this.r(this.f28394b, this.f28395c, this.f28396d), null);
            } catch (UpYunException e10) {
                e10.printStackTrace();
                this.f28393a.a(false, null, e10);
            } catch (IOException e11) {
                e11.printStackTrace();
                this.f28393a.a(false, null, e11);
            }
        }
    }

    public class e implements gh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28398a;

        /* JADX INFO: renamed from: fh.a$e$a, reason: collision with other inner class name */
        public class RunnableC0334a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f28400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f28401b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f28402c;

            public RunnableC0334a(boolean z10, d0 d0Var, Exception exc) {
                this.f28400a = z10;
                this.f28401b = d0Var;
                this.f28402c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                gh.b bVar = e.this.f28398a;
                if (bVar != null) {
                    bVar.a(this.f28400a, this.f28401b, this.f28402c);
                }
            }
        }

        public e(gh.b bVar) {
            this.f28398a = bVar;
        }

        @Override // gh.b
        public void a(boolean z10, d0 d0Var, Exception exc) {
            hh.a.a(new RunnableC0334a(z10, d0Var, exc));
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f28405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f28406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f28407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f28408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Map f28409f;

        public f(gh.b bVar, File file, String str, String str2, String str3, Map map) {
            this.f28404a = bVar;
            this.f28405b = file;
            this.f28406c = str;
            this.f28407d = str2;
            this.f28408e = str3;
            this.f28409f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f28404a.a(true, a.this.q(this.f28405b, this.f28406c, this.f28407d, this.f28408e, this.f28409f), null);
            } catch (UpYunException e10) {
                e10.printStackTrace();
                this.f28404a.a(false, null, e10);
            } catch (IOException e11) {
                e11.printStackTrace();
                this.f28404a.a(false, null, e11);
            } catch (InterruptedException e12) {
                e12.printStackTrace();
                this.f28404a.a(false, null, e12);
            } catch (ExecutionException e13) {
                e13.printStackTrace();
                this.f28404a.a(false, null, e13);
            }
        }
    }

    public class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f28411b = "bucket_name";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f28412c = "notify_url";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f28413d = "source";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f28414e = "tasks";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f28415f = "accept";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f28416g = "status_code";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f28417h = "path";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f28418i = "description";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f28419j = "task_id";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f28420k = "info";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f28421l = "signature";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f28422m = "timestamp";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f28423n = "task_ids";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f28424o = "type";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f28425p = "save_as";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f28426q = "return_info";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f28427r = "avopts";

        public g() {
        }
    }

    public a(String str, String str2, String str3) {
        this.f28366m = str;
        this.f28367n = str2;
        this.f28368o = str3;
    }

    public final d0 a(b0 b0Var, int i10) throws UpYunException, IOException {
        d0 d0VarX = this.f28362i.a(b0Var).X();
        if (!d0VarX.k1()) {
            this.f28360g = null;
            throw new RespException(d0VarX.W(), d0VarX.L().string());
        }
        gh.c cVar = this.f28371r;
        if (cVar != null) {
            cVar.a(i10, this.f28372s);
        }
        this.f28360g = d0VarX.G0(G, "");
        this.f28354a = Integer.parseInt(d0VarX.G0(I, "-2"));
        return d0VarX;
    }

    public d0 b() throws UpYunException, IOException {
        RandomAccessFile randomAccessFile = this.f28364k;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.f28364k = null;
        }
        c0 c0VarF = c0.f(null, "");
        String strH = this.f28365l ? hh.c.h("") : null;
        if (!this.f28359f) {
            String strD = d();
            this.f28373t = strD;
            this.f28374u = hh.c.k("PUT", strD, this.f28361h, this.f28367n, this.f28368o, strH).trim();
        }
        b0.a aVarS = new b0.a().B(this.f28370q).n(HttpHeaders.DATE, this.f28373t).n("Authorization", this.f28374u).n(D, "complete").n(G, this.f28360g).n("User-Agent", hh.c.f31296b).s(c0VarF);
        Map<String, String> map = this.f28357d;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVarS.n(entry.getKey(), entry.getValue());
            }
        }
        if (strH != null) {
            aVarS.n("Content-MD5", strH);
        }
        return a(aVarS.b(), this.f28372s);
    }

    public abstract d0 c() throws UpYunException, IOException;

    public String d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date());
    }

    public String e() {
        return this.f28360g;
    }

    public void f(File file, String str, String str2, String str3, Map<String, String> map) {
        this.f28359f = true;
        this.f28361h = str;
        this.f28374u = str3;
        this.f28358e = false;
        if (map == null) {
            map = new HashMap<>();
        }
        this.f28357d = map;
        this.f28363j = file;
        this.f28373t = str2;
        this.f28372s = (int) Math.ceil((file.length() / 1048576.0d) + 2.0d);
        this.f28370q = "https://v0.api.upyun.com" + str;
        a0.a aVar = new a0.a();
        long j10 = (long) this.f28369p;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f28362i = aVar.k(j10, timeUnit).j0(this.f28369p, timeUnit).R0(this.f28369p, timeUnit).f();
    }

    public void g(File file, String str, Map<String, String> map) {
        this.f28359f = false;
        this.f28358e = false;
        if (map == null) {
            map = new HashMap<>();
        }
        this.f28357d = map;
        this.f28363j = file;
        this.f28372s = (int) Math.ceil((file.length() / 1048576.0d) + 2.0d);
        if (str.startsWith(f28350w)) {
            this.f28361h = f28350w + this.f28366m + f28350w + URLEncoder.encode(str.substring(1));
        } else {
            this.f28361h = f28350w + this.f28366m + f28350w + URLEncoder.encode(str);
        }
        this.f28370q = "https://v0.api.upyun.com" + this.f28361h;
        a0.a aVar = new a0.a();
        long j10 = (long) this.f28369p;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f28362i = aVar.k(j10, timeUnit).j0(this.f28369p, timeUnit).R0(this.f28369p, timeUnit).f();
    }

    public void h() {
        this.f28358e = true;
    }

    public abstract d0 i() throws UpYunException, IOException;

    public byte[] j(long j10) throws IOException {
        byte[] bArr = new byte[1048576];
        this.f28364k.seek(j10 * 1048576);
        int i10 = this.f28364k.read(bArr, 0, 1048576);
        if (i10 >= 1048576) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    public d0 k() throws UpYunException, IOException {
        this.f28358e = false;
        return p();
    }

    public void l(boolean z10) {
        this.f28365l = z10;
    }

    public void m(gh.c cVar) {
        this.f28371r = cVar;
    }

    public void n(int i10) {
        this.f28369p = i10;
    }

    public void o(String str) {
        this.f28360g = str;
    }

    public d0 p() throws UpYunException, IOException {
        if (this.f28358e) {
            throw new UpYunException("upload paused");
        }
        if (this.f28360g == null) {
            c0 c0VarF = c0.f(null, "");
            String strH = this.f28365l ? hh.c.h("") : null;
            if (!this.f28359f) {
                String strD = d();
                this.f28373t = strD;
                this.f28374u = hh.c.k("PUT", strD, this.f28361h, this.f28367n, this.f28368o, strH).trim();
            }
            b0.a aVarS = new b0.a().B(this.f28370q).n(HttpHeaders.DATE, this.f28373t).n("Authorization", this.f28374u).n(D, "initiate").n(E, DfuBaseService.MIME_TYPE_OCTET_STREAM).n(F, this.f28363j.length() + "").n("User-Agent", hh.c.f31296b).s(c0VarF);
            Map<String, String> map = this.f28357d;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    aVarS.n(entry.getKey(), entry.getValue());
                }
            }
            if (strH != null) {
                aVarS.n("Content-MD5", strH);
            }
            a(aVarS.b(), 1);
        }
        if (this.f28364k == null) {
            this.f28364k = new RandomAccessFile(this.f28363j, SsManifestParser.e.J);
        }
        return i();
    }

    public abstract d0 q(File file, String str, String str2, String str3, Map<String, String> map) throws ExecutionException, InterruptedException, UpYunException, IOException;

    public abstract d0 r(File file, String str, Map<String, String> map) throws UpYunException, IOException;

    public void s(File file, String str, String str2, String str3, Map<String, String> map, gh.b bVar) {
        this.f28356c.execute(new f(new e(bVar), file, str, str2, str3, map));
    }

    public void t(File file, String str, Map<String, String> map, gh.b bVar) {
        this.f28356c.execute(new d(new c(bVar), file, str, map));
    }

    public void u(File file, String str, Map<String, String> map, Map<String, Object> map2, gh.b bVar) {
        if (map2 == null) {
            t(file, str, map, bVar);
        } else {
            this.f28356c.execute(new b(file, str, map, map2, new C0331a(bVar)));
        }
    }

    public a() {
    }
}
