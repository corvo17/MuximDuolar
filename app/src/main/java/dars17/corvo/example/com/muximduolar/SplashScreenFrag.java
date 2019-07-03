package dars17.corvo.example.com.muximduolar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFrag extends Fragment {


    public SplashScreenFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

}
