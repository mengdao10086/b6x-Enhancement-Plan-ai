package a;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qy f447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f449a = new TextPaint(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sy f448a = new ay(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f451a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<by> f450a = new WeakReference<>(null);

    public cy(by byVar) {
        g(byVar);
    }

    public final float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f449a.measureText(charSequence, 0, charSequence.length());
    }

    public qy d() {
        return this.f447a;
    }

    public TextPaint e() {
        return this.f449a;
    }

    public float f(String str) {
        if (!this.f451a) {
            return this.f5838a;
        }
        float fC = c(str);
        this.f5838a = fC;
        this.f451a = false;
        return fC;
    }

    public void g(by byVar) {
        this.f450a = new WeakReference<>(byVar);
    }

    public void h(qy qyVar, Context context) {
        if (this.f447a != qyVar) {
            this.f447a = qyVar;
            if (qyVar != null) {
                qyVar.j(context, this.f449a, this.f448a);
                by byVar = this.f450a.get();
                if (byVar != null) {
                    this.f449a.drawableState = byVar.getState();
                }
                qyVar.i(context, this.f449a, this.f448a);
                this.f451a = true;
            }
            by byVar2 = this.f450a.get();
            if (byVar2 != null) {
                byVar2.a();
                byVar2.onStateChange(byVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f451a = z;
    }

    public void j(Context context) {
        this.f447a.i(context, this.f449a, this.f448a);
    }
}
