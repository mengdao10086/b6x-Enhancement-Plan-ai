package a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ot extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ba<Animator, String> f2297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f2298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AnimatorSet f2299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Animator> f2300a;

    public ot(Context context, ot otVar, Drawable.Callback callback, Resources resources) {
        if (otVar != null) {
            this.f7053a = otVar.f7053a;
            gu guVar = otVar.f2298a;
            if (guVar != null) {
                Drawable.ConstantState constantState = guVar.getConstantState();
                this.f2298a = (gu) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                gu guVar2 = this.f2298a;
                guVar2.mutate();
                gu guVar3 = guVar2;
                this.f2298a = guVar3;
                guVar3.setCallback(callback);
                this.f2298a.setBounds(otVar.f2298a.getBounds());
                this.f2298a.h(false);
            }
            ArrayList<Animator> arrayList = otVar.f2300a;
            if (arrayList != null) {
                int size = arrayList.size();
                this.f2300a = new ArrayList<>(size);
                this.f2297a = new ba<>(size);
                for (int i = 0; i < size; i++) {
                    Animator animator = otVar.f2300a.get(i);
                    Animator animatorClone = animator.clone();
                    String str = otVar.f2297a.get(animator);
                    animatorClone.setTarget(this.f2298a.d(str));
                    this.f2300a.add(animatorClone);
                    this.f2297a.put(animatorClone, str);
                }
                a();
            }
        }
    }

    public void a() {
        if (this.f2299a == null) {
            this.f2299a = new AnimatorSet();
        }
        this.f2299a.playTogether(this.f2300a);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f7053a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
