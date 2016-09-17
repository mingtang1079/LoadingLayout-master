package com.sunxipeng.loadinglayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    ExpandableListView mExpandableListView;
    adapter mAdapter;
    adapter2 mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mExpandableListView = (ExpandableListView) findViewById(R.id.list);
        //  mAdapter=new adapter()

        List<Bean> mList = new ArrayList<>();
        ;
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");


        for (int i = 0; i < 5; i++) {

            Bean mBean = new Bean();
            mBean.name = "" + i;

            mBean.mStrings = list;
            mList.add(mBean);

        }


        mAdapter2 = new adapter2(mList);
        mExpandableListView.setAdapter(mAdapter2);


    }


    class adapter extends BaseExpandableListAdapter {


        private List<String> mP;
        private List<String> mS;

        public adapter(List<String> mP, List<String> mS) {
            this.mP = mP;
            this.mS = mS;
        }


        @Override
        public int getGroupCount() {
            return mP.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mS.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mP.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }


    class adapter2 extends BaseExpandableListAdapter {


        List<Bean> mBeen;


        public adapter2(List<Bean> mBeen) {
            this.mBeen = mBeen;
        }

        @Override

        public int getGroupCount() {
            return mBeen.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mBeen.get(groupPosition).mStrings.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mBeen.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mBeen.get(groupPosition).mStrings.get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) Main2Activity.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item, null);
            }
            TextView tv = (TextView) convertView
                    .findViewById(R.id.text);
            tv.setText(mBeen.get(groupPosition).name);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) Main2Activity.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item2, null);
            }
            TextView tv = (TextView) convertView
                    .findViewById(R.id.text2);
            tv.setText(mBeen.get(groupPosition).mStrings.get(childPosition));
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }


}
