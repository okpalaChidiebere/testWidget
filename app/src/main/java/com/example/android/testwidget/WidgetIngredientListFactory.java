package com.example.android.testwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.android.testwidget.Model.BakingFood;
import com.example.android.testwidget.Model.Ingredient;

import java.util.List;

public class WidgetIngredientListFactory implements RemoteViewsService.RemoteViewsFactory {

    private static final String TAG = "IngredientListFactory";

    private Context ctxt=null;
    private String[] items;
    //private int appWidgetId;

    private List<Ingredient> list;

    public WidgetIngredientListFactory(Context ctxt, Intent intent) {
        this.ctxt=ctxt;

        Bundle bundle = intent.getExtras();
        bundle = bundle.getBundle(MainActivity.BUNDLE_FOOD_LIST_INGREDIENT);
        list = (List<Ingredient>) bundle.getSerializable(MainActivity.EXTRA_FOOD_LIST_INGREDIENT);

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
        return(list.size());
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row=new RemoteViews(ctxt.getPackageName(),
                R.layout.baking_ingredients_list_item);


        row.setTextViewText(R.id.tv_foodIngredient, list.get(position).getIngredient());

        String measurement = list.get(position).getQuantity() +" "+list.get(position).getMeasure();
        row.setTextViewText(R.id.tv_IngredientMeasurement, measurement);

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