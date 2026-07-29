package id;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class g implements GLSurfaceView.Renderer, k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f32214n = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f32216p = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GLSurfaceView f32218a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32222e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32224g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f32227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f32211k = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f32212l = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f32213m = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f32215o = {"y_tex", "u_tex", "v_tex"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final FloatBuffer f32217q = hd.m.g(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f32219b = new int[3];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<j> f32220c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer[] f32221d = new FloatBuffer[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f32223f = new int[3];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f32225h = new int[3];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f32226i = new int[3];

    public g(GLSurfaceView gLSurfaceView) {
        this.f32218a = gLSurfaceView;
        for (int i10 = 0; i10 < 3; i10++) {
            int[] iArr = this.f32225h;
            this.f32226i[i10] = -1;
            iArr[i10] = -1;
        }
    }

    @Override // id.k
    public void a(j jVar) {
        j andSet = this.f32220c.getAndSet(jVar);
        if (andSet != null) {
            andSet.p();
        }
        this.f32218a.requestRender();
    }

    public final void b() {
        GLES20.glGenTextures(3, this.f32219b, 0);
        for (int i10 = 0; i10 < 3; i10++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f32222e, f32215o[i10]), i10);
            GLES20.glActiveTexture(33984 + i10);
            GLES20.glBindTexture(3553, this.f32219b[i10]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, androidx.work.d.f8361d, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        hd.m.c();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        j andSet = this.f32220c.getAndSet(null);
        if (andSet == null && this.f32227j == null) {
            return;
        }
        if (andSet != null) {
            j jVar = this.f32227j;
            if (jVar != null) {
                jVar.p();
            }
            this.f32227j = andSet;
        }
        j jVar2 = (j) hd.a.g(this.f32227j);
        float[] fArr = f32212l;
        int i10 = jVar2.f32242l;
        if (i10 == 1) {
            fArr = f32211k;
        } else if (i10 == 3) {
            fArr = f32213m;
        }
        GLES20.glUniformMatrix3fv(this.f32224g, 1, false, fArr, 0);
        int[] iArr = (int[]) hd.a.g(jVar2.f32241k);
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) hd.a.g(jVar2.f32240j);
        int i11 = 0;
        while (i11 < 3) {
            int i12 = i11 == 0 ? jVar2.f32238h : (jVar2.f32238h + 1) / 2;
            GLES20.glActiveTexture(33984 + i11);
            GLES20.glBindTexture(3553, this.f32219b[i11]);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexImage2D(3553, 0, 6409, iArr[i11], i12, 0, 6409, 5121, byteBufferArr[i11]);
            i11++;
        }
        int i13 = (iArr[0] + 1) / 2;
        int[] iArr2 = {jVar2.f32237g, i13, i13};
        for (int i14 = 0; i14 < 3; i14++) {
            if (this.f32225h[i14] != iArr2[i14] || this.f32226i[i14] != iArr[i14]) {
                hd.a.i(iArr[i14] != 0);
                float f10 = iArr2[i14] / iArr[i14];
                this.f32221d[i14] = hd.m.g(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f10, 0.0f, f10, 1.0f});
                GLES20.glVertexAttribPointer(this.f32223f[i14], 2, 5126, false, 0, (Buffer) this.f32221d[i14]);
                this.f32225h[i14] = iArr2[i14];
                this.f32226i[i14] = iArr[i14];
            }
        }
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        hd.m.c();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int iD = hd.m.d(f32214n, f32216p);
        this.f32222e = iD;
        GLES20.glUseProgram(iD);
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f32222e, "in_pos");
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) f32217q);
        this.f32223f[0] = GLES20.glGetAttribLocation(this.f32222e, "in_tc_y");
        GLES20.glEnableVertexAttribArray(this.f32223f[0]);
        this.f32223f[1] = GLES20.glGetAttribLocation(this.f32222e, "in_tc_u");
        GLES20.glEnableVertexAttribArray(this.f32223f[1]);
        this.f32223f[2] = GLES20.glGetAttribLocation(this.f32222e, "in_tc_v");
        GLES20.glEnableVertexAttribArray(this.f32223f[2]);
        hd.m.c();
        this.f32224g = GLES20.glGetUniformLocation(this.f32222e, "mColorConversion");
        hd.m.c();
        b();
        hd.m.c();
    }
}
