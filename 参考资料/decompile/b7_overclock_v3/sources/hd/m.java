package hd;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31084a = "GlUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31085b = "EGL_EXT_protected_content";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31086c = "EGL_KHR_surfaceless_context";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public Buffer f31090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31091e;

        public a(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr, 0);
            byte[] bArr = new byte[iArr[0]];
            int[] iArr2 = new int[1];
            int i12 = iArr[0];
            GLES20.glGetActiveAttrib(i10, i11, i12, iArr2, 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, m.m(bArr));
            this.f31087a = str;
            this.f31089c = GLES20.glGetAttribLocation(i10, str);
            this.f31088b = i11;
        }

        public void a() {
            Buffer buffer = (Buffer) hd.a.h(this.f31090d, "call setBuffer before bind");
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.f31089c, this.f31091e, 5126, false, 0, buffer);
            GLES20.glEnableVertexAttribArray(this.f31088b);
            m.c();
        }

        public void b(float[] fArr, int i10) {
            this.f31090d = m.g(fArr);
            this.f31091e = i10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f31095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f31097f;

        public b(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            byte[] bArr = new byte[iArr[0]];
            int i12 = iArr[0];
            GLES20.glGetActiveUniform(i10, i11, i12, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, m.m(bArr));
            this.f31092a = str;
            this.f31093b = GLES20.glGetUniformLocation(i10, str);
            this.f31094c = iArr2[0];
            this.f31095d = new float[1];
        }

        public void a() {
            if (this.f31094c == 5126) {
                GLES20.glUniform1fv(this.f31093b, 1, this.f31095d, 0);
                m.c();
                return;
            }
            if (this.f31096e == 0) {
                throw new IllegalStateException("call setSamplerTexId before bind");
            }
            GLES20.glActiveTexture(this.f31097f + 33984);
            int i10 = this.f31094c;
            if (i10 == 36198) {
                GLES20.glBindTexture(36197, this.f31096e);
            } else {
                if (i10 != 35678) {
                    throw new IllegalStateException("unexpected uniform type: " + this.f31094c);
                }
                GLES20.glBindTexture(3553, this.f31096e);
            }
            GLES20.glUniform1i(this.f31093b, this.f31097f);
            GLES20.glTexParameteri(3553, androidx.work.d.f8361d, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            m.c();
        }

        public void b(float f10) {
            this.f31095d[0] = f10;
        }

        public void c(int i10, int i11) {
            this.f31096e = i10;
            this.f31097f = i11;
        }
    }

    public static void b(int i10, String str, int i11) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            n(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i11, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        c();
    }

    public static void c() {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            t.d(f31084a, "glError " + GLU.gluErrorString(iGlGetError));
        }
    }

    public static int d(String str, String str2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        c();
        b(35633, str, iGlCreateProgram);
        b(35632, str2, iGlCreateProgram);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            n("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        }
        c();
        return iGlCreateProgram;
    }

    public static int e(String[] strArr, String[] strArr2) {
        return d(TextUtils.join("\n", strArr), TextUtils.join("\n", strArr2));
    }

    public static FloatBuffer f(int i10) {
        return ByteBuffer.allocateDirect(i10 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer g(float[] fArr) {
        return (FloatBuffer) f(fArr.length).put(fArr).flip();
    }

    public static int h() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, androidx.work.d.f8361d, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        c();
        return iArr[0];
    }

    public static a[] i(int i10) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i10, 35721, iArr, 0);
        if (iArr[0] != 2) {
            throw new IllegalStateException("expected two attributes");
        }
        a[] aVarArr = new a[iArr[0]];
        for (int i11 = 0; i11 < iArr[0]; i11++) {
            aVarArr[i11] = new a(i10, i11);
        }
        return aVarArr;
    }

    public static b[] j(int i10) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i10, 35718, iArr, 0);
        b[] bVarArr = new b[iArr[0]];
        for (int i11 = 0; i11 < iArr[0]; i11++) {
            bVarArr[i11] = new b(i10, i11);
        }
        return bVarArr;
    }

    public static boolean k(Context context) {
        String strEglQueryString;
        int i10 = u0.f31154a;
        if (i10 < 24) {
            return false;
        }
        if (i10 >= 26 || !(com.google.android.material.internal.i.f20422b.equals(u0.f31156c) || "XT1650".equals(u0.f31157d))) {
            return (i10 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f31085b);
        }
        return false;
    }

    public static boolean l() {
        String strEglQueryString;
        return u0.f31154a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f31086c);
    }

    public static int m(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] == 0) {
                return i10;
            }
        }
        return bArr.length;
    }

    public static void n(String str) {
        t.d(f31084a, str);
    }
}
