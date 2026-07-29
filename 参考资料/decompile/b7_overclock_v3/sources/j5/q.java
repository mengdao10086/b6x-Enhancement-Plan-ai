package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.base.R;
import com.flydigi.base.widget.superlink.SuperLinkTextView;
import g.n0;
import java.util.Objects;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final View f36139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperButton f36140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SuperLinkTextView f36141c;

    public q(@n0 View view, @n0 SuperButton superButton, @n0 SuperLinkTextView superLinkTextView) {
        this.f36139a = view;
        this.f36140b = superButton;
        this.f36141c = superLinkTextView;
    }

    @n0
    public static q a(@n0 View view) {
        int i10 = R.id.expand_collapse;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.expandable_text;
            SuperLinkTextView superLinkTextView = (SuperLinkTextView) j2.c.a(view, i10);
            if (superLinkTextView != null) {
                return new q(view, superButton, superLinkTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static q b(@n0 LayoutInflater layoutInflater, @n0 ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, androidx.constraintlayout.widget.d.V1);
        layoutInflater.inflate(R.layout.expandabletextview, viewGroup);
        return a(viewGroup);
    }

    @Override // j2.b
    @n0
    public View getRoot() {
        return this.f36139a;
    }
}
