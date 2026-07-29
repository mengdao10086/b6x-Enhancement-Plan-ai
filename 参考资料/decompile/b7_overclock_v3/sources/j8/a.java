package j8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import g.i0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Context f36187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public GamepadInfo f36188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public InterfaceC0408a f36189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public PropertyLinearLayout f36190d;

    /* JADX INFO: renamed from: j8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0408a {
        void a(int i10);

        void b(@k String str, @k String str2);
    }

    public a(@k Context context, @k GamepadInfo deviceInfo, @i0 int i10) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        this.f36187a = context;
        this.f36188b = deviceInfo;
        View viewInflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) null, false);
        f0.n(viewInflate, "null cannot be cast to non-null type com.flydigi.float_view.widget.PropertyLinearLayout");
        PropertyLinearLayout propertyLinearLayout = (PropertyLinearLayout) viewInflate;
        this.f36190d = propertyLinearLayout;
        e(propertyLinearLayout, this.f36188b);
    }

    @k
    public final Context a() {
        return this.f36187a;
    }

    @k
    public final GamepadInfo b() {
        return this.f36188b;
    }

    @k
    public abstract CFGSubPropertyMacro c();

    @k
    public final PropertyLinearLayout d() {
        return this.f36190d;
    }

    public abstract void e(@k View view, @k GamepadInfo gamepadInfo);

    public abstract void f(@k CFGSubPropertyMacro cFGSubPropertyMacro);

    public abstract void g();

    public final void h(@k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "<set-?>");
        this.f36188b = gamepadInfo;
    }

    public final void i(@k InterfaceC0408a listener) {
        f0.p(listener, "listener");
        this.f36189c = listener;
    }

    public final void j(@k String title, @k String content) {
        f0.p(title, "title");
        f0.p(content, "content");
        InterfaceC0408a interfaceC0408a = this.f36189c;
        if (interfaceC0408a != null) {
            interfaceC0408a.b(title, content);
        }
    }

    public final void k(int i10) {
        InterfaceC0408a interfaceC0408a = this.f36189c;
        if (interfaceC0408a != null) {
            interfaceC0408a.a(i10);
        }
    }
}
