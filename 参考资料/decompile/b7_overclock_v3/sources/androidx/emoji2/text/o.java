package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import androidx.core.os.y;
import g.i1;
import g.n0;
import g.v0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@g.d
@v0(19)
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5577e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5578f = "EmojiCompat.MetadataRepo.create";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final androidx.emoji2.text.flatbuffer.o f5579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final char[] f5580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final a f5581c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Typeface f5582d;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f5583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f5584b;

        public a() {
            this(1);
        }

        public a a(int i10) {
            SparseArray<a> sparseArray = this.f5583a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        public final h b() {
            return this.f5584b;
        }

        public void c(@n0 h hVar, int i10, int i11) {
            a aVarA = a(hVar.b(i10));
            if (aVarA == null) {
                aVarA = new a();
                this.f5583a.put(hVar.b(i10), aVarA);
            }
            if (i11 > i10) {
                aVarA.c(hVar, i10 + 1, i11);
            } else {
                aVarA.f5584b = hVar;
            }
        }

        public a(int i10) {
            this.f5583a = new SparseArray<>(i10);
        }
    }

    public o(@n0 Typeface typeface, @n0 androidx.emoji2.text.flatbuffer.o oVar) {
        this.f5582d = typeface;
        this.f5579a = oVar;
        this.f5580b = new char[oVar.K() * 2];
        a(oVar);
    }

    @n0
    public static o b(@n0 AssetManager assetManager, @n0 String str) throws IOException {
        try {
            y.b(f5578f);
            return new o(Typeface.createFromAsset(assetManager, str), n.b(assetManager, str));
        } finally {
            y.d();
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @n0
    public static o c(@n0 Typeface typeface) {
        try {
            y.b(f5578f);
            return new o(typeface, new androidx.emoji2.text.flatbuffer.o());
        } finally {
            y.d();
        }
    }

    @n0
    public static o d(@n0 Typeface typeface, @n0 InputStream inputStream) throws IOException {
        try {
            y.b(f5578f);
            return new o(typeface, n.c(inputStream));
        } finally {
            y.d();
        }
    }

    @n0
    public static o e(@n0 Typeface typeface, @n0 ByteBuffer byteBuffer) throws IOException {
        try {
            y.b(f5578f);
            return new o(typeface, n.d(byteBuffer));
        } finally {
            y.d();
        }
    }

    public final void a(androidx.emoji2.text.flatbuffer.o oVar) {
        int iK = oVar.K();
        for (int i10 = 0; i10 < iK; i10++) {
            h hVar = new h(this, i10);
            Character.toChars(hVar.g(), this.f5580b, i10 * 2);
            k(hVar);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public char[] f() {
        return this.f5580b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public androidx.emoji2.text.flatbuffer.o g() {
        return this.f5579a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int h() {
        return this.f5579a.S();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public a i() {
        return this.f5581c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public Typeface j() {
        return this.f5582d;
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void k(@n0 h hVar) {
        androidx.core.util.o.m(hVar, "emoji metadata cannot be null");
        androidx.core.util.o.b(hVar.c() > 0, "invalid metadata codepoint length");
        this.f5581c.c(hVar, 0, hVar.c() - 1);
    }
}
