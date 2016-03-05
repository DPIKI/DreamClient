package ki13dpi.dreambarclient61.Logic;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by prog1 on 27.02.2016.
 */
public class ElemMenu {
    private int _id;
    private String _name;
    private String _category;
    //TODO:private BitmapDrawable f;

    public ElemMenu(){
        _category = "";
        _name = "";
        _id = 0;
    }

    public ElemMenu(int id, String category, String name) {
        this._id = id;
        this._category = category;
        this._name = name;
    }

    public String get_category() {
        return _category;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
