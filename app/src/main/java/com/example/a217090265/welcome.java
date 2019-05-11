package com.example.a217090265;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class welcome extends AppCompatActivity {

    //creating array data and store it into listview

    //title
    String[]listviewtitle=new String[]
            {
            "Listview Title 1","Listview Title 2","Listview Title 3","Listview Title 4","Listview Title 5",
            "Listview Title 6","Listview Title 7","Listview Title 8"
    };

    //description
    String[]listviewdescription=new String[]
            {
            "Listview Description 1","Listview Description 2","Listview Description 3","Listview Description 4","Listview Description 5",
            "Listview Description 6","Listview Description 7","Listview Description 8"
    };
//image
    int[] listviewimage=new int[]{

   R.drawable.ic_person_black_24dp,   R.drawable.ic_person_black_24dp, R.drawable.ic_person_black_24dp, R.drawable.ic_person_black_24dp

};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        List<HashMap<String,String>>alist=new ArrayList<HashMap<String, String>>();
        for (int x=0;x<8;x++){

            HashMap<String,String>hm=new HashMap<String, String>();
            hm.put("ListTitle",listviewtitle[x]);
            hm.put("ListDescription",listviewdescription[x]);
            hm.put("ListImage",Integer.toString(listviewimage[x]));
            alist.add(hm);
        }

        String[]from={
                "ListImage","ListTitle","ListDescription"
        }   ;
        int []to={
            R.id.listviewimage,R.id.title,R.id.descritpion

        };
        SimpleAdapter simpleAdapter=new SimpleAdapter(getBaseContext(),alist,R.layout.listview_layout,from,to);
        ListView simplelistview=(ListView)findViewById(R.id.listview);
        simplelistview .setAdapter(simpleAdapter);
    }
}
