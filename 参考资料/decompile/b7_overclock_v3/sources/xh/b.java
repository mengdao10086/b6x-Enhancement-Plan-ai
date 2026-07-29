package xh;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;

/* JADX INFO: loaded from: classes5.dex */
public class b extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f55332a;

    public b(Context context, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.album_thumbnail_placeholder});
        this.f55332a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        Album albumC = Album.C(cursor);
        ((TextView) view.findViewById(R.id.album_name)).setText(albumC.g(context));
        ((TextView) view.findViewById(R.id.album_media_count)).setText(String.valueOf(albumC.b()));
        th.c.b().f51307p.d(context, context.getResources().getDimensionPixelSize(R.dimen.media_grid_size), this.f55332a, (ImageView) view.findViewById(R.id.album_cover), albumC.e());
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.album_list_item, viewGroup, false);
    }

    public b(Context context, Cursor cursor, int i10) {
        super(context, cursor, i10);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.album_thumbnail_placeholder});
        this.f55332a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
