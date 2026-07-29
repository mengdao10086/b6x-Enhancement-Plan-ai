package com.google.android.exoplayer2.audio;

import hd.u0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f16752a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f16753e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f16756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f16757d;

        public a(int i10, int i11, int i12) {
            this.f16754a = i10;
            this.f16755b = i11;
            this.f16756c = i12;
            this.f16757d = u0.E0(i12) ? u0.m0(i12, i11) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f16754a + ", channelCount=" + this.f16755b + ", encoding=" + this.f16756c + ']';
        }
    }

    boolean b();

    ByteBuffer c();

    void d(ByteBuffer byteBuffer);

    a e(a aVar) throws UnhandledAudioFormatException;

    void f();

    void flush();

    boolean isActive();

    void reset();
}
