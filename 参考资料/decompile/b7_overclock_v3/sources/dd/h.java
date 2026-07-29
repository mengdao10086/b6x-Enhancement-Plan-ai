package dd;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import com.umeng.analytics.pro.an;
import dd.a;
import dd.i;
import g.h1;
import g.i1;
import g.p0;
import hd.u0;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import ya.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends GLSurfaceView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f26208m = 90;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f26209n = 0.1f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f26210o = 100.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f26211p = 25.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f26212q = 3.1415927f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f26213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final Sensor f26214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dd.a f26215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f26216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f26217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f26218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public SurfaceTexture f26219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Surface f26220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public j1.p f26221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f26222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f26223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f26224l;

    @i1
    public class a implements GLSurfaceView.Renderer, i.a, a.InterfaceC0295a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f26225a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f26228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f26229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f26230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f26231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f26232h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f26226b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f26227c = new float[16];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float[] f26233i = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f26234j = new float[16];

        public a(d dVar) {
            float[] fArr = new float[16];
            this.f26228d = fArr;
            float[] fArr2 = new float[16];
            this.f26229e = fArr2;
            float[] fArr3 = new float[16];
            this.f26230f = fArr3;
            this.f26225a = dVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f26232h = 3.1415927f;
        }

        @Override // dd.a.InterfaceC0295a
        @g.g
        public synchronized void a(float[] fArr, float f10) {
            float[] fArr2 = this.f26228d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f26232h = -f10;
            d();
        }

        @Override // dd.i.a
        @h1
        public synchronized void b(PointF pointF) {
            this.f26231g = pointF.y;
            d();
            Matrix.setRotateM(this.f26230f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float c(float f10) {
            if (f10 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f10))) * 2.0d);
            }
            return 90.0f;
        }

        @g.d
        public final void d() {
            Matrix.setRotateM(this.f26229e, 0, -this.f26231g, (float) Math.cos(this.f26232h), (float) Math.sin(this.f26232h), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f26234j, 0, this.f26228d, 0, this.f26230f, 0);
                Matrix.multiplyMM(this.f26233i, 0, this.f26229e, 0, this.f26234j, 0);
            }
            Matrix.multiplyMM(this.f26227c, 0, this.f26226b, 0, this.f26233i, 0);
            this.f26225a.e(this.f26227c, false);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
            float f10 = i10 / i11;
            Matrix.perspectiveM(this.f26226b, 0, c(f10), f10, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            h.this.f(this.f26225a.f());
        }
    }

    public h(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Surface surface = this.f26220h;
        if (surface != null) {
            j1.p pVar = this.f26221i;
            if (pVar != null) {
                pVar.F(surface);
            }
            g(this.f26219g, this.f26220h);
            this.f26219g = null;
            this.f26220h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f26219g;
        Surface surface = this.f26220h;
        this.f26219g = surfaceTexture;
        Surface surface2 = new Surface(surfaceTexture);
        this.f26220h = surface2;
        j1.p pVar = this.f26221i;
        if (pVar != null) {
            pVar.q(surface2);
        }
        g(surfaceTexture2, surface);
    }

    public static void g(@p0 SurfaceTexture surfaceTexture, @p0 Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public final void f(final SurfaceTexture surfaceTexture) {
        this.f26216d.post(new Runnable() { // from class: dd.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f26206a.e(surfaceTexture);
            }
        });
    }

    public final void h() {
        boolean z10 = this.f26222j && this.f26223k;
        Sensor sensor = this.f26214b;
        if (sensor == null || z10 == this.f26224l) {
            return;
        }
        if (z10) {
            this.f26213a.registerListener(this.f26215c, sensor, 0);
        } else {
            this.f26213a.unregisterListener(this.f26215c);
        }
        this.f26224l = z10;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f26216d.post(new Runnable() { // from class: dd.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f26205a.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f26223k = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f26223k = true;
        h();
    }

    public void setDefaultStereoMode(int i10) {
        this.f26218f.h(i10);
    }

    public void setSingleTapListener(@p0 e eVar) {
        this.f26217e.b(eVar);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f26222j = z10;
        h();
    }

    public void setVideoComponent(@p0 j1.p pVar) {
        j1.p pVar2 = this.f26221i;
        if (pVar == pVar2) {
            return;
        }
        if (pVar2 != null) {
            Surface surface = this.f26220h;
            if (surface != null) {
                pVar2.F(surface);
            }
            this.f26221i.C(this.f26218f);
            this.f26221i.V0(this.f26218f);
        }
        this.f26221i = pVar;
        if (pVar != null) {
            pVar.d1(this.f26218f);
            this.f26221i.S0(this.f26218f);
            this.f26221i.q(this.f26220h);
        }
    }

    public h(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26216d = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) hd.a.g(context.getSystemService(an.f23201ac));
        this.f26213a = sensorManager;
        Sensor defaultSensor = u0.f31154a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f26214b = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        d dVar = new d();
        this.f26218f = dVar;
        a aVar = new a(dVar);
        i iVar = new i(context, aVar, 25.0f);
        this.f26217e = iVar;
        this.f26215c = new dd.a(((WindowManager) hd.a.g((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), iVar, aVar);
        this.f26222j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(iVar);
    }
}
