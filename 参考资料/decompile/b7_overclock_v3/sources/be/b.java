package be;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.o;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.i;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;
import kd.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.google.android.material.floatingactionbutton.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ExtendedFloatingActionButton f9389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator.AnimatorListener> f9390c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final be.a f9391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public h f9392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public h f9393f;

    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(kd.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.E7.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f9389b.E7.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f10) {
            int colorForState = extendedFloatingActionButton.E7.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f9389b.E7.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (kd.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f10.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f10.floatValue() == 1.0f) {
                extendedFloatingActionButton.Z(extendedFloatingActionButton.E7);
            } else {
                extendedFloatingActionButton.Z(colorStateListValueOf);
            }
        }
    }

    public b(@n0 ExtendedFloatingActionButton extendedFloatingActionButton, be.a aVar) {
        this.f9389b = extendedFloatingActionButton;
        this.f9388a = extendedFloatingActionButton.getContext();
        this.f9391d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @i
    public void a() {
        this.f9391d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final h b() {
        h hVar = this.f9393f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f9392e == null) {
            this.f9392e = h.d(this.f9388a, c());
        }
        return (h) o.l(this.f9392e);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @p0
    public h e() {
        return this.f9393f;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void g(@n0 Animator.AnimatorListener animatorListener) {
        this.f9390c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void h(@n0 Animator.AnimatorListener animatorListener) {
        this.f9390c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @i
    public void i() {
        this.f9391d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void j(@p0 h hVar) {
        this.f9393f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public AnimatorSet k() {
        return o(b());
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @n0
    public final List<Animator.AnimatorListener> l() {
        return this.f9390c;
    }

    @n0
    public AnimatorSet o(@n0 h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f9389b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f9389b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f9389b, View.SCALE_X));
        }
        if (hVar.j(SocializeProtocolConstants.WIDTH)) {
            arrayList.add(hVar.f(SocializeProtocolConstants.WIDTH, this.f9389b, ExtendedFloatingActionButton.J7));
        }
        if (hVar.j(SocializeProtocolConstants.HEIGHT)) {
            arrayList.add(hVar.f(SocializeProtocolConstants.HEIGHT, this.f9389b, ExtendedFloatingActionButton.K7));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.f9389b, ExtendedFloatingActionButton.L7));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.f9389b, ExtendedFloatingActionButton.M7));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.f9389b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        kd.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @i
    public void onAnimationStart(Animator animator) {
        this.f9391d.c(animator);
    }
}
