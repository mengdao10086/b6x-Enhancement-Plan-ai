package b8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import g.i0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Context f9111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public GamepadInfo f9112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public CFGPropertyJS f9113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public InterfaceC0095a f9114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public PropertyLinearLayout f9115e;

    /* JADX INFO: renamed from: b8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0095a {
        void a(int i10);

        void b(@k String str, @k String str2);
    }

    public a(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property, @i0 int i10) {
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
        this.f9111a = context;
        this.f9112b = deviceInfo;
        this.f9113c = property;
        View viewInflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) null, false);
        f0.n(viewInflate, "null cannot be cast to non-null type com.flydigi.float_view.widget.PropertyLinearLayout");
        PropertyLinearLayout propertyLinearLayout = (PropertyLinearLayout) viewInflate;
        this.f9115e = propertyLinearLayout;
        f(propertyLinearLayout);
    }

    @k
    public final Context a() {
        return this.f9111a;
    }

    @k
    public final GamepadInfo b() {
        return this.f9112b;
    }

    @k
    public final CFGPropertyJS c() {
        return this.f9113c;
    }

    @k
    public abstract CFGPropertyJS d();

    @k
    public final PropertyLinearLayout e() {
        return this.f9115e;
    }

    public abstract void f(@k View view);

    public abstract void g(@k CFGPropertyJS cFGPropertyJS);

    public abstract void h();

    public final void i(@k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "<set-?>");
        this.f9112b = gamepadInfo;
    }

    public final void j(@k InterfaceC0095a listener) {
        f0.p(listener, "listener");
        this.f9114d = listener;
    }

    public final void k(@k CFGPropertyJS cFGPropertyJS) {
        f0.p(cFGPropertyJS, "<set-?>");
        this.f9113c = cFGPropertyJS;
    }

    public final void l(@k String title, @k String content) {
        f0.p(title, "title");
        f0.p(content, "content");
        InterfaceC0095a interfaceC0095a = this.f9114d;
        if (interfaceC0095a != null) {
            interfaceC0095a.b(title, content);
        }
    }

    public final void m(int i10) {
        InterfaceC0095a interfaceC0095a = this.f9114d;
        if (interfaceC0095a != null) {
            interfaceC0095a.a(i10);
        }
    }
}
