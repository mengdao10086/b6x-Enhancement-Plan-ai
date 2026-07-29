package ms;

import ft.a0;
import ft.x;
import ft.y;

/* JADX INFO: loaded from: classes6.dex */
public class q extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f41671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ft.h f41674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y f41675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ft.e f41676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x f41677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f41678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ft.e f41679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y[] f41680l;

    public q(int i10, int i11, ft.h hVar, y yVar, x xVar, x xVar2, ft.e eVar) {
        super(true, null);
        this.f41673e = i11;
        this.f41672d = i10;
        this.f41674f = hVar;
        this.f41675g = yVar;
        this.f41676h = eVar;
        this.f41677i = xVar;
        this.f41678j = xVar2;
        this.f41679k = ft.s.b(hVar, yVar);
        this.f41680l = new a0(hVar, yVar).c();
    }

    public q(int i10, int i11, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[][] bArr7) {
        super(true, null);
        this.f41672d = i10;
        this.f41673e = i11;
        ft.h hVar = new ft.h(bArr);
        this.f41674f = hVar;
        this.f41675g = new y(hVar, bArr2);
        this.f41676h = new ft.e(bArr3);
        this.f41677i = new x(bArr4);
        this.f41678j = new x(bArr5);
        this.f41679k = new ft.e(bArr6);
        this.f41680l = new y[bArr7.length];
        for (int i12 = 0; i12 < bArr7.length; i12++) {
            this.f41680l[i12] = new y(this.f41674f, bArr7[i12]);
        }
    }

    public ft.h e() {
        return this.f41674f;
    }

    public y f() {
        return this.f41675g;
    }

    public ft.e g() {
        return this.f41679k;
    }

    public int h() {
        return this.f41673e;
    }

    public int i() {
        return this.f41672d;
    }

    public x j() {
        return this.f41677i;
    }

    public x k() {
        return this.f41678j;
    }

    public y[] l() {
        return this.f41680l;
    }

    public ft.e m() {
        return this.f41676h;
    }
}
