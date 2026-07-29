package v0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.l;
import g.b0;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import m0.w;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.j<String, Typeface> f52469a = new androidx.collection.j<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f52470b = i.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f52471c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0("LOCK")
    public static final l<String, ArrayList<androidx.core.util.d<e>>> f52472d = new l<>();

    public class a implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f52474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f52475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f52476d;

        public a(String str, Context context, f fVar, int i10) {
            this.f52473a = str;
            this.f52474b = context;
            this.f52475c = fVar;
            this.f52476d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return g.c(this.f52473a, this.f52474b, this.f52475c, this.f52476d);
        }
    }

    public class b implements androidx.core.util.d<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v0.a f52477a;

        public b(v0.a aVar) {
            this.f52477a = aVar;
        }

        @Override // androidx.core.util.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f52477a.b(eVar);
        }
    }

    public class c implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f52479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f52480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f52481d;

        public c(String str, Context context, f fVar, int i10) {
            this.f52478a = str;
            this.f52479b = context;
            this.f52480c = fVar;
            this.f52481d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return g.c(this.f52478a, this.f52479b, this.f52480c, this.f52481d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements androidx.core.util.d<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52482a;

        public d(String str) {
            this.f52482a = str;
        }

        @Override // androidx.core.util.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (g.f52471c) {
                l<String, ArrayList<androidx.core.util.d<e>>> lVar = g.f52472d;
                ArrayList<androidx.core.util.d<e>> arrayList = lVar.get(this.f52482a);
                if (arrayList == null) {
                    return;
                }
                lVar.remove(this.f52482a);
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    arrayList.get(i10).accept(eVar);
                }
            }
        }
    }

    public static String a(@n0 f fVar, int i10) {
        return fVar.d() + "-" + i10;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@n0 h.b bVar) {
        int i10 = 1;
        if (bVar.c() != 0) {
            return bVar.c() != 1 ? -3 : -2;
        }
        h.c[] cVarArrB = bVar.b();
        if (cVarArrB != null && cVarArrB.length != 0) {
            i10 = 0;
            for (h.c cVar : cVarArrB) {
                int iB = cVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i10;
    }

    @n0
    public static e c(@n0 String str, @n0 Context context, @n0 f fVar, int i10) {
        androidx.collection.j<String, Typeface> jVar = f52469a;
        Typeface typefaceF = jVar.f(str);
        if (typefaceF != null) {
            return new e(typefaceF);
        }
        try {
            h.b bVarE = v0.e.e(context, fVar, null);
            int iB = b(bVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceD = w.d(context, null, bVarE.b(), i10);
            if (typefaceD == null) {
                return new e(-3);
            }
            jVar.j(str, typefaceD);
            return new e(typefaceD);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    public static Typeface d(@n0 Context context, @n0 f fVar, int i10, @p0 Executor executor, @n0 v0.a aVar) {
        String strA = a(fVar, i10);
        Typeface typefaceF = f52469a.f(strA);
        if (typefaceF != null) {
            aVar.b(new e(typefaceF));
            return typefaceF;
        }
        b bVar = new b(aVar);
        synchronized (f52471c) {
            l<String, ArrayList<androidx.core.util.d<e>>> lVar = f52472d;
            ArrayList<androidx.core.util.d<e>> arrayList = lVar.get(strA);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<androidx.core.util.d<e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            lVar.put(strA, arrayList2);
            c cVar = new c(strA, context, fVar, i10);
            if (executor == null) {
                executor = f52470b;
            }
            i.c(executor, cVar, new d(strA));
            return null;
        }
    }

    public static Typeface e(@n0 Context context, @n0 f fVar, @n0 v0.a aVar, int i10, int i11) {
        String strA = a(fVar, i10);
        Typeface typefaceF = f52469a.f(strA);
        if (typefaceF != null) {
            aVar.b(new e(typefaceF));
            return typefaceF;
        }
        if (i11 == -1) {
            e eVarC = c(strA, context, fVar, i10);
            aVar.b(eVarC);
            return eVarC.f52483a;
        }
        try {
            e eVar = (e) i.d(f52470b, new a(strA, context, fVar, i10), i11);
            aVar.b(eVar);
            return eVar.f52483a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    public static void f() {
        f52469a.d();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f52483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52484b;

        public e(int i10) {
            this.f52483a = null;
            this.f52484b = i10;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f52484b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public e(@n0 Typeface typeface) {
            this.f52483a = typeface;
            this.f52484b = 0;
        }
    }
}
