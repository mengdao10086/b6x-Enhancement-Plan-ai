package dd;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.m;
import hd.o0;
import id.l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements l, jd.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SurfaceTexture f26201j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public byte[] f26204m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f26192a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f26193b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f26194c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jd.c f26195d = new jd.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0<Long> f26196e = new o0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0<jd.d> f26197f = new o0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f26198g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f26199h = new float[16];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f26202k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26203l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f26192a.set(true);
    }

    @Override // jd.a
    public void a(long j10, float[] fArr) {
        this.f26195d.e(j10, fArr);
    }

    @Override // jd.a
    public void b() {
        this.f26196e.c();
        this.f26195d.d();
        this.f26193b.set(true);
    }

    @Override // id.l
    public void c(long j10, long j11, Format format, @p0 MediaFormat mediaFormat) {
        this.f26196e.a(j11, Long.valueOf(j10));
        i(format.f16709v, format.f16710w, j11);
    }

    public void e(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        m.c();
        if (this.f26192a.compareAndSet(true, false)) {
            ((SurfaceTexture) hd.a.g(this.f26201j)).updateTexImage();
            m.c();
            if (this.f26193b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f26198g, 0);
            }
            long timestamp = this.f26201j.getTimestamp();
            Long lG = this.f26196e.g(timestamp);
            if (lG != null) {
                this.f26195d.c(this.f26198g, lG.longValue());
            }
            jd.d dVarJ = this.f26197f.j(timestamp);
            if (dVarJ != null) {
                this.f26194c.d(dVarJ);
            }
        }
        Matrix.multiplyMM(this.f26199h, 0, fArr, 0, this.f26198g, 0);
        this.f26194c.a(this.f26200i, this.f26199h, z10);
    }

    public SurfaceTexture f() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        m.c();
        this.f26194c.b();
        m.c();
        this.f26200i = m.h();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f26200i);
        this.f26201j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: dd.c
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f26191a.g(surfaceTexture2);
            }
        });
        return this.f26201j;
    }

    public void h(int i10) {
        this.f26202k = i10;
    }

    public final void i(@p0 byte[] bArr, int i10, long j10) {
        byte[] bArr2 = this.f26204m;
        int i11 = this.f26203l;
        this.f26204m = bArr;
        if (i10 == -1) {
            i10 = this.f26202k;
        }
        this.f26203l = i10;
        if (i11 == i10 && Arrays.equals(bArr2, this.f26204m)) {
            return;
        }
        byte[] bArr3 = this.f26204m;
        jd.d dVarA = bArr3 != null ? jd.e.a(bArr3, this.f26203l) : null;
        if (dVarA == null || !b.c(dVarA)) {
            dVarA = jd.d.b(this.f26203l);
        }
        this.f26197f.a(j10, dVarA);
    }

    public void j() {
        this.f26194c.e();
    }
}
