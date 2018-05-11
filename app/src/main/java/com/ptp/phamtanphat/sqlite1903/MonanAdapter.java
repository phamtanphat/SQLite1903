package com.ptp.phamtanphat.sqlite1903;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KhoaPhamPC on 11/5/2018.
 */

public class MonanAdapter extends ArrayAdapter<Monan> {
    List<Monan> mangmonan;

    public MonanAdapter(@NonNull Context context, int resource, @NonNull List<Monan> objects) {
        super(context, resource, objects);
        this.mangmonan = objects;
    }

    class ViewHolder {
        TextView txtTenmonan, txtGiamonan;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_mon_an, null);
            viewHolder = new ViewHolder();
            viewHolder.txtGiamonan = convertView.findViewById(R.id.textviewGiamonan);
            viewHolder.txtTenmonan = convertView.findViewById(R.id.textviewTenmonan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Monan monan = getItem(position);
        viewHolder.txtTenmonan.setText("Ten mon an : " + monan.getTenmonan());
        viewHolder.txtGiamonan.setText("Gia mon an : " + monan.getGiamonan() + " D");
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteDatabase = "DELETE FROM Monan WHERE Id = " + monan.getId() + " ";
                MainActivity.sqLite.QueryData(deleteDatabase);
                mangmonan.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}

