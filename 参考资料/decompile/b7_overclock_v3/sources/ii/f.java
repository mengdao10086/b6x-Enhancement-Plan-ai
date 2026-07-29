package ii;

import io.objectbox.BoxStore;
import io.objectbox.EntityInfo;
import io.objectbox.exception.DbException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f32396x = "objectbox";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f32397y = 1048576;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f32398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f32399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f32400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f32402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Object f32403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Object f32404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mi.b f32405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f32408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f32410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f32411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f32412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f32413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f32414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f32415r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public short f32416s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f32417t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public l<?> f32418u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<EntityInfo<?>> f32419v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h<InputStream> f32420w;

    public f() {
        this.f32402e = 1048576L;
        this.f32419v = new ArrayList();
        this.f32398a = null;
    }

    @li.c
    public static f i() {
        f fVar = new f();
        fVar.f32413p = true;
        return fVar;
    }

    public static String j(@Nullable String str) {
        return str != null ? str : f32396x;
    }

    public static File r(Object obj) {
        return new File(t(obj), f32396x);
    }

    public static File s(Object obj, @Nullable String str) {
        return new File(r(obj), j(str));
    }

    @Nonnull
    public static File t(Object obj) {
        try {
            Method method = obj.getClass().getMethod("getFilesDir", new Class[0]);
            File file = (File) method.invoke(obj, new Object[0]);
            if (file == null) {
                System.err.println("getFilesDir() returned null - retrying once...");
                file = (File) method.invoke(obj, new Object[0]);
            }
            if (file == null) {
                throw new IllegalStateException("Android files dir is null");
            }
            if (file.exists()) {
                return file;
            }
            throw new IllegalStateException("Android files dir does not exist");
        } catch (Exception e10) {
            throw new RuntimeException("Could not init with given Android context (must be sub class of android.content.Context)", e10);
        }
    }

    public static File v(@Nullable File file, @Nullable String str) {
        String strJ = j(str);
        return file != null ? new File(file, strJ) : new File(strJ);
    }

    public static /* synthetic */ InputStream y(File file) throws Exception {
        return new FileInputStream(file);
    }

    public f A(long j10) {
        this.f32402e = j10;
        return this;
    }

    public f B(mi.b bVar) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public f C(String str) {
        if (this.f32399b != null) {
            throw new IllegalArgumentException("Already has directory, cannot assign name");
        }
        if (str.contains(fh.a.f28350w) || str.contains("\\")) {
            throw new IllegalArgumentException("Name may not contain (back) slashes. Use baseDirectory() or directory() to configure alternative directories");
        }
        this.f32401d = str;
        return this;
    }

    public f D() {
        this.f32411n = true;
        return this;
    }

    @li.b
    public f E(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("Query attempts must >= 1");
        }
        this.f32412o = i10;
        return this;
    }

    public f F() {
        this.f32414q = true;
        return this;
    }

    public f G() {
        this.f32415r = true;
        return this;
    }

    public f H(short s10) {
        if (s10 < 1 || s10 > 5) {
            throw new IllegalArgumentException("Must be one of ValidateOnOpenMode");
        }
        this.f32416s = s10;
        return this;
    }

    public f I(long j10) {
        short s10 = this.f32416s;
        if (s10 != 2 && s10 != 3) {
            throw new IllegalStateException("Must call validateOnOpen(mode) with mode Regular or WithLeaves first");
        }
        if (j10 < 1) {
            throw new IllegalArgumentException("limit must be positive");
        }
        this.f32417t = j10;
        return this;
    }

    public f b(Object obj) {
        Objects.requireNonNull(obj, "Context may not be null");
        this.f32403f = u(obj);
        File fileR = r(obj);
        if (!fileR.exists()) {
            fileR.mkdir();
            if (!fileR.exists()) {
                throw new RuntimeException("Could not init Android base dir at " + fileR.getAbsolutePath());
            }
        }
        if (fileR.isDirectory()) {
            this.f32400c = fileR;
            this.f32407j = true;
            return this;
        }
        throw new RuntimeException("Android base dir is not a dir: " + fileR.getAbsolutePath());
    }

    public f c(Object obj) {
        if (this.f32403f == null) {
            throw new IllegalArgumentException("Set a Context using androidContext(context) first");
        }
        Objects.requireNonNull(obj, "ReLinkerInstance may not be null");
        this.f32404g = obj;
        return this;
    }

    public f d(File file) {
        if (this.f32399b != null) {
            throw new IllegalArgumentException("Already has directory, cannot assign base directory");
        }
        this.f32400c = file;
        return this;
    }

    public BoxStore e() throws Throwable {
        if (this.f32399b == null) {
            String strJ = j(this.f32401d);
            this.f32401d = strJ;
            this.f32399b = v(this.f32400c, strJ);
        }
        h();
        return new BoxStore(this);
    }

    public BoxStore f() throws Throwable {
        BoxStore boxStoreE = e();
        BoxStore.H2(boxStoreE);
        return boxStoreE;
    }

    public byte[] g(String str) {
        io.objectbox.flatbuffers.i iVar = new io.objectbox.flatbuffers.i();
        iVar.N(true);
        int iY = iVar.y(str);
        oi.b.l0(iVar);
        oi.b.z(iVar, iY);
        oi.b.B(iVar, this.f32402e);
        oi.b.A(iVar, this.f32409l);
        oi.b.C(iVar, this.f32410m);
        short s10 = this.f32416s;
        if (s10 != 0) {
            oi.b.K(iVar, s10);
            long j10 = this.f32417t;
            if (j10 != 0) {
                oi.b.L(iVar, j10);
            }
        }
        boolean z10 = this.f32413p;
        if (z10) {
            oi.b.H(iVar, z10);
        }
        boolean z11 = this.f32415r;
        if (z11) {
            oi.b.I(iVar, z11);
        }
        boolean z12 = this.f32414q;
        if (z12) {
            oi.b.G(iVar, z12);
        }
        boolean z13 = this.f32411n;
        if (z13) {
            oi.b.E(iVar, z13);
        }
        int i10 = this.f32406i;
        if (i10 != 0) {
            oi.b.y(iVar, i10);
        }
        iVar.G(oi.b.T(iVar));
        return iVar.d0();
    }

    public final void h() throws Throwable {
        InputStream inputStreamA;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        Exception e10;
        if (this.f32420w == null) {
            return;
        }
        File file = new File(BoxStore.d1(this.f32399b), "data.mdb");
        if (file.exists()) {
            return;
        }
        try {
            inputStreamA = this.f32420w.a();
            try {
                if (inputStreamA == null) {
                    throw new DbException("Factory did not provide a resource");
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamA);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        st.c.a(bufferedInputStream, bufferedOutputStream2);
                        st.c.j(bufferedOutputStream2);
                        st.c.j(bufferedInputStream);
                    } catch (Exception e11) {
                        e10 = e11;
                        bufferedOutputStream = bufferedOutputStream2;
                        inputStreamA = bufferedInputStream;
                        try {
                            throw new DbException("Could not provision initial data file", e10);
                        } catch (Throwable th3) {
                            th2 = th3;
                            st.c.j(bufferedOutputStream);
                            st.c.j(inputStreamA);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        bufferedOutputStream = bufferedOutputStream2;
                        inputStreamA = bufferedInputStream;
                        st.c.j(bufferedOutputStream);
                        st.c.j(inputStreamA);
                        throw th2;
                    }
                } catch (Exception e12) {
                    e = e12;
                    inputStreamA = bufferedInputStream;
                    Exception exc = e;
                    bufferedOutputStream = null;
                    e10 = exc;
                    throw new DbException("Could not provision initial data file", e10);
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamA = bufferedInputStream;
                    Throwable th6 = th;
                    bufferedOutputStream = null;
                    th2 = th6;
                    st.c.j(bufferedOutputStream);
                    st.c.j(inputStreamA);
                    throw th2;
                }
            } catch (Exception e13) {
                e = e13;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e14) {
            inputStreamA = null;
            e10 = e14;
            bufferedOutputStream = null;
        } catch (Throwable th8) {
            inputStreamA = null;
            th2 = th8;
            bufferedOutputStream = null;
        }
    }

    public f k(int i10) {
        this.f32406i = i10;
        return this;
    }

    public f l() {
        this.f32408k = true;
        return this;
    }

    @Deprecated
    public f m() {
        this.f32406i |= 3;
        return this;
    }

    public f n(File file) {
        if (this.f32401d != null) {
            throw new IllegalArgumentException("Already has name, cannot assign directory");
        }
        if (!this.f32407j && this.f32400c != null) {
            throw new IllegalArgumentException("Already has base directory, cannot assign directory");
        }
        this.f32399b = file;
        return this;
    }

    @li.c
    public void o(EntityInfo<?> entityInfo) {
        this.f32419v.add(entityInfo);
    }

    @li.b
    public f p(l<?> lVar) {
        this.f32418u = lVar;
        return this;
    }

    public f q(int i10) {
        this.f32409l = i10;
        return this;
    }

    public final Object u(Object obj) {
        try {
            return obj.getClass().getMethod("getApplicationContext", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException("context must be a valid Android Context", e10);
        }
    }

    @li.b
    public f w(h<InputStream> hVar) {
        this.f32420w = hVar;
        return this;
    }

    @li.b
    public f x(final File file) {
        return w(new h() { // from class: ii.e
            @Override // ii.h
            public final Object a() {
                return f.y(file);
            }
        });
    }

    public f z(int i10) {
        this.f32410m = i10;
        return this;
    }

    @li.c
    public f(byte[] bArr) {
        this.f32402e = 1048576L;
        this.f32419v = new ArrayList();
        if (bArr != null) {
            this.f32398a = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        throw new IllegalArgumentException("Model may not be null");
    }
}
