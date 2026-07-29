package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import g.p0;
import g.v0;
import hd.m;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@v0(17)
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19282h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f19283i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f19284j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f19285k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19286l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f19287m = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19288n = 12992;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f19289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f19290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final c f19291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public EGLDisplay f19292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public EGLContext f19293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public EGLSurface f19294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public SurfaceTexture f19295g;

    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void a();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
    }

    public static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f19287m, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!zEglChooseConfig || iArr[0] <= 0 || eGLConfigArr[0] == null) {
            throw new GlException(u0.I("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        }
        return eGLConfigArr[0];
    }

    public static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10) {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i10 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, f19288n, 1, 12344}, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new GlException("eglCreateContext failed");
    }

    public static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i10) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i10 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i10 == 2 ? new int[]{12375, 1, 12374, 1, f19288n, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new GlException("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new GlException("eglMakeCurrent failed");
    }

    public static void e(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        m.c();
    }

    public static EGLDisplay f() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new GlException("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new GlException("eglInitialize failed");
    }

    public final void d() {
        c cVar = this.f19291c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) hd.a.g(this.f19295g);
    }

    public void h(int i10) {
        EGLDisplay eGLDisplayF = f();
        this.f19292d = eGLDisplayF;
        EGLConfig eGLConfigA = a(eGLDisplayF);
        EGLContext eGLContextB = b(this.f19292d, eGLConfigA, i10);
        this.f19293e = eGLContextB;
        this.f19294f = c(this.f19292d, eGLConfigA, eGLContextB, i10);
        e(this.f19290b);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f19290b[0]);
        this.f19295g = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f19289a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f19295g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f19290b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f19292d;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f19292d;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f19294f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f19292d, this.f19294f);
            }
            EGLContext eGLContext = this.f19293e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f19292d, eGLContext);
            }
            if (u0.f31154a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f19292d;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f19292d);
            }
            this.f19292d = null;
            this.f19293e = null;
            this.f19294f = null;
            this.f19295g = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f19289a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f19295g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @p0 c cVar) {
        this.f19289a = handler;
        this.f19291c = cVar;
        this.f19290b = new int[1];
    }
}
