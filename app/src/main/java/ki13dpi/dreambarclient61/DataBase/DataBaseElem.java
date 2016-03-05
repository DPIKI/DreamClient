package ki13dpi.dreambarclient61.DataBase;

/**
 * Created by prog1 on 03.03.2016.
 */

//Модель элемента базы данных
public class DataBaseElem {
        private Integer _id;
        private Integer _realID;
        private String _category;
        private String _name;

        DataBaseElem(){}

        public DataBaseElem(Integer _id, Integer _realID, String _category, String _name){
            this._id = _id;
            this._realID = _realID;
            this._category = _category;
            this._name = _name;
        }

    public Integer get_id() {
        return _id;
    }

    public Integer get_realID() {
        return _realID;
    }

    public String get_category() {
        return _category;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void set_realID(Integer _realID) {
        this._realID = _realID;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
