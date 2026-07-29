package hb;

import android.net.Uri;
import g.p0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rb.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f30875m = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public static final Constructor<? extends k> f30876n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f30877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f30880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f30881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f30882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f30883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f30884i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f30886k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f30885j = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f30887l = h0.B;

    static {
        Constructor<? extends k> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(k.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e10) {
            throw new RuntimeException("Error instantiating FLAC extension", e10);
        }
        f30876n = constructor;
    }

    @Override // hb.q
    public synchronized k[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // hb.q
    public synchronized k[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iB = hd.k.b(map);
        if (iB != -1) {
            c(iB, arrayList);
        }
        int iC = hd.k.c(uri);
        if (iC != -1 && iC != iB) {
            c(iC, arrayList);
        }
        for (int i10 : f30875m) {
            if (i10 != iB && i10 != iC) {
                c(i10, arrayList);
            }
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public final void c(int i10, List<k> list) {
        switch (i10) {
            case 0:
                list.add(new rb.b());
                return;
            case 1:
                list.add(new rb.e());
                return;
            case 2:
                list.add(new rb.h(this.f30878c | (this.f30877b ? 1 : 0)));
                return;
            case 3:
                list.add(new ib.b(this.f30879d | (this.f30877b ? 1 : 0)));
                return;
            case 4:
                Constructor<? extends k> constructor = f30876n;
                if (constructor == null) {
                    list.add(new jb.d(this.f30880e));
                    return;
                }
                try {
                    list.add(constructor.newInstance(Integer.valueOf(this.f30880e)));
                    return;
                } catch (Exception e10) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e10);
                }
            case 5:
                list.add(new kb.b());
                return;
            case 6:
                list.add(new mb.e(this.f30881f));
                return;
            case 7:
                list.add(new nb.f(this.f30884i | (this.f30877b ? 1 : 0)));
                return;
            case 8:
                list.add(new ob.g(this.f30883h));
                list.add(new ob.k(this.f30882g));
                return;
            case 9:
                list.add(new pb.d());
                return;
            case 10:
                list.add(new rb.a0());
                return;
            case 11:
                list.add(new h0(this.f30885j, this.f30886k, this.f30887l));
                return;
            case 12:
                list.add(new sb.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new lb.a());
                return;
        }
    }

    public synchronized h d(int i10) {
        this.f30878c = i10;
        return this;
    }

    public synchronized h e(int i10) {
        this.f30879d = i10;
        return this;
    }

    public synchronized h f(boolean z10) {
        this.f30877b = z10;
        return this;
    }

    public synchronized h g(int i10) {
        this.f30880e = i10;
        return this;
    }

    public synchronized h h(int i10) {
        this.f30883h = i10;
        return this;
    }

    public synchronized h i(int i10) {
        this.f30881f = i10;
        return this;
    }

    public synchronized h j(int i10) {
        this.f30884i = i10;
        return this;
    }

    public synchronized h k(int i10) {
        this.f30882g = i10;
        return this;
    }

    public synchronized h l(int i10) {
        this.f30886k = i10;
        return this;
    }

    public synchronized h m(int i10) {
        this.f30885j = i10;
        return this;
    }

    public synchronized h n(int i10) {
        this.f30887l = i10;
        return this;
    }
}
