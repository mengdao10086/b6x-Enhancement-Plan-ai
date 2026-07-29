package e8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.c1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final GamepadInfo f26731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CFGPropertyMacro f26732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public c1 f26733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public PropertyLinearLayout f26734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public b f26735e;

    public static final class a implements FloatViewKeySetView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            d.this.m(2);
        }
    }

    public interface b {
        void a(int i10);

        void c();

        void d(@k CFGPropertyMacro cFGPropertyMacro);
    }

    public d(@k Context context, @k GamepadInfo deviceInfo) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        this.f26731a = deviceInfo;
        c1 c1VarD = c1.d(LayoutInflater.from(context), null, false);
        f0.o(c1VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.f26733c = c1VarD;
        PropertyLinearLayout root = c1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        this.f26734d = root;
        this.f26733c.f54009e.setOnButtonClickListener$float_view_officialRelease(new a());
        o.r(this.f26733c.f54006b, new View.OnClickListener() { // from class: e8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.c(this.f26730a, view);
            }
        });
        o.r(this.f26733c.f54007c, new View.OnClickListener() { // from class: e8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.d(this.f26729a, view);
            }
        });
    }

    public static final void c(d this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f26735e;
        if (bVar != null) {
            bVar.d(this$0.g());
        }
    }

    public static final void d(d this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f26735e;
        if (bVar != null) {
            bVar.c();
        }
    }

    @k
    public final GamepadInfo f() {
        return this.f26731a;
    }

    @k
    public final CFGPropertyMacro g() {
        CFGPropertyMacro cFGPropertyMacro = this.f26732b;
        if (cFGPropertyMacro == null) {
            f0.S("propertyKey");
            cFGPropertyMacro = null;
        }
        cFGPropertyMacro.key_id_cancel = this.f26733c.f54009e.getValue();
        CFGPropertyMacro cFGPropertyMacro2 = this.f26732b;
        if (cFGPropertyMacro2 == null) {
            f0.S("propertyKey");
            cFGPropertyMacro2 = null;
        }
        if (cFGPropertyMacro2.key_id_cancel == -1) {
            CFGPropertyMacro cFGPropertyMacro3 = this.f26732b;
            if (cFGPropertyMacro3 == null) {
                f0.S("propertyKey");
                cFGPropertyMacro3 = null;
            }
            cFGPropertyMacro3.key_id_cancel = 255;
        }
        CFGPropertyMacro cFGPropertyMacro4 = this.f26732b;
        if (cFGPropertyMacro4 == null) {
            f0.S("propertyKey");
            cFGPropertyMacro4 = null;
        }
        CFGPropertyMacro cFGPropertyMacro5 = this.f26732b;
        if (cFGPropertyMacro5 == null) {
            f0.S("propertyKey");
            cFGPropertyMacro5 = null;
        }
        cFGPropertyMacro4.key_cancel = com.flydigi.sdk.gamepad.extension.a.i(cFGPropertyMacro5.key_id_cancel, this.f26731a.getDeviceMode());
        CFGPropertyMacro cFGPropertyMacro6 = this.f26732b;
        if (cFGPropertyMacro6 != null) {
            return cFGPropertyMacro6;
        }
        f0.S("propertyKey");
        return null;
    }

    @k
    public final PropertyLinearLayout h() {
        return this.f26734d;
    }

    public final void i(@k CFGPropertyMacro pkey) {
        int i10;
        f0.p(pkey, "pkey");
        this.f26732b = pkey;
        this.f26733c.f54010f.setText(String.valueOf(pkey.macro_keys.size()));
        FloatViewKeySetView floatViewKeySetView = this.f26733c.f54009e;
        CFGPropertyMacro cFGPropertyMacro = this.f26732b;
        CFGPropertyMacro cFGPropertyMacro2 = null;
        if (cFGPropertyMacro == null) {
            f0.S("propertyKey");
            cFGPropertyMacro = null;
        }
        if (cFGPropertyMacro.key_id_cancel == 255) {
            i10 = -1;
        } else {
            CFGPropertyMacro cFGPropertyMacro3 = this.f26732b;
            if (cFGPropertyMacro3 == null) {
                f0.S("propertyKey");
            } else {
                cFGPropertyMacro2 = cFGPropertyMacro3;
            }
            i10 = cFGPropertyMacro2.key_id_cancel;
        }
        floatViewKeySetView.g(i10, this.f26731a);
    }

    public final void j() {
        this.f26732b = new CFGPropertyMacro();
        this.f26733c.f54009e.g(-1, this.f26731a);
        this.f26733c.f54010f.setText("0");
    }

    public final void k(@k b listener) {
        f0.p(listener, "listener");
        this.f26735e = listener;
    }

    public final void l(int i10) {
        this.f26733c.f54009e.g(i10, this.f26731a);
    }

    public final void m(int i10) {
        b bVar = this.f26735e;
        if (bVar != null) {
            bVar.a(i10);
        }
    }
}
