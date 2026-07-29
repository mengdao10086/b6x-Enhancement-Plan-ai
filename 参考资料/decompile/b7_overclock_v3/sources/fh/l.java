package fh;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.d0;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static l f28489c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f28490a = Executors.newFixedThreadPool(j.f28480b);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f28491b = new k();

    public class a implements gh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.c f28492a;

        /* JADX INFO: renamed from: fh.l$a$a, reason: collision with other inner class name */
        public class RunnableC0335a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f28494a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f28495b;

            public RunnableC0335a(long j10, long j11) {
                this.f28494a = j10;
                this.f28495b = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                gh.c cVar = a.this.f28492a;
                if (cVar != null) {
                    cVar.a(this.f28494a, this.f28495b);
                }
            }
        }

        public a(gh.c cVar) {
            this.f28492a = cVar;
        }

        @Override // gh.c
        public void a(long j10, long j11) {
            hh.a.a(new RunnableC0335a(j10, j11));
        }
    }

    public class b implements gh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28497a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f28499a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f28500b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f28501c;

            public a(boolean z10, d0 d0Var, Exception exc) {
                this.f28499a = z10;
                this.f28500b = d0Var;
                this.f28501c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f28497a.a(this.f28499a, this.f28500b, this.f28501c);
            }
        }

        public b(gh.b bVar) {
            this.f28497a = bVar;
        }

        @Override // gh.b
        public void a(boolean z10, d0 d0Var, Exception exc) {
            hh.a.a(new a(z10, d0Var, exc));
        }
    }

    public class c implements gh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.c f28503a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f28505a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f28506b;

            public a(long j10, long j11) {
                this.f28505a = j10;
                this.f28506b = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                gh.c cVar = c.this.f28503a;
                if (cVar != null) {
                    cVar.a(this.f28505a, this.f28506b);
                }
            }
        }

        public c(gh.c cVar) {
            this.f28503a = cVar;
        }

        @Override // gh.c
        public void a(long j10, long j11) {
            hh.a.a(new a(j10, j11));
        }
    }

    public class d implements gh.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gh.b f28508a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f28510a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d0 f28511b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f28512c;

            public a(boolean z10, d0 d0Var, Exception exc) {
                this.f28510a = z10;
                this.f28511b = d0Var;
                this.f28512c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f28508a.a(this.f28510a, this.f28511b, this.f28512c);
            }
        }

        public d(gh.b bVar) {
            this.f28508a = bVar;
        }

        @Override // gh.b
        public void a(boolean z10, d0 d0Var, Exception exc) {
            hh.a.a(new a(z10, d0Var, exc));
        }
    }

    public static l c() {
        if (f28489c == null) {
            synchronized (l.class) {
                if (f28489c == null) {
                    f28489c = new l();
                }
            }
        }
        return f28489c;
    }

    public void a(File file, String str, String str2, String str3, gh.b bVar, gh.c cVar) {
        c cVar2 = new c(cVar);
        this.f28490a.execute(new fh.b(this.f28491b, file, str, str2, str3, new d(bVar), cVar2));
    }

    public void b(File file, Map<String, Object> map, String str, String str2, gh.b bVar, gh.c cVar) {
        if (map.get(e.f28444a) == null) {
            map.put(e.f28444a, j.f28487i);
        }
        if (map.get("expiration") == null) {
            map.put("expiration", Long.valueOf((System.currentTimeMillis() / 1000) + j.f28481c));
        }
        a aVar = new a(cVar);
        b bVar2 = new b(bVar);
        this.f28490a.execute(new fh.b(this.f28491b, file, new HashMap(map), str, str2, bVar2, aVar));
    }
}
