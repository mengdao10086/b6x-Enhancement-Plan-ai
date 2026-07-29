package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import g.p0;
import gb.s;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17060a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17061b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17062c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17063d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17064e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f17065f = 3;

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f17066a;

        public a(f fVar) {
            this.f17066a = fVar;
        }

        @Override // com.google.android.exoplayer2.drm.f.g
        public f a(UUID uuid) {
            this.f17066a.a();
            return this.f17066a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f17067d = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f17068e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f17069f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f17070g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f17071h = 3;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f17072i = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f17073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17075c;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public b(byte[] bArr, String str) {
            this(bArr, str, Integer.MIN_VALUE);
        }

        public byte[] a() {
            return this.f17073a;
        }

        public String b() {
            return this.f17074b;
        }

        public int c() {
            return this.f17075c;
        }

        public b(byte[] bArr, String str, int i10) {
            this.f17073a = bArr;
            this.f17074b = str;
            this.f17075c = i10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f17077b;

        public c(int i10, byte[] bArr) {
            this.f17076a = i10;
            this.f17077b = bArr;
        }

        public byte[] a() {
            return this.f17077b;
        }

        public int b() {
            return this.f17076a;
        }
    }

    public interface d {
        void a(f fVar, @p0 byte[] bArr, int i10, int i11, @p0 byte[] bArr2);
    }

    public interface e {
        void a(f fVar, byte[] bArr, long j10);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.f$f, reason: collision with other inner class name */
    public interface InterfaceC0177f {
        void a(f fVar, byte[] bArr, List<c> list, boolean z10);
    }

    public interface g {
        f a(UUID uuid);
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f17078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17079b;

        public h(byte[] bArr, String str) {
            this.f17078a = bArr;
            this.f17079b = str;
        }

        public byte[] a() {
            return this.f17078a;
        }

        public String b() {
            return this.f17079b;
        }
    }

    void a();

    Class<? extends s> b();

    Map<String, String> c(byte[] bArr);

    void d(String str, byte[] bArr);

    String e(String str);

    s f(byte[] bArr) throws MediaCryptoException;

    h g();

    void h(@p0 e eVar);

    byte[] i() throws MediaDrmException;

    void j(byte[] bArr, byte[] bArr2);

    void k(String str, String str2);

    void l(byte[] bArr);

    byte[] m(String str);

    void n(@p0 d dVar);

    @p0
    byte[] o(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    @p0
    PersistableBundle p();

    void q(byte[] bArr) throws DeniedByServerException;

    b r(byte[] bArr, @p0 List<DrmInitData.SchemeData> list, int i10, @p0 HashMap<String, String> map) throws NotProvisionedException;

    void release();

    void s(@p0 InterfaceC0177f interfaceC0177f);
}
