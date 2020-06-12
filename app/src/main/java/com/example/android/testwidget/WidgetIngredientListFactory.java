package com.example.android.testwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetIngredientListFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context ctxt=null;
    private String[] items;
    //private int appWidgetId;

    public WidgetIngredientListFactory(Context ctxt, Intent intent) {
        this.ctxt=ctxt;
        //appWidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
               // AppWidgetManager.INVALID_APPWIDGET_ID);
        items = intent.getStringArrayExtra(MainActivity.EXTRA_FOOD_LIST);

    }

    @Override
    public void onCreate() {
        // no-op
    }

    @Override
    public void onDestroy() {
        // no-op
    }

    @Override
    public int getCount() {
        return(items.length);
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row=new RemoteViews(ctxt.getPackageName(),
                R.layout.baking_ingredients_list_item);


        row.setTextViewText(R.id.tv_foodIngredient, items[position]);

        String measurement = items[position] +" CUP";
        row.setTextViewText(R.id.tv_IngredientMeasurement,measurement);

        /*Intent i=new Intent();
        Bundle extras=new Bundle();

        extras.putString(WidgetProvider.EXTRA_WORD, items[position]);
        i.putExtras(extras);
        baking_ingredients_list_item.setOnClickFillInIntent(android.R.id.text1, i);*/

        return(row);
    }

    @Override
    public RemoteViews getLoadingView() {
        return(null);
    }

    @Override
    public int getViewTypeCount() {
        return(1);
    }

    @Override
    public long getItemId(int position) {
        return(position);
    }

    @Override
    public boolean hasStableIds() {
        return(true);
    }

    @Override
    public void onDataSetChanged() {
        // no-op
    }
}