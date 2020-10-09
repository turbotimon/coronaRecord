package ch.ost.mge.testat.coronarecord.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.ost.mge.testat.coronarecord.R;

public class SpinnerFragment extends Fragment {

    public static SpinnerFragment create() {
        return new SpinnerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spinner, container, false);
    }

}
