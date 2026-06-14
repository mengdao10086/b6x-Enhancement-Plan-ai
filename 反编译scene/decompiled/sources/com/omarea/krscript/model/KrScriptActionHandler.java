package com.omarea.krscript.model;

import a.eg0;
import a.f92;
import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public interface KrScriptActionHandler {

    public interface AddToFavoritesHandler {
        void onAddToFavorites(ClickableNode clickableNode, Intent intent);
    }

    public static final class DefaultImpls {
        public static boolean openParamsPage(KrScriptActionHandler krScriptActionHandler, ActionNode actionNode, View view, Runnable runnable) {
            f92.d(actionNode, "actionNode");
            f92.d(view, "view");
            f92.d(runnable, "onCompleted");
            return false;
        }
    }

    void addToFavorites(ClickableNode clickableNode, AddToFavoritesHandler addToFavoritesHandler);

    void onActionCompleted(RunnableNode runnableNode);

    void onSubPageClick(PageNode pageNode);

    boolean openFileChooser(eg0 eg0Var);

    boolean openParamsPage(ActionNode actionNode, View view, Runnable runnable);
}
