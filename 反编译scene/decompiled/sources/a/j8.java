package a;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedAPI"})
public class j8 extends xj implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchableInfo f6484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SearchView f1512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakHashMap<String, Drawable.ConstantState> f1513a;
    public final Context b;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1514d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    public j8(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1514d = false;
        this.e = 1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.f1512a = searchView;
        this.f6484a = searchableInfo;
        this.d = searchView.getSuggestionCommitIconResId();
        this.b = context;
        this.f1513a = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1513a.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // a.uj, a.vj
    public CharSequence a(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.f6484a.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f6484a.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // a.vj
    public Cursor c(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f1512a.getVisibility() == 0 && this.f1512a.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f6484a, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // a.uj, a.vj
    public void d(Cursor cursor) {
        if (this.f1514d) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.d(cursor);
            if (cursor != null) {
                this.f = cursor.getColumnIndex("suggest_text_1");
                this.g = cursor.getColumnIndex("suggest_text_2");
                this.h = cursor.getColumnIndex("suggest_text_2_url");
                this.i = cursor.getColumnIndex("suggest_icon_1");
                this.j = cursor.getColumnIndex("suggest_icon_2");
                this.k = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // a.uj
    public void e(View view, Context context, Cursor cursor) {
        i8 i8Var = (i8) view.getTag();
        int i = this.k;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (i8Var.f1336a != null) {
            z(i8Var.f1336a, w(cursor, this.f));
        }
        if (i8Var.f1337b != null) {
            String strW = w(cursor, this.h);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.g);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = i8Var.f1336a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    i8Var.f1336a.setMaxLines(2);
                }
            } else {
                TextView textView2 = i8Var.f1336a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    i8Var.f1336a.setMaxLines(1);
                }
            }
            z(i8Var.f1337b, charSequenceL);
        }
        ImageView imageView = i8Var.f6383a;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = i8Var.b;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i3 = this.e;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            i8Var.c.setVisibility(8);
            return;
        }
        i8Var.c.setVisibility(0);
        i8Var.c.setTag(i8Var.f1336a.getText());
        i8Var.c.setOnClickListener(this);
    }

    @Override // a.uj, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewG = g(((uj) this).f3181a, ((uj) this).f3182a, viewGroup);
            if (viewG != null) {
                ((i8) viewG.getTag()).f1336a.setText(e.toString());
            }
            return viewG;
        }
    }

    @Override // a.uj, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewH = h(((uj) this).f3181a, ((uj) this).f3182a, viewGroup);
            if (viewH != null) {
                ((i8) viewH.getTag()).f1336a.setText(e.toString());
            }
            return viewH;
        }
    }

    @Override // a.xj, a.uj
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new i8(viewH));
        ((ImageView) viewH.findViewById(y.edit_query)).setImageResource(this.d);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1513a.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f1511a == null) {
            TypedValue typedValue = new TypedValue();
            ((uj) this).f3181a.getTheme().resolveAttribute(t.textColorSearchUrl, typedValue, true);
            this.f1511a = ((uj) this).f3181a.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1511a, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        String string;
        ActivityInfo activityInfo;
        int iconResource;
        PackageManager packageManager = ((uj) this).f3181a.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
            iconResource = activityInfo.getIconResource();
        } catch (PackageManager.NameNotFoundException e) {
            string = e.toString();
        }
        if (iconResource == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable != null) {
            return drawable;
        }
        string = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
        Log.w("SuggestionsAdapter", string);
        return null;
    }

    public final Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f1513a.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f1513a.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = this.f1513a.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.b.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1512a.U((CharSequence) tag);
        }
    }

    public final Drawable p() {
        Drawable drawableN = n(this.f6484a.getSearchActivity());
        return drawableN != null ? drawableN : ((uj) this).f3181a.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.b.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    public Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = ((uj) this).f3181a.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.b.getPackageName() + "/" + i;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawableD = yb.d(this.b, i);
            A(str2, drawableD);
            return drawableD;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i = this.i;
        if (i == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i));
        return drawableS != null ? drawableS : p();
    }

    public final Drawable u(Cursor cursor) {
        int i = this.j;
        if (i == -1) {
            return null;
        }
        return s(cursor.getString(i));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return ((uj) this).f3181a.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i) {
        this.e = i;
    }

    public final void y(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }
}
