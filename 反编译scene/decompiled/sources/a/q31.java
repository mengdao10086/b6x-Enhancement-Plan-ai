package a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class q31 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f7174a;
    public final z32 b;
    public final z32 c;
    public final z32 d;
    public final z32 e;
    public final z32 f;
    public final z32 g;
    public final z32 h;
    public final z32 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q31(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f7174a = a42.a(new k31(this));
        this.b = a42.a(new p31(this));
        this.c = a42.a(new l31(this));
        this.d = a42.a(new n31(this));
        this.e = a42.a(new m31(this));
        this.f = a42.a(new o31(this));
        this.g = a42.a(new h31(this));
        this.h = a42.a(new i31(this));
        this.i = a42.a(new j31(this));
    }

    public final int getColorAccent() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final int getColorPrimary() {
        return ((Number) this.h.getValue()).intValue();
    }

    public final int getColorPrimaryDark() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final int getFull() {
        return ((Number) this.f7174a.getValue()).intValue();
    }

    public final int getHigh() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final int getLow() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final int getMiddle() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final int getNone() {
        return ((Number) this.f.getValue()).intValue();
    }

    public final int getVeryHigh() {
        return ((Number) this.b.getValue()).intValue();
    }
}
