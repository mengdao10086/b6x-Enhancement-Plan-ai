package androidx.appcompat.widget;

import android.R;
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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class s0 extends d1.c implements View.OnClickListener {
    public static final boolean C = false;
    public static final int C1 = -1;
    public static final String D = "SuggestionsAdapter";
    public static final int K0 = 0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f2679k0 = 50;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f2680k1 = 1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f2681v1 = 2;
    public int A;
    public int B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SearchView f2682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SearchableInfo f2683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f2684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f2685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f2686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2687t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2688u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f2689v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2690w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2691x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2692y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2693z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f2694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f2695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f2696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f2697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f2698e;

        public a(View view) {
            this.f2694a = (TextView) view.findViewById(R.id.text1);
            this.f2695b = (TextView) view.findViewById(R.id.text2);
            this.f2696c = (ImageView) view.findViewById(R.id.icon1);
            this.f2697d = (ImageView) view.findViewById(R.id.icon2);
            this.f2698e = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public s0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f2687t = false;
        this.f2688u = 1;
        this.f2690w = -1;
        this.f2691x = -1;
        this.f2692y = -1;
        this.f2693z = -1;
        this.A = -1;
        this.B = -1;
        this.f2682o = searchView;
        this.f2683p = searchableInfo;
        this.f2686s = searchView.getSuggestionCommitIconResId();
        this.f2684q = context;
        this.f2685r = weakHashMap;
    }

    public static String D(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String u(Cursor cursor, String str) {
        return D(cursor, cursor.getColumnIndex(str));
    }

    public final Drawable A(Cursor cursor) {
        int i10 = this.A;
        if (i10 == -1) {
            return null;
        }
        return y(cursor.getString(i10));
    }

    public int B() {
        return this.f2688u;
    }

    public Cursor C(SearchableInfo searchableInfo, String str, int i10) {
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
        if (i10 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f2684q.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void E(int i10) {
        this.f2688u = i10;
    }

    public final void F(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void G(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void H(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2685r.put(str, drawable.getConstantState());
        }
    }

    public final void I(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // d1.a, d1.b.a
    public CharSequence a(Cursor cursor) {
        String strU;
        String strU2;
        if (cursor == null) {
            return null;
        }
        String strU3 = u(cursor, "suggest_intent_query");
        if (strU3 != null) {
            return strU3;
        }
        if (this.f2683p.shouldRewriteQueryFromData() && (strU2 = u(cursor, "suggest_intent_data")) != null) {
            return strU2;
        }
        if (!this.f2683p.shouldRewriteQueryFromText() || (strU = u(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strU;
    }

    @Override // d1.a, d1.b.a
    public void b(Cursor cursor) {
        if (this.f2687t) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f2690w = cursor.getColumnIndex("suggest_text_1");
                this.f2691x = cursor.getColumnIndex("suggest_text_2");
                this.f2692y = cursor.getColumnIndex("suggest_text_2_url");
                this.f2693z = cursor.getColumnIndex("suggest_icon_1");
                this.A = cursor.getColumnIndex("suggest_icon_2");
                this.B = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    @Override // d1.a, d1.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f2682o.getVisibility() == 0 && this.f2682o.getWindowVisibility() == 0) {
            try {
                Cursor cursorC = C(this.f2683p, string, 50);
                if (cursorC != null) {
                    cursorC.getCount();
                    return cursorC;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // d1.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.B;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f2694a != null) {
            G(aVar.f2694a, D(cursor, this.f2690w));
        }
        if (aVar.f2695b != null) {
            String strD = D(cursor, this.f2692y);
            CharSequence charSequenceR = strD != null ? r(strD) : D(cursor, this.f2691x);
            if (TextUtils.isEmpty(charSequenceR)) {
                TextView textView = aVar.f2694a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f2694a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f2694a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f2694a.setMaxLines(1);
                }
            }
            G(aVar.f2695b, charSequenceR);
        }
        ImageView imageView = aVar.f2696c;
        if (imageView != null) {
            F(imageView, z(cursor), 4);
        }
        ImageView imageView2 = aVar.f2697d;
        if (imageView2 != null) {
            F(imageView2, A(cursor), 8);
        }
        int i12 = this.f2688u;
        if (i12 != 2 && (i12 != 1 || (i11 & 1) == 0)) {
            aVar.f2698e.setVisibility(8);
            return;
        }
        aVar.f2698e.setVisibility(0);
        aVar.f2698e.setTag(aVar.f2694a.getText());
        aVar.f2698e.setOnClickListener(this);
    }

    @Override // d1.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View viewI = i(this.f2684q, c(), viewGroup);
            if (viewI != null) {
                ((a) viewI.getTag()).f2694a.setText(e10.toString());
            }
            return viewI;
        }
    }

    @Override // d1.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View viewJ = j(this.f2684q, c(), viewGroup);
            if (viewJ != null) {
                ((a) viewJ.getTag()).f2694a.setText(e10.toString());
            }
            return viewJ;
        }
    }

    @Override // d1.a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // d1.c, d1.a
    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewJ = super.j(context, cursor, viewGroup);
        viewJ.setTag(new a(viewJ));
        ((ImageView) viewJ.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.f2686s);
        return viewJ;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        I(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        I(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2682o.b0((CharSequence) tag);
        }
    }

    public final Drawable p(String str) {
        Drawable.ConstantState constantState = this.f2685r.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public void q() {
        b(null);
        this.f2687t = true;
    }

    public final CharSequence r(CharSequence charSequence) {
        if (this.f2689v == null) {
            TypedValue typedValue = new TypedValue();
            this.f2684q.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.f2689v = this.f2684q.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2689v, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable s(ComponentName componentName) {
        PackageManager packageManager = this.f2684q.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid icon resource ");
            sb2.append(iconResource);
            sb2.append(" for ");
            sb2.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.toString();
            return null;
        }
    }

    public final Drawable t(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f2685r.containsKey(strFlattenToShortString)) {
            Drawable drawableS = s(componentName);
            this.f2685r.put(strFlattenToShortString, drawableS != null ? drawableS.getConstantState() : null);
            return drawableS;
        }
        Drawable.ConstantState constantState = this.f2685r.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f2684q.getResources());
    }

    public final Drawable v() {
        Drawable drawableT = t(this.f2683p.getSearchActivity());
        return drawableT != null ? drawableT : this.f2684q.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable w(Uri uri) {
        try {
            if (com.google.android.exoplayer2.upstream.c.f19120t.equals(uri.getScheme())) {
                try {
                    return x(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f2684q.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error closing icon stream for ");
                    sb2.append(uri);
                }
            }
        } catch (FileNotFoundException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Icon not found: ");
            sb3.append(uri);
            sb3.append(", ");
            sb3.append(e10.getMessage());
            return null;
        }
        StringBuilder sb32 = new StringBuilder();
        sb32.append("Icon not found: ");
        sb32.append(uri);
        sb32.append(", ");
        sb32.append(e10.getMessage());
        return null;
    }

    public Drawable x(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2684q.getPackageManager().getResourcesForApplication(authority);
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

    public final Drawable y(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i10 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2684q.getPackageName() + fh.a.f28350w + i10;
            Drawable drawableP = p(str2);
            if (drawableP != null) {
                return drawableP;
            }
            Drawable drawableI = h0.d.i(this.f2684q, i10);
            H(str2, drawableI);
            return drawableI;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Icon resource not found: ");
            sb2.append(str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableP2 = p(str);
            if (drawableP2 != null) {
                return drawableP2;
            }
            Drawable drawableW = w(Uri.parse(str));
            H(str, drawableW);
            return drawableW;
        }
    }

    public final Drawable z(Cursor cursor) {
        int i10 = this.f2693z;
        if (i10 == -1) {
            return null;
        }
        Drawable drawableY = y(cursor.getString(i10));
        return drawableY != null ? drawableY : v();
    }
}
