package ki13dpi.dreambarclient61.Logic;

import java.util.ArrayList;

/**
 * Created by prog1 on 01.03.2016.
 */
public class Singleton {
        private static Singleton  singleton;

        //Поля для использования//////////////////////////////////////////////////////
        ArrayList<ElemMenu> _elemMenuArrayList;                             //////////
        int _numberOfTable;                                                 //////////
        //////////////////////////////////////////////////////////////////////////////

        //Будем вызывать этот метод только в InitApp.
        //InitApp - это точка входа в приложение.
        public static void initInstance(){
            if(singleton == null)
                singleton = new Singleton();
        }

        //Будем вызывать во всех активити для использования полей.
        //При этом будет использоваться экземпляр класса, созданный в InitApp
        public static Singleton getInstance(){
            return singleton;
        }

        //Конструктор метода. Что будет делать пока не придумал
        private Singleton(){
            _numberOfTable = 0;
            _elemMenuArrayList = new ArrayList<>();
        }
/////////////////////////////////////////////////////////////////////////////////////////
        public void addToMenu(ElemMenu elemMenu){
            _elemMenuArrayList.add(elemMenu);
        }

        public ArrayList<ElemMenu> getElemMenuArrayList(){
            return _elemMenuArrayList;
        }
    /////////////////////////////////
        public void set_numberOfTable(int numberOfTable){
            _numberOfTable = numberOfTable;
        }

        public int get_numberOfTable(){
            return _numberOfTable;
        }
    //////////////////////////////////////
}
