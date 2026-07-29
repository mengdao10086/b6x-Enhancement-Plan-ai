package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 4;
    public static final int O = 5;
    public static final int P = 6;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public static final int V = 5;
    public static final int W = 6;
    public static final int X = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3962t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f3963u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f3964v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3965w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3966x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3967y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3968z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3969a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3970b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3971c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3972d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3973e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3974f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3975g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3976h = 4.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3977i = 1.2f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3978j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3979k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3980l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3981m = 10.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3982n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3983o = 1.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3984p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3985q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3986r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3987s = 0;

    public u A(boolean moveWhenScrollAtTop) {
        this.f3978j = moveWhenScrollAtTop;
        return this;
    }

    public u B(int flags) {
        this.f3980l = flags;
        return this;
    }

    public u C(int mode) {
        this.f3974f = mode;
        return this;
    }

    public u D(int rotationCenterId) {
        this.f3975g = rotationCenterId;
        return this;
    }

    public u E(int springBoundary) {
        this.f3986r = springBoundary;
        return this;
    }

    public u F(float springDamping) {
        this.f3982n = springDamping;
        return this;
    }

    public u G(float springMass) {
        this.f3983o = springMass;
        return this;
    }

    public u H(float springStiffness) {
        this.f3984p = springStiffness;
        return this;
    }

    public u I(float springStopThreshold) {
        this.f3985q = springStopThreshold;
        return this;
    }

    public u J(int side) {
        this.f3971c = side;
        return this;
    }

    public u K(int side) {
        this.f3970b = side;
        return this;
    }

    public u L(int side) {
        this.f3972d = side;
        return this;
    }

    public int a() {
        return this.f3987s;
    }

    public int b() {
        return this.f3969a;
    }

    public float c() {
        return this.f3979k;
    }

    public float d() {
        return this.f3981m;
    }

    public int e() {
        return this.f3973e;
    }

    public float f() {
        return this.f3977i;
    }

    public float g() {
        return this.f3976h;
    }

    public boolean h() {
        return this.f3978j;
    }

    public int i() {
        return this.f3980l;
    }

    public int j() {
        return this.f3974f;
    }

    public int k() {
        return this.f3975g;
    }

    public int l() {
        return this.f3986r;
    }

    public float m() {
        return this.f3982n;
    }

    public float n() {
        return this.f3983o;
    }

    public float o() {
        return this.f3984p;
    }

    public float p() {
        return this.f3985q;
    }

    public int q() {
        return this.f3971c;
    }

    public int r() {
        return this.f3970b;
    }

    public int s() {
        return this.f3972d;
    }

    public void t(int autoCompleteMode) {
        this.f3987s = autoCompleteMode;
    }

    public u u(int dragDirection) {
        this.f3969a = dragDirection;
        return this;
    }

    public u v(int dragScale) {
        this.f3979k = dragScale;
        return this;
    }

    public u w(int dragThreshold) {
        this.f3981m = dragThreshold;
        return this;
    }

    public u x(int id2) {
        this.f3973e = id2;
        return this;
    }

    public u y(int maxAcceleration) {
        this.f3977i = maxAcceleration;
        return this;
    }

    public u z(int maxVelocity) {
        this.f3976h = maxVelocity;
        return this;
    }
}
