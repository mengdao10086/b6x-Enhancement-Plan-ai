package com.google.android.exoplayer2.audio;

import ab.u;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.Format;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import ya.h1;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16758a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16759b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16760c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f16761d = Long.MIN_VALUE;

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format format;
        public final boolean isRecoverable;

        public InitializationException(int i10, int i11, int i12, int i13, Format format, boolean z10, @p0 Exception exc) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AudioTrack init failed ");
            sb2.append(i10);
            sb2.append(i0.f11861z);
            sb2.append("Config(");
            sb2.append(i11);
            sb2.append(", ");
            sb2.append(i12);
            sb2.append(", ");
            sb2.append(i13);
            sb2.append(ee.a.f26979d);
            sb2.append(z10 ? " (recoverable)" : "");
            super(sb2.toString(), exc);
            this.audioTrackState = i10;
            this.isRecoverable = z10;
            this.format = format;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;

        public WriteException(int i10, Format format, boolean z10) {
            super("AudioTrack write failed: " + i10);
            this.isRecoverable = z10;
            this.errorCode = i10;
            this.format = format;
        }
    }

    public interface a {
        void a(boolean z10);

        void b(long j10);

        void c(int i10, long j10, long j11);

        void d(Exception exc);

        void e(long j10);

        void f();

        void g();
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    void A();

    boolean a(Format format);

    boolean b();

    void c(h1 h1Var);

    h1 e();

    void flush();

    void h(int i10);

    void i();

    void l(u uVar);

    void m(float f10);

    boolean n();

    void o(boolean z10);

    void p() throws WriteException;

    void pause();

    boolean q();

    long r(boolean z10);

    void reset();

    void s();

    void t();

    void u();

    void v(ab.d dVar);

    boolean w(ByteBuffer byteBuffer, long j10, int i10) throws WriteException, InitializationException;

    void x(a aVar);

    int y(Format format);

    void z(Format format, int i10, @p0 int[] iArr) throws ConfigurationException;

    public static final class ConfigurationException extends Exception {
        public final Format format;

        public ConfigurationException(Throwable th2, Format format) {
            super(th2);
            this.format = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.format = format;
        }
    }
}
