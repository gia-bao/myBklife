package mybklife.main.mybklife.view.fragment;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mybklife.main.mybklife.R;

/**
 * Created by 14102 on 21/04/2017.
 */

public class FragmentPresentClass extends Fragment {
    private static final String TAG="FragmentPresentClass";
    private Button btnTEST;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_presentclass,container,false);
        btnTEST=(Button)view.findViewById(R.id.btnTESTpast);
        btnTEST.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view,"wait for seconds", Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();

        }

    });
        return inflater.inflate(R.layout.fragment_presentclass,container,false);
    }
}
