package umd.mad.frag.tempdist;

import android.support.v4.app.Fragment;

public abstract class UnitFragment extends Fragment {
    boolean flipped = false;

    public abstract double convert(double value);
    public void swapUnits() {
        flipped = !flipped;
    }

}
