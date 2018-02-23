package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lpzal on 22/02/2018.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;



    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table Cuenta( _ID integer primary key autoincrement,Pass text,Filtro text,Nombre text);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Abrir BD
    public void abrir(){
        this.getWritableDatabase();
    }
    //Cerrar BD
    public void cerrar(){
        this.close();
    }

    //Metodo insertar en la tabla Cuenta

    public void insertarRegistro(String nombre, String pass, String filtro){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nombre);
        valores.put("Filtro",filtro);
        valores.put("Pass",pass);

        long nuevaLinea;
        nuevaLinea=this.getWritableDatabase().insert("Cuenta",null,valores);

    }

}
