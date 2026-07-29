package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.i;
import g.n0;
import g.p0;
import g.v0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final AssetManager f6430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Executor f6431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final i.d f6432c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final File f6434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final String f6435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final String f6436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final String f6437h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public d[] f6439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public byte[] f6440k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6438i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final byte[] f6433d = d();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public c(@n0 AssetManager assetManager, @n0 Executor executor, @n0 i.d dVar, @n0 String str, @n0 String str2, @n0 String str3, @n0 File file) {
        this.f6430a = assetManager;
        this.f6431b = executor;
        this.f6432c = dVar;
        this.f6435f = str;
        this.f6436g = str2;
        this.f6437h = str3;
        this.f6434e = file;
    }

    @p0
    public static byte[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 33) {
            return null;
        }
        switch (i10) {
            case 24:
            case 25:
                return p.f6529e;
            case 26:
                return p.f6528d;
            case 27:
                return p.f6527c;
            case 28:
            case 29:
            case 30:
                return p.f6526b;
            case 31:
            case 32:
            case 33:
                return p.f6525a;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i10, Object obj) {
        this.f6432c.b(i10, obj);
    }

    public static boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 33) {
            return false;
        }
        if (i10 != 24 && i10 != 25) {
            switch (i10) {
                case 31:
                case 32:
                case 33:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    @p0
    public final c b(d[] dVarArr, byte[] bArr) {
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.f6430a, this.f6437h);
        } catch (FileNotFoundException e10) {
            this.f6432c.b(9, e10);
        } catch (IOException e11) {
            this.f6432c.b(7, e11);
        } catch (IllegalStateException e12) {
            this.f6439j = null;
            this.f6432c.b(8, e12);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.f6439j = n.q(inputStreamH, n.o(inputStreamH, n.f6499g), bArr, dVarArr);
            inputStreamH.close();
            return this;
        } catch (Throwable th2) {
            try {
                inputStreamH.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void c() {
        if (!this.f6438i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e() {
        if (this.f6433d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f6434e.canWrite()) {
            this.f6438i = true;
            return true;
        }
        l(4, null);
        return false;
    }

    @p0
    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f6436g);
        } catch (FileNotFoundException e10) {
            this.f6432c.b(6, e10);
            return null;
        } catch (IOException e11) {
            this.f6432c.b(7, e11);
            return null;
        }
    }

    @p0
    public final InputStream h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f6432c.a(5, null);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public c i() {
        c cVarB;
        c();
        if (this.f6433d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f6430a);
        if (inputStreamF != null) {
            this.f6439j = j(inputStreamF);
        }
        d[] dVarArr = this.f6439j;
        return (dVarArr == null || !k() || (cVarB = b(dVarArr, this.f6433d)) == null) ? this : cVarB;
    }

    @p0
    public final d[] j(InputStream inputStream) {
        try {
        } catch (IOException e10) {
            this.f6432c.b(7, e10);
        }
        try {
            try {
                d[] dVarArrW = n.w(inputStream, n.o(inputStream, n.f6498f), this.f6435f);
                try {
                    inputStream.close();
                    return dVarArrW;
                } catch (IOException e11) {
                    this.f6432c.b(7, e11);
                    return dVarArrW;
                }
            } catch (Throwable th2) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    this.f6432c.b(7, e12);
                }
                throw th2;
            }
        } catch (IOException e13) {
            this.f6432c.b(7, e13);
            inputStream.close();
            return null;
        } catch (IllegalStateException e14) {
            this.f6432c.b(8, e14);
            inputStream.close();
            return null;
        }
    }

    public final void l(final int i10, @p0 final Object obj) {
        this.f6431b.execute(new Runnable() { // from class: androidx.profileinstaller.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f6427a.g(i10, obj);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public c m() {
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f6439j;
        byte[] bArr = this.f6433d;
        if (dVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    n.E(byteArrayOutputStream, bArr);
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (IOException e10) {
                this.f6432c.b(7, e10);
            } catch (IllegalStateException e11) {
                this.f6432c.b(8, e11);
            }
            if (!n.B(byteArrayOutputStream, bArr, dVarArr)) {
                this.f6432c.b(5, null);
                this.f6439j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f6440k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f6439j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean n() {
        byte[] bArr = this.f6440k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f6434e);
                    try {
                        e.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } finally {
                this.f6440k = null;
                this.f6439j = null;
            }
        } catch (FileNotFoundException e10) {
            l(6, e10);
            return false;
        } catch (IOException e11) {
            l(7, e11);
            return false;
        }
    }
}
