package pu;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.f0;
import top.androidman.internal.superview.Plasterer;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends Plasterer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public c f47070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public LinearLayout f47071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @k
    public ImageView f47072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @k
    public TextView f47073m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k LinearLayout linearLayout, @k c valueStore) {
        super(linearLayout, valueStore);
        f0.p(linearLayout, "linearLayout");
        f0.p(valueStore, "valueStore");
        this.f47070j = valueStore;
        this.f47071k = linearLayout;
        this.f47072l = new ImageView(linearLayout.getContext());
        this.f47073m = new AppCompatTextView(linearLayout.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    @Override // top.androidman.internal.superview.Plasterer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D() {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.d.D():void");
    }

    @k
    public final ImageView E() {
        return this.f47072l;
    }

    @k
    public final TextView F() {
        return this.f47073m;
    }

    @k
    public final d G(@l CharSequence charSequence) {
        this.f47070j.f0(charSequence);
        return this;
    }

    @k
    public final d H(@g.l int i10) {
        this.f47070j.g0(i10);
        return this;
    }

    @k
    public final d I(@l Drawable drawable) {
        this.f47070j.h0(drawable != null ? drawable.mutate() : null);
        return this;
    }

    @k
    public final d J(@g.l int i10) {
        this.f47070j.k0(i10);
        return this;
    }

    @k
    public final d K(int i10) {
        this.f47070j.i0(i10);
        return this;
    }

    @k
    public final d L(int i10) {
        this.f47070j.m0(i10);
        return this;
    }

    public final void M(@k ImageView imageView) {
        f0.p(imageView, "<set-?>");
        this.f47072l = imageView;
    }

    @k
    public final d N(int i10, int i11) {
        this.f47070j.n0(i10);
        this.f47070j.l0(i11);
        return this;
    }

    @k
    public final d O(int i10) {
        if (i10 >= 1) {
            this.f47070j.o0(i10);
        }
        return this;
    }

    @k
    public final d P(boolean z10) {
        this.f47070j.p0(z10);
        return this;
    }

    @k
    public final d Q(@l CharSequence charSequence) {
        this.f47070j.q0(charSequence);
        return this;
    }

    @k
    public final d R(@g.l int i10) {
        this.f47070j.r0(i10);
        return this;
    }

    @k
    public final d S(int i10) {
        this.f47070j.s0(i10);
        return this;
    }

    public final void T(@k TextView textView) {
        f0.p(textView, "<set-?>");
        this.f47073m = textView;
    }

    @k
    public final d U(@k Typeface typeface) {
        f0.p(typeface, "typeface");
        this.f47070j.t0(typeface);
        return this;
    }
}
