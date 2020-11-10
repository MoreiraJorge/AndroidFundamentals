package pt.ipp.estg.dialogs;

import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public interface InterfaceDialog {
    public void onDialogPositiveClick(DialogFragment dialog);
    public void onDialogNegativeClick(DialogFragment dialog);

}
