package androidx.recyclerview.widget;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6910f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6911g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6912h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6913i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6915b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6916c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6917d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f6918e = null;

    public f(@n0 t tVar) {
        this.f6914a = tVar;
    }

    public void a() {
        int i10 = this.f6915b;
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            this.f6914a.onInserted(this.f6916c, this.f6917d);
        } else if (i10 == 2) {
            this.f6914a.onRemoved(this.f6916c, this.f6917d);
        } else if (i10 == 3) {
            this.f6914a.onChanged(this.f6916c, this.f6917d, this.f6918e);
        }
        this.f6918e = null;
        this.f6915b = 0;
    }

    @Override // androidx.recyclerview.widget.t
    public void onChanged(int i10, int i11, Object obj) {
        int i12;
        if (this.f6915b == 3) {
            int i13 = this.f6916c;
            int i14 = this.f6917d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f6918e == obj) {
                this.f6916c = Math.min(i10, i13);
                this.f6917d = Math.max(i14 + i13, i12) - this.f6916c;
                return;
            }
        }
        a();
        this.f6916c = i10;
        this.f6917d = i11;
        this.f6918e = obj;
        this.f6915b = 3;
    }

    @Override // androidx.recyclerview.widget.t
    public void onInserted(int i10, int i11) {
        int i12;
        if (this.f6915b == 1 && i10 >= (i12 = this.f6916c)) {
            int i13 = this.f6917d;
            if (i10 <= i12 + i13) {
                this.f6917d = i13 + i11;
                this.f6916c = Math.min(i10, i12);
                return;
            }
        }
        a();
        this.f6916c = i10;
        this.f6917d = i11;
        this.f6915b = 1;
    }

    @Override // androidx.recyclerview.widget.t
    public void onMoved(int i10, int i11) {
        a();
        this.f6914a.onMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onRemoved(int i10, int i11) {
        int i12;
        if (this.f6915b == 2 && (i12 = this.f6916c) >= i10 && i12 <= i10 + i11) {
            this.f6917d += i11;
            this.f6916c = i10;
        } else {
            a();
            this.f6916c = i10;
            this.f6917d = i11;
            this.f6915b = 2;
        }
    }
}
