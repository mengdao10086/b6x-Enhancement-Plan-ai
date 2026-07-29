package y7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.flydigi.sdk.gamepad.GamepadInfo;
import g.n0;
import g.p0;
import java.util.Iterator;
import q.a;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f56474l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f56475m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f56476n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f56477o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f56478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f56479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowManager.LayoutParams f56480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WindowManager f56481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f56482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f56483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GamepadInfo f56484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f56485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f56486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q.a f56487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayMap<Integer, b> f56488k;

    public b(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view, int i10, ViewGroup viewGroup) {
        this.f56479b = view;
        u();
    }

    public void A() {
        if (tt.c.f().o(this)) {
            tt.c.f().A(this);
        }
    }

    @g.i
    public void g() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("创建 ");
        sb2.append(getClass().getSimpleName());
        if (i() != 0) {
            if (!this.f56486i) {
                this.f56487j.a(i(), null, new a.e() { // from class: y7.a
                    @Override // q.a.e
                    public final void a(View view, int i10, ViewGroup viewGroup) {
                        this.f56473a.o(view, i10, viewGroup);
                    }
                });
            } else {
                this.f56479b = View.inflate(this.f56478a, i(), null);
                u();
            }
        }
    }

    @g.i
    public void h() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("销毁 ");
        sb2.append(getClass().getSimpleName());
        A();
        Iterator<Integer> it2 = this.f56488k.keySet().iterator();
        while (it2.hasNext()) {
            b bVar = this.f56488k.get(it2.next());
            if (bVar != null) {
                View viewJ = bVar.j();
                if (viewJ != null && this.f56481d != null && viewJ.isAttachedToWindow()) {
                    this.f56481d.removeView(viewJ);
                }
                bVar.h();
            }
            it2.remove();
        }
        View view = this.f56479b;
        if (view != null && this.f56481d != null && view.isAttachedToWindow()) {
            this.f56481d.removeView(this.f56479b);
        }
        Handler handler = this.f56483f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public abstract int i();

    public View j() {
        return this.f56479b;
    }

    public boolean k() {
        View view = this.f56479b;
        return view != null && view.getVisibility() == 0;
    }

    @g.i
    public void l() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("隐藏 ");
        sb2.append(getClass().getSimpleName());
        View view = this.f56479b;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public void m(int i10) {
        b bVar = this.f56488k.get(Integer.valueOf(i10));
        if (bVar != null) {
            bVar.l();
        }
    }

    public abstract void n();

    public abstract WindowManager.LayoutParams p();

    public void q(int i10) {
        r(i10, -1);
    }

    public void r(int i10, int i11) {
        s(i10, i11, null);
    }

    public void s(int i10, int i11, Object obj) {
        if (this.f56482e != null) {
            Message message = new Message();
            message.what = i10;
            if (i11 > -1) {
                message.arg1 = i11;
            }
            message.obj = obj;
            this.f56482e.sendMessage(message);
        }
    }

    public void t(int i10, Object obj) {
        s(i10, -1, obj);
    }

    public void u() {
        this.f56480c = p();
        if (o5.d.o(this.f56478a)) {
            n nVar = this.f56485h;
            if (nVar != null) {
                nVar.addView(this.f56479b, this.f56480c);
            } else {
                this.f56481d = (WindowManager) this.f56478a.getApplicationContext().getSystemService("window");
                if (!this.f56479b.isAttachedToWindow()) {
                    this.f56481d.addView(this.f56479b, this.f56480c);
                }
            }
            n();
        }
    }

    public void v() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public void w(int i10) {
        b bVar = this.f56488k.get(Integer.valueOf(i10));
        if (bVar != null) {
            View viewJ = bVar.j();
            if (viewJ != null && this.f56481d != null && viewJ.isAttachedToWindow()) {
                this.f56481d.removeView(viewJ);
            }
            bVar.h();
            this.f56488k.remove(Integer.valueOf(i10));
        }
    }

    public void x(GamepadInfo gamepadInfo) {
        this.f56484g = gamepadInfo;
    }

    @g.i
    public void y() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("显示 ");
        sb2.append(getClass().getSimpleName());
        View view = this.f56479b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void z(int i10) {
        b bVar = this.f56488k.get(Integer.valueOf(i10));
        if (bVar != null) {
            bVar.y();
        }
    }

    public b(@n0 Context context, @p0 n nVar) {
        this(context, nVar, null, null, false);
    }

    public b(@n0 Context context, @p0 n nVar, GamepadInfo gamepadInfo) {
        this(context, nVar, null, gamepadInfo);
    }

    public b(@n0 Context context, @p0 n nVar, boolean z10) {
        this(context, nVar, null, null, z10);
    }

    public b(@n0 Context context, @p0 n nVar, Handler handler) {
        this(context, nVar, handler, null, false);
    }

    public b(@n0 Context context, @p0 n nVar, Handler handler, GamepadInfo gamepadInfo) {
        this(context, nVar, handler, gamepadInfo, false);
    }

    public b(@n0 Context context, @p0 n nVar, Handler handler, GamepadInfo gamepadInfo, boolean z10) {
        this.f56483f = new Handler(Looper.getMainLooper());
        this.f56488k = new ArrayMap<>();
        this.f56478a = context;
        this.f56482e = handler;
        this.f56485h = nVar;
        this.f56486i = z10;
        this.f56484g = gamepadInfo;
        this.f56487j = new q.a(context);
        g();
    }
}
