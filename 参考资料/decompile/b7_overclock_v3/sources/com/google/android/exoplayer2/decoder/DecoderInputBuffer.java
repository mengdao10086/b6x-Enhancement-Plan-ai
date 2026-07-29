package com.google.android.exoplayer2.decoder;

import eb.b;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderInputBuffer extends eb.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16956i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16957j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16958k = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f16959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public ByteBuffer f16960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f16962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public ByteBuffer f16963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16965h;

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i10, int i11) {
            super("Buffer too small (" + i10 + " < " + i11 + ee.a.f26979d);
            this.currentCapacity = i10;
            this.requiredCapacity = i11;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public DecoderInputBuffer(int i10) {
        this(i10, 0);
    }

    public static DecoderInputBuffer u() {
        return new DecoderInputBuffer(0);
    }

    @Override // eb.a
    public void h() {
        super.h();
        ByteBuffer byteBuffer = this.f16960c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f16963f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f16961d = false;
    }

    public final ByteBuffer p(int i10) {
        int i11 = this.f16964g;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f16960c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i10);
    }

    @EnsuresNonNull({"data"})
    public void q(int i10) {
        int i11 = i10 + this.f16965h;
        ByteBuffer byteBuffer = this.f16960c;
        if (byteBuffer == null) {
            this.f16960c = p(i11);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        if (iCapacity >= i12) {
            this.f16960c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferP = p(i12);
        byteBufferP.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferP.put(byteBuffer);
        }
        this.f16960c = byteBufferP;
    }

    public final void r() {
        ByteBuffer byteBuffer = this.f16960c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f16963f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean s() {
        return j(1073741824);
    }

    public final boolean t() {
        return this.f16960c == null && this.f16964g == 0;
    }

    @EnsuresNonNull({"supplementalData"})
    public void v(int i10) {
        ByteBuffer byteBuffer = this.f16963f;
        if (byteBuffer == null || byteBuffer.capacity() < i10) {
            this.f16963f = ByteBuffer.allocate(i10);
        } else {
            this.f16963f.clear();
        }
    }

    public DecoderInputBuffer(int i10, int i11) {
        this.f16959b = new b();
        this.f16964g = i10;
        this.f16965h = i11;
    }
}
