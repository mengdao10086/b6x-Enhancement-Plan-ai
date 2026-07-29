package dd;

import android.opengl.GLES20;
import g.p0;
import hd.m;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import jd.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f26171j = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", zc.a.f58317e};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f26172k = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", zc.a.f58317e};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f26173l = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f26174m = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float[] f26175n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float[] f26176o = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float[] f26177p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public a f26179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public a f26180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26186i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f26188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FloatBuffer f26189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f26190d;

        public a(d.c cVar) {
            this.f26187a = cVar.a();
            this.f26188b = m.g(cVar.f36337c);
            this.f26189c = m.g(cVar.f36338d);
            int i10 = cVar.f36336b;
            if (i10 == 1) {
                this.f26190d = 5;
            } else if (i10 != 2) {
                this.f26190d = 4;
            } else {
                this.f26190d = 6;
            }
        }
    }

    public static boolean c(jd.d dVar) {
        d.b bVar = dVar.f36329a;
        d.b bVar2 = dVar.f36330b;
        return bVar.b() == 1 && bVar.a(0).f36335a == 0 && bVar2.b() == 1 && bVar2.a(0).f36335a == 0;
    }

    public void a(int i10, float[] fArr, boolean z10) {
        a aVar = z10 ? this.f26180c : this.f26179b;
        if (aVar == null) {
            return;
        }
        GLES20.glUseProgram(this.f26181d);
        m.c();
        GLES20.glEnableVertexAttribArray(this.f26184g);
        GLES20.glEnableVertexAttribArray(this.f26185h);
        m.c();
        int i11 = this.f26178a;
        GLES20.glUniformMatrix3fv(this.f26183f, 1, false, i11 == 1 ? z10 ? f26175n : f26174m : i11 == 2 ? z10 ? f26177p : f26176o : f26173l, 0);
        GLES20.glUniformMatrix4fv(this.f26182e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        GLES20.glUniform1i(this.f26186i, 0);
        m.c();
        GLES20.glVertexAttribPointer(this.f26184g, 3, 5126, false, 12, (Buffer) aVar.f26188b);
        m.c();
        GLES20.glVertexAttribPointer(this.f26185h, 2, 5126, false, 8, (Buffer) aVar.f26189c);
        m.c();
        GLES20.glDrawArrays(aVar.f26190d, 0, aVar.f26187a);
        m.c();
        GLES20.glDisableVertexAttribArray(this.f26184g);
        GLES20.glDisableVertexAttribArray(this.f26185h);
    }

    public void b() {
        int iE = m.e(f26171j, f26172k);
        this.f26181d = iE;
        this.f26182e = GLES20.glGetUniformLocation(iE, "uMvpMatrix");
        this.f26183f = GLES20.glGetUniformLocation(this.f26181d, "uTexMatrix");
        this.f26184g = GLES20.glGetAttribLocation(this.f26181d, "aPosition");
        this.f26185h = GLES20.glGetAttribLocation(this.f26181d, "aTexCoords");
        this.f26186i = GLES20.glGetUniformLocation(this.f26181d, "uTexture");
    }

    public void d(jd.d dVar) {
        if (c(dVar)) {
            this.f26178a = dVar.f36331c;
            a aVar = new a(dVar.f36329a.a(0));
            this.f26179b = aVar;
            if (!dVar.f36332d) {
                aVar = new a(dVar.f36330b.a(0));
            }
            this.f26180c = aVar;
        }
    }

    public void e() {
        int i10 = this.f26181d;
        if (i10 != 0) {
            GLES20.glDeleteProgram(i10);
        }
    }
}
