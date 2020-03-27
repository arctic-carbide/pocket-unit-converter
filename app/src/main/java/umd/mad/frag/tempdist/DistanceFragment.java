package umd.mad.frag.tempdist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DistanceFragment extends UnitFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }

    public double toMiles(double Km) {
        return Km / 1.609d;
    }

    public double toKilometers(double m) {
        return m * 1.609d;
    }

    @Override
    public double convert(double value) {
        if (flipped) {
            return toMiles(value);
        }
        else {
            return toKilometers(value);
        }
    }
}
