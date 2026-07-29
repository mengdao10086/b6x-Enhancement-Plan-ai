package a0;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24e;

    public void a(View v10) {
        this.f21b = v10.getLeft();
        this.f22c = v10.getTop();
        this.f23d = v10.getRight();
        this.f24e = v10.getBottom();
        this.f20a = v10.getRotation();
    }

    public int b() {
        return this.f24e - this.f22c;
    }

    public int c() {
        return this.f23d - this.f21b;
    }
}
