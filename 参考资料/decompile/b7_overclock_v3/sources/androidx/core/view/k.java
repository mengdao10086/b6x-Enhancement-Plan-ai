package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f4973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnLongClickListener f4978f = new View.OnLongClickListener() { // from class: androidx.core.view.i
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return this.f4921a.d(view);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnTouchListener f4979g = new View.OnTouchListener() { // from class: androidx.core.view.j
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f4924a.e(view, motionEvent);
        }
    };

    public interface a {
        boolean a(@g.n0 View view, @g.n0 k kVar);
    }

    public k(@g.n0 View view, @g.n0 a aVar) {
        this.f4973a = view;
        this.f4974b = aVar;
    }

    public void a() {
        this.f4973a.setOnLongClickListener(this.f4978f);
        this.f4973a.setOnTouchListener(this.f4979g);
    }

    public void b() {
        this.f4973a.setOnLongClickListener(null);
        this.f4973a.setOnTouchListener(null);
    }

    public void c(@g.n0 Point point) {
        point.set(this.f4975c, this.f4976d);
    }

    public boolean d(@g.n0 View view) {
        return this.f4974b.a(view, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(@g.n0 android.view.View r7, @g.n0 android.view.MotionEvent r8) {
        /*
            r6 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r2 = r8.getAction()
            r3 = 0
            if (r2 == 0) goto L49
            r4 = 1
            if (r2 == r4) goto L46
            r5 = 2
            if (r2 == r5) goto L1b
            r7 = 3
            if (r2 == r7) goto L46
            goto L4d
        L1b:
            r2 = 8194(0x2002, float:1.1482E-41)
            boolean r2 = androidx.core.view.b0.l(r8, r2)
            if (r2 == 0) goto L4d
            int r8 = r8.getButtonState()
            r8 = r8 & r4
            if (r8 != 0) goto L2b
            goto L4d
        L2b:
            boolean r8 = r6.f4977e
            if (r8 == 0) goto L30
            goto L4d
        L30:
            int r8 = r6.f4975c
            if (r8 != r0) goto L39
            int r8 = r6.f4976d
            if (r8 != r1) goto L39
            goto L4d
        L39:
            r6.f4975c = r0
            r6.f4976d = r1
            androidx.core.view.k$a r8 = r6.f4974b
            boolean r7 = r8.a(r7, r6)
            r6.f4977e = r7
            return r7
        L46:
            r6.f4977e = r3
            goto L4d
        L49:
            r6.f4975c = r0
            r6.f4976d = r1
        L4d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.k.e(android.view.View, android.view.MotionEvent):boolean");
    }
}
