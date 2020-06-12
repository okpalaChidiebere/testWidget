package com.example.android.testwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.android.testwidget.Model.BakingFood;
import com.example.android.testwidget.Utils.ApiClient;
import com.example.android.testwidget.Utils.ApiInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Implementation of App Widget functionality.
 */
public class WidgetProvider extends AppWidgetProvider {

    private static final String TAG = "BakingWidgetProvider";

    static void updateAppWidget(final Context context, AppWidgetManager appWidgetManager,
                                 int appWidgetId) {

        String[] items={"lorem", "ipsum", "dolor",
                "sit", "amet", "consectetuer",
                "adipiscing", "elit", "morbi",
                "vel", "ligula", "vitae",
                "arcu", "aliquet", "mollis",
                "etiam", "vel", "erat",
                "placerat", "ante",
                "porttitor", "sodales",
                "pellentesque", "augue",
                "purus"};


        Intent svcIntent=new Intent(context, WidgetService.class);
        //svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        svcIntent.putExtra(MainActivity.EXTRA_FOOD_LIST, items);
        svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));

        RemoteViews widget=new RemoteViews(context.getPackageName(),
                R.layout.widget_provider);

        widget.setTextViewText(R.id.widget_ingredient_list_title, "EXAMPLE");

        widget.setRemoteAdapter(R.id.widget_ingredients_list,
                svcIntent);

        Intent clickIntent=new Intent(context, MainActivity.class);
        PendingIntent clickPI=PendingIntent
                .getActivity(context, 0,
                        clickIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        //widget.setPendingIntentTemplate(R.id.widget_ingredients_list, clickPI);

        widget.setOnClickPendingIntent(R.id.widget_ingredient_list_title, clickPI);

        appWidgetManager.updateAppWidget(appWidgetId, widget);
    }


    @Override
    public void onUpdate(Context ctxt, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(ctxt, appWidgetManager, appWidgetId);
        }

    }
}

