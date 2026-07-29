package com.blankj.utilcode.util;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Camera f11707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SurfaceTexture f11708b;

    public c0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a() {
        Camera camera = f11707a;
        if (camera == null) {
            return;
        }
        camera.release();
        f11708b = null;
        f11707a = null;
    }

    public static boolean b() {
        if (f11707a == null) {
            try {
                f11707a = Camera.open(0);
                f11708b = new SurfaceTexture(0);
            } catch (Throwable unused) {
                return false;
            }
        }
        return f11707a != null;
    }

    public static boolean c() {
        return j1.a().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static boolean d() {
        if (b()) {
            return "torch".equals(f11707a.getParameters().getFlashMode());
        }
        return false;
    }

    public static void e(boolean z10) {
        if (b()) {
            Camera.Parameters parameters = f11707a.getParameters();
            if (!z10) {
                if (kotlinx.coroutines.q0.f38941e.equals(parameters.getFlashMode())) {
                    return;
                }
                parameters.setFlashMode(kotlinx.coroutines.q0.f38941e);
                f11707a.setParameters(parameters);
                return;
            }
            if ("torch".equals(parameters.getFlashMode())) {
                return;
            }
            try {
                f11707a.setPreviewTexture(f11708b);
                f11707a.startPreview();
                parameters.setFlashMode("torch");
                f11707a.setParameters(parameters);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }
}
