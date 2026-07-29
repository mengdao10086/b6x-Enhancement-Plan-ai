package a0;

import androidx.constraintlayout.motion.widget.r;
import w.p;
import w.s;

/* JADX INFO: loaded from: classes2.dex */
public class b extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f8a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f9b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w.r f10c;

    public b() {
        s sVar = new s();
        this.f8a = sVar;
        this.f10c = sVar;
    }

    @Override // androidx.constraintlayout.motion.widget.r
    public float a() {
        return this.f10c.a();
    }

    public void b(float currentPos, float destination, float currentVelocity, float maxTime, float maxAcceleration, float maxVelocity) {
        s sVar = this.f8a;
        this.f10c = sVar;
        sVar.f(currentPos, destination, currentVelocity, maxTime, maxAcceleration, maxVelocity);
    }

    public String c(String desc, float time) {
        return this.f10c.b(desc, time);
    }

    public float d(float x10) {
        return this.f10c.c(x10);
    }

    public boolean e() {
        return this.f10c.d();
    }

    public void f(float currentPos, float destination, float currentVelocity, float mass, float stiffness, float damping, float stopThreshold, int boundaryMode) {
        if (this.f9b == null) {
            this.f9b = new p();
        }
        p pVar = this.f9b;
        this.f10c = pVar;
        pVar.h(currentPos, destination, currentVelocity, mass, stiffness, damping, stopThreshold, boundaryMode);
    }

    @Override // androidx.constraintlayout.motion.widget.r, android.animation.TimeInterpolator
    public float getInterpolation(float v10) {
        return this.f10c.getInterpolation(v10);
    }
}
