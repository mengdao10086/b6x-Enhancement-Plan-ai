package a;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m0 extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ q0 f1873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f1874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController f1875a;
    public final int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(q0 q0Var, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.f1873a = q0Var;
        this.f1874a = recycleListView;
        this.f1875a = alertController;
        Cursor cursor2 = getCursor();
        this.f6753a = cursor2.getColumnIndexOrThrow(this.f1873a.f2504a);
        this.b = cursor2.getColumnIndexOrThrow(this.f1873a.f2512b);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f6753a));
        this.f1874a.setItemChecked(cursor.getPosition(), cursor.getInt(this.b) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1873a.f2499a.inflate(this.f1875a.l, viewGroup, false);
    }
}
