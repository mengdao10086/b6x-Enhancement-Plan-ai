package a;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f7178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CompoundButton f2543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f2544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2546a;
    public TextView b;

    public q41(u41 u41Var) {
    }

    public final View a() {
        View view = this.f7178a;
        if (view != null) {
            return view;
        }
        f92.m("currentView");
        throw null;
    }

    public final CharSequence b() {
        return this.f2546a;
    }

    public final ImageView c() {
        return this.f2544a;
    }

    public final CompoundButton d() {
        return this.f2543a;
    }

    public final TextView e() {
        return this.b;
    }

    public final TextView f() {
        return this.f2545a;
    }

    public final void g(View view) {
        f92.d(view, "<set-?>");
        this.f7178a = view;
    }

    public final void h(CharSequence charSequence) {
        this.f2546a = charSequence;
    }

    public final void i(ImageView imageView) {
        this.f2544a = imageView;
    }

    public final void j(CompoundButton compoundButton) {
        this.f2543a = compoundButton;
    }

    public final void k(TextView textView) {
        this.b = textView;
    }

    public final void l(TextView textView) {
        this.f2545a = textView;
    }
}
