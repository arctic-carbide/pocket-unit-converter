package umd.mad.frag.tempdist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TemperatureFragment extends UnitFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_temperature, container, false);
    }

    // convert the value to the correct output
    // formula is "(F - 32) * 5/9 = C" and "(9C / 5) + 32 = F"

    public double toFahrenheit(double C) {
        return (9d * C / 5d) + 32d;
    }

    public double toCelsius(double F) {
        return (F - 32d) * (5d/9d);
    }

    @Override
    public double convert(double value) {
        if (flipped) {
            return toFahrenheit(value);
        }
        else {
            return toCelsius(value);
        }
    }
}
