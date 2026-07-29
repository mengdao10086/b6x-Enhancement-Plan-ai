package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Item;
import th.c;

/* JADX INFO: loaded from: classes5.dex */
public class MediaGrid extends SquareFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f25136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckView f25137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f25138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f25139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Item f25140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f25141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f25142g;

    public interface a {
        void e(ImageView imageView, Item item, RecyclerView.e0 e0Var);

        void g(CheckView checkView, Item item, RecyclerView.e0 e0Var);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f25144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView.e0 f25146d;

        public b(int i10, Drawable drawable, boolean z10, RecyclerView.e0 e0Var) {
            this.f25143a = i10;
            this.f25144b = drawable;
            this.f25145c = z10;
            this.f25146d = e0Var;
        }
    }

    public MediaGrid(Context context) {
        super(context);
        b(context);
    }

    public void a(Item item) {
        this.f25140e = item;
        f();
        c();
        g();
        h();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.media_grid_content, (ViewGroup) this, true);
        this.f25136a = (ImageView) findViewById(R.id.media_thumbnail);
        this.f25137b = (CheckView) findViewById(R.id.check_view);
        this.f25138c = (ImageView) findViewById(R.id.gif);
        this.f25139d = (TextView) findViewById(R.id.video_duration);
        this.f25136a.setOnClickListener(this);
        this.f25137b.setOnClickListener(this);
    }

    public final void c() {
        this.f25137b.setCountable(this.f25141f.f25145c);
    }

    public void d(b bVar) {
        this.f25141f = bVar;
    }

    public void e() {
        this.f25142g = null;
    }

    public final void f() {
        this.f25138c.setVisibility(this.f25140e.e() ? 0 : 8);
    }

    public final void g() {
        if (this.f25140e.e()) {
            qh.a aVar = c.b().f51307p;
            Context context = getContext();
            b bVar = this.f25141f;
            aVar.e(context, bVar.f25143a, bVar.f25144b, this.f25136a, this.f25140e.a());
            return;
        }
        qh.a aVar2 = c.b().f51307p;
        Context context2 = getContext();
        b bVar2 = this.f25141f;
        aVar2.d(context2, bVar2.f25143a, bVar2.f25144b, this.f25136a, this.f25140e.a());
    }

    public Item getMedia() {
        return this.f25140e;
    }

    public final void h() {
        if (!this.f25140e.j()) {
            this.f25139d.setVisibility(8);
        } else {
            this.f25139d.setVisibility(0);
            this.f25139d.setText(DateUtils.formatElapsedTime(this.f25140e.f25101e / 1000));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f25142g;
        if (aVar != null) {
            ImageView imageView = this.f25136a;
            if (view == imageView) {
                aVar.e(imageView, this.f25140e, this.f25141f.f25146d);
                return;
            }
            CheckView checkView = this.f25137b;
            if (view == checkView) {
                aVar.g(checkView, this.f25140e, this.f25141f.f25146d);
            }
        }
    }

    public void setCheckEnabled(boolean z10) {
        this.f25137b.setEnabled(z10);
    }

    public void setChecked(boolean z10) {
        this.f25137b.setChecked(z10);
    }

    public void setCheckedNum(int i10) {
        this.f25137b.setCheckedNum(i10);
    }

    public void setOnMediaGridClickListener(a aVar) {
        this.f25142g = aVar;
    }

    public MediaGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
