package mybklife.main.mybklife.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.Toast;

import mybklife.main.mybklife.R;
import mybklife.main.mybklife.view.adapter.SectionsPageAdapter;

public class ClassMenu extends Fragment{
    private static final String TAG="Class menu";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file

        View view=inflater.inflate(R.layout.fragment_menu_class,container,false);
        FloatingActionButton fab=(FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment fragment=null;
                Toast.makeText(view.getContext(), "Hhsdkfh", Toast.LENGTH_SHORT).show();
                fragment=new ExamMenu();
//                Snackbar.make(view,"wait for seconds", Snackbar.LENGTH_LONG)
//                        .setAction("Action",null).show();
            }
        });
        //change R.layout.yourlayoutfilename for each of your fragments
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Menu Class");
        Log.d(TAG,"noCreate: Starting.");
       // mSectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager =(ViewPager) view.findViewById(R.id.container);
      //  setupViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    /*private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabPresentFragment(),"PRESENT" );
        adapter.addFragment(new TabPastFragment(),"PAST");

    }
*/
}
