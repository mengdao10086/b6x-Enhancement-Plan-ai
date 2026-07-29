package dd;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f26164a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f26165b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f26166c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f26167d = new float[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Display f26168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0295a[] f26169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f26170g;

    /* JADX INFO: renamed from: dd.a$a, reason: collision with other inner class name */
    public interface InterfaceC0295a {
        void a(float[] fArr, float f10);
    }

    public a(Display display, InterfaceC0295a... interfaceC0295aArr) {
        this.f26168e = display;
        this.f26169f = interfaceC0295aArr;
    }

    public static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f26165b);
        SensorManager.getOrientation(this.f26165b, this.f26167d);
        return this.f26167d[2];
    }

    public final void b(float[] fArr, float f10) {
        for (InterfaceC0295a interfaceC0295a : this.f26169f) {
            interfaceC0295a.a(fArr, f10);
        }
    }

    public final void c(float[] fArr) {
        if (!this.f26170g) {
            jd.c.a(this.f26166c, fArr);
            this.f26170g = true;
        }
        float[] fArr2 = this.f26165b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f26165b, 0, this.f26166c, 0);
    }

    public final void d(float[] fArr, int i10) {
        if (i10 != 0) {
            int i11 = 130;
            int i12 = 129;
            if (i10 == 1) {
                i11 = 2;
            } else if (i10 == 2) {
                i11 = 129;
                i12 = 130;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException();
                }
                i12 = 1;
            }
            float[] fArr2 = this.f26165b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f26165b, i11, i12, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    @g.g
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f26164a, sensorEvent.values);
        d(this.f26164a, this.f26168e.getRotation());
        float fA = a(this.f26164a);
        e(this.f26164a);
        c(this.f26164a);
        b(this.f26164a, fA);
    }
}
