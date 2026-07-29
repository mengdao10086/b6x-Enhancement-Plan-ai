package ll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public class c extends FrameLayout implements il.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f39831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f39832b;

    public interface a {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public interface b {
        void a(int i10, int i11);

        void b(int i10, int i11, float f10, boolean z10);

        void c(int i10, int i11);

        void d(int i10, int i11, float f10, boolean z10);
    }

    public c(Context context) {
        super(context);
    }

    @Override // il.d
    public void a(int i10, int i11) {
        b bVar = this.f39831a;
        if (bVar != null) {
            bVar.a(i10, i11);
        }
    }

    @Override // il.d
    public void b(int i10, int i11, float f10, boolean z10) {
        b bVar = this.f39831a;
        if (bVar != null) {
            bVar.b(i10, i11, f10, z10);
        }
    }

    @Override // il.d
    public void c(int i10, int i11) {
        b bVar = this.f39831a;
        if (bVar != null) {
            bVar.c(i10, i11);
        }
    }

    @Override // il.d
    public void d(int i10, int i11, float f10, boolean z10) {
        b bVar = this.f39831a;
        if (bVar != null) {
            bVar.d(i10, i11, f10, z10);
        }
    }

    public void e(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    @Override // il.b
    public int getContentBottom() {
        a aVar = this.f39832b;
        return aVar != null ? aVar.getContentBottom() : getBottom();
    }

    @Override // il.b
    public int getContentLeft() {
        a aVar = this.f39832b;
        return aVar != null ? aVar.getContentLeft() : getLeft();
    }

    public a getContentPositionDataProvider() {
        return this.f39832b;
    }

    @Override // il.b
    public int getContentRight() {
        a aVar = this.f39832b;
        return aVar != null ? aVar.getContentRight() : getRight();
    }

    @Override // il.b
    public int getContentTop() {
        a aVar = this.f39832b;
        return aVar != null ? aVar.getContentTop() : getTop();
    }

    public b getOnPagerTitleChangeListener() {
        return this.f39831a;
    }

    public void setContentPositionDataProvider(a aVar) {
        this.f39832b = aVar;
    }

    public void setContentView(View view) {
        e(view, null);
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        this.f39831a = bVar;
    }

    public void setContentView(int i10) {
        e(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) null), null);
    }
}
