package adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import tie.hackathon.travelguide.CityInfo;
import tie.hackathon.travelguide.R;

/**
 * Created by swati on 9/10/15.
 */


/**
 * Created by Sidharth Patro on 22-Jun-15.
 */
public class Cities_adapter extends BaseAdapter {

    Context context;
    JSONArray FeedItems;
    private static LayoutInflater inflater = null;

    public Cities_adapter(Context context, JSONArray FeedItems) {
        this.context = context;
        this.FeedItems = FeedItems;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return FeedItems.length();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        try {
            return FeedItems.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.jokes_listitem, null);

        TextView Title = (TextView) vi.findViewById(R.id.joke);

        try {

            Title.setText(FeedItems.getJSONObject(position).getString("name"));
            vi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, CityInfo.class);
                    try {
                        i.putExtra("id_", FeedItems.getJSONObject(position).getString("id"));
                        i.putExtra("name_", FeedItems.getJSONObject(position).getString("name"));
                        context.startActivity(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("eroro",e.getMessage()+" ");
        }



        return vi;
    }
}