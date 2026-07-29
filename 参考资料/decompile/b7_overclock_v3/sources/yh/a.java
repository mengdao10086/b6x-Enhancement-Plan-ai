package yh;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.j0;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import g.n0;
import zh.e;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f57346e = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CursorAdapter f57347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f57348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f57349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f57350d;

    /* JADX INFO: renamed from: yh.a$a, reason: collision with other inner class name */
    public class C0672a implements AdapterView.OnItemClickListener {
        public C0672a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            a.this.e(adapterView.getContext(), i10);
            if (a.this.f57350d != null) {
                a.this.f57350d.onItemSelected(adapterView, view, i10, j10);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.album_item_height);
            a.this.f57349c.Z(a.this.f57347a.getCount() > 6 ? dimensionPixelSize * 6 : dimensionPixelSize * a.this.f57347a.getCount());
            a.this.f57349c.a();
        }
    }

    public a(@n0 Context context) {
        j0 j0Var = new j0(context, null, R.attr.listPopupWindowStyle);
        this.f57349c = j0Var;
        j0Var.d0(true);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f57349c.U((int) (216.0f * f10));
        this.f57349c.f((int) (16.0f * f10));
        this.f57349c.l((int) (f10 * (-48.0f)));
        this.f57349c.f0(new C0672a());
    }

    public final void e(Context context, int i10) {
        this.f57349c.dismiss();
        Cursor cursor = this.f57347a.getCursor();
        cursor.moveToPosition(i10);
        String strG = Album.C(cursor).g(context);
        if (this.f57348b.getVisibility() == 0) {
            this.f57348b.setText(strG);
            return;
        }
        if (!e.a()) {
            this.f57348b.setVisibility(0);
            this.f57348b.setText(strG);
        } else {
            this.f57348b.setAlpha(0.0f);
            this.f57348b.setVisibility(0);
            this.f57348b.setText(strG);
            this.f57348b.animate().alpha(1.0f).setDuration(context.getResources().getInteger(android.R.integer.config_longAnimTime)).start();
        }
    }

    public void f(CursorAdapter cursorAdapter) {
        this.f57349c.q(cursorAdapter);
        this.f57347a = cursorAdapter;
    }

    public void g(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f57350d = onItemSelectedListener;
    }

    public void h(View view) {
        this.f57349c.S(view);
    }

    public void i(TextView textView) {
        this.f57348b = textView;
        Drawable drawable = textView.getCompoundDrawables()[2];
        TypedArray typedArrayObtainStyledAttributes = this.f57348b.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.album_element_color});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.f57348b.setVisibility(8);
        this.f57348b.setOnClickListener(new b());
        TextView textView2 = this.f57348b;
        textView2.setOnTouchListener(this.f57349c.t(textView2));
    }

    public void j(Context context, int i10) {
        this.f57349c.l0(i10);
        e(context, i10);
    }
}
