package h1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f30209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f30210b;

    public static class a {
        public boolean a(@n0 Editable editable, int i10, @n0 KeyEvent keyEvent) {
            return androidx.emoji2.text.e.h(editable, i10, keyEvent);
        }
    }

    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f30209a.clearMetaKeyState(view, editable, i10);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f30209a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f30210b.a(editable, i10, keyEvent) || this.f30209a.onKeyDown(view, editable, i10, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f30209a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f30209a.onKeyUp(view, editable, i10, keyEvent);
    }

    public e(KeyListener keyListener, a aVar) {
        this.f30209a = keyListener;
        this.f30210b = aVar;
    }
}
