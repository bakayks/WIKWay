package de.fh_zwickau.WIKWay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.fh_zwickau.WIKWay.Job;
import de.fh_zwickau.WIKWay.R;

public class MyAdapter extends ArrayAdapter<Job> {
    ArrayList<Job> jobs;
    Context context;
    int resource;


    public MyAdapter(Context context, int resource, ArrayList<Job> products) {
        super(context, resource, products);
        this.jobs = products;
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.list_item, null);
        }

        Job job = getItem(position);

        TextView text1 = (TextView) view.findViewById(R.id.name);
        text1.setText(job.getBezeichnungderStelle());
        TextView text2 = (TextView) view.findViewById(R.id.bewerbenFirma);
        text2.setText(job.getBewerbenkontaktfirma());
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(context).load(job.getURLImage()).into(image);
        return view;
    }


}

