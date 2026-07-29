package top.zibin.luban;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import hd.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class e implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f51531i = "Luban";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f51532j = "luban_disk_cache";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f51533k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f51534l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f51535m = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f51539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f51540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public top.zibin.luban.b f51541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<d> f51542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f51543h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f51544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f51545b;

        public a(Context context, d dVar) {
            this.f51544a = context;
            this.f51545b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f51543h.sendMessage(e.this.f51543h.obtainMessage(1));
                e.this.f51543h.sendMessage(e.this.f51543h.obtainMessage(0, e.this.f(this.f51544a, this.f51545b)));
            } catch (IOException e10) {
                e.this.f51543h.sendMessage(e.this.f51543h.obtainMessage(2, e10));
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f51547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f51548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51549c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public g f51551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f f51552f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public top.zibin.luban.b f51553g;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51550d = 100;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<top.zibin.luban.d> f51554h = new ArrayList();

        public class a implements top.zibin.luban.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ File f51555a;

            public a(File file) {
                this.f51555a = file;
            }

            @Override // top.zibin.luban.d
            public String getPath() {
                return this.f51555a.getAbsolutePath();
            }

            @Override // top.zibin.luban.d
            public InputStream open() throws IOException {
                return new FileInputStream(this.f51555a);
            }
        }

        /* JADX INFO: renamed from: top.zibin.luban.e$b$b, reason: collision with other inner class name */
        public class C0585b implements top.zibin.luban.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f51557a;

            public C0585b(String str) {
                this.f51557a = str;
            }

            @Override // top.zibin.luban.d
            public String getPath() {
                return this.f51557a;
            }

            @Override // top.zibin.luban.d
            public InputStream open() throws IOException {
                return new FileInputStream(this.f51557a);
            }
        }

        public class c implements top.zibin.luban.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Uri f51559a;

            public c(Uri uri) {
                this.f51559a = uri;
            }

            @Override // top.zibin.luban.d
            public String getPath() {
                return this.f51559a.getPath();
            }

            @Override // top.zibin.luban.d
            public InputStream open() throws IOException {
                return b.this.f51547a.getContentResolver().openInputStream(this.f51559a);
            }
        }

        public class d implements top.zibin.luban.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f51561a;

            public d(String str) {
                this.f51561a = str;
            }

            @Override // top.zibin.luban.d
            public String getPath() {
                return this.f51561a;
            }

            @Override // top.zibin.luban.d
            public InputStream open() throws IOException {
                return new FileInputStream(this.f51561a);
            }
        }

        public b(Context context) {
            this.f51547a = context;
        }

        public final e h() {
            return new e(this, null);
        }

        public b i(top.zibin.luban.b bVar) {
            this.f51553g = bVar;
            return this;
        }

        public File j(String str) throws IOException {
            return h().g(new d(str), this.f51547a);
        }

        public List<File> k() throws IOException {
            return h().h(this.f51547a);
        }

        public b l(int i10) {
            this.f51550d = i10;
            return this;
        }

        public void m() {
            h().m(this.f51547a);
        }

        public b n(Uri uri) {
            this.f51554h.add(new c(uri));
            return this;
        }

        public b o(File file) {
            this.f51554h.add(new a(file));
            return this;
        }

        public b p(String str) {
            this.f51554h.add(new C0585b(str));
            return this;
        }

        public <T> b q(List<T> list) {
            for (T t10 : list) {
                if (t10 instanceof String) {
                    p((String) t10);
                } else if (t10 instanceof File) {
                    o((File) t10);
                } else {
                    if (!(t10 instanceof Uri)) {
                        throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                    }
                    n((Uri) t10);
                }
            }
            return this;
        }

        public b r(top.zibin.luban.d dVar) {
            this.f51554h.add(dVar);
            return this;
        }

        public b s(int i10) {
            return this;
        }

        public b t(f fVar) {
            this.f51552f = fVar;
            return this;
        }

        public b u(boolean z10) {
            this.f51549c = z10;
            return this;
        }

        public b v(g gVar) {
            this.f51551e = gVar;
            return this;
        }

        public b w(String str) {
            this.f51548b = str;
            return this;
        }
    }

    public /* synthetic */ e(b bVar, a aVar) {
        this(bVar);
    }

    public static File j(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        File file = new File(externalCacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public static b n(Context context) {
        return new b(context);
    }

    public final File f(Context context, d dVar) throws IOException {
        Checker checker = Checker.SINGLE;
        File fileK = k(context, checker.extSuffix(dVar));
        g gVar = this.f51539d;
        if (gVar != null) {
            fileK = l(context, gVar.a(dVar.getPath()));
        }
        top.zibin.luban.b bVar = this.f51541f;
        return bVar != null ? (bVar.a(dVar.getPath()) && checker.needCompress(this.f51538c, dVar.getPath())) ? new c(dVar, fileK, this.f51537b).a() : new File(dVar.getPath()) : checker.needCompress(this.f51538c, dVar.getPath()) ? new c(dVar, fileK, this.f51537b).a() : new File(dVar.getPath());
    }

    public final File g(d dVar, Context context) throws IOException {
        return new c(dVar, k(context, Checker.SINGLE.extSuffix(dVar)), this.f51537b).a();
    }

    public final List<File> h(Context context) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator<d> it2 = this.f51542g.iterator();
        while (it2.hasNext()) {
            arrayList.add(f(context, it2.next()));
            it2.remove();
        }
        return arrayList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        f fVar = this.f51540e;
        if (fVar == null) {
            return false;
        }
        int i10 = message.what;
        if (i10 == 0) {
            fVar.a((File) message.obj);
        } else if (i10 == 1) {
            fVar.b();
        } else if (i10 == 2) {
            fVar.onError((Throwable) message.obj);
        }
        return false;
    }

    public final File i(Context context) {
        return j(context, f51532j);
    }

    public final File k(Context context, String str) {
        if (TextUtils.isEmpty(this.f51536a)) {
            this.f51536a = i(context).getAbsolutePath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f51536a);
        sb2.append(fh.a.f28350w);
        sb2.append(System.currentTimeMillis());
        sb2.append((int) (Math.random() * 1000.0d));
        if (TextUtils.isEmpty(str)) {
            str = k.S;
        }
        sb2.append(str);
        return new File(sb2.toString());
    }

    public final File l(Context context, String str) {
        if (TextUtils.isEmpty(this.f51536a)) {
            this.f51536a = i(context).getAbsolutePath();
        }
        return new File(this.f51536a + fh.a.f28350w + str);
    }

    public final void m(Context context) {
        List<d> list = this.f51542g;
        if (list == null || (list.size() == 0 && this.f51540e != null)) {
            this.f51540e.onError(new NullPointerException("image file cannot be null"));
        }
        Iterator<d> it2 = this.f51542g.iterator();
        while (it2.hasNext()) {
            AsyncTask.SERIAL_EXECUTOR.execute(new a(context, it2.next()));
            it2.remove();
        }
    }

    public e(b bVar) {
        this.f51536a = bVar.f51548b;
        this.f51539d = bVar.f51551e;
        this.f51542g = bVar.f51554h;
        this.f51540e = bVar.f51552f;
        this.f51538c = bVar.f51550d;
        this.f51541f = bVar.f51553g;
        this.f51543h = new Handler(Looper.getMainLooper(), this);
    }
}
